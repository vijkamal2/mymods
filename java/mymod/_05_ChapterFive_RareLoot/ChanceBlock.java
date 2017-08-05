package mymod._05_ChapterFive_RareLoot;

import java.util.Random;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ChanceBlock extends Block {

	//Constructor
	public ChanceBlock() {
		
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName("chanceBlock");
		
	}
	
	//Make the block drop nothing when broken
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return null;
		
	}
	
	@Override
	public void breakBlock(World worldIn,BlockPos pos, IBlockState state) {
		 Random rand = new Random();
		 int number = rand.nextInt(100)+1;
		 //1% give 64 diamonds and 64 redstone blocks mjolnir and another lucky block
		 if (number<=1) 
		 {
			 Codakid.spawnItem(worldIn, pos, Items.diamond, 64);
			 Codakid.spawnItem(worldIn, pos, Items.redstone, 64);
			 Codakid.spawnItem(worldIn, pos, Main.myThunderHammer, 1);	 
		 }
		 //4% spawn a irongolem
		 else if(number <= 5)
		 {
			 Codakid.spawnEntity(worldIn, pos, new EntityIronGolem(worldIn));
		 }
		 //15% spawn 5 gold ingots
		 else if(number <= 20)
		 {
			 Codakid.spawnItem(worldIn, pos, Items.gold_ingot, 25);
		 }
		 //20%  a snowman
		 else if(number <= 40)
		 {
			 Codakid.spawnEntity(worldIn, pos, new EntitySnowman(worldIn));
		 }
		 //20% spawn 5 creepers
		 else if(number <= 60)
		 {
			 Codakid.spawnEntity(worldIn, pos, new EntityCreeper(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityCreeper(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityCreeper(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityCreeper(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityCreeper(worldIn));
		 }
		 //20% spawn 5 blaze
		 else if(number <= 80)
		 {
			 Codakid.spawnEntity(worldIn, pos, new EntityBlaze(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityBlaze(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityBlaze(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityBlaze(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityBlaze(worldIn));
		 }
		 //10% spawn  ender dragon
		 else if(number <= 90)
		 {
			 Codakid.spawnEntity(worldIn, pos, new EntityDragon(worldIn));
		 }
		 //5% spawn command Block
		 else if(number <= 95)
		 {
			 Codakid.spawnBlock(worldIn, pos, Blocks.command_block, 1);
		 }
		 //4 % spawn 20 zombies
		 else if(number <= 99)
		 {
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntityZombie(worldIn));
		 }
		 //1% spawn 50 skeletons
		 else if(number <= 100)
		 {
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
			 Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));  Codakid.spawnEntity(worldIn, pos, new EntitySkeleton(worldIn));
		 }
		 
		 
		 
	}
		
}
