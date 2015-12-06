import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class Main_LuaTest {
	public static void main(String[] args) {
		Globals globals = JsePlatform.standardGlobals();
		LuaValue chunk = globals.load("print '你好，世界！'");
		long tm = System.nanoTime();
		chunk.call();
		System.out.println((System.nanoTime() - tm) / 1000000f);
	}
}
