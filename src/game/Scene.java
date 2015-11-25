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
	private Layer[] layers;
	
	private Map<String, BufferedImage> tile_set = new HashMap<String, BufferedImage>();
	
	public Scene(int width, int height) {
		this.width = width;
		this.height = height;
		
		layers = new Layer[2];
		layers[0] = new Layer("background", "草地_1");
		layers[1] = new Layer("objects");
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
	
	public int getLayerCount() {
		return layers.length;
	}
	
	public Layer getLayer(int l) {
		return layers[l];
	}
	
	@Override
	public String toString() {
		JSONObject object = new JSONObject();
		
		JSONArray layers = new JSONArray();
		for(int i = 0; i < layers.length(); i++) {
			layers.put(i, this.layers[i]);
		}
		object.put("layers", layers);
		
		return object.toString();
	}
	
	public class Layer extends JSONStringer {
		private String name;
		private Cell[][] cells;
		
		private Layer(String name) {
			this.name = name;
			cells = new Cell[width][height];
			for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				cells[i][j] = new Cell(null);
			}}
		}
		
		private Layer(String name, String tile_name) {
			this.name = name;
			cells = new Cell[width][height];
			for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				cells[i][j] = new Cell(tile_name);
			}}
		}
		
		public Cell getCellAt(int x, int y) {
			return cells[x][y];
		}
		
		public String getName() {
			return name;
		}
		
		@Override
		public String toString() {
			JSONObject object = new JSONObject();
			object.put("name", name);
			
			JSONArray tiles = new JSONArray();
			for(int i = 0; i < width * height; i++) {
				tiles.put(i, cells[i % width][i / width].getTileName());
			}
			object.put("titles", tiles);
			
			return object.toString();
		}

	}
}
