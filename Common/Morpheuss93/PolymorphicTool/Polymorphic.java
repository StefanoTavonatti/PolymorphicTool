package Morpheuss93.PolymorphicTool;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.MOD_VERSION)
@NetworkMod(serverSideRequired=false,clientSideRequired=true)
public class Polymorphic {
	
	@Instance(Reference.MOD_NAME)
	public static Polymorphic instance;
	
	@SidedProxy(clientSide = "Morpheuss93.PolymorphicTool.client.ClientProxy",serverSide="Morpheuss93.PolymorphicTool.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent even){
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}