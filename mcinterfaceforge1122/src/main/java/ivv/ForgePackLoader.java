package ivv;

import net.minecraftforge.fml.common.Mod;

/*
 * This mod is a generic class that will interact with Forge to restrict it as a 1.12.2-only pack.
 * 
 * @author don_bruce
 * @mangler cowboycosmic
 */
//@Mod.EventBusSubscriber
//DO NOT MODIFY THIS LINE!  Modify the things below this line instead.  Modifying this line will cause your pack to crash.
@Mod(modid=ForgePackLoader.MODID, name=ForgePackLoader.MODNAME, version=ForgePackLoader.MODVER, dependencies=ForgePackLoader.DEPS, acceptedMinecraftVersions=ForgePackLoader.MCVERS)
public class ForgePackLoader{
	//The ID for your pack.  Must be unique to every mod and pack in the world!
	public static final String MODID="ivv";
	//Short title for your pack.
	public static final String MODNAME="Immersive Vehicles Vanity";
	//Pack version.  May be linked to from other packs to force specific versions.  Otherwise unused.
	public static final String MODVER="2.4.0";
	//Mods/packs and the versions needed to run this pack.  Put whatever you want, but always leave MTS in here to ensure players have it loaded.
	public static final String DEPS="required-after:mts@[22.0.0,);";
	//What MC versions this pack supports.  If you're using an older ForgePackLoader file and older JSON you can support 1.10.2-1.12.2.
	public static final String MCVERS="[1.12.2,]";
	
	/**
	 * Used to register each JSON's item with Forge on the pack-side but this changed ages ago.
	 * Now does nothing and simply exists to exist. Your pack probably kicks back and smokes a beer or something while this runs.
	 */
	public ForgePackLoader(){}
}
