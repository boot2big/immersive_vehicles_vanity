package net.cc.ivv.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.cc.ivv.ElementsIvvMod;

import java.util.Map;

@ElementsIvvMod.ModElement.Tag
public class ProcedureRoggedAfterEffect extends ElementsIvvMod.ModElement {
	public ProcedureRoggedAfterEffect(ElementsIvvMod instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RoggedAfterEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC,
				(float) (((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) * 0.5));
	}
}
