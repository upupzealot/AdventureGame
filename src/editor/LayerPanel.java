package editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import org.luaj.vm2.LuaValue;

import game.Layer;
import quick_component.BorderPanel;
import quick_component.QuickToggleButton;

@SuppressWarnings("serial")
public class LayerPanel extends JPanel {
	private static LayerPanel instance = null;
	/**
	 * 获得LayerPanel单例实例
	 * @return LayerPanel单例
	 */
	public static LayerPanel getInstance() {
		if(instance == null) {
			instance = new LayerPanel();
		}
		return instance;
	}
	
	public static Layer getCurrentLayer() {
		return getInstance().current_layer;
	}
	
	private Layer current_layer = null;
	private LayerPanel() {
		setBorder(new TitledBorder("地图层"));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();	
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.insets = new Insets(2, 4, 2, 4);
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridy = 0;
		LuaValue layers = MapCanvas.getInstance().scene.getLayers();
		ButtonGroup group = new ButtonGroup();
		for(int l = 0; l < layers.length(); l++) {
			LayerButtonPanel button_panel = new LayerButtonPanel((Layer)layers.get(l + 1));
			group.add(button_panel.select_button);
			add(button_panel, gbc);
			button_panel.select_button.setSelected(true);
			
			gbc.gridy++;
		}
		gbc.weighty = 1;
		add(new JPanel(), gbc);
	}
	
	class LayerButtonPanel extends BorderPanel {
		JToggleButton select_button;
		JCheckBox visible;
		
		LayerButtonPanel(Layer layer) {
			select_button = new QuickToggleButton(layer.get("name").toString()) {
			@Override
				public void onSelected() {
					current_layer = layer;
				}
			};
			visible = new JCheckBox();
			visible.setSelected(true);
			add(select_button, BorderLayout.CENTER);
			add(visible, BorderLayout.WEST);
			
			Dimension size = new Dimension(160, 40);
			setPreferredSize(size);
			setMinimumSize(size);
		}
	}
}
