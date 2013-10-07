package Morpheuss93.PolymorphicTool;

import Morpheuss93.PolymorphicTool.blocks.BlueMonomerOre;
import Morpheuss93.PolymorphicTool.blocks.GreenMonomerOre;
import Morpheuss93.PolymorphicTool.item.dusts.BlueMonomerDust;
import Morpheuss93.PolymorphicTool.item.dusts.GreenMonomerDust;
import Morpheuss93.PolymorphicTool.item.monomers.BlueMonomer;
import Morpheuss93.PolymorphicTool.item.monomers.GreenMonomer;
import Morpheuss93.PolymorphicTool.item.polymers.GenericPolymer;
import Morpheuss93.PolymorphicTool.item.polymers.ShapeMemoryPolymer;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicAxe;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicHoe;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicPickaxe;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicShears;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicShovel;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicSword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockHandler {
	
	public static Block bluMonomerOre;
	public static Item bluMonomerDust;
	public static Item bluMonomer;
	public static Block greenMonomerOre;
	public static Item greenMonomerDust;
	public static Item greenMonomer;
	public static Item genericPolymer;
	public static Item shapeMemoryPolymer;
	public static Item polymorphicPickaxe;
	public static Item polymorphicAxe;
	public static Item polymorphicHoe;
	public static Item polymorphicShears;
	public static Item polymorphicShovel;
	public static Item polymorphicSword;
	
	public static int bluMonomerOreID;
	public static int bluMonomerDustID;
	public static int bluMonomerID;
	public static int greenMonomerOreID;
	public static int greenMonomerDustID;
	public static int greenMonomerID;
	public static int genericPolymerID;
	public static int shapeMemoryPolymerID;
	public static int polymorphicPickaxeID;
	public static int polymorphicAxeID;
	public static int polymorphicHoeID;
	public static int polymorphicShearsID;
	public static int polymorphicShovelID;
	public static int polymorphicSwordID;
	
	public static EnumToolMaterial POLYMORPHIC = EnumHelper.addToolMaterial("POLYMORPHIC", 4, 2000, 8.0F, 6, 22);

	public static void configureBlock(Configuration config){
		
		bluMonomerOreID=config.get("Blocks", "BlueMonomerOre",3000).getInt();
		bluMonomerOre=new BlueMonomerOre(bluMonomerOreID,Material.rock).setUnlocalizedName("BlueMonomerOre").setCreativeTab(Polymorphic.tabPolymorphic);
		bluMonomerOre.setHardness(5.0F);
		
		greenMonomerOreID=config.get("Blocks", "Green Monomer Ore", 3001).getInt();
		greenMonomerOre=new GreenMonomerOre(greenMonomerOreID,Material.rock).setUnlocalizedName("GreenMonomerOre").setCreativeTab(Polymorphic.tabPolymorphic).setHardness(5.0F); 
		
		/////Item/////
		bluMonomerDustID=config.get("Items", "BlueMonomerDust", 3500).getInt();
		bluMonomerDust=new BlueMonomerDust(bluMonomerDustID).setUnlocalizedName("BlueMonomerDust"); 
		
		bluMonomerID=config.get("Items", "BluMonomer", 3501).getInt();
		bluMonomer=new BlueMonomer(bluMonomerID).setUnlocalizedName("BlueMonomer"); 
		
		greenMonomerDustID=config.get("Items", "GreenMonomerDust",3502).getInt();
		greenMonomerDust=new GreenMonomerDust(greenMonomerDustID).setUnlocalizedName("GreenMonomerDust");
		
		greenMonomerID=config.get("Items", "GreenMonomer", 3503).getInt();
		greenMonomer=new GreenMonomer(greenMonomerID).setUnlocalizedName("GreenMonomer");
		
		genericPolymerID=config.get("Items", "GenericPolymer", 3504).getInt();
		genericPolymer=new GenericPolymer(genericPolymerID).setUnlocalizedName("GenericPolymer");
		
		shapeMemoryPolymerID=config.get("Items", "ShapeMemoryPolymer", 3505).getInt();
		shapeMemoryPolymer=new ShapeMemoryPolymer(shapeMemoryPolymerID).setUnlocalizedName("ShapeMemoryPolymer");
		
		polymorphicPickaxeID=config.get("Items", "polymorphicPickaxe", 3506).getInt();
		polymorphicPickaxe=new PolymorphicPickaxe(polymorphicPickaxeID).setUnlocalizedName("PolymorphicPickaxe");
		
		polymorphicAxeID=config.get("Item", "PolymorphicAxe", 3507).getInt();
		polymorphicAxe=new PolymorphicAxe(polymorphicAxeID).setUnlocalizedName("PolymorphicAxe");
		
		polymorphicHoeID=config.get("Item", "PolymorphicHoe", 3508).getInt();
		polymorphicHoe=new PolymorphicHoe(polymorphicHoeID).setUnlocalizedName("PolymorphicHoe");
		
		polymorphicShearsID=config.get("Item", "PolymorphicShears", 3509).getInt();
		polymorphicShears=new PolymorphicShears(polymorphicShearsID).setUnlocalizedName("PolymorphicShears");
		
		polymorphicShovelID=config.get("Item", "PolymorphicShovel", 3510).getInt();
		polymorphicShovel=new PolymorphicShovel(polymorphicShovelID).setUnlocalizedName("PolymorphicShovel");
		
		polymorphicSwordID=config.get("Item", "PolymorphicSword", 3511).getInt();
		polymorphicSword=new PolymorphicSword(polymorphicSwordID).setUnlocalizedName("PolymorphicSword");
	}
	
	public static void registerBlocks(GameRegistry registry){
		registry.registerBlock(bluMonomerOre,"BlueMonomerOre"); 
		registry.registerBlock(greenMonomerOre,"GreenMonomerOre");
		
		///Item////
		registry.registerItem(bluMonomerDust, "BluMonomerDust");
		registry.registerItem(bluMonomer,"BlueMonomer");
		registry.registerItem(greenMonomerDust, "GreenMonomerDust");
		registry.registerItem(greenMonomer, "GreenMonomer");
		registry.registerItem(genericPolymer, "GenericPolymer");
		registry.registerItem(shapeMemoryPolymer, "ShapeMemoryPolymer");
		registry.registerItem(polymorphicPickaxe, "PolymorphicPickaxe");
		registry.registerItem(polymorphicAxe, "PolymorphicAxe");
		registry.registerItem(polymorphicHoe, "PolymorphicHoe");
		registry.registerItem(polymorphicShears, "PolymorphicShears");
		registry.registerItem(polymorphicShovel, "PolymorphicShovel");
		registry.registerItem(polymorphicSword, "PolymorphicSword");
	}
	
	public static void setNames(LanguageRegistry registry){
		registry.addName(bluMonomerOre, "Blue Monomer Ore");
		registry.addName(greenMonomerOre, "Green Monomer Ore");
		
		
		////item/////
		registry.addName(bluMonomerDust, "Blue Monomer Dust");
		registry.addName(bluMonomer, "Blue Monomer");
		registry.addName(greenMonomerDust, "Green Monomer Dust");
		registry.addName(greenMonomer, "Green Monomer");
		registry.addName(genericPolymer, "Generic Polymer");
		registry.addName(shapeMemoryPolymer, "Shape Memory Polymer");
		registry.addName(polymorphicPickaxe, "Polymorphic Pickaxe");
		registry.addName(polymorphicAxe, "Polymorphic Axe");
		registry.addName(polymorphicHoe, "Polymorphic Hoe");
		registry.addName(polymorphicShovel, "Polymorphic Shovel");
		registry.addName(polymorphicShears, "Polymorphic Shears");
		registry.addName(polymorphicSword, "Polymorphic Sword");
		
		
		///tab/////
		registry.instance().addStringLocalization("itemGroup.tabPolymorphic", "en_US", "Polymorphic Tool");
	}
	
	public static void setHarvestLevel()
	{
		MinecraftForge.setBlockHarvestLevel(bluMonomerOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(greenMonomerOre, "pickaxe", 2);
	}
	
	public static void setRecipes(GameRegistry registry)
	{
		//registry.addRecipe(new ItemStack(bluMonomerOre),new Object[] {" i ",'i',Block.cobblestone }); 
		registry.addShapelessRecipe(new ItemStack(genericPolymer),new Object[] {new ItemStack(greenMonomer),new ItemStack(bluMonomer)});
		registry.addShapelessRecipe(new ItemStack(shapeMemoryPolymer), new Object[]{new ItemStack(genericPolymer), new ItemStack(Item.redstone)});
		
		setSmeltingRecipes(registry);
	}
	
	public static void setSmeltingRecipes(GameRegistry registry)
	{
		registry.addSmelting(bluMonomerDust.itemID, new ItemStack(bluMonomer), 0.1f);//da cambiare con monomero
		FurnaceRecipes.smelting().addSmelting(bluMonomerDust.itemID, 15, new ItemStack(bluMonomer, 1, 0), 0.1f);
	
		registry.addSmelting(greenMonomerDust.itemID, new ItemStack(greenMonomer), 0.1f);
		FurnaceRecipes.smelting().addSmelting(greenMonomerDust.itemID, 15, new ItemStack(greenMonomer, 1, 0), 0.1f);
	}
	
	public static void setToolClass(){
		
		MinecraftForge.setToolClass(polymorphicAxe, "axe", POLYMORPHIC.getHarvestLevel());
		MinecraftForge.setToolClass(polymorphicHoe, "hoe", POLYMORPHIC.getHarvestLevel());
		MinecraftForge.setToolClass(polymorphicPickaxe, "pickaxe", POLYMORPHIC.getHarvestLevel());
		//MinecraftForge.setToolClass(polymorphicShears, "shears", POLYMORPHIC.getHarvestLevel());
		MinecraftForge.setToolClass(polymorphicShovel, "shovel", POLYMORPHIC.getHarvestLevel());
		MinecraftForge.setToolClass(polymorphicSword, "sword", POLYMORPHIC.getHarvestLevel());
		
	}
	
}
