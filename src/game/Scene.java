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
	private Cell[][] cells;
	
	private Map<String, BufferedImage> tile_set = new HashMap<String, BufferedImage>();	
	
	public Scene(int width, int height) {
		this.width = width;
		this.height = height;
		cells = new Cell[width][height];
		
		for(int i = 0; i < width; i++) {
			cells[i] = new Cell[height];
		for(int j = 0; j < height; j++) {
			cells[i][j] = new Cell("草地_1");
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
	
	public Cell getCellAt(int x, int y) {
		return cells[x][y];
	}
	
	@Override
	public String toString() {
		JSONObject object = new JSONObject();
		
		JSONArray tiles = new JSONArray(width * height);
		for(int i = 0; i < width * height; i++) {
			tiles.put(i, this.cells[i / width][i % width]);
		}
		object.put("titles", tiles);
		
		return object.toString();
	}
}
