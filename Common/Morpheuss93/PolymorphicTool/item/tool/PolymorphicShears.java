package Morpheuss93.PolymorphicTool.item.tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PolymorphicShears extends ItemShears{

	public PolymorphicShears(int id) {
		super(id);

		this.setMaxDamage(2000);
		//this.setCreativeTab(Polymorphic.tabPolymorphic);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		this.itemIcon = register.registerIcon(Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack,
            World par2World,
            EntityPlayer player)
	{
		if(player.isSneaking())
			return new ItemStack(BlockHandler.polymorphicPickaxe,1,stack.getItemDamage());
		else return stack;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack,int X,int Y,int Z,EntityPlayer player){
		
		if(itemstack.getItem().getDamage(itemstack)>=1990)
		{
			player.addChatMessage("Strumento troppo Danneggiato!!!");
			
			return true;
		}
		else
			return super.onBlockStartBreak(itemstack, X, Y, Z, player);
	}
	
	public boolean itemInteractionForEntity(ItemStack itemstack,
            EntityPlayer player,
            EntityLivingBase entity){
		
		
		if(itemstack.getItem().getDamage(itemstack)>=1990)
		{
			return false;
		}
		else
			return super.itemInteractionForEntity(itemstack, player, entity);
		
	}

}
