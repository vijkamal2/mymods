package mymod.CodakidFiles;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;

import mymod.Main;
import mymod._01_ChapterOne_ForgeYourSword.CustomMonster;
import mymod._04_ChapterFour_MakeSomeMonsters.RenderEntity;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

 //Welcome to the Codakid helper file! I'm glad you decided to try and take a look at some of the code we wrote to make your modding life easier.
 //All of the blue lines of text which looks like
/**
 * this are also comments. They will help explain what each method does.
 */
 //Hope you have fun looking through our code, and thanks again for taking a course with Codakid!

public class Codakid {
	
	/**
	 * Applies a potion effect to the player.
	 * 
	 * Potions come from the Potion list. Duration is counted in frames, so a duration of 30 will last one second.
	 * The amplifier will make the potion effect more powerful.
	 * 
	 * Example: Codakid.applyPotion(player, Potion.moveSpeed, 300, 3);
	 * 
	 * @param player
	 * @param potion
	 * @param duration
	 * @param amplifier
	 */
	public static void applyPotion(EntityPlayer player, Potion potion, int duration, int amplifier) {
		player.addPotionEffect(new PotionEffect(potion.id, duration, amplifier));
	}
	
	/**
	 * Registers a block with its texture. 
	 * 
	 * Looks through block textures and registers whichever one has the same name as the block's unlocalized name.
	 * 
	 * @param block
	 */
	public static void registerBlockTexture(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation("foundations:" + block.getUnlocalizedName().substring(5), "inventory"));
	}
	
	/**
	 * Registers an item with its texture. 
	 * 
	 * Looks through item textures and registers whichever one has the same name as the item's unlocalized name.
	 * 
	 * @param item
	 */
	public static void registerItemTexture(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation("foundations:" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	/**
	 * Registers textures for both the grenade item and grenade entity.
	 * 
	 * @param grenade
	 * @param entity
	 */
	public static void registerGrenadeTexture(Item grenade, Class<? extends Entity> entity) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(grenade, 0, new ModelResourceLocation(Main.MODID + ":" + grenade.getUnlocalizedName().substring(5), "inventory"));
		RenderingRegistry.registerEntityRenderingHandler(entity,  new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), grenade, Minecraft.getMinecraft().getRenderItem()));
	}
	
	/**
	 * Registers textures for the grenade item, grenade entity, and grenade child entity.
	 * 
	 * @param grenade
	 * @param entity
	 * @param entityChild
	 */
	public static void registerClusterGrenadeTexture(Item grenade, Class<? extends Entity> entity, Class<? extends Entity> entityChild) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(grenade, 0, new ModelResourceLocation(Main.MODID + ":" + grenade.getUnlocalizedName().substring(5), "inventory"));
		RenderingRegistry.registerEntityRenderingHandler(entity,  new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), grenade, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(entityChild,  new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), grenade, Minecraft.getMinecraft().getRenderItem()));
	}
	
	/**
	 * Registers the monster made in chapter 1.
	 * 
	 * This method only works for the monster made in chapter 1. If you want to make a new entity using Codakid's
	 * helper methods, use registerEntity() instead.
	 * 
	 * The second parameter defines which model it will use:
	 * 	0 - Biped
	 * 	1 - Wolf
	 *  2 - Pig
	 * 
	 * @param entity
	 * @param type
	 */
	public static void registerMonster(Class<? extends EntityMob> entity, int type) {
		int ID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entity, "myMonster", ID, 0x000000, 0xE60000);
		if(type == 0)
			RenderingRegistry.registerEntityRenderingHandler(entity, new RenderMonster(Minecraft.getMinecraft().getRenderManager(), new BossModelBiped(), 0.5F, type));
		else if(type == 1)
			RenderingRegistry.registerEntityRenderingHandler(entity, new RenderMonster(Minecraft.getMinecraft().getRenderManager(), new BossModelWolf(), 0.5F, type));
		else
			RenderingRegistry.registerEntityRenderingHandler(entity, new RenderMonster(Minecraft.getMinecraft().getRenderManager(), new BossModelPig(), 0.5F, type));
	}
	
	/**
	 * Registers an entity with a model and texture. Texture name is given without the file extension
	 * so "myTexture.png" would be written as "myTexture".
	 * 
	 * @param entity
	 * @param model
	 * @param textureName
	 */
	public static void registerEntity(Class<? extends EntityCreature> entity, ModelBase model, String textureName)
	{
		RenderingRegistry.registerEntityRenderingHandler(entity, new RenderEntity(Minecraft.getMinecraft().getRenderManager(), model, textureName));
	}
	
	public static void setMovementSpeed(EntityCreature mob, float value) {
		mob.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(value);
	}
	
	public static void setAttackDamage(EntityCreature mob, float value) {
		mob.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(value);
	}
	
	public static void setMaxHealth(EntityCreature mob, float value) {
		mob.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(value);
	}
	
	public static void setFollowRange(EntityCreature mob, float value) {
		mob.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(value);
	}
	
	/**
	 * Spawns items of a given type at the block position.
	 * 
	 * @param world
	 * @param pos
	 * @param item
	 * @param count
	 */
	public static void spawnItem(World worldIn, BlockPos pos, Item item, int count)
	{
		for(int i = 0; i < count; i++)
			worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item)));
	}
	
	/**
	 * Spawns grabbable blocks of a given type at the block position.
	 * 
	 * @param world
	 * @param pos
	 * @param block
	 * @param count
	 */
	public static void spawnBlock(World worldIn, BlockPos pos, Block block, int count)
	{
		for(int i = 0; i < count; i++)
			worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(block)));
	}
	
	/**
	 * Spawns a single entity of a given type at the block position with a minor, random offset. Retype this line to spawn multiple entities.
	 * 
	 * @param world
	 * @param pos
	 * @param entity
	 */
	public static void spawnEntity(World worldIn, BlockPos pos, Entity entity)
	{
		Random rand = new Random();
		entity.setPosition(pos.getX()+rand.nextInt(2), pos.getY()+rand.nextInt(2), pos.getZ()+rand.nextInt(2));
		worldIn.spawnEntityInWorld(entity);
	}

	/**
	 * Turns negative numbers into positive numbers. Returns a variable of type long to match the input in chapter 5, so it may
	 * not be the best method to use when working with smaller data types like int and double;
	 * 
	 * @param input
	 * @return
	 */
	public static long makePositive(long input) {
		if(input < 0)
			return input * -1;
		else
			return input;
	}
	
	/**
	 * Builds a structure out of an ArrayList of 2D arrays. Used in chapter 8.
	 * 
	 * @param world
	 * @param pos
	 * @param layers
	 */
	public static void buildStructure(World world, BlockPos pos, ArrayList<Block[][]> layers)
	{
		for(int y = 0; y < layers.size(); y++)
		{
			for(int x = 0; x < layers.get(y).length; x++)
			{
				for(int z = 0; z < layers.get(y)[0].length; z++)
				{
					world.setBlockState(new BlockPos(pos.getX()+x,pos.getY()+y,pos.getZ()+z), layers.get(y)[x][z].getDefaultState());
				}
			}
		}
	}
	
	/**
	 * Handles the ugly code of adding a block to the world generation.
	 * 
	 * @param world
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param minY
	 * @param maxY
	 * @param chance
	 * @param newBlock
	 * @param hostBlocks
	 */
	public static void fullGeneration(World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int chance, Block newBlock, Block... hostBlocks)
	{
			
		int veinSize = 3;
		int heightRange = maxY - minY;
		
		for(Block b : hostBlocks)
		{
			for(int i = 0; i < chance; i++) {
				int xRand = chunkX * 16 + random.nextInt(16);
				int yRand = random.nextInt(heightRange) + minY;
				int zRand = chunkZ * 16 + random.nextInt(16);
				new WorldGenMinable(newBlock.getDefaultState(), veinSize, BlockHelper.forBlock(b)).generate(world, random, new BlockPos(xRand, yRand, zRand ));
			}
		}
	}
	
	
	/**
	 * Stops the game from rendering any image for an entity effectively making it invisible.
	 * 
	 * @param entity
	 */
	public static void makeInvisible(Class<? extends Entity> entity) {
	
		RenderingRegistry.registerEntityRenderingHandler(entity, new RenderInvisible(Minecraft.getMinecraft().getRenderManager(), Items.fire_charge, Minecraft.getMinecraft().getRenderItem()));
		
	}
	

}
