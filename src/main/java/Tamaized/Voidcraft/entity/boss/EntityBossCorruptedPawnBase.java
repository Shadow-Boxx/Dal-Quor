package Tamaized.Voidcraft.entity.boss;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

//CLASS WAS MADE FOR TARGETTING PURPOSES (and less use of nbt)
public abstract class EntityBossCorruptedPawnBase extends EntityCreature implements IMob {
	
	private boolean invulnerable = false;
	
	public EntityBossCorruptedPawnBase(World p_i1738_1_){
		super(p_i1738_1_);
		this.experienceValue = 10;
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate(){
		this.updateArmSwingProgress();
		float f = this.getBrightness(1.0F);
		
		if (f > 0.5F){
			this.entityAge += 2;
		}
		super.onLivingUpdate();
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate(){
		super.onUpdate();
		
		if (!this.worldObj.isRemote && this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL){
			this.setDead();
		}
	}
    
	@Override
	public SoundCategory getSoundCategory(){
		return SoundCategory.HOSTILE;
	}
	
	@Override
	protected SoundEvent getSwimSound(){
		return SoundEvents.ENTITY_HOSTILE_SWIM;
	}
	
	@Override
	protected SoundEvent getSplashSound(){
		return SoundEvents.ENTITY_HOSTILE_SPLASH;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_){
		if(this.isEntityInvulnerable()){
			return false;
		}else if(super.attackEntityFrom(p_70097_1_, p_70097_2_)){
			Entity entity = p_70097_1_.getEntity();
			if(entity != this && entity instanceof EntityLivingBase){
				this.setAttackTarget((EntityLivingBase) entity);
			}
			return true;
		}else{
			return false;
		}
	}
    
	/**
	 * I'm lazy
	 * 
	 * @param b
	 */
	public void setInvul(boolean b){
		this.invulnerable = b;
	}
	
	/**
	 * Return whether this entity is invulnerable to damage. Again, im lazy
	 */
	public boolean isEntityInvulnerable(){
		return this.invulnerable;
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected SoundEvent getHurtSound(){
		return SoundEvents.ENTITY_HOSTILE_HURT;
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected SoundEvent getDeathSound(){
		return SoundEvents.ENTITY_HOSTILE_DEATH;
	}
	
	@Override
	protected SoundEvent getFallSound(int heightIn){
		return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn){
		//if(p_70652_1_ instanceof VoidChain) return false;
		
		float f = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
		int i = 0;
		
		if (entityIn instanceof EntityLivingBase){
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)entityIn).getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}
		
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
		
		if (flag){
			if (i > 0){
				entityIn.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
			
			int j = EnchantmentHelper.getFireAspectModifier(this);
			
			if (j > 0){
				entityIn.setFire(j * 4);
			}
			
			if (entityIn instanceof EntityPlayer){
				EntityPlayer entityplayer = (EntityPlayer)entityIn;
				ItemStack itemstack = this.getHeldItemMainhand();
				ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : null;
				
				if (itemstack != null && itemstack1 != null && itemstack.getItem() instanceof ItemAxe && itemstack1.getItem() == Items.SHIELD){
					float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
					
					if (this.rand.nextFloat() < f1){
						entityplayer.getCooldownTracker().setCooldown(Items.SHIELD, 100);
						this.worldObj.setEntityState(entityplayer, (byte)30);
					}
				}
			}
			this.applyEnchantments(this, entityIn);
		}
		return flag;
	}

	/**
	 * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
	 * Args: x, y, z
	 */
	@Override
	public float getBlockPathWeight(BlockPos pos){
		return 0.5F - this.worldObj.getLightBrightness(pos);
	}
	
	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 * BUT! MY MOBS DONT CARE SO YEA; this always returns true bro
	 */
	protected boolean isValidLightLevel(){
		return true;
	}
	
	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	@Override
	public boolean getCanSpawnHere(){
		return this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
	}
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
	}

    /**
     * Entity won't drop items or experience points if this returns false
     */
    @Override
    protected boolean canDropLoot(){
    	return true;
    }
}