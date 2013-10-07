package Morpheuss93.PolymorphicTool.item.polymers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ShapeMemoryPolymer extends Item{

	public ShapeMemoryPolymer(int id) {
		super(id);
		
		this.setCreativeTab(Polymorphic.tabPolymorphic);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		this.itemIcon = register.registerIcon(Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
		
	}

}
