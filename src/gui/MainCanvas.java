package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.JPanel;

import game.Game;
import game.Scene;
import util.Preferences;

@SuppressWarnings("serial")
public class MainCanvas extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		paintCanvas(g2d);
	}
	
	public void paintCanvas(Graphics2D g2d) {
		g2d.scale(Preferences.SCALE, Preferences.SCALE);
		
		Scene scene = Game.getInstance().getCurrentScene();
		if(scene == null) { System.err.println("没有指定场景。"); return; }
		int height = scene.getHeight();
		int width = scene.getWidth();
		Map<String, BufferedImage> tile_set = scene.getTileSet();
		
		for(int i = 0; i < width; i++) {
		for(int j = 0; j < height; j++) {
			g2d.drawImage(tile_set.get(scene.getCellAt(i, j).getTileName()), i * Preferences.GRID_SIZE, j * Preferences.GRID_SIZE, null);
		}}
	}
}
