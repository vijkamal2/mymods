/*************************************************************
 ****************CODAKID MINECRAFT MODDING********************
 *************************************************************/

package mymod;

import mymod.CodakidFiles.BossModelWolf;
import mymod.CodakidFiles.Codakid;
import mymod._01_ChapterOne_ForgeYourSword.CustomMonster;
import mymod._01_ChapterOne_ForgeYourSword.CustomSword;
import mymod._02_ChapterTwo_StrikeTheEarth.CustomIngot;
import mymod._02_ChapterTwo_StrikeTheEarth.CustomOre;
import mymod._02_ChapterTwo_StrikeTheEarth.CustomPickaxe;
import mymod._02_ChapterTwo_StrikeTheEarth.LaserAxe;
import mymod._04_ChapterFour_MakeSomeMonsters.CKModelDragon;
import mymod._04_ChapterFour_MakeSomeMonsters.CKModelRabbit;
import mymod._04_ChapterFour_MakeSomeMonsters.CKModelWither;
import mymod._04_ChapterFour_MakeSomeMonsters.CustomHoe;
import mymod._04_ChapterFour_MakeSomeMonsters.CustomMob;
import mymod._05_ChapterFive_RareLoot.ChanceBlock;
import mymod._06_ChapterSix_BrandNewBiomes.CustomBiome;
import mymod._07_ChapterSeven_ExplosionsAndSpecialEffects.BuildGrenade;
import mymod._07_ChapterSeven_ExplosionsAndSpecialEffects.ClusterGrenade;
import mymod._07_ChapterSeven_ExplosionsAndSpecialEffects.CustomGrenade;
import mymod._07_ChapterSeven_ExplosionsAndSpecialEffects.EntityBuildGrenade;
import mymod._07_ChapterSeven_ExplosionsAndSpecialEffects.EntityClusterGrenade;
import mymod._07_ChapterSeven_ExplosionsAndSpecialEffects.EntityClusterGrenadeFragment;
import mymod._07_ChapterSeven_ExplosionsAndSpecialEffects.EntityGrenade;
import mymod._08_ChapterEight_CustomStructures.StructureBlock;
import mymod._09_ChapterNine_WorldGeneration.CustomWorldGen;
import mymod._10_ChapterTen_EpicWeapons.ThunderHammer;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main
{
	public static final String MODNAME = "Epic Weapons";
    public static final String MODID = "foundations";
    public static final String VERSION = "1.0";

    //DECLARE VARIABLES
    public static Item mySword;
    public static ToolMaterial myToolMaterial;
    public static Item myPickaxe;
    public static Block myOre;
    public static Item myIngot;
    public static Item laserAxe;
    public static Item myHelmet;
    public static Item myChestplate;
    public static Item myLeggings;
    public static Item myBoots;
    public static ArmorMaterial myArmorMaterial;
    public static Block myChanceBlock;
    public static Item myThunderHammer;
    public static BiomeGenBase myBiome;
    public static Item myGrenade;
    public static Item myHoe;
    public static Item myClusterGrenade;
    public static Item myBuildGrenade;
    public static Block myStructure;
    
    
    

    @EventHandler 
    public void preinit(FMLPreInitializationEvent event)
    {
    		//hi mac you are my friend
    		//INITIALIZE VARIABLES
    		myToolMaterial = EnumHelper.addToolMaterial("spin n thwack", 999999999, 999999999, 999999999F, 999999999F, 100);
    		
    		mySword = new CustomSword();
    		myPickaxe = new CustomPickaxe();
    		myOre = new CustomOre();
    		myHoe = new CustomHoe();
    		myIngot = new CustomIngot();
    		laserAxe = new LaserAxe();
    		
    		myArmorMaterial = EnumHelper.addArmorMaterial("Asgardian Gold", MODID + ":myArmor", 500, new int []{10,20,15,10}, 100);
    		myChanceBlock = new ChanceBlock();
    		
    		myThunderHammer = new ThunderHammer();
    		myBiome = new CustomBiome();
    		myGrenade = new CustomGrenade();    
    		
    		myClusterGrenade = new ClusterGrenade();
    		myBuildGrenade = new BuildGrenade();
    		myStructure = new StructureBlock();
    		
    		
    		
    		
    		//REGISTER ITEMS AND BLOCKS
    		GameRegistry.registerItem(mySword, "mySword");
    		GameRegistry.registerItem(myPickaxe, "myPickaxe");
    		GameRegistry.registerBlock(myOre, "myOre");
    		GameRegistry.registerItem(myIngot, "myIngot");
    		GameRegistry.registerItem(laserAxe, "laserAxe");
    		
    		GameRegistry.registerItem(myThunderHammer, "myHammer");
    		GameRegistry.registerItem(myGrenade, "myGrenade");
    		GameRegistry.registerItem(myHoe, "myHoe");
    		GameRegistry.registerItem(myClusterGrenade, "myClusterGrenade");
    		GameRegistry.registerItem(myBuildGrenade, "myBuildGrenade");
    		GameRegistry.registerBlock(myStructure, "myStructure");
    		GameRegistry.registerBlock(myChanceBlock, "chanceBlock");
    		
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	//REGISTER TEXTURES
    	Codakid.registerItemTexture(mySword);
    	Codakid.registerItemTexture(myPickaxe);
    	Codakid.registerBlockTexture(myOre);
    	Codakid.registerItemTexture(myIngot);
    	Codakid.registerItemTexture(laserAxe);
   
    	Codakid.registerItemTexture(myThunderHammer);
    	Codakid.registerGrenadeTexture(myGrenade, EntityGrenade.class);
    	Codakid.registerItemTexture(myHoe);
    	Codakid.registerClusterGrenadeTexture(myClusterGrenade, EntityClusterGrenade.class, EntityClusterGrenadeFragment.class);
    	Codakid.registerGrenadeTexture(myBuildGrenade, EntityBuildGrenade.class);
    	Codakid.registerBlockTexture(myStructure);
    	Codakid.registerBlockTexture(myChanceBlock);

    	//ADD RECIPES
    	GameRegistry.addShapedRecipe(new ItemStack(mySword), 
    			" S ",
    			" G ",
    			" B ",
    			'S', Items.stick,
    			'G', Blocks.gold_ore,
    			'B', Blocks.beacon); 
    	GameRegistry.addShapedRecipe(new ItemStack(myPickaxe), 
    			" R ",
    			" O ",
    			" T ",
    			'R', Blocks.redstone_ore,
    			'O', Blocks.obsidian,
    			'T', Blocks.redstone_torch); 
    	
    	GameRegistry.addSmelting(myOre, new ItemStack (myIngot), 64F);

    	//REGISTER MOBS
    	Codakid.registerMonster(CustomMonster.class, 2);
    	
    	EntityRegistry.registerGlobalEntityID(CustomMob.class , "myEntity", EntityRegistry.findGlobalUniqueEntityId(), 0x000066, 0x99CCFF);
    	Codakid.registerEntity(CustomMob.class, new CKModelWither(0), "wither");
    	
    	EntityRegistry.addSpawn(CustomMob.class, 1000, 1, 3, EnumCreatureType.MONSTER, new BiomeGenBase[] {
    			BiomeGenBase.hell,
    			BiomeGenBase.plains,
    			BiomeGenBase.forest,
    			BiomeGenBase.desert,
    			BiomeGenBase.taiga
    	});
    	//REGISTER BIOMES
    	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(myBiome, 100));
    	BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(myBiome, 100));
    	BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(myBiome, 100));
    	BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(myBiome, 100));
 
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {



    }

}
