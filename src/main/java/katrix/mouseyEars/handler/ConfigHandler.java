/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Mousey Ears Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Mousey-Ears
 *
 * Mousey Ears is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.mouseyEars.handler;

import java.io.File;

import katrix.mouseyEars.lib.LibMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	public static Configuration cfg;

	public static final String RENDERING = "Rendering";

	public static float distance;
	public static float size;
	public static String[] names;

	public static void setConfig(File configFile) {

		cfg = new Configuration(configFile);
		cfg.load();
		loadConfig();

		MinecraftForge.EVENT_BUS.register(new ChangeListener());
	}

	public static void loadConfig() {

		String[] defaultNames = {"Nazrin", "Mouse"};

		distance = (float)cfg.get(RENDERING, "distance", 0.375F, "The distance between the ears").getDouble();
		size = (float)cfg.get(RENDERING, "size", 1.33333F, "The size of the ears").getDouble();
		Property propNames = cfg.get(RENDERING, "names", defaultNames, "The names that should be rendered ears on");

		if (propNames.isList()) {
			names = propNames.getStringList();
		}
		else {
			names = new String[1];
			names[1] = propNames.getString();
		}

		if (cfg.hasChanged()) {
			cfg.save();
		}
	}

	public static class ChangeListener {

		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
			if (eventArgs.modID.equals(LibMod.MODID)) {
				loadConfig();
			}
		}
	}
}
