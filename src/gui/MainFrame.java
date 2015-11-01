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
	 * 在中央插入MainCanvas
	 */
	@Override
	protected void Layout() {
		add(new MainCanvas(), BorderLayout.CENTER);
	}
	
	/**
	 * 获取初始化窗口尺寸
	 * @return 初始化窗口尺寸
	 */
	protected Dimension getInitailSize() {
		int scale = Preferences.GRID_SIZE * Preferences.SCALE;
		return new Dimension(Preferences.WINDOW_GRID_WIDTH * scale, Preferences.WINDOW_GRID_HEIGHT * scale);
	}
}
