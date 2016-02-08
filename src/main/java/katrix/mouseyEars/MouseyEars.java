/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Mousey Ears Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Mousey-Ears
 *
 * Mousey Ears is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.mouseyEars;

import katrix.mouseyEars.handler.ConfigHandler;
import katrix.mouseyEars.lib.LibMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLModDisabledEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LibMod.MODID, name = LibMod.NAME, version = LibMod.VERSION, guiFactory = LibMod.GUI_FACTORY, clientSideOnly = true, canBeDeactivated = true)
public class MouseyEars {

	@Instance(LibMod.MODID)
	public static MouseyEars instance;

	@SidedProxy(clientSide = LibMod.CLIENT_PROXY, serverSide = LibMod.COMMON_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.setConfig(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerLayers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	@EventHandler
	public void disable(FMLModDisabledEvent event) {
		proxy.unregisterLayers(); //Doesn't work yet as disabling mods is not implemented yet AFAIK, also broken when not in dev enviroment
	}
}
