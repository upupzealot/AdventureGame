package util;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class Preferences {
	/**
	 * RES目录路径
	 */
	public static String RES_FOLDER = System.getProperty("user.dir") + "/res/";
	/**
	 * 地图栅格大小（像素）
	 */
	public static int GRID_SIZE;
	/**
	 * 整体的像素粒度
	 */
	public static int SCALE;
	/**
	 * 窗口宽度（栅格）
	 */
	public static int WINDOW_GRID_WIDTH;
	/**
	 * 窗口高度（栅格）
	 */
	public static int WINDOW_GRID_HEIGHT;
	
	/**
	 * 读取Preferences
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public static void read() throws JSONException, IOException {
		JSONObject preferences = IO.read_json_object("/prefrences.json");
		GRID_SIZE = preferences.getInt("GRID_SIZE");
		SCALE = preferences.getInt("SCALE");
		WINDOW_GRID_WIDTH = preferences.getInt("WINDOW_GRID_WIDTH");
		WINDOW_GRID_HEIGHT = preferences.getInt("WINDOW_GRID_HEIGHT");
	}
}
