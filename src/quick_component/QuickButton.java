package quick_component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

@SuppressWarnings("serial")
public abstract class QuickButton extends JButton{
	public QuickButton(String name) {
		super(name);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isEnabled()) {
					OnClick();
				}
			}
		});
	}
	
	public abstract void OnClick();
}
