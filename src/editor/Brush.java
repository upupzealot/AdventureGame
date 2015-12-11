package editor;

import java.awt.image.BufferedImage;

import org.luaj.vm2.LuaValue;

public class Brush {
	String name;
	BufferedImage image;
	Brush(String name, BufferedImage image) {
		this.name = name;
		this.image = image;
	}
	void paint(LuaValue cell, String layer_name) {
		
	}
}
