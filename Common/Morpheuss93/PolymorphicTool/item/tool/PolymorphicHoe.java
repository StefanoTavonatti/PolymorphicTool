package Morpheuss93.PolymorphicTool.item.tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class PolymorphicHoe extends ItemHoe{

	public PolymorphicHoe(int id) {
		super(id,BlockHandler.POLYMORPHIC);

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
			return new ItemStack(BlockHandler.polymorphicShears,1,stack.getItemDamage());
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
			return false;
		else
			return super.itemInteractionForEntity(itemstack, player, entity);
		
	}
	
	 public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	 {
		 
		 if(par1ItemStack.getItem().getDamage(par1ItemStack)<1990)
		 {
			 return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
		 }
		 else
			 return false;
	 }
	
	/*public boolean onLeftClickEntity(ItemStack stack, //per la spada
            EntityPlayer player,
            Entity entity)
{
		
		
		if(stack.getItem().getDamage(stack)>=1990)
			return true;
		else
			return super.onLeftClickEntity(stack, player, entity);
		
	}*/
	
	

}
