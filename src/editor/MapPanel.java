package editor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import quick_component.BorderPanel;

@SuppressWarnings("serial")
public class MapPanel extends BorderPanel {
	private static MapPanel instance = null;
	public static MapPanel getInstance() {
		if(instance == null) {
			instance = new MapPanel();
		}
		return instance;
	}
	
	
	private MapPanel() {
		JPanel paint_panel = new BorderPanel();
		JPanel brush_panel = new BorderPanel();
		brush_panel.setBorder(new TitledBorder("Brush"));
		brush_panel.add(BrushPanel.getInstance(), BorderLayout.CENTER);
		paint_panel.add(brush_panel, BorderLayout.SOUTH);
		add(paint_panel, BorderLayout.WEST);
		
		add(MapCanvas.getInstance(), BorderLayout.CENTER);
		
		JScrollPane scroll = new JScrollPane(new BrushSelectPanel());
		scroll.setPreferredSize(new Dimension(0, 200));
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		add(scroll, BorderLayout.SOUTH);
	}
}
