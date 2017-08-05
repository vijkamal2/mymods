package mymod._02_ChapterTwo_StrikeTheEarth;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class CustomPickaxe extends ItemPickaxe {
	
	public CustomPickaxe() {
		
		super(Main.myToolMaterial);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName("myPickaxe");
	}

}
