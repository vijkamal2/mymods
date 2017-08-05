package mymod.CodakidFiles;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraftforge.fml.relauncher.SideOnly;
import mymod.Main;
import mymod._01_ChapterOne_ForgeYourSword.CustomMonster;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMonster extends RenderLiving {

	private static final ResourceLocation bipedTexture = new ResourceLocation(
			Main.MODID, "mobs/bipedTexture.png");
	private static final ResourceLocation pigTexture = new ResourceLocation(
			Main.MODID, "mobs/pigTexture.png");
	private static final ResourceLocation wolfTexture = new ResourceLocation(
			Main.MODID, "mobs/wolfTexture.png");
	private int type;

	public RenderMonster(RenderManager renderManager, ModelBase var1, float var2, int type) {
		super(renderManager, var1, var2);
		this.type = type;
	}

	public void func_177_a(CustomMonster entity, double d, double d1, double d2,
			float f, float f1) {
		super.doRender(entity, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1,
			double d2, float f, float f1) {
		func_177_a((CustomMonster) entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2,
			float f, float f1) {
		func_177_a((CustomMonster) entity, d, d1, d2, f, f1);
	}

	protected ResourceLocation func_110872_a(CustomMonster par1Entity) {
		
		switch(type)
		{
			case 0:
				return bipedTexture;
			case 1:
				return wolfTexture;
			case 2:
				return pigTexture;
		}
		
		return null;
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return func_110872_a((CustomMonster) var1);
	}
}