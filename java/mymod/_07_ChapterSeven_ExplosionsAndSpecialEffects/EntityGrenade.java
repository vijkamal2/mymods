package mymod._07_ChapterSeven_ExplosionsAndSpecialEffects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {

	public EntityGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) {
		if(pos.entityHit == null)
		{
		worldObj.createExplosion(this, pos.getBlockPos().getX(), pos.getBlockPos().getY(), pos.getBlockPos().getZ(), 8, true);
		}
		else
		{
			worldObj.createExplosion(this, pos.entityHit.posX, pos.entityHit.posY, pos.entityHit.posZ, 20, true);
		}
		this.setDead();
		
	}


}
