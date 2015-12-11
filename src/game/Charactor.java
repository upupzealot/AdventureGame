package game;

import java.awt.image.BufferedImage;

import util.IO;

public class Charactor extends GameObject{
	private String ID = null;
	private String name;
	private BufferedImage avatar = IO.read_image("/avatars/default.png");
	
	protected void update() {
		
	}
}
