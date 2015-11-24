package game;

import java.awt.Dimension;

import gui.MainFrame;

public class Game {
	private static Game instance;
	/**
	 * 获得Game单例实例
	 * @return Game单例
	 */
	public static Game getInstance() {
		if(instance == null) {
			instance = new Game();
		}
		return instance;
	}
	
	/**
	 * 游戏当前加载的场景
	 */
	private Scene current_scene;
	/**
	 * 将游戏切换到指令的场景
	 * @param scene 指定的场景
	 */
	public void setScene(Scene scene) {
		current_scene = scene;
	}
	/**
	 * 获得游戏当前加载的场景
	 * @return 当前加载的场景
	 */
	public Scene getCurrentScene() {
		return current_scene;
	}
}
