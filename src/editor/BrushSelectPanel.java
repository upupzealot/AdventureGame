package editor;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import quick_component.QuickToggleButton;
import quick_component.WrapLayout;
import util.Preferences;

@SuppressWarnings("serial")
public class BrushSelectPanel extends JPanel{
	public BrushSelectPanel() {
		WrapLayout layout = new WrapLayout(FlowLayout.LEFT, 8, 16);
		layout.setAlignOnBaseline(true);
		setLayout(layout);
		
		File root = new File(Preferences.RES_FOLDER + "/editor/map");
		File[] files = root.listFiles();
		ButtonGroup group = new ButtonGroup();
		for (File file : files) {
			if(file.getName().toLowerCase().endsWith(".png")) {
				BufferedImage image;
				try {
					image = ImageIO.read(file);
					String name = file.getName();
					name = name.substring(0, name.lastIndexOf('.'));
					JToggleButton button = new BrushSelectButton(name, image) {
						@Override
						public int getBaseline(int width, int height) {
							return height;
						}
					};
					group.add(button);
					add(button);
				} catch (IOException e) { e.printStackTrace(); }
			}
		}
		
		if(getComponents().length > 0) {
			((JToggleButton)getComponents()[0]).setSelected(true);
		}
	}
	
	private BufferedImage image = null;
	public BufferedImage getCurrentImage() {
		return image;
	}
	
	class BrushSelectButton extends QuickToggleButton {
		TileBrush brush;
		BrushSelectButton(String name, BufferedImage icon) {
			super(icon);
			brush = new TileBrush(name, icon);
			setToolTipText(name);
		}
		
		@Override
		public void onSelected() {
			TileBrushPanel.getInstance().setBrush(brush);
		}
	}
}
