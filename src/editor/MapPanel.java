package editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import util.Preferences;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	private static MapPanel instance = null;
	public static MapPanel getInstance() {
		if(instance == null) {
			instance = new MapPanel();
		}
		return instance;
	}
	
	
	private MapPanel() {
		setLayout(new BorderLayout());
		
		add(new BrushPanel(), BorderLayout.WEST);
		add(new MapCanvas(Preferences.WINDOW_GRID_WIDTH, Preferences.WINDOW_GRID_HEIGHT), BorderLayout.CENTER);
		
		JScrollPane scroll = new JScrollPane(new TileSelectPanel());
		scroll.setPreferredSize(new Dimension(0, 200));
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		add(scroll, BorderLayout.SOUTH);
	}
}
