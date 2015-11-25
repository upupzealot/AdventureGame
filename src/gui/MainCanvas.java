package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.JPanel;

import game.Game;
import game.Scene;
import game.Scene.Layer;
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
		
		for(int l = 0; l < scene.getLayerCount(); l++) {
			Layer layer = scene.getLayer(l);
		for(int i = 0; i < width; i++) {
		for(int j = 0; j < height; j++) {
			BufferedImage image = tile_set.get(layer.getCellAt(i, j).getTileName());
			if(image != null) {
				g2d.drawImage(image, i * Preferences.GRID_SIZE, j * Preferences.GRID_SIZE, null);
			}
		}}}
	}
}
