package mymod._07_ChapterSeven_ExplosionsAndSpecialEffects;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CustomGrenade extends Item {
	
	//Constructor
	public CustomGrenade() {
		this.setUnlocalizedName("myGrenade");
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}
	
	//What to do when we right click
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		worldIn.spawnEntityInWorld(new EntityGrenade(worldIn, playerIn));
		itemStackIn.stackSize = itemStackIn.stackSize - 1;
        return itemStackIn;
        
    }

}
