package net.cc.ivv.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.cc.ivv.potion.PotionSmoked;
import net.cc.ivv.ElementsIvvMod;

import java.util.Map;
import java.util.Collection;

@ElementsIvvMod.ModElement.Tag
public class ProcedureSmokeStatus extends ElementsIvvMod.ModElement {
	public ProcedureSmokeStatus(ElementsIvvMod instance) {
		super(instance, 9);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SmokeStatus!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((new Object() {
			boolean check() {
				if (entity instanceof EntityLivingBase) {
					Collection<PotionEffect> effects = ((EntityLivingBase) entity).getActivePotionEffects();
					for (PotionEffect effect : effects) {
						if (effect.getPotion() == PotionSmoked.potion)
							return true;
					}
				}
				return false;
			}
		}.check())) {
			return (true);
		}
		return (false);
	}
}
