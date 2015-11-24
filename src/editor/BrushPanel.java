package editor;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import util.Preferences;

@SuppressWarnings("serial")
public class BrushPanel extends JPanel{
	public BrushPanel() {
		setPreferredSize(new Dimension(Preferences.GRID_SIZE * 8 + 9, Preferences.GRID_SIZE * 8 + 9));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}
}
