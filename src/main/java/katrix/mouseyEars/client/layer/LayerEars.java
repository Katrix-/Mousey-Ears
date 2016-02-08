package katrix.mouseyEars.client.layer;

import katrix.mouseyEars.handler.ConfigHandler;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerEars implements LayerRenderer<AbstractClientPlayer> {

	private final RenderPlayer playerRenderer;

	public LayerEars(RenderPlayer playerRendererIn) {
		playerRenderer = playerRendererIn;
	}

	@Override
	public void doRenderLayer(AbstractClientPlayer player, float movement, float far, float partialTicks, float yaw, float pitch, float p_177141_7_,
			float scale) {
		for (String name : ConfigHandler.names) {
			if (player.getName().equals(name) /*&& player.hasSkin()*/ && !player.isInvisible()) {
				playerRenderer.bindTexture(player.getLocationSkin());
				float tickYaw = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * partialTicks
						- (player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * partialTicks);
				float tickPitch = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * partialTicks;
				float distance = ConfigHandler.distance;
				float size = ConfigHandler.size;

				for (int i = 0; i < 2; ++i) {
					GlStateManager.pushMatrix();
					GlStateManager.rotate(tickYaw, 0.0F, 1.0F, 0.0F);
					GlStateManager.rotate(tickPitch, 1.0F, 0.0F, 0.0F);
					GlStateManager.translate(distance * (i * 2 - 1), 0.0F, 0.0F);
					GlStateManager.translate(0.0F, -distance, 0.0F);
					GlStateManager.rotate(-tickPitch, 1.0F, 0.0F, 0.0F);
					GlStateManager.rotate(-tickYaw, 0.0F, 1.0F, 0.0F);
					GlStateManager.scale(size, size, size);
					playerRenderer.getMainModel().renderDeadmau5Head(0.0625F);
					GlStateManager.popMatrix();
				}
			}
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}