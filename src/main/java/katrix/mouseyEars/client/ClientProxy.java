/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Mousey Ears Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Mousey-Ears
 *
 * Mousey Ears is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.mouseyEars.client;

import java.util.List;

import katrix.mouseyEars.CommonProxy;
import katrix.mouseyEars.client.layer.LayerEars;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ClientProxy extends CommonProxy {

	private LayerEars defaultModelLayer;
	private LayerEars slimModelLayer;

	@Override
	public void registerLayers() {
		RenderPlayer defaultModel = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
		RenderPlayer slimModel = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim");
		defaultModelLayer = new LayerEars(defaultModel);
		slimModelLayer = new LayerEars(slimModel);
		defaultModel.addLayer(defaultModelLayer);
		slimModel.addLayer(slimModelLayer);
	}

	@Override
	public void unregisterLayers() {
		RenderPlayer defaultModel = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
		RenderPlayer slimModel = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim");
		List<?> layersDefualt = ObfuscationReflectionHelper.getPrivateValue(RendererLivingEntity.class, defaultModel, "layerRenderers");
		List<?> layersSlim = ObfuscationReflectionHelper.getPrivateValue(RendererLivingEntity.class, slimModel, "layerRenderers");
		layersDefualt.remove(defaultModelLayer);
		layersSlim.remove(slimModelLayer);
	}
}
