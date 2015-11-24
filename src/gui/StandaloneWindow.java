package gui;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public abstract class StandaloneWindow extends JFrame{
	/**
	 * 构造方法
	 */
	protected StandaloneWindow() {
		//EXIT_ON_CLOSE
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//可以获取焦点
		setFocusable(true);
		
		//默认采用BorderLayout
		setLayout(new BorderLayout());
		Layout();
		
		//居中显示窗口
		pack();
		MakeCenter(this);
		setVisible(true);
	}
	
	/**
	 * 布局方法
	 */
	protected abstract void Layout();
	
	/**
	 * 使某个窗口在屏幕可视区域内居中
	 * @param window 要居中的窗口
	 */
	public static void MakeCenter(Window window) {
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(window.getGraphicsConfiguration());
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		window.setLocation(
			(screenSize.width - screenInsets.left - screenInsets.right - window.getWidth()) / 2,
			(screenSize.height - screenInsets.top - screenInsets.bottom - window.getHeight()) / 2
		);
	}
}
