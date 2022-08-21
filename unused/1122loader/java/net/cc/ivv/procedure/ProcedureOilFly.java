package net.cc.ivv.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.cc.ivv.potion.PotionOilyBody;
import net.cc.ivv.ElementsIvvMod;

import java.util.Map;
import java.util.Collection;

@ElementsIvvMod.ModElement.Tag
public class ProcedureOilFly extends ElementsIvvMod.ModElement {
	public ProcedureOilFly(ElementsIvvMod instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OilFly!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OilFly!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((world.canSeeSky(new BlockPos((int) (entity.posX), (int) (entity.posY), (int) (entity.posZ)))) && ((new Object() {
			boolean check() {
				if (entity instanceof EntityLivingBase) {
					Collection<PotionEffect> effects = ((EntityLivingBase) entity).getActivePotionEffects();
					for (PotionEffect effect : effects) {
						if (effect.getPotion() == PotionOilyBody.potion)
							return true;
					}
				}
				return false;
			}
		}.check()) && ((world.isRaining()) || (world.isThundering()))))) {
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).capabilities.isFlying = (true);
				((EntityPlayer) entity).sendPlayerAbilities();
			}
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).capabilities.allowFlying = (true);
				((EntityPlayer) entity).sendPlayerAbilities();
			}
		} else {
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
}
