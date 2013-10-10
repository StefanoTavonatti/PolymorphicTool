package Morpheuss93.PolymorphicTool.Gui;

import Morpheuss93.PolymorphicTool.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class GuiDamage extends Gui{
	
	private Minecraft mc;

	  public GuiDamage(Minecraft mc)
	  {
	    super();
	    
	    // We need this to invoke the render engine.
	    this.mc=mc;
	    
	  }
	  
	 /* @ForgeSubscribe(priority = EventPriority.NORMAL)
	  public void onRenderExperienceBar(RenderGameOverlayEvent event)
	  {
		 
		  
		  	ItemStack is=mc.thePlayer.getItemInUse();
	          Icon iconIndex = mc.thePlayer.getItemInUse().getItem().getIconIndex(is);
	          ResourceLocation rs=new ResourceLocation(Reference.MOD_ID+":PolymorphicPickaxe");
	          this.mc.renderEngine.bindTexture(rs);
	          
	          this.drawTexturedModalRect(10,10,16,16,50,50);
	        
	  }*/

}
