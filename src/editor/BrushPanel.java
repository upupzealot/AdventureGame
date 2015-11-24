package editor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import quick_component.BorderPanel;
import util.Preferences;

@SuppressWarnings("serial")
public class BrushPanel extends BorderPanel{
	
	private static BrushPanel instance;
	/**
	 * 获得BrushPanel单例实例
	 * @return Game单例
	 */
	static BrushPanel getInstance() {
		if(instance == null) {
			instance = new BrushPanel();
		}
		return instance;
	}
	
	BrushPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX() - x_offset;
				int y = e.getY() - y_offset;
				x /= Brush.SCALE;
				y /= Brush.SCALE;
				if(x % Preferences.GRID_SIZE != 0 && y % Preferences.GRID_SIZE != 0) {
					x /= (Preferences.GRID_SIZE + 1);
					y /= (Preferences.GRID_SIZE + 1);
					if(x < brush.GRID_WIDTH && y < brush.GRID_HEIGHT) {
						brush.tile_x = x;
						brush.tile_y = y;
						repaint();
					}
				}
			}
		});
	}
	
	Brush brush;
	void setBrush(Brush brush) {
		this.brush = brush;
		
		Dimension size = new Dimension(
			brush.image.getWidth() * Brush.SCALE + 16,
			8 + brush.image.getHeight() * Brush.SCALE + 16 + Preferences.GRID_SIZE + 8
		);
		setPreferredSize(size);
		setSize(size);
	}
	
	int x_offset = 0;
	int y_offset = 0;
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		x_offset = (getWidth() - brush.image.getWidth() * Brush.SCALE) / 2;
		y_offset = (getHeight() - brush.image.getHeight() * Brush.SCALE - 16 - Preferences.GRID_SIZE) / 2;
		g2d.translate(x_offset, y_offset);
		g2d.scale(2, 2);
		
		g2d.setColor(getForeground());
		int size = Preferences.GRID_SIZE + 1;
		g2d.fillRect(
			brush.tile_x * size - 1,
			brush.tile_y * size - 1,
			size + 1,
			size + 1
		);
		
		g2d.drawImage(brush.image, 0, 0, null);

		g2d.drawImage(
			brush.getTileImage(),
			(brush.image.getWidth() - Preferences.GRID_SIZE) / 2,
			brush.image.getHeight() + 4,
			null);
	}
}
