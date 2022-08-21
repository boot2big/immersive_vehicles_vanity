package net.cc.ivv.procedure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.cc.ivv.ElementsIvvMod;

import java.util.Map;

@ElementsIvvMod.ModElement.Tag
public class ProcedureOilFlynt extends ElementsIvvMod.ModElement {
	public ProcedureOilFlynt(ElementsIvvMod instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OilFlynt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).capabilities.isFlying = (false);
			((EntityPlayer) entity).sendPlayerAbilities();
		}
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).capabilities.allowFlying = (false);
			((EntityPlayer) entity).sendPlayerAbilities();
		}
	}
}
