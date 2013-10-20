package Morpheuss93.PolymorphicTool;

import org.bouncycastle.asn1.cmp.GenRepContent;

import Morpheuss93.PolymorphicTool.blocks.BlueMonomerOre;
import Morpheuss93.PolymorphicTool.blocks.GreenMonomerOre;
import Morpheuss93.PolymorphicTool.blocks.furnaces.AlloyFurnace;
import Morpheuss93.PolymorphicTool.blocks.furnaces.FurnaceMK2;
import Morpheuss93.PolymorphicTool.blocks.furnaces.tileEntity.TileEntityAlloyFurnace;
import Morpheuss93.PolymorphicTool.item.dusts.BlueMonomerDust;
import Morpheuss93.PolymorphicTool.item.dusts.GreenMonomerDust;
import Morpheuss93.PolymorphicTool.item.monomers.BlueMonomer;
import Morpheuss93.PolymorphicTool.item.monomers.GreenMonomer;
import Morpheuss93.PolymorphicTool.item.parts.ConversionMatrix;
import Morpheuss93.PolymorphicTool.item.parts.ToolsConversionMatrix;
import Morpheuss93.PolymorphicTool.item.parts.WeaponConversionMatrix;
import Morpheuss93.PolymorphicTool.item.polymers.GenericPolymer;
import Morpheuss93.PolymorphicTool.item.polymers.ShapeMemoryPolymer;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicAxe;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicBow;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicHoe;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicPickaxe;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicShears;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicShovel;
import Morpheuss93.PolymorphicTool.item.tool.PolymorphicSword;
import Morpheuss93.PolymorphicTool.Gui.GuiHandler;
import Morpheuss93.PolymorphicTool.WorldGenerators.*;
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
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.NetworkRegistry;
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
	public static Item conversionMatrix;
	public static Item toolConversionMatrix;
	public static Item weaponConversionMatrix;
	public static Block	furnaceMk2;
	public static Item polymorphicBow;
	public static Block AlloyFurnaceIdle;
	public static Block AlloyFurnaceActive;
	
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
	public static int conversionMatrixID;
	public static int toolConversionMatrixID;
	public static int weaponConversionMatrixID;
	public static int furnaceMk2ID;
	public static int polymorphicBowID;
	public static int AlloyFurnaceIdleID;
	public static int AlloyFurnaceActiveID;
	
	public static int blueMonomerOreVeins;
	public static int greenMonomerOreVeins;
	public static int blueMonomerOreBlockXVeins;
	public static int greenMonomerOreBlockXVeins;
	
	public static EnumToolMaterial POLYMORPHIC = EnumHelper.addToolMaterial("POLYMORPHIC", 4, 2000, 8.0F, 6, 22);

	public static void configureBlock(Configuration config){
		
		
		
		bluMonomerOreID=config.get("Blocks", "BlueMonomerOre",3000).getInt();
		bluMonomerOre=new BlueMonomerOre(bluMonomerOreID,Material.rock).setUnlocalizedName("BlueMonomerOre").setCreativeTab(Polymorphic.tabPolymorphic);
		bluMonomerOre.setHardness(5.0F);
		
		greenMonomerOreID=config.get("Blocks", "GreenMonomerOre", 3001).getInt();
		greenMonomerOre=new GreenMonomerOre(greenMonomerOreID,Material.rock).setUnlocalizedName("GreenMonomerOre").setCreativeTab(Polymorphic.tabPolymorphic).setHardness(5.0F);
		
		furnaceMk2ID=config.get("Blocks", "FurnaceMk2", 3002).getInt();
		furnaceMk2=new FurnaceMK2(furnaceMk2ID).setUnlocalizedName("FurnaceMK2").setCreativeTab(Polymorphic.tabPolymorphic);
		
		OreDictionary.registerOre("OreBluMonomer", new ItemStack(bluMonomerOre));
		OreDictionary.registerOre("OreGreenMonomerr", new ItemStack(greenMonomerOre));//completare gli altri
		//OreDictionary.registerOre("OreGreenMonomer", new ItemStack(ingotCopper));
		
		AlloyFurnaceIdleID=config.get("Blocks", "AlloyFurnaceIdle", 3003).getInt();
		AlloyFurnaceActiveID=config.get("Blocks", "AlloyFurnaceActive", 3004).getInt();		
		AlloyFurnaceIdle=new AlloyFurnace(AlloyFurnaceIdleID,false).setUnlocalizedName("AlloyFurnaceIdle").setHardness(3.5F);
		AlloyFurnaceActive=new AlloyFurnace(AlloyFurnaceActiveID,true).setUnlocalizedName("AlloyFurnaceActive").setHardness(3.5F).setLightValue(0.9F);
		
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
		
		polymorphicAxeID=config.get("Items", "PolymorphicAxe", 3507).getInt();
		polymorphicAxe=new PolymorphicAxe(polymorphicAxeID).setUnlocalizedName("PolymorphicAxe");
		
		polymorphicHoeID=config.get("Items", "PolymorphicHoe", 3508).getInt();
		polymorphicHoe=new PolymorphicHoe(polymorphicHoeID).setUnlocalizedName("PolymorphicHoe");
		
		polymorphicShearsID=config.get("Items", "PolymorphicShears", 3509).getInt();
		polymorphicShears=new PolymorphicShears(polymorphicShearsID).setUnlocalizedName("PolymorphicShears");
		
		polymorphicShovelID=config.get("Items", "PolymorphicShovel", 3510).getInt();
		polymorphicShovel=new PolymorphicShovel(polymorphicShovelID).setUnlocalizedName("PolymorphicShovel");
		
		polymorphicSwordID=config.get("Items", "PolymorphicSword", 3511).getInt();
		polymorphicSword=new PolymorphicSword(polymorphicSwordID).setUnlocalizedName("PolymorphicSword");
		
		conversionMatrixID=config.get("Items", "ConversionMatrix", 3512).getInt();
		conversionMatrix=new ConversionMatrix(conversionMatrixID).setUnlocalizedName("ConversionMatrix");
		
		toolConversionMatrixID=config.get("Items", "ToolConversionMatrix", 3513).getInt();
		toolConversionMatrix=new ToolsConversionMatrix(toolConversionMatrixID).setUnlocalizedName("ToolConversionMatrix");
		
		weaponConversionMatrixID=config.get("Items", "WeaponConversionMatrix", 3514).getInt();
		weaponConversionMatrix=new WeaponConversionMatrix(weaponConversionMatrixID).setUnlocalizedName("WeaponConversionMatrix");
	
		polymorphicBowID=config.get("Items", "PolymorphicBow", 3515).getInt();
		polymorphicBow=new PolymorphicBow(polymorphicBowID).setUnlocalizedName("PolymorphicBow");
		
		blueMonomerOreVeins=config.get("OreGenerator", "BlueMonomerOreVeins",25).getInt();
		greenMonomerOreVeins=config.get("OreGenerator", "GreenMonomerOreVeins",25).getInt();
		blueMonomerOreBlockXVeins=config.get("OreGenerator", "BlueMonomerOreBlockXVeins",8).getInt();
		greenMonomerOreBlockXVeins=config.get("OreGenerator", "GreenMonomerOreBlockXVeins",8).getInt();
		
		
	}
	
	public static void registerBlocks(GameRegistry registry){
		registry.registerBlock(bluMonomerOre,"BlueMonomerOre"); 
		registry.registerBlock(greenMonomerOre,"GreenMonomerOre");
		registry.registerBlock(furnaceMk2,"furnaceMk2");
		registry.registerBlock(AlloyFurnaceIdle,"AlloyFurnaceIdle");
		registry.registerBlock(AlloyFurnaceActive,"AlloyFurnaceActive");
		
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
		registry.registerItem(conversionMatrix, "ConversionMatrix");
		registry.registerItem(toolConversionMatrix, "ToolConversionMatrix");
		registry.registerItem(weaponConversionMatrix, "WeaponConversionMatrix");
		registry.registerItem(polymorphicBow, "PolymorphicBow");
	}
	
	public static void setNames(LanguageRegistry registry){
		registry.addName(bluMonomerOre, "Blue Monomer Ore");
		registry.addName(greenMonomerOre, "Green Monomer Ore");
		registry.addName(furnaceMk2, "FurnaceMk2");
		
		
		////item/////
		registry.addName(bluMonomerDust, "Blue Monomer Dust");
		registry.addName(bluMonomer, "Blue Monomer");
		registry.addName(greenMonomerDust, "Green Monomer Dust");
		registry.addName(greenMonomer, "Green Monomer");
		registry.addName(genericPolymer, "Generic Polymer");
		registry.addName(shapeMemoryPolymer, "Shape Memory Polymer");
		registry.addName(polymorphicPickaxe, "Polymorphic Tool (Pickaxe)");
		registry.addName(polymorphicAxe, "Polymorphic Tool (Axe)");
		registry.addName(polymorphicHoe, "Polymorphic Tool (Hoe)");
		registry.addName(polymorphicShovel, "Polymorphic Tool (Shovel)");
		registry.addName(polymorphicShears, "Polymorphic Tool (Shears)");
		registry.addName(polymorphicSword, "Polymorphic Tool (Sword)");
		registry.addName(conversionMatrix, "Conversion Matrix");
		registry.addName(toolConversionMatrix, "Tool Conversion Matrix");
		registry.addName(weaponConversionMatrix, "Weapon Conversion Matrix");
		registry.addName(polymorphicBow, "Polymorphic Bow");
		
		registry.instance().addStringLocalization("conatiner.alloyFurnace","Alloy Furnace");
		
		
		///tab/////
		registry.instance().addStringLocalization("itemGroup.tabPolymorphic", "en_US", "Polymorphic Tool");
	}
	
	public static void setHarvestLevel()
	{
		MinecraftForge.setBlockHarvestLevel(bluMonomerOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(greenMonomerOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(furnaceMk2, "pickaxe", 1);
	}
	
	public static void setRecipes(GameRegistry registry)
	{
		//registry.addRecipe(new ItemStack(bluMonomerOre),new Object[] {" i ",'i',Block.cobblestone }); 
		//registry.addShapelessRecipe(new ItemStack(genericPolymer),new Object[] {new ItemStack(greenMonomer),new ItemStack(bluMonomer)});
		registry.addRecipe(new ItemStack(genericPolymer), new Object[]{"iii","ijj","jj ",'i',bluMonomer,'j',greenMonomer});
		registry.addShapelessRecipe(new ItemStack(shapeMemoryPolymer), new Object[]{new ItemStack(genericPolymer), new ItemStack(Item.redstone)});
		registry.addRecipe(new ItemStack(conversionMatrix),new Object[]{"grg","rdr","grg",'d',Item.diamond,'r',Item.redstone,'g',Item.ingotGold});
		registry.addRecipe(new ItemStack(toolConversionMatrix),new Object[]{"pas","hcf",'p',Item.pickaxeWood,'a',Item.axeWood,'s',Item.shovelWood,'h',Item.hoeWood,'c',conversionMatrix,'f',Item.shears});
		registry.addRecipe(new ItemStack(polymorphicPickaxe),new Object[]{"ppp","pcp","ppp",'p',shapeMemoryPolymer,'c',toolConversionMatrix});
		
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
	
	public static void setWorldGenerator(GameRegistry registry){
		registry.registerWorldGenerator(new WorldGenaratorBluMonomer());
		//registry.registerWorldGenerator(new WorldGeneratorGreenMonomer());
		
	}
	
	public static void setTileEntity(GameRegistry registry){
		
		registry.registerTileEntity(TileEntityAlloyFurnace.class, "tileEntityAlloyFurnace");
		
		setGui();
	}
	
	public static void setGui(){
		GuiHandler guiHandler=new GuiHandler();

		NetworkRegistry.instance().registerGuiHandler(Polymorphic.instance, guiHandler);
	}
	
}
