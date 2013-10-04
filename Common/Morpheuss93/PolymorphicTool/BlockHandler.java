package Morpheuss93.PolymorphicTool;

import Morpheuss93.PolymorphicTool.blocks.BlueMonomerOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockHandler {
	public static Block bluMonomerOre;

	public static void configureBlock(Configuration config){
		
		bluMonomerOre=new BlueMonomerOre(config.get("Blocks", "BlueMonomerOre",3000).getInt(),Material.rock).setUnlocalizedName("BlueMonomerOre").setCreativeTab(CreativeTabs.tabBlock);
		bluMonomerOre.setHardness(50.0F);
	}
	
	public static void registerBlocks(GameRegistry registry){
		registry.registerBlock(bluMonomerOre,"BlueMonomerOre"); 
	}
	
	public static void setNames(LanguageRegistry registry){
		registry.addName(bluMonomerOre, "Blue Monomer Ore");
	}
}
