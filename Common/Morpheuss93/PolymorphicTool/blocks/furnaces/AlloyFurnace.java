package Morpheuss93.PolymorphicTool.blocks.furnaces;

import java.util.Random;

import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import Morpheuss93.PolymorphicTool.blocks.furnaces.tileEntity.TileEntityAlloyFurnace;
import cpw.mods.fml.common.network.FMLNetworkHandler;
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
		return side==metadata ? this.iconFront: this.blockIcon;
	}
	
	@Override
	public void onBlockAdded(World world, int x,int y, int z){
		super.onBlockAdded(world, x, y, z);
		
		this.setDefaultDirection(world, x, y, z);
	}
	
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if(!world.isRemote)
		{
			int l = world.getBlockId(x, y, z-1);//west
			int il = world.getBlockId(x, y, z+1);
			int jl= world.getBlockId(x-1, y, z);
			int kl= world.getBlockId(x+1, y, z);
			byte b0=3;
		         
			if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[il]){
				b0=3;
			} else if(Block.opaqueCubeLookup[il] && !Block.opaqueCubeLookup[l]){
				b0=2;
			}else if(Block.opaqueCubeLookup[kl] && !Block.opaqueCubeLookup[jl]){
				b0=5;
			}else if(Block.opaqueCubeLookup[jl] && !Block.opaqueCubeLookup[kl]){
				b0=5;
			}
			
			
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	public TileEntity createNewTileentity(World world){
		return new TileEntityAlloyFurnace();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x,int y,int z,EntityLivingBase entity, ItemStack stack){
	
		int l=MathHelper.floor_double((double)(entity.rotationYaw *4.0F / 360.0F)+0.5D) & 3;
		
		if(l==0){
			
			world.setBlockMetadataWithNotify(x, y, z, 2,2);
			
		}else if(l==1){
			
			world.setBlockMetadataWithNotify(x, y, z, 5,2);
			
		}else if(l==2){
			
			world.setBlockMetadataWithNotify(x, y, z, 3,2);
			
		}else if(l==3){
			
			world.setBlockMetadataWithNotify(x, y, z, 4,2);
		}
		
		TileEntity en=world.getBlockTileEntity(x, y, z);
		
		/*if(en!=null)
		{
			(TilEntityAlloyFurnace)en
			
		}*/
		//if(itemstack.hasDisplayName())
	}

	@Override
	public  boolean onBlockActivated(World world,int x,int y,int z,EntityPlayer player,int side,float hitX,float hitY,float hitZ){
		
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, Polymorphic.instance,Reference.guiIDAlloyFurnace , world, x, y, z);
		
		}
		
		return true;
	}

}
