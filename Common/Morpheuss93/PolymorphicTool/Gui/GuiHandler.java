package Morpheuss93.PolymorphicTool.Gui;

import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import Morpheuss93.PolymorphicTool.blocks.furnaces.tileEntity.TileEntityAlloyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{

	public GuiHandler(){
		//NetworkRegistry.instance().registerGuiHandler(Polymorphic.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
TileEntity entity= world.getBlockTileEntity(x, y, z);
		
		if(entity != null){
			
			switch(ID){
				case Reference.guiIDAlloyFurnace:
					if(entity instanceof TileEntityAlloyFurnace){
						return new ContainerAlloyFurnace(player.inventory, (TileEntityAlloyFurnace)entity);
					}
					break;
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity= world.getBlockTileEntity(x, y, z);
		
		if(entity != null){
			
			switch(ID){
				case Reference.guiIDAlloyFurnace:
					if(entity instanceof TileEntityAlloyFurnace){
						return new GuiAlloyFurnace(player.inventory, (TileEntityAlloyFurnace)entity);
					}
					break;
			}
		}
		
		return null;
	}

}
