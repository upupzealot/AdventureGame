package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class IO {
	private static Globals globals = JsePlatform.standardGlobals();
	/**
	 * 从LUA文件读取LuaValue对象
	 * @param path 文件存放的路径。
	 * 首先作为基于res/data目录的相对路径查找，若没有，则作为绝对路径查找
	 * @return 读取的LuaValue对象
	 * @throws IOException 没有找到该文件
	 */
	public static LuaValue read_lua_value(String path) {
		File lua_file = new File(Preferences.RES_FOLDER + "data/" + path);
		if(!lua_file.exists()) {
			lua_file = new File(path);
		}
		
		Long file_length = lua_file.length();
		byte[] content = new byte[file_length.intValue()];
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(lua_file);
			fis.read(content);
			fis.close();
		} catch (Exception e) { throw new RuntimeException(e); }

		String lua_string = "do local result = " + new String(content) + "return result end";
		
		return globals.load(lua_string).call();
	}
	
	/**
	 * 从图片文件读取图片
	 * @param path 文件存放的路径。
	 * 首先作为基于res/data目录的相对路径查找，若没有，则作为绝对路径查找
	 * @return 读取的BufferedImage对象
	 * @throws IOException 没有找到该文件
	 */
	public static BufferedImage read_image(String path) {
		File img_file = new File(Preferences.RES_FOLDER + "images/" + path);
		if(!img_file.exists()) {
			img_file = new File(path);
		}
		
		BufferedImage image;
		try {
			image = ImageIO.read(img_file);
		} catch (Exception e) { throw new RuntimeException(e); }
		
		return image;
	}
}
