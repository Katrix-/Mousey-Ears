/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Mousey Ears Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Mousey-Ears
 *
 * Mousey Ears is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.mouseyEars.client.gui;

import java.util.ArrayList;
import java.util.List;

import katrix.mouseyEars.handler.ConfigHandler;
import katrix.mouseyEars.lib.LibMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class MousyEarsGuiConfig extends GuiConfig {

	public MousyEarsGuiConfig(GuiScreen parentScreen) {

		super(parentScreen, getConfigList(), LibMod.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.cfg.toString()));
	}

	public static List<IConfigElement> getConfigList() {

		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new ConfigElement(ConfigHandler.cfg.getCategory(ConfigHandler.RENDERING.toLowerCase())));

		return list;
	}
}
