import java.awt.EventQueue;

import javax.swing.JFrame;
import game.Game;
import game.Scene;
import gui.MainFrame;
import gui.StandaloneWindow;
import util.Preferences;

public class Main_Game {
	public static void main(String[] args) {
		try {
			Preferences.read();
		} catch (Exception e) { e.printStackTrace(); }
		
		EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			JFrame main = MainFrame.getInstance();
    			Game.getInstance().setScene(new Scene(20, 16));
    			StandaloneWindow.MakeCenter(main);
    		}
		});
	}
}
