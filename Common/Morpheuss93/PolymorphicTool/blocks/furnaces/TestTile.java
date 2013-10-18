package Morpheuss93.PolymorphicTool.blocks.furnaces;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;


public class TestTile extends TileEntity{
	public int NumeroPassaggi;
	public NBTTagCompound tag;
	
	public TestTile(){
		super();
		tag=new NBTTagCompound();
		NumeroPassaggi=0;
	}
	
	@Override
	   public void writeToNBT(NBTTagCompound par1)
	   {
	      super.writeToNBT(par1);
	      par1.setInteger("NumeroPassaggi", NumeroPassaggi);
	   }

	   @Override
	   public void readFromNBT(NBTTagCompound par1)
	   {
	      super.readFromNBT(par1);
	      this.NumeroPassaggi=par1.getInteger("NumeroPassaggi");
	      
	   }
	   //////////////////////rivedere parte 4
	   /*@Override
	    public boolean receiveClientEvent(int eventID, int numUsingPlayers) {

		   System.out.println("ClientEvent");
	        if (eventID == 1) {
	            this.NumeroPassaggi = numUsingPlayers;
	            return true;
	        }
	        else
	            return super.receiveClientEvent(eventID, numUsingPlayers);
	    }*/
	   
	   

}
