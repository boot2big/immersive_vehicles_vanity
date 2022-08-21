package net.cc.ivv.procedure;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.cc.ivv.ElementsIvvMod;

import java.util.Map;

@ElementsIvvMod.ModElement.Tag
public class ProcedurePiracyWarning extends ElementsIvvMod.ModElement {
	public ProcedurePiracyWarning(ElementsIvvMod instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		System.out.println("Thank you for using IVV!");
		System.out.println("Please ensure that you've only downloaded this mod through PlanetMinecraft.");
	}

	@Override
	public void init(FMLInitializationEvent event) {
		this.executeProcedure(new java.util.HashMap<>());
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
