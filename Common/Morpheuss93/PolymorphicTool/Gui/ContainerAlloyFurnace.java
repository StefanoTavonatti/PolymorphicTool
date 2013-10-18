package Morpheuss93.PolymorphicTool.Gui;

import Morpheuss93.PolymorphicTool.blocks.furnaces.tileEntity.TileEntityAlloyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerAlloyFurnace extends Container {

	public ContainerAlloyFurnace(InventoryPlayer inventoryPlayer, TileEntityAlloyFurnace entity){
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

}
