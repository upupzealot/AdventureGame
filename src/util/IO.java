package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.json.JSONObject;

public class IO {
	/**
	 * 从JSON文件读取对象
	 * @param path 文件存放的路径。
	 * 首先作为基于res/data目录的相对路径查找，若没有，则作为绝对路径查找
	 * @return 读取的JSON对象
	 * @throws IOException 没有找到该文件
	 */
	public static JSONObject read_json_object(String path) {
		File json_file = new File(Preferences.RES_FOLDER + "data/" + path);
		if(!json_file.exists()) {
			json_file = new File(path);
		}
		
		Long file_length = json_file.length();
		byte[] content = new byte[file_length.intValue()];
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(json_file);
			fis.read(content);
			fis.close();
		} catch (Exception e) { throw new RuntimeException(e); }

		return new JSONObject(new String(content));
	}
	
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
