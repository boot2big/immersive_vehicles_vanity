
package net.cc.ivv.potion;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.EntityLivingBase;

import net.cc.ivv.procedure.ProcedureBlegh;
import net.cc.ivv.ElementsIvvMod;

import java.util.Map;
import java.util.HashMap;

@ElementsIvvMod.ModElement.Tag
public class PotionMilkpizza extends ElementsIvvMod.ModElement {
	@GameRegistry.ObjectHolder("ivv:milkpizza")
	public static final Potion potion = null;
	public PotionMilkpizza(ElementsIvvMod instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.potions.add(() -> new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		private final ResourceLocation potionIcon;
		public PotionCustom() {
			super(true, -1794728);
			setRegistryName("milkpizza");
			setPotionName("effect.milkpizza");
			potionIcon = new ResourceLocation("ivv:textures/mob_effect/milkpizza.png");
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(PotionEffect effect) {
			return false;
		}

		@Override
		public boolean shouldRenderHUD(PotionEffect effect) {
			return false;
		}

		@Override
		public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn, int amplifier) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				ProcedureBlegh.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
