package Morpheuss93.PolymorphicTool.Gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Morpheuss93.PolymorphicTool.blocks.furnaces.tileEntity.TileEntityAlloyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerAlloyFurnace extends Container {
	
	public int burnTime;
	
	/** */
	public int lastBurnTime;
	
	public int lastCookTime;
	
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
	
	
	public void addCraftingToCrafters(ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		
		icrafting.sendProgressBarUpdate(this, 0, this.alloyFurnace.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.alloyFurnace.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.alloyFurnace.currentBurnTime);
	}
	
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();// video 17 minuto 11:50
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot,int newValue){
		if(slot==0) this.alloyFurnace.cookTime=newValue;
		if(slot==1) this.alloyFurnace.burnTime=newValue;
		if(slot==2) this.alloyFurnace.currentBurnTime=newValue;
	}
	
	public ItemStack transerStackInSlot(EntityPlayer player,int slot){
		return null;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.alloyFurnace.isUseableByPlayer(entityplayer);
	}

}
