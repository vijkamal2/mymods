package mymod._06_ChapterSix_BrandNewBiomes;

import java.util.Random;

import mymod.Main;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class CustomBiome extends BiomeGenBase {
	
	public CustomBiome() {
		super(150);
		this.setBiomeName("Boss Base");
		this.topBlock =   Blocks.obsidian.getDefaultState();
		this.fillerBlock = Blocks.glass.getDefaultState();
		this.enableRain = false;
		this.setHeight(this.height_HighPlateaus);
		
		
		this.theBiomeDecorator.bigMushroomsPerChunk = 30;
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityOcelot.class, 20, 5, 8));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 35, 10, 15));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 100, 20, 30));
		
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityIronGolem.class, 15, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityGiantZombie.class, 25, 1, 6));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWither.class, 1, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 25, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityBlaze.class, 10, 1, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 10, 1, 20));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 10, 1, 10));
		
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunk, int num1, int num2, double num3) {
		int number = rand.nextInt(10 + 1);
		
		if(number <= 4) {
			
			this.topBlock = Blocks.obsidian.getDefaultState();
					this.fillerBlock = Blocks.quartz_ore.getDefaultState();
					
		}
		else if (number <= 9) {
			this.topBlock = Blocks.redstone_block.getDefaultState();
			this.fillerBlock = Blocks.gold_block.getDefaultState();
		}
		else 
		{
			this.topBlock = Blocks.mossy_cobblestone.getDefaultState();
			this.fillerBlock = Blocks.cocoa.getDefaultState();
			
		
				
			
		
		
		
	

}
		this.generateBiomeTerrain( worldIn,  rand,  chunk, num1,  num2,  num3);
}
}
