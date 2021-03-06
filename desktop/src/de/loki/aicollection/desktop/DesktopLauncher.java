package de.loki.aicollection.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.loki.aicollection.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "AICollection";
		config.width = 1920;
		config.height = 1080;
		config.fullscreen = false;
		config.resizable = false;

		new LwjglApplication(new Main(), config);
	}
}
