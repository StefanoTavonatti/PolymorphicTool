package Morpheuss93.PolymorphicTool.blocks;

import java.util.Random;

import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlueMonomerOre extends Block{

	public BlueMonomerOre(int id, Material material) {
		super(id, material);
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		//if(this.blockIcon==null) 
		this.blockIcon = register.registerIcon(Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
		
	}
	
	public int idDropped(int par1, Random rand,int par2){
		
		//return BlockHandler.bluMonomerDust.itemID;
		return this.blockID;
	}
	
	public int quantityDropped(Random rand)
	{
		//return 2;
		return 1;
	}

	
	
}
