package Morpheuss93.PolymorphicTool.blocks.furnaces;

import java.util.Random;

import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AlloyFurnace extends BlockContainer{

	
		private Random furnaceRand = new Random();
		private final boolean isActive;
		private static boolean keepFurnaceInventory = false;
	//private final boolean isActive;
	
	@SideOnly(Side.CLIENT)
	private Icon iconFront;
	
	@SideOnly(Side.CLIENT)
	private Icon iconSide;
	
	public AlloyFurnace(int id,boolean isActive) {
		super(id, Material.rock);
		
		this.isActive=isActive;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon=iconRegister.registerIcon(Reference.MOD_ID+":"+"AlloyFurnace_side");
		
		this.iconFront = iconRegister.registerIcon(Reference.MOD_ID+":"+(this.isActive ? "AlloyFurnace_front_active" : "AlloyFurnace_front_idle"));
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata){
		if(side == 0) {
			return this.blockIcon;//bottomIcon;
		} else if(side == 1) {
			return  blockIcon;
		} else if(side== 2){
			return iconFront;
		} else 
		{
			return  blockIcon;
		}
	}
	
	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
	         if (!par1World.isRemote)
	         {
	                 int l = par1World.getBlockId(par2, par3, par4 - 1);
	                 int i1 = par1World.getBlockId(par2, par3, par4 + 1);
	                 int j1 = par1World.getBlockId(par2 - 1, par3, par4);
	                 int k1 = par1World.getBlockId(par2 + 1, par3, par4);
	                 byte b0 = 3;
	                 if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
	                 {
	                         b0 = 3;
	                 }
	                 if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
	                 {
	                         b0 = 2;
	                 }
	                 if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
	                 {
	                         b0 = 5;
	                 }
	                 if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
	                 {
	                         b0 = 4;
	                 }
	                 par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
	         }
	}
	

	

}
