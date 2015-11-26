package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.ZJSONArray;

import util.IO;
import util.Preferences;

public class Scene extends JSONStringer {
	private int width;
	private int height;
	private ZJSONArray layers;
	private JSONObject[][] cells;
	
	private Map<String, BufferedImage> tile_set = new HashMap<String, BufferedImage>();
	
	public Scene(int width, int height) {
		this.width = width;
		this.height = height;
		
		layers = new ZJSONArray();
		layers.put("background");
		layers.put("objects");
		
		cells = new JSONObject[width][height];
		for(int i = 0; i < width; i++) {
		for(int j = 0; j < height; j++) {
			JSONObject cell = new JSONObject();
			cell.put("background", "草地_1");
			cells[i][j] = cell;
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
	
	public ZJSONArray getLayerNames() {
		return layers;
	}
	
	public JSONObject getCellAt(int x, int y) {
		return cells[x][y];
	}
	
	@Override
	public String toString() {
		JSONObject object = new JSONObject();

		object.put("layers", layers);
		
		JSONArray cells = new JSONArray();
		for(int i = 0; i < width * height; i++) {
			cells.put(i, this.cells[i % width][i / width]);
		}
		object.put("cells", cells);
		
		return object.toString();
	}
	
	public void paint(Graphics2D g2d) {
		ZJSONArray layer_names = getLayerNames();
		for(int l = 0; l < layer_names.length(); l++) {
		for(int i = 0; i < width; i++) {
		for(int j = 0; j < height; j++) {
			String layer_name = layer_names.getString(l);
			JSONObject cell = getCellAt(i, j);
			if(!cell.keySet().contains(layer_name)) {
				continue;
			}
			String tile_name = cell.getString(layer_name);
			if(tile_name != null) {
				g2d.drawImage(tile_set.get(tile_name), i * Preferences.GRID_SIZE, j * Preferences.GRID_SIZE, null);
			}
		}}}
	}
}
