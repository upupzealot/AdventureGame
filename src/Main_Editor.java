import java.awt.EventQueue;

import javax.swing.UIManager;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import editor.MainFrame;

import game.Game;
import util.Preferences;

public class Main_Editor {
	public static void main(String[] args) {
		try {
			Preferences.read();
		} catch (Exception e) { e.printStackTrace(); }
		
		EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			MainFrame.getInstance();
				Game.getInstance();
    			
    			try {
    				String LookAndFeelName = "Dust";
    				
    				UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.Substance" + LookAndFeelName + "LookAndFeel");
    				SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin." + LookAndFeelName + "Skin");
    			} catch(Exception e) { e.printStackTrace(); }
    		}
		});
	}
}