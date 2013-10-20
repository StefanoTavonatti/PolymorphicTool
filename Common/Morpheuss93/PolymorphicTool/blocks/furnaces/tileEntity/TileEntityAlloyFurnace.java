package Morpheuss93.PolymorphicTool.blocks.furnaces.tileEntity;

import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.blocks.furnaces.AlloyFurnace;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;


public class TileEntityAlloyFurnace extends TileEntity implements ISidedInventory{

	
	
	private static final int[] slots_top=new int[]{0};
	private static final int[] slots_bottom=new int[]{2,1};
	private static final int[] slots_side=new int[]{1};
	
	private String localizedName;
	
	private ItemStack[] slots=new ItemStack[3];
	
	
	public int furnaceSpeed=125; //fornace normale 200
	
	
	/** Time Left this furnace to burn for*/
	public int burnTime;
	
	/** */
	public int currentBurnTime;
	
	public int cookTime;
	
	public int getSizeInventory(){
		return this.slots.length;
	}
	
	public boolean isInvNameLocalized(){
		return this.localizedName != null && this.localizedName.length()>0;
	}
	
	public String getInvName(){
		return this.isInvNameLocalized() ? this.localizedName : "conatiner.alloyFurnace";
	}
	
	public void setGuiDysplayName(String displayName){
		this.localizedName=displayName;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		
		return this.slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		
		if(this.slots[i]!=null){
			ItemStack itemstack;
			
			if(this.slots[i].stackSize <=j ){
				itemstack = this.slots[i];
				
				this.slots[i]=null;
				return itemstack;
			}
			else{
				itemstack=this.slots[i].splitStack(j);
				
				if(this.slots[i].stackSize == 0)
				{
					this.slots[i]=null;
				}
				
				return itemstack;
			}
		}
		
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(this.slots[i] != null){
			ItemStack itemstack =this.slots[i];
			this.slots=null;
			return itemstack;
		}
		
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.slots[i] =itemstack;
		
		if(itemstack!=null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize=this.getInventoryStackLimit();
		}
		
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		
		return worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ?false : entityplayer.getDistanceSq((double)this.xCoord+0.5D, (double)this.yCoord+0.5D, (double)this.zCoord+0.5D)<=64.0D;
	}

	@Override
	public void openChest() {
		
		
	}

	@Override
	public void closeChest() {
		
		
	}
	
	public boolean isBurning(){
		return this.burnTime>0;
	}
	
	@Override
	public void updateEntity(){// chiamata ogni tick
		
		boolean flag=this.burnTime>0;
		boolean flag1= false;
		
		
		if(isBurning()){
			this.burnTime--;
		}
		
		if(!this.worldObj.isRemote){
			if(this.burnTime ==0 && this.canSmelt()){
				this.currentBurnTime=this.burnTime= getItemBurnTime(this.slots[1]);
				
				if(isBurning()){
					flag1=true;
					
					
					if(this.slots[1]!=null){
						this.slots[1].stackSize--;
						
						if(this.slots[1].stackSize == 0){
							this.slots[1] =this.slots[1].getItem().getContainerItemStack(this.slots[1]);
						}
					}
				}
			}
			
			if(this.isBurning() && this.canSmelt()){
				this.cookTime++;
				
				if(this.cookTime== this.furnaceSpeed){
					this.cookTime=0;
					this.smeltItem();
					flag1=true;
				}
				
			}else
			{
				this.cookTime=0;
			}
			
			if(flag != isBurning()){
				flag1=true;
				AlloyFurnace.updateAlloyFurnaceBlockState(this.burnTime > 0,this.worldObj, this.xCoord ,this.yCoord,this.zCoord);
			}
				
		}
		
		if(flag1){
			this.onInventoryChanged();
		}
		
	}
	
	
	private boolean canSmelt(){
		if(this.slots[0] == null){
			return false;
		}else //per fornace MK2
		{
			ItemStack itemstack =FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(itemstack == null) return false;
			if(this.slots[2]==null) return true;
			if(!this.slots[2].isItemEqual(itemstack)) return false;
			
			int result = this.slots[2].stackSize+itemstack.stackSize;
			
			return (result <=getInventoryStackLimit() && result<= itemstack.getMaxStackSize());
		}
	}
	
	public void smeltItem(){
		if(this.canSmelt()){
			ItemStack itemstack= FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(this.slots[2]==null){
				this.slots[2]=itemstack.copy();
			}else if(this.slots[2].isItemEqual(itemstack)){
				this.slots[2].stackSize+=itemstack.stackSize;
			}
			
			
			this.slots[0].stackSize--;
			
			if(this.slots[0].stackSize<=0){
				this.slots=null;
			}
		}
	}
	
	
	public static int getItemBurnTime(ItemStack itemstack){
		
		if(itemstack == null){
			return 0;
		} 
		else {
			
			int i=itemstack.getItem().itemID;
			
			Item item =itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.blocksList[i] != null){
				Block block=Block.blocksList[i];
				
				if(block==Block.woodSingleSlab){
					return 150;
				}
				
				if(block.blockMaterial== Material.wood){
					return 300;
				}
				
				//if(block == Block)
			}
			
			if(item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
			if(item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
			if(item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
			//Not real recipe // gameregistry.addFuel per farlo valere per ogni fornace
			if(i == BlockHandler.genericPolymerID) return 100; 
			
			else
				return GameRegistry.getFuelValue(itemstack);
		}
	}
	
	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		
		return i==2 ? false : (i==1 ? isItemFuel(itemstack) :true );
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		
		return var1 ==0 ? slots_bottom:( var1 == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		
		return j !=0 || i != 1 || itemstack.itemID == Item.bucketEmpty.itemID;
	}
	
	
}
