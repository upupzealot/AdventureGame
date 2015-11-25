package quick_component;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class QuickToggleButton extends JToggleButton{
	public QuickToggleButton(String name) {
		super(name);
		init();
	}
	
	public QuickToggleButton(Icon icon) {
		super(icon);
		init();
	}
	
	public QuickToggleButton(Image icon) {
		super(new ImageIcon(icon));
		init();
	}
	
	private void init() {
		addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					onSelected();
				}
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					onDeselected();
				}
			}
		});
	}
	
	public void onSelected() {};
	public void onDeselected() {};
}
