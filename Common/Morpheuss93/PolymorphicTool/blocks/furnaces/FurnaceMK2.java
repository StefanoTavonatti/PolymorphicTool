package Morpheuss93.PolymorphicTool.blocks.furnaces;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
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

	/*@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
	   return new TestTile();
	}

	public boolean onBlockActivated(World par1World,
            int par2,
            int par3,
            int par4,
            EntityPlayer par5EntityPlayer,
            int par6,
            float par7,
            float par8,
            float par9)
	{
		
		TestTile tile = (TestTile) par1World.getBlockTileEntity(par2, par3, par4);
		if (tile != null)
		{
			super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
			
			 Side side = FMLCommonHandler.instance().getEffectiveSide();
			
			if(side == Side.CLIENT)
			{
				//tile.readFromNBT(tile.tag);
				int l = tile.NumeroPassaggi;
				tile.NumeroPassaggi+=1;
				sendChangeToServer(par2,par3,par4,tile.NumeroPassaggi);
				par5EntityPlayer.addChatMessage("Passaggi Non Remote"+tile.NumeroPassaggi);
				
				//tile.writeToNBT(tile.tag);
				
				//par5EntityPlayer.openGui(Polymorphic.instance,1, par1World, par2,par3,par4);
				
			}
			
			 if(side == Side.SERVER)
				   par5EntityPlayer.addChatMessage("Passaggi Remote"+tile.NumeroPassaggi);
			 
			
		   
			//int l = tile.NumeroPassaggi;
			tile.NumeroPassaggi+=1;
			
		
		  /* if(par1World.isRemote)
			   par5EntityPlayer.addChatMessage("Passaggi Remote"+tile.NumeroPassaggi);
		   if(!par1World.isRemote)
			   par5EntityPlayer.addChatMessage("Passaggi Non Remote"+tile.NumeroPassaggi);
		   
		   if(!par1World.isRemote)
			   sendChangeToServer(par2,par3,par4,tile.NumeroPassaggi);*/
		}
		else
		{
			par5EntityPlayer.addChatMessage("NonTrovato");
		}
		
		
		return true;
	}
	
	public void sendChangeToServer(int x,int y,int z,int m){
	    ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
	    DataOutputStream outputStream = new DataOutputStream(bos);
	    try {
	        outputStream.writeInt(x);
	        outputStream.writeInt(y);
	        outputStream.writeInt(z);
	        //write the relevant information here... exemple:
	        outputStream.writeInt(m);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	               
	    Packet250CustomPayload packet = new Packet250CustomPayload();
	    packet.channel = "Polymorphic";
	    packet.data = bos.toByteArray();
	    packet.length = bos.size();

	    PacketDispatcher.sendPacketToServer(packet);
	}
		

}
