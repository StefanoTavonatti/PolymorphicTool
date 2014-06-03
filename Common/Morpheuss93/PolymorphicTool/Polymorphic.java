package Morpheuss93.PolymorphicTool;


import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.MOD_VERSION)
@NetworkMod(serverSideRequired=false,clientSideRequired=true)
//@NetworkMod(serverSideRequired=false,clientSideRequired=true,channels={"Polymorphic"}, packetHandler = Morpheuss93.PolymorphicTool.PacketHandler.class)
public class Polymorphic {
	
	@Instance(Reference.MOD_NAME)
	public static Polymorphic instance;
	
	@SidedProxy(clientSide = "Morpheuss93.PolymorphicTool.client.ClientProxy",serverSide="Morpheuss93.PolymorphicTool.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Configuration config=new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		BlockHandler.configureBlock(config);
		config.save();
		
		GameRegistry.registerTileEntity(Morpheuss93.PolymorphicTool.blocks.furnaces.TestTile.class, "TestTile");
		
		BlockHandler.registerBlocks(new GameRegistry());
		BlockHandler.setNames(new LanguageRegistry()); 
		BlockHandler.setHarvestLevel();
		BlockHandler.setRecipes(new GameRegistry()); 
		BlockHandler.setToolClass();
		BlockHandler.setWorldGenerator(new GameRegistry());
		BlockHandler.setTileEntity(new GameRegistry());
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		// MinecraftForge.EVENT_BUS.register(new GuiDamage(Minecraft.getMinecraft()));
	}
	
	public static CreativeTabs tabPolymorphic = new CreativeTabs("tabPolymorphic") {
        public ItemStack getIconItemStack() {
                return new ItemStack(BlockHandler.bluMonomerDust, 1, 0);
        }
};

}
