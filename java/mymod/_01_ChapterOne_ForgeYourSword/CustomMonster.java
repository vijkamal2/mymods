package mymod._01_ChapterOne_ForgeYourSword;

import java.util.Random;
import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class CustomMonster extends EntityMob {
	
	public float mobSpeed;
	public float attackDamage;
	public float health;
	public float followRange;
	
	public CustomMonster(World world)
	{

		super(world);
		
		this.tasks.addTask(0, new EntityAIWander(this, this.mobSpeed));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 32));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.mobSpeed, false));
		
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.mobSpeed = 0.5F;
		this.attackDamage = 10F;
		this.health = 9999999999999F;
		this.followRange = 15F;
		
		Codakid.setMovementSpeed(this, this.mobSpeed);
		Codakid.setAttackDamage(this, this.attackDamage);
		Codakid.setFollowRange(this, this.followRange);
		Codakid.setMaxHealth(this, this.health);
		
	}
	
	@Override
	protected void dropFewItems(boolean flag, int x)
	{
		
		//ADD ITEMS TO DROP
		this.dropItem(Items.arrow, 64);
		this.dropItem(Items.bow, 10);
	}
	
	

}