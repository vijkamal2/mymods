package mymod._04_ChapterFour_MakeSomeMonsters;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class CustomMob extends EntityWither {

	public float mobSpeed;
	public float attackDamage;
	public float followRange;
	public float health;
	
	public CustomMob(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAIWander(this, this.mobSpeed));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 16));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.mobSpeed, false));
		
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));

		
	}
	
	@Override
	public void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		this.mobSpeed = 0.87F;
		this.attackDamage = 12F;
		this.followRange = 15F;
		this.health = 3999999996F;
		
		Codakid.setMovementSpeed(this, this.mobSpeed);
		Codakid.setAttackDamage(this, this.attackDamage);
		Codakid.setFollowRange(this, this.followRange);
		Codakid.setMaxHealth(this, this.health);
		
	}
		@Override
		public void dropFewItems(boolean flag, int x) {
			this.dropItem(Main.myIngot, 3);
			this.dropItem(Items.blaze_powder, 3);
			this.dropItem(Items.fireworks, 3);
			this.dropItem(Items.gunpowder, 3);
			this.dropItem(Items.diamond_pickaxe, 1);
			
			
			
		
			
		}
	}	
	
	

