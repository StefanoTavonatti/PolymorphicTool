package Morpheuss93.PolymorphicTool;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import Morpheuss93.PolymorphicTool.blocks.furnaces.TestTile;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		
		int x =0;
	    int y =0;
	    int z =0;
	    int num=0;
		
		//  
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		
		int randomInt1;
        int randomInt2;
        
        try {
                x = inputStream.readInt();
                y = inputStream.readInt();
                z = inputStream.readInt();
                num = inputStream.readInt();
        } catch (IOException e) {
                e.printStackTrace();
                return;
        }
        		
		
		////
	    
        Side side = FMLCommonHandler.instance().getEffectiveSide();

	    EntityPlayerMP playerMP = (EntityPlayerMP)player;

	    TileEntity te = playerMP.worldObj.getBlockTileEntity(x, y, z);
	    if(te != null){
	        if(te instanceof TestTile){
	        	//if(side == Side.SERVER)
	        	System.out.println("Qui");
	        	TestTile tet = (TestTile)te;
	        	
	        	
	            tet.NumeroPassaggi=num;
	           // tet.receiveClientEvent(1, num);
	            /*tet.updateEntity();
	            tet.updateContainingBlockInfo();*/
	           //NBTTagCompound par1=new NBTTagCompound();
	           // par1.setInteger("NumeroPassaggi", num);
	            //tet.writeToNBT(par1);
	            
	            
	            playerMP.worldObj.markBlockForUpdate(x, y, z);//this could also be the code to make a custom packet to send to all players
	            //PacketDispatcher.sendPacketToPlayer(packet, (Player)player);
	        }
	    }
		
	}

}
