package mymod._07_ChapterSeven_ExplosionsAndSpecialEffects;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityClusterGrenade extends EntityThrowable {

	public EntityClusterGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) {
		Random rand = new Random();
		
		if(pos.entityHit == null)
		{
			int number = 0;
			while (number < 10)
			{
				worldObj.spawnEntityInWorld(new EntityClusterGrenadeFragment(worldObj, this.posX, this.posY, this.posZ,
				rand.nextInt(5)-2, this.motionY*-1, rand.nextInt(5)-2));
				number+=1;
			}
		}
		else
		{
			int number = 0;
			while (number < 10)
			{
				worldObj.spawnEntityInWorld(new EntityClusterGrenadeFragment(worldObj, this.posX, this.posY, this.posZ,
				rand.nextInt(5)-2, this.motionY*-1, rand.nextInt(5)-2));
				number+=1;
		}
		this.setDead();
		
	}


}
}
