package net.cc.ivv.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.cc.ivv.ElementsIvvMod;

import java.util.Random;
import java.util.Map;

@ElementsIvvMod.ModElement.Tag
public class ProcedureOminousLookingCode extends ElementsIvvMod.ModElement {
	public ProcedureOminousLookingCode(ElementsIvvMod instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OminousLookingCode!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure OminousLookingCode!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OminousLookingCode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		double d20 = 0;
		d20 = (double) ((new Random()).nextInt((int) 100 + 1));
		if ((!((((itemstack)).getItemDamage()) > 0))) {
			entity.setFire((int) 8);
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) ((((itemstack)).getMaxDamage()) + 1), new Random(), null)) {
					_ist.shrink(1);
					_ist.setItemDamage(0);
				}
			}
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 10);
		} else if (((d20) == 69)) {
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
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 20);
		} else if (((d20) == 42)) {
			if ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).experienceLevel : 0) < 2)) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).addExperienceLevel((int) 1);
				if (entity instanceof EntityPlayer && !entity.world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString("You feel slightly more intelligent"), (true));
				}
			} else {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).addExperienceLevel(-((int) 2));
				if (entity instanceof EntityPlayer && !entity.world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString("You feel slightly less intelligent"), (true));
				}
			}
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) ((((itemstack)).getMaxDamage()) + 1), new Random(), null)) {
					_ist.shrink(1);
					_ist.setItemDamage(0);
				}
			}
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 10);
		} else {
			world.playSound((EntityPlayer) null, (entity.posX), (entity.posY), (entity.posZ),
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ivv:letrolle")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) ((((itemstack)).getMaxDamage()) + 1), new Random(), null)) {
					_ist.shrink(1);
					_ist.setItemDamage(0);
				}
			}
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 10);
		}
	}
}
