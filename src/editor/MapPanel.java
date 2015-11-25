package editor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import quick_component.BorderPanel;

@SuppressWarnings("serial")
public class MapPanel extends BorderPanel {
	private static MapPanel instance = null;
	/**
	 * 获得MapPanel单例实例
	 * @return MapPanel单例
	 */
	public static MapPanel getInstance() {
		if(instance == null) {
			instance = new MapPanel();
		}
		return instance;
	}
	
	
	private MapPanel() {
		JPanel paint_panel = new BorderPanel();
		JPanel brush_panel = new BorderPanel();
		brush_panel.setBorder(new TitledBorder("笔刷"));
		brush_panel.add(BrushPanel.getInstance(), BorderLayout.CENTER);
		paint_panel.add(brush_panel, BorderLayout.SOUTH);
		LayerPanel layer_panel = LayerPanel.getInstance();
		paint_panel.add(layer_panel, BorderLayout.CENTER);
		add(paint_panel, BorderLayout.WEST);
		
		JScrollPane scroll = new JScrollPane(MapCanvas.getInstance());
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.getHorizontalScrollBar().setUnitIncrement(16);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll, BorderLayout.CENTER);
		
		scroll = new JScrollPane(new BrushSelectPanel());
		scroll.setPreferredSize(new Dimension(0, 200));
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		add(scroll, BorderLayout.SOUTH);
	}
}
