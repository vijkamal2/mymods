package mymod._04_ChapterFour_MakeSomeMonsters;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraftforge.fml.relauncher.SideOnly;
import mymod.Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntity extends RenderLiving {

	private String textureName = null;

	public RenderEntity(RenderManager renderManager, ModelBase model, String name) {
		super(renderManager, model, 0.5F);
		textureName = name;
	}

	public void func_177_a(EntityLiving entity, double d, double d1, double d2,
			float f, float f1) {
		super.doRender(entity, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1,
			double d2, float f, float f1) {
		func_177_a(entityliving, d, d1, d2, f, f1);
	}

	public void doRender(EntityLiving entity, double d, double d1, double d2,
			float f, float f1) {
		func_177_a(entity, d, d1, d2, f, f1);
	}

	protected ResourceLocation func_110872_a(EntityLiving par1Entity) {
		return new ResourceLocation(
				Main.MODID, "mobs/" + textureName + ".png");
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return func_110872_a((EntityLiving)var1);
	}
}
