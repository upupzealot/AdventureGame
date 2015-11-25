package editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.JPanel;

import game.Cell;
import game.Scene;
import game.Scene.Layer;
import util.Preferences;

@SuppressWarnings("serial")
public class MapCanvas extends JPanel{
	
	private static MapCanvas instance;
	/**
	 * 获得MapCanvas单例实例
	 * @return MapCanvas单例
	 */
	static MapCanvas getInstance() {
		if(instance == null) {
			instance = new MapCanvas(Preferences.WINDOW_GRID_WIDTH, Preferences.WINDOW_GRID_HEIGHT);
		}
		return instance;
	}
	
	int grid_width;
	int grid_height;
	int grid_size = Preferences.GRID_SIZE;
	
	int width;
	int height;
	
	private MapCanvas(int grid_width, int grid_height) {
		this.grid_width = grid_width;
		this.grid_height = grid_height;
		
		width = grid_width * grid_size;
		height = grid_height * grid_size;
		scene = new Scene(grid_width, grid_height);
		
		setPreferredSize(new Dimension(width * Brush.SCALE + 16, height * Brush.SCALE + 16));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					onDraw(e);
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					onDraw(e);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					onDraw(e);
				}
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				onDraw(e);
			}
		});
	}
	
	void onDraw(MouseEvent e) {
		int x = e.getX() - x_offset;
		int y = e.getY() - y_offset;
		x /= Brush.SCALE;	x /= Preferences.GRID_SIZE;
		y /= Brush.SCALE;	y /= Preferences.GRID_SIZE;
		if(x < grid_width && y < grid_height) {
			Cell cell = scene.getLayer(LayerPanel.getCurrentLayer()).getCellAt(x, y);
			Brush brush = BrushPanel.getInstance().brush;
			String tile_name = brush.getTileName();
			if(tile_name != null && !tile_name.equals(cell.getTileName())) {
				Map<String, BufferedImage> tile_set = scene.getTileSet();
				if(!tile_set.keySet().contains(tile_name)) {
					tile_set.put(tile_name, brush.getTileImage());
				}
				cell.setTileName(tile_name);
				
				repaint();
			}
		}
	}
	
	int x_offset = 0;
	int y_offset = 0;
	Scene scene;
	@Override
	public void paintComponent(Graphics g) {
		x_offset = (getWidth() - width * Brush.SCALE) / 2;
		y_offset = (getHeight() - height * Brush.SCALE) / 2;
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.translate(x_offset, y_offset);
		g2d.scale(2, 2);
		
		g2d.setColor(Color.LIGHT_GRAY);
		
		g2d.drawRect(0, 0, width, height);
		
		for(int i = 1; i < grid_width; i++) {
			g2d.drawLine(i * grid_size, 0, i * grid_size, height);
		}
		for(int j = 1; j < grid_height; j++) {
			g2d.drawLine(0, j * grid_size, width, j * grid_size);
		}
		
		Map<String, BufferedImage> tile_set = scene.getTileSet();
		for(int l = 0; l < scene.getLayerCount(); l++) {
			Layer layer = scene.getLayer(l);
		for(int i = 0; i < grid_width; i++) {
		for(int j = 0; j < grid_height; j++) {
				Cell cell = layer.getCellAt(i, j);
				if(cell != null) {
					g2d.drawImage(tile_set.get(cell.getTileName()), i * Preferences.GRID_SIZE, j * Preferences.GRID_SIZE, null);
				}
		}}}
	}
}
