package Morpheuss93.PolymorphicTool;

import Morpheuss93.PolymorphicTool.blocks.BlueMonomerOre;
import Morpheuss93.PolymorphicTool.item.dusts.BlueMonomerDust;
import Morpheuss93.PolymorphicTool.item.dusts.GreenMonomerDust;
import Morpheuss93.PolymorphicTool.item.monomers.BlueMonomer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockHandler {
	
	public static Block bluMonomerOre;
	public static Item bluMonomerDust;
	public static Item bluMonomer;
	public static Item greenMonomerDust;
	
	public static int bluMonomerOreID;
	public static int bluMonomerDustID;
	public static int bluMonomerID;
	public static int greenMonomerDustID;

	public static void configureBlock(Configuration config){
		
		bluMonomerOreID=config.get("Blocks", "BlueMonomerOre",3000).getInt();
		bluMonomerOre=new BlueMonomerOre(bluMonomerOreID,Material.rock).setUnlocalizedName("BlueMonomerOre").setCreativeTab(Polymorphic.tabPolymorphic);
		bluMonomerOre.setHardness(5.0F);
		
		/////Item/////
		bluMonomerDustID=config.get("Items", "BlueMonomerDust", 3500).getInt();
		bluMonomerDust=new BlueMonomerDust(bluMonomerDustID).setUnlocalizedName("BlueMonomerDust"); 
		
		bluMonomerID=config.get("Items", "BluMonomer", 3501).getInt();
		bluMonomer=new BlueMonomer(bluMonomerID).setUnlocalizedName("BlueMonomer"); 
		
		greenMonomerDustID=config.get("Items", "GreenMonomerDust",3502).getInt();
		greenMonomerDust=new GreenMonomerDust(greenMonomerDustID).setUnlocalizedName("GreenMonomerDust");
	}
	
	public static void registerBlocks(GameRegistry registry){
		registry.registerBlock(bluMonomerOre,"BlueMonomerOre"); 
		
		///Item////
		registry.registerItem(bluMonomerDust, "BluMonomerDust");
		registry.registerItem(bluMonomer,"BlueMonomer");
		registry.registerItem(greenMonomerDust, "GreenMonomerDust");
	}
	
	public static void setNames(LanguageRegistry registry){
		registry.addName(bluMonomerOre, "Blue Monomer Ore");
		
		
		////item/////
		registry.addName(bluMonomerDust, "Blue Monomer Dust");
		registry.addName(bluMonomer, "Blue Monomer");
		registry.addName(greenMonomerDust, "Green Monomer Dust");
		
		
		///tab/////
		registry.instance().addStringLocalization("itemGroup.tabPolymorphic", "en_US", "Polymorphic Tool");
	}
	
	public static void setHarvestLevel()
	{
		MinecraftForge.setBlockHarvestLevel(bluMonomerOre, "pickaxe", 2);
	}
	
	public static void setRecipes(GameRegistry registry)
	{
		//registry.addRecipe(new ItemStack(bluMonomerOre),new Object[] {" i ",'i',Block.cobblestone }); 
		
		
		setSmeltingRecipes(registry);
	}
	
	public static void setSmeltingRecipes(GameRegistry registry)
	{
		registry.addSmelting(bluMonomerDust.itemID, new ItemStack(bluMonomer), 0.1f);//da cambiare con monomero
		FurnaceRecipes.smelting().addSmelting(bluMonomerDust.itemID, 15, new ItemStack(bluMonomer, 1, 0), 0.1f);
	}
	
}
