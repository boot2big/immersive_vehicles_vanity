package net.cc.ivv.procedure;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.cc.ivv.ElementsIvvMod;

import java.util.Random;
import java.util.Map;

@ElementsIvvMod.ModElement.Tag
public class ProcedureOminousLookingDamageHandler extends ElementsIvvMod.ModElement {
	public ProcedureOminousLookingDamageHandler(ElementsIvvMod instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OminousLookingDamageHandler!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure OminousLookingDamageHandler!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure OminousLookingDamageHandler!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure OminousLookingDamageHandler!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure OminousLookingDamageHandler!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OminousLookingDamageHandler!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((((itemstack)).getItemDamage()) == 0)) {
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setItemDamage(0);
				}
			}
			world.playSound((EntityPlayer) null, (entity.posX), (entity.posY), (entity.posZ),
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("item.shield.break")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) ((((itemstack)).getMaxDamage()) + 1), new Random(), null)) {
					_ist.shrink(1);
					_ist.setItemDamage(0);
				}
			}
			world.playSound((EntityPlayer) null, (entity.posX), (entity.posY), (entity.posZ),
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ivv:pew")),
					SoundCategory.NEUTRAL, (float) 2, (float) 0.6);
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 2, true);
			}
		}
	}
}
