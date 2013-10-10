package Morpheuss93.PolymorphicTool.blocks.furnaces;

import Morpheuss93.PolymorphicTool.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class FurnaceMK2 extends BlockContainer{

	/*public FurnaceMK2(int id) {
		super(id, Material.rock);
		
	}*/
	
	public FurnaceMK2(int par1) {
		super(par1, Material.rock);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon,frontIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		topIcon = icon.registerIcon(Reference.MOD_ID+":" + this.getUnlocalizedName().substring(5) + "_top");
		bottomIcon = icon.registerIcon(Reference.MOD_ID+ ":" + this.getUnlocalizedName().substring(5) + "_top");
		sideIcon = icon.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5)+ "_side");
		frontIcon = icon.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5)+ "_front");
		}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(side == 0) {
			return bottomIcon;
		} else if(side == 1) {
			return topIcon;
		} else if(side== 2){
			return frontIcon;
		} else 
		{
			return sideIcon;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

	
		

}
