package Morpheuss93.PolymorphicTool.item.tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Morpheuss93.PolymorphicTool.BlockHandler;
import Morpheuss93.PolymorphicTool.Polymorphic;
import Morpheuss93.PolymorphicTool.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PolymorphicPickaxe extends ItemPickaxe{

	public PolymorphicPickaxe(int id) {
		super(id, BlockHandler.POLYMORPHIC);

		this.setCreativeTab(Polymorphic.tabPolymorphic);
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
			return new ItemStack(BlockHandler.polymorphicAxe,1,stack.getItemDamage());
		else 
		{
			/*stack.getItem().setDamage(stack, 1991);
			player.addChatMessage(""+stack.getItem().getDamage(stack));*/
			
			
			
			return stack;
		}
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
	
	/*@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack,
            World par2World,
            int par3,
            int par4,
            int par5,
            int par6,
            EntityLiving par7EntityLivingBase){
		System.out.println("dentro funz");
		if(par1ItemStack.getItem().getDamage(par1ItemStack)>=1990)
		{
			//par7EntityLivingBase.inventory.changeCurrentItem(BlockHandler.polymorphicSwordID);
			par1ItemStack=new ItemStack(Item.diamond,2);
			System.out.println("dentro if");
			return false;
		}
		else
			return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
	}*/
	
	public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack2)
	{
		//return itemStack2.getItem().itemID== BlockHandler.shapeMemoryPolymerID ? true : super.getIsRepairable(itemStack, itemStack2);
		//System.out.println(itemStack2.getItem().itemID+"   "+BlockHandler.shapeMemoryPolymerID);
		return itemStack2.getItem().itemID==(BlockHandler.shapeMemoryPolymerID+256);
	}

}
