package mymod._10_ChapterTen_EpicWeapons;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ThunderHammer extends ItemPickaxe {
	
	public ThunderHammer() {
		super(Main.myToolMaterial);
		this.setUnlocalizedName("myHammer");
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		Vec3 blockHit = playerIn.rayTrace(200, 1F).hitVec;
		worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, blockHit.xCoord, blockHit.yCoord, blockHit.zCoord));
		worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, blockHit.xCoord, blockHit.yCoord, blockHit.zCoord));
		worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, blockHit.xCoord, blockHit.yCoord, blockHit.zCoord));
		worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, blockHit.xCoord, blockHit.yCoord, blockHit.zCoord));
		worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, blockHit.xCoord, blockHit.yCoord, blockHit.zCoord));
		worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, blockHit.xCoord, blockHit.yCoord, blockHit.zCoord));
		worldIn.createExplosion(playerIn, blockHit.xCoord, blockHit.yCoord, blockHit.zCoord, 5F, true);
		
		return itemStackIn;
		
		
	}
	

}
