package Morpheuss93.PolymorphicTool.item.tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class PolymorphicSword extends ItemSword{

	public PolymorphicSword(int id) {
		super(id, BlockHandler.POLYMORPHIC);

		this.setCreativeTab(Polymorphic.tabPolymorphic);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		this.itemIcon = register.registerIcon(Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack,
            World par2World,
            EntityPlayer player)
	{
		if(player.isSneaking())
			return new ItemStack(Item.goldenCarrot);
		else return new ItemStack(this);
	}

}
