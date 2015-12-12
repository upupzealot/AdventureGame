package editor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import quick_component.BorderPanel;

@SuppressWarnings("serial")
public class CharacterPanel extends BorderPanel {
	
	private static CharacterPanel instance;
	/**
	 * 获得CharactorPanel单例实例
	 * @return CharactorPanel单例
	 */
	static CharacterPanel getInstance() {
		if(instance == null) {
			instance = new CharacterPanel();
		}
		return instance;
	}
	
	CharacterPanel() {
		
	}
	
	TileBrush brush;
	void setBrush(TileBrush brush) {

	}
	
	int x_offset = 0;
	int y_offset = 0;
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);
	}
}
