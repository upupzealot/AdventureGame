import game.Game;
import game.Scene;
import gui.MainFrame;
import util.Preferences;

public class Main {
	public static void main(String[] agrs) {
		try {
			Preferences.read();
		} catch (Exception e) { e.printStackTrace(); }
		
		MainFrame.getInstance();
		
		Game.getInstance().setScene(new Scene(20, 16));
	}
}
