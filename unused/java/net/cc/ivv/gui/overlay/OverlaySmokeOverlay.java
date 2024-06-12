
package net.cc.ivv.gui.overlay;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;

import net.cc.ivv.procedure.ProcedureSmokeStatus;
import net.cc.ivv.ElementsIvvMod;

import com.google.common.collect.ImmutableMap;

@ElementsIvvMod.ModElement.Tag
public class OverlaySmokeOverlay extends ElementsIvvMod.ModElement {
	public OverlaySmokeOverlay(ElementsIvvMod instance) {
		super(instance, 8);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new GUIRenderEventClass());
	}
	public static class GUIRenderEventClass {
		@SubscribeEvent(priority = EventPriority.LOWEST)
		@SideOnly(Side.CLIENT)
		public void eventHandler(RenderGameOverlayEvent event) {
			if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
				int posX = (event.getResolution().getScaledWidth()) / 2;
				int posY = (event.getResolution().getScaledHeight()) / 2;
				EntityPlayer entity = Minecraft.getMinecraft().player;
				World world = entity.world;
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				if (ProcedureSmokeStatus.executeProcedure(ImmutableMap.of("entity", entity))) {
					GlStateManager.disableDepth();
					GlStateManager.depthMask(false);
					GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
							GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
					GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
					GlStateManager.disableAlpha();
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("ivv:textures/guis/zoinkoverlay.png"));
					Minecraft.getMinecraft().ingameGUI.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, event.getResolution().getScaledWidth(),
							event.getResolution().getScaledHeight(), event.getResolution().getScaledWidth(), event.getResolution().getScaledHeight());
					GlStateManager.depthMask(true);
					GlStateManager.enableDepth();
					GlStateManager.enableAlpha();
					GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				}
			}
		}
	}
}
