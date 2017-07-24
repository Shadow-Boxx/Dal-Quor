package tamaized.voidcraft.common.entity.ai;

import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class EntityAIFindEntityNearestPlayerNoSight extends EntityAIFindEntityNearestPlayer {

	private final EntityLiving entityLiving;
	private final Predicate<Entity> predicate;
	private final EntityAINearestAttackableTarget.Sorter sorter;
	private EntityLivingBase entityTarget;

	/**
	 * VanillaCopy super, but change predicate to not check sight, or bother reducing range for sneaking/invisibility
	 */
	public EntityAIFindEntityNearestPlayerNoSight(EntityLiving entityLivingIn) {
		super(entityLivingIn);
		this.entityLiving = entityLivingIn;
		this.predicate = entity -> {
			if (!(entity instanceof EntityPlayer)) {
				return false;
			} else if (((EntityPlayer) entity).capabilities.disableDamage) {
				return false;
			} else {
				double maxRange = EntityAIFindEntityNearestPlayerNoSight.this.maxTargetRange();

				return !((double) entity.getDistanceToEntity(EntityAIFindEntityNearestPlayerNoSight.this.entityLiving) > maxRange) && EntityAITarget.isSuitableTarget(EntityAIFindEntityNearestPlayerNoSight.this.entityLiving, (EntityLivingBase) entity, false, false);
			}
		};

		this.sorter = new EntityAINearestAttackableTarget.Sorter(entityLivingIn);
	}

	/**
	 * VanillaCopy super, but change bounding box y expansion from 4 to full range
	 */
	@Override
	public boolean shouldExecute() {
		double maxRange = this.maxTargetRange();
		List<EntityPlayer> list = this.entityLiving.world.getEntitiesWithinAABB(EntityPlayer.class, this.entityLiving.getEntityBoundingBox().grow(maxRange), this.predicate);
		list.sort(this.sorter);

		if (list.isEmpty()) {
			return false;
		} else {
			this.entityTarget = list.get(0);
			return true;
		}
	}

	/**
	 * Use our target instead of super's.
	 */
	@Override
	public void startExecuting() {
		this.entityLiving.setAttackTarget(this.entityTarget);
	}
}