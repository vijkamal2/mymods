package mymod._07_ChapterSeven_ExplosionsAndSpecialEffects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBuildGrenade extends EntityThrowable {

	public EntityBuildGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) {
		if(pos.entityHit == null)
		{	for( int z = 0; z < 25;  z ++) {
			for( int y = 0; y < 25;  y ++) {
			for( int x = 0; x < 25;  x ++) {
			
			worldObj.setBlockState(new BlockPos(pos.getBlockPos().getX()+x, pos.getBlockPos().getY()+y, pos.getBlockPos().getZ()+z), Blocks.tnt.getDefaultState());
			}
			}
		}
		}
			else
		{
			worldObj.createExplosion(this, pos.entityHit.posX, pos.entityHit.posY, pos.entityHit.posZ, 20, true);
		}
		this.setDead();
		
	}


}
