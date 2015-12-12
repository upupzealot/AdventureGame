package game;

import org.luaj.vm2.LuaTable;

public class Layer extends LuaTable {
	public static final String TILE = "TILE";
	public static final String OBJECT = "OBJECT";
	public static final String CHARACTOR = "CHARACTOR";
	
	public Layer(String name, String type) {
		set("name", name);
		set("type", type);
	}
}
