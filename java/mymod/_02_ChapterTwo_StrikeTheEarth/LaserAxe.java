package mymod._02_ChapterTwo_StrikeTheEarth;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class LaserAxe extends ItemAxe {
	
	public LaserAxe() {
		super(Main.myToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName("laserAxe");
	}

}
