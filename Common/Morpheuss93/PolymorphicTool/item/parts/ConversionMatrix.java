package Morpheuss93.PolymorphicTool.item.parts;

import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ConversionMatrix extends Item{

	public ConversionMatrix(int id) {
		super(id);
		
		this.setCreativeTab(Polymorphic.tabPolymorphic);
		//
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		//if(this.blockIcon==null) 
		this.itemIcon = register.registerIcon(Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
		
	}


}
