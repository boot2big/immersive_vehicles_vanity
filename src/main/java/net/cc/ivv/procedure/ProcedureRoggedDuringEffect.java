package net.cc.ivv.procedure;

import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.cc.ivv.ElementsIvvMod;

import java.util.Map;

@ElementsIvvMod.ModElement.Tag
public class ProcedureRoggedDuringEffect extends ElementsIvvMod.ModElement {
	public ProcedureRoggedDuringEffect(ElementsIvvMod instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RoggedDuringEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		float yeetYaw = 0;
		float yeetPitch = 0;
		if ((Math.random() < 0.0125)) {
			if ((Math.random() < 0.5)) {
				if (entity instanceof EntityLivingBase) {
					((EntityLivingBase) entity).swingArm(EnumHand.OFF_HAND);
				}
			} else {
				if (entity instanceof EntityLivingBase) {
					((EntityLivingBase) entity).swingArm(EnumHand.MAIN_HAND);
				}
			}
		}
		if ((Math.random() < 0.025)) {
			if ((Math.random() < 0.5)) {
				yeetYaw = (float) (Math.random() * 3);
			} else {
				yeetYaw = (float) (Math.random() * -3);
			}
			if ((Math.random() < 0.5)) {
				yeetYaw = (float) (Math.random() * 3);
			} else {
				yeetYaw = (float) (Math.random() * -3);
			}
			for (int index0 = 0; index0 < (int) (Math.floor((Math.random() * 6))); index0++) {
				entity.rotationYaw = (entity.rotationYaw);
				entity.rotationPitch = ((entity.rotationPitch) + (yeetYaw));
			}
			for (int index1 = 0; index1 < (int) (Math.floor((Math.random() * 6))); index1++) {
				entity.rotationYaw = ((entity.rotationYaw) + (yeetPitch));
				entity.rotationPitch = (entity.rotationPitch);
			}
		}
		if ((((entity.motionY) == 0) && (Math.random() < 0.025))) {
			entity.motionX = (entity.motionX);
			entity.motionY = ((entity.motionY) + 1);
			entity.motionZ = (entity.motionZ);
		}
		if ((Math.random() < 0.00625)) {
			entity.attackEntityFrom(DamageSource.WITHER, (float) 1);
		}
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 40, (int) 0, (true), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, (int) 40, (int) 0, (true), (false)));
	}
}
