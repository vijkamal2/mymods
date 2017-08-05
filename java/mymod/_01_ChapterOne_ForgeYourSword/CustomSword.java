package mymod._01_ChapterOne_ForgeYourSword;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CustomSword extends ItemSword {
	
	public CustomSword() {
		
		super(Main.myToolMaterial);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName("mySword");	
	}
	
}