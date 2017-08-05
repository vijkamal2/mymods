package mymod._04_ChapterFour_MakeSomeMonsters;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class CustomHoe extends ItemHoe {

	public CustomHoe() {
		super(Main.myToolMaterial);
		this.setUnlocalizedName("myHoe");
		this.setCreativeTab(CreativeTabs.tabTools);
		
		
	}
	

}
