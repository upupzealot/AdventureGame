package util;
import java.io.IOException;

import org.luaj.vm2.LuaValue;

public class Preferences {
	/**
	 * RES目录路径
	 */
	public static String RES_FOLDER = System.getProperty("user.dir") + "/res/";
	/**
	 * 地图栅格大小（像素）
	 */
	public static int GRID_SIZE = 16;
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
	 */
	public static void read() throws IOException {
		LuaValue preferences = IO.read_lua_value("/prefrences.lua");
		SCALE = preferences.get("SCALE").toint();
		WINDOW_GRID_WIDTH = preferences.get("WINDOW_GRID_WIDTH").toint();
		WINDOW_GRID_HEIGHT = preferences.get("WINDOW_GRID_HEIGHT").toint();
	}
}
