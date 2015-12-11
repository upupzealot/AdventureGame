package editor;

import java.awt.image.BufferedImage;
import java.util.Map;

import org.luaj.vm2.LuaValue;

import game.Scene;
import util.Preferences;

public class TileBrush extends Brush {
	
	final int WIDTH;
	final int HEIGHT;
	int tile_x = 0;
	int tile_y = 0;
	
	static final int SCALE = 2;
	
	TileBrush(String name, BufferedImage image) {
		super(name, image);
		
		WIDTH = (image.getWidth() + 1) / (Preferences.GRID_SIZE + 1);
		HEIGHT = (image.getHeight() + 1) / (Preferences.GRID_SIZE + 1);
	}
	
	BufferedImage getTileImage() {
		return image.getSubimage(
			(Preferences.GRID_SIZE + 1) * tile_x,
			(Preferences.GRID_SIZE + 1) * tile_y,
			Preferences.GRID_SIZE,
			Preferences.GRID_SIZE
		);
	}
	
	String getTileName() {
		return name + "-" + tile_x + "-" + tile_y;
	}
	
	@Override
	void paint(LuaValue cell, String layer_name) {
		String tile_name = getTileName();
		
		Scene scene = MapCanvas.getInstance().scene;
		
		boolean contains = cell.get(layer_name).isnil();
		boolean equals = contains && tile_name.equals(cell.get(layer_name).toString());
		if(tile_name != null && !equals) {
			Map<String, BufferedImage> tile_set = scene.getTileSet();
			if(!tile_set.keySet().contains(tile_name)) {
				tile_set.put(tile_name, getTileImage());
			}
			cell.set(layer_name, tile_name);
		}
	}
}
