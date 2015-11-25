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

import game.Scene;
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
	
	public static int getCurrentLayer() {
		return getInstance().current_layer;
	}
	
	private int current_layer = 0;
	private LayerPanel() {
		setBorder(new TitledBorder("地图层"));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();	
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.insets = new Insets(2, 4, 2, 4);
		gbc.fill = GridBagConstraints.BOTH;
		
		
		gbc.gridy = 0;
		Scene scene = MapCanvas.getInstance().scene;
		ButtonGroup group = new ButtonGroup();
		for(int l = 0; l < scene.getLayerCount(); l++) {
			LayerButton button = new LayerButton(scene.getLayer(l).getName(), l);
			group.add(button.layer_button);
			add(button, gbc);
			
			gbc.gridy++;
		}
		add(new JPanel(), gbc);
	}
	
	class LayerButton extends BorderPanel {
		JToggleButton layer_button;
		
		LayerButton(String name, int l) {
			layer_button = new QuickToggleButton(name) {
			@Override
				public void onSelected() {
					current_layer = l;
				}
			};
			add(layer_button, BorderLayout.CENTER);
			add(new JCheckBox(), BorderLayout.WEST);
			
			setPreferredSize(new Dimension(0, 60));
			setMinimumSize(new Dimension(0, 40));
		}
	}
}
