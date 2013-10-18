package Morpheuss93.PolymorphicTool.Gui;

import Morpheuss93.PolymorphicTool.Reference;
import Morpheuss93.PolymorphicTool.blocks.furnaces.tileEntity.TileEntityAlloyFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.I18n;

public class GuiAlloyFurnace extends GuiContainer{
	
	public TileEntityAlloyFurnace alloyFurnace;
	public static final ResourceLocation texture=new ResourceLocation(Reference.MOD_ID,"textures/gui/AlloyFurnace.png");

	public GuiAlloyFurnace(InventoryPlayer inventoryPlayer, TileEntityAlloyFurnace entity ){
		super(new ContainerAlloyFurnace(inventoryPlayer, entity));
	
		this.alloyFurnace=entity;
		
		this.xSize=176;
		this.ySize=166;
	}

	@Override
	public void drawGuiContainerForegroundLayer(int par1,int par2){
	//	String name=this.alloyFurnace.isInvNameLocalized() ? this.alloyFurnace.getInvName():"AlloyFurnace";
		String name="asd";
		this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize-96+2, 4210752);
		this.fontRenderer.drawString(name, this.xSize/2-this.fontRenderer.getStringWidth(name)/2, 6,4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		
		
	}
}
