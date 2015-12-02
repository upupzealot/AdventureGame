package editor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;
import gui.MainFrame;
import gui.StandaloneWindow;
import quick_component.QuickButton;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel{
	public ControlPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();	
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.insets = new Insets(2, 4, 2, 4);
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridy = 0;
		add(new JButton("打开"), gbc);
		gbc.gridy++;
		add(new JButton("保存"), gbc);
		gbc.weighty = 1;
		gbc.gridy++;
		add(new JPanel(), gbc);
		gbc.weighty = 0;
		gbc.gridy++;
		add(new QuickButton("运行") {
			@Override
			public void OnClick() {
				JFrame main = MainFrame.getInstance();
    			//Game.getInstance().setScene(new Scene(20, 16));
				Game.getInstance().setScene(MapCanvas.getInstance().scene);
    			StandaloneWindow.MakeCenter(main);
    			main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			main.setVisible(true);
			}
		}, gbc);
	}
}
