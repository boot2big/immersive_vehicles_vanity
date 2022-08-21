package net.cc.ivv.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.cc.ivv.ElementsIvvMod;

import java.util.Map;

@ElementsIvvMod.ModElement.Tag
public class ProcedureEeey extends ElementsIvvMod.ModElement {
	public ProcedureEeey(ElementsIvvMod instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Eeey!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Eeey!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((((entity.getDisplayName().getUnformattedText())).equals("ConnieCommie"))
				|| (((entity.getDisplayName().getUnformattedText())).equals("TheCactus27")))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Invalid command structure"), (false));
			}
		} else {
			world.playSound((EntityPlayer) null, (entity.posX), (entity.posY), (entity.posZ),
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ivv:kek")),
					SoundCategory.NEUTRAL, (float) 0.8, (float) 1);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(
							new TextComponentString((("* ") + "" + ((entity.getDisplayName().getUnformattedText())) + "" + (" keks *"))));
			}
		}
	}
}
