package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

import util.IO;
import util.Preferences;

public class Scene {
	private int width;
	private int height;
	private LuaValue layers;
	private LuaValue cells;
	
	private Map<String, BufferedImage> tile_set = new HashMap<String, BufferedImage>();
	
	public Scene(int width, int height) {
		this.width = width;
		this.height = height;
		
		layers = new LuaTable();
		layers.set(1, "background");
		layers.set(2, "objects");
		
		cells = new LuaTable();
		for(int i = 1; i <= width; i++) {
			LuaValue column = new LuaTable();
			cells.set(i, column);
		for(int j = 1; j <= height; j++) {
			LuaValue cell = new LuaTable();
			cell.set("background", "草地_1");
			column.set(j, cell);
		}}
		
		tile_set.put("草地_1", IO.read_image("tiles/草地_1.png"));
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Map<String, BufferedImage> getTileSet() {
		return tile_set;
	}
	
	public LuaValue getLayerNames() {
		return layers;
	}
	
	public LuaValue getCellAt(int x, int y) {
		return cells.get(x).get(y);
	}
	
	public void paint(Graphics2D g2d) {
		LuaValue layer_names = getLayerNames();
		for(int l = 1; l <= layer_names.length(); l++) {
		for(int i = 1; i <= width; i++) {
		for(int j = 1; j <= height; j++) {
			LuaValue layer_name = layer_names.get(l);
			LuaValue cell = getCellAt(i, j);
			if(cell.get(layer_name).isnil()) {
				continue;
			}
			String tile_name = cell.get(layer_name).toString();
			if(tile_name != null) {
				g2d.drawImage(tile_set.get(tile_name), (i - 1) * Preferences.GRID_SIZE, (j - 1) * Preferences.GRID_SIZE, null);
			}
		}}}
	}
}
