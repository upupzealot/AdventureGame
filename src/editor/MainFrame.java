package editor;

import java.awt.BorderLayout;

import gui.StandaloneWindow;

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
	 * 在中央插入MapCanvas
	 */
	@Override
	protected void Layout() {
		setTitle("地图编辑器");
		
		add(MapPanel.getInstance(), BorderLayout.CENTER);
	}
}
