package net.cc.ivv.procedure;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.cc.ivv.ElementsIvvMod;

import java.util.Map;

@ElementsIvvMod.ModElement.Tag
public class ProcedureBlegh extends ElementsIvvMod.ModElement {
	public ProcedureBlegh(ElementsIvvMod instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Blegh!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Blegh!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		entity.attackEntityFrom(DamageSource.GENERIC,
				(float) ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getMaxHealth() : -1)
						+ ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1))
						* ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1)));
		world.playSound((EntityPlayer) null, (entity.posX), ((entity.posY) + 1), (entity.posZ),
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ivv:milkpizza")),
				SoundCategory.NEUTRAL, (float) 1, (float) 1);
	}
}
