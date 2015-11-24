package game;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import util.IO;

public class Scene extends JSONStringer {
	private int width;
	private int height;
	private Cell[][] tiles;
	
	private Map<String, BufferedImage> tile_set = new HashMap<String, BufferedImage>();	
	
	public Scene(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Cell[width][height];
		
		for(int i = 0; i < width; i++) {
		for(int j = 0; j < height; j++) {
			tiles[i][j] = new Cell("草地_1");
		}}
		
		tile_set.put("草地_1", IO.read_image("tiles/草地_1.png"));
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public BufferedImage getTileAt(int x, int y) {
		return tile_set.get(tiles[x][y].getTile());
	}
	
	@Override
	public String toString() {
		JSONObject object = new JSONObject();
		
		JSONArray tiles = new JSONArray(width * height);
		for(int i = 0; i < width * height; i++) {
			tiles.put(i, this.tiles[i / width][i % width]);
		}
		object.put("titles", tiles);
		
		return object.toString();
	}
}
