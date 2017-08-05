package mymod._02_ChapterTwo_StrikeTheEarth;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CustomOre extends Block {

	public CustomOre(){
		
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName("myOre");
		this.setHardness(25F);
		this.setHarvestLevel("pickaxe", 4);
	
	}
	
}
