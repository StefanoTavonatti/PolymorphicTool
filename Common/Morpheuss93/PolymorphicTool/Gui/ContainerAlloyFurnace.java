package Morpheuss93.PolymorphicTool.Gui;

import Morpheuss93.PolymorphicTool.blocks.furnaces.tileEntity.TileEntityAlloyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

public class ContainerAlloyFurnace extends Container {
	
	
	private TileEntityAlloyFurnace alloyFurnace;

	public ContainerAlloyFurnace(InventoryPlayer inventory, TileEntityAlloyFurnace tileentity){
		this.alloyFurnace=tileentity;
		
		this.addSlotToContainer(new Slot(tileentity,0,56,17));
		this.addSlotToContainer(new Slot(tileentity,1,56,53));
		this.addSlotToContainer(new SlotFurnace(inventory.player,tileentity,2,116,35));//vedere 17
		
		for(int i=0;i<3;i++){
			for(int j=0;j<9;j++){
				this.addSlotToContainer(new Slot(inventory,j+i*9+9,8+j*18,84+i*18));
			}
		}
		
		for(int i=0; i<9;i++){
			this.addSlotToContainer(new Slot(inventory,i,8+i*18,142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return false;
	}

}
