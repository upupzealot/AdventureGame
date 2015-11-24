import javax.swing.UIManager;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import editor.MainFrame;

import game.Game;
import game.Scene;

import util.Preferences;

public class Main_Editor {
	public static void main(String[] agrs) {
		try {
			Preferences.read();
		} catch (Exception e) { e.printStackTrace(); }
		
		java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			MainFrame.getInstance();
				Game.getInstance().setScene(new Scene(20, 16));
    			
    			try {
    				String LookAndFeelName = "Dust";
    				//String LookAndFeelName = "Twilight";
    				UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.Substance" + LookAndFeelName + "LookAndFeel");
    				SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin." + LookAndFeelName + "Skin");
    				//System.err.close();
    			} catch(Exception e) {
    				e.printStackTrace();
    			}
    		}
		});
	}
}