package editor;

import java.awt.image.BufferedImage;

import util.Preferences;

public class Brush {
	String name;
	BufferedImage image;
	final int GRID_WIDTH;
	final int GRID_HEIGHT;
	int tile_x = 0;
	int tile_y = 0;
	
	static final int SCALE = 2;
	
	public Brush(String name, BufferedImage image) {
		this.name = name;
		this.image = image;
		
		GRID_WIDTH = (image.getWidth() + 1) / (Preferences.GRID_SIZE + 1);
		GRID_HEIGHT = (image.getHeight() + 1) / (Preferences.GRID_SIZE + 1);
	}
	
	public BufferedImage getTileImage() {
		return image.getSubimage(
			(Preferences.GRID_SIZE + 1) * tile_x,
			(Preferences.GRID_SIZE + 1) * tile_y,
			Preferences.GRID_SIZE,
			Preferences.GRID_SIZE
		);
	}
}
