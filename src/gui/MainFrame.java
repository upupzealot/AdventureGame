package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import util.Preferences;

@SuppressWarnings("serial")
public class MainFrame extends StandaloneWindow{
	private static MainFrame instance;
	/**
	 * 获得主窗口单例实例
	 * @return 主窗口单例
	 */
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	
	/**
	 * 布局
	 * 指定显示区域的尺寸
	 * 在中央插入MainCanvas
	 */
	@Override
	protected void Layout() {
		Dimension size = new Dimension(
			Preferences.WINDOW_GRID_WIDTH * Preferences.GRID_SIZE * Preferences.SCALE,
			Preferences.WINDOW_GRID_HEIGHT * Preferences.GRID_SIZE * Preferences.SCALE
		);
		setPreferredSize(size);
		
		add(new MainCanvas(), BorderLayout.CENTER);
	}
}
