package tamaized.dalquor.common.entity.boss.xia.finalphase;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import net.minecraftforge.common.ForgeChunkManager.Type;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tamaized.tammodized.common.entity.EntityDragonOld;
import tamaized.dalquor.DalQuor;
import tamaized.dalquor.client.entity.boss.bossbar.RenderAlternateBossBars.IAlternateBoss;
import tamaized.dalquor.common.entity.EntityVoidNPC;
import tamaized.dalquor.common.entity.boss.herobrine.extra.EntityHerobrineWitherSkull;

import java.util.List;

public class EntityWitherbrine extends EntityMob implements IRangedAttackMob, IAlternateBoss {

	private static final DataParameter<Integer> FIRST_HEAD_TARGET = EntityDataManager.createKey(EntityWitherbrine.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> SECOND_HEAD_TARGET = EntityDataManager.createKey(EntityWitherbrine.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> THIRD_HEAD_TARGET = EntityDataManager.createKey(EntityWitherbrine.class, DataSerializers.VARINT);
	private static final DataParameter<Integer>[] HEAD_TARGETS = new DataParameter[]{FIRST_HEAD_TARGET, SECOND_HEAD_TARGET, THIRD_HEAD_TARGET};
	private static final DataParameter<Integer> INVULNERABILITY_TIME = EntityDataManager.createKey(EntityWitherbrine.class, DataSerializers.VARINT);
	private static final Predicate<Entity> NOT_UNDEAD = p_apply_1_ -> !(p_apply_1_ instanceof EntityDragonOld) && !(p_apply_1_ instanceof EntityVoidNPC) && p_apply_1_ instanceof EntityLivingBase && ((EntityLivingBase) p_apply_1_).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD && ((EntityLivingBase) p_apply_1_).attackable();
	private final BossInfoServer bossInfo = new BossInfoServer(getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
	private final float[] xRotationHeads = new float[2];
	private final float[] yRotationHeads = new float[2];
	private final int[] nextHeadUpdate = new int[2];
	private final int[] idleHeadUpdates = new int[2];
	/**
	 * Time before the Wither tries to break blocks
	 */
	private int blockBreakCounter;
	private Ticket chunkLoadTicket;

	public EntityWitherbrine(World worldIn) {
		super(worldIn);
		this.setHealth(this.getMaxHealth());
		this.setSize(0.9F, 3.5F);
		this.isImmuneToFire = true;
		((PathNavigateGround) this.getNavigator()).setCanSwim(true);
		this.experienceValue = 50;
		enablePersistence();
	}

	public static void registerFixesWither(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityWitherbrine.class);
	}

	public static boolean canDestroyBlock(Block blockIn) {
		return false;
	}

	@Override
	public void setCustomNameTag(String name) {
		super.setCustomNameTag(name);
		this.bossInfo.setName(this.getDisplayName());
	}

	public final void setKeepLoaded() {
		chunkLoadTicket = ForgeChunkManager.requestTicket(DalQuor.instance, world, Type.ENTITY);
		if (chunkLoadTicket != null)
			chunkLoadTicket.bindEntity(this);
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityWitherbrine.AIDoNothing());
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackRanged(this, 1.0D, 40, 20.0F));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, false, false, NOT_UNDEAD));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(FIRST_HEAD_TARGET, 0);
		this.dataManager.register(SECOND_HEAD_TARGET, 0);
		this.dataManager.register(THIRD_HEAD_TARGET, 0);
		this.dataManager.register(INVULNERABILITY_TIME, 0);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("Invul", this.getInvulTime());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setInvulTime(compound.getInteger("Invul"));

		if (this.hasCustomName())
			this.bossInfo.setName(this.getDisplayName());
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_WITHER_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_WITHER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_WITHER_DEATH;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons use this to react to sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate() {
		if (!world.isRemote)
			bossInfo.setPercent(getHealth() / getMaxHealth());
		if (chunkLoadTicket != null) {
			for (ChunkPos pos : chunkLoadTicket.getChunkList()) {
				ForgeChunkManager.unforceChunk(chunkLoadTicket, pos);
			}
			for (int x = -1; x <= 1; x++)
				for (int z = -1; z <= 1; z++)
					ForgeChunkManager.forceChunk(chunkLoadTicket, world.getChunk((getPosition().getX() >> 4) + x, (getPosition().getZ() >> 4) + z).getPos());
		}
		this.motionY *= 0.6000000238418579D;

		if (!this.world.isRemote) {
			if (this.getWatchedTargetId(0) > 0) {
				Entity entity = this.world.getEntityByID(this.getWatchedTargetId(0));

				if (entity != null) {
					if (this.posY < entity.posY || !this.isArmored() && this.posY < entity.posY + 5.0D) {
						if (this.motionY < 0.0D) {
							this.motionY = 0.0D;
						}

						this.motionY += (0.5D - this.motionY) * 0.6000000238418579D;
					}

					double d0 = entity.posX - this.posX;
					double d1 = entity.posZ - this.posZ;
					double d3 = d0 * d0 + d1 * d1;

					if (d3 > 9.0D) {
						double d5 = (double) MathHelper.sqrt(d3);
						this.motionX += (d0 / d5 * 0.5D - this.motionX) * 0.6000000238418579D;
						this.motionZ += (d1 / d5 * 0.5D - this.motionZ) * 0.6000000238418579D;
					}
				} else {
					motionY = 0;
				}
			} else {
				motionY = 0;
			}
		}

		if (this.motionX * this.motionX + this.motionZ * this.motionZ > 0.05000000074505806D) {
			this.rotationYaw = (float) MathHelper.atan2(this.motionZ, this.motionX) * (180F / (float) Math.PI) - 90.0F;
		}

		super.onLivingUpdate();

		for (int j = 0; j < 2; ++j) {
			int k = this.getWatchedTargetId(j + 1);
			Entity entity1 = null;

			if (k > 0) {
				entity1 = this.world.getEntityByID(k);
			}

			if (entity1 != null) {
				double d11 = this.getHeadX(j + 1);
				double d12 = this.getHeadY(j + 1);
				double d13 = this.getHeadZ(j + 1);
				double d6 = entity1.posX - d11;
				double d7 = entity1.posY + (double) entity1.getEyeHeight() - d12;
				double d8 = entity1.posZ - d13;
				double d9 = (double) MathHelper.sqrt(d6 * d6 + d8 * d8);
				float f = (float) (MathHelper.atan2(d8, d6) * (180D / Math.PI)) - 90.0F;
				float f1 = (float) (-(MathHelper.atan2(d7, d9) * (180D / Math.PI)));
				this.xRotationHeads[j] = this.rotlerp(this.xRotationHeads[j], f1, 40.0F);
				this.yRotationHeads[j] = this.rotlerp(this.yRotationHeads[j], f, 10.0F);
			} else {
				this.yRotationHeads[j] = this.rotlerp(this.yRotationHeads[j], this.renderYawOffset, 10.0F);
			}
		}

		boolean flag = this.isArmored();

		for (int l = 0; l < 3; ++l) {
			double d10 = this.getHeadX(l);
			double d2 = this.getHeadY(l);
			double d4 = this.getHeadZ(l);
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d10 + this.rand.nextGaussian() * 0.30000001192092896D, d2 + this.rand.nextGaussian() * 0.30000001192092896D, d4 + this.rand.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D);

			if (flag && this.world.rand.nextInt(4) == 0) {
				this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, d10 + this.rand.nextGaussian() * 0.30000001192092896D, d2 + this.rand.nextGaussian() * 0.30000001192092896D, d4 + this.rand.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D);
			}
		}

		if (this.getInvulTime() > 0) {
			motionY = 0;
			for (int i1 = 0; i1 < 3; ++i1) {
				this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + this.rand.nextGaussian(), this.posY + (double) (this.rand.nextFloat() * 3.3F), this.posZ + this.rand.nextGaussian(), 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D);
			}
		}
	}

	@Override
	protected void updateAITasks() {
		if (this.getInvulTime() > 0) {
			int j1 = this.getInvulTime() - 1;

			if (j1 <= 0) {
				this.world.newExplosion(this, this.posX, this.posY + (double) this.getEyeHeight(), this.posZ, 7.0F, false, this.world.getGameRules().getBoolean("mobGriefing"));
				this.world.playBroadcastSound(1023, new BlockPos(this), 0);
			}

			this.setInvulTime(j1);

			if (this.ticksExisted % 10 == 0) {
				this.heal(10.0F);
			}
		} else {
			super.updateAITasks();

			for (int i = 1; i < 3; ++i) {
				if (this.ticksExisted >= this.nextHeadUpdate[i - 1]) {
					this.nextHeadUpdate[i - 1] = this.ticksExisted + 10 + this.rand.nextInt(10);

					if (this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) {
						int j3 = i - 1;
						int k3 = this.idleHeadUpdates[i - 1];
						this.idleHeadUpdates[j3] = this.idleHeadUpdates[i - 1] + 1;

						if (k3 > 15) {
							float f = 10.0F;
							float f1 = 5.0F;
							double d0 = MathHelper.nextDouble(this.rand, this.posX - 10.0D, this.posX + 10.0D);
							double d1 = MathHelper.nextDouble(this.rand, this.posY - 5.0D, this.posY + 5.0D);
							double d2 = MathHelper.nextDouble(this.rand, this.posZ - 10.0D, this.posZ + 10.0D);
							this.launchWitherSkullToCoords(i + 1, d0, d1, d2, true);
							this.idleHeadUpdates[i - 1] = 0;
						}
					}

					int k1 = this.getWatchedTargetId(i);

					if (k1 > 0) {
						Entity entity = this.world.getEntityByID(k1);

						if (entity != null && entity.isEntityAlive() && this.getDistanceSq(entity) <= 900.0D && this.canEntityBeSeen(entity)) {
							if (entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.disableDamage) {
								this.updateWatchedTargetId(i, 0);
							} else {
								this.launchWitherSkullToEntity(i + 1, (EntityLivingBase) entity);
								this.nextHeadUpdate[i - 1] = this.ticksExisted + 40 + this.rand.nextInt(20);
								this.idleHeadUpdates[i - 1] = 0;
							}
						} else {
							this.updateWatchedTargetId(i, 0);
						}
					} else {
						List<EntityLivingBase> list = this.world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().grow(20.0D, 8.0D, 20.0D), Predicates.and(NOT_UNDEAD, EntitySelectors.NOT_SPECTATING));

						for (int j2 = 0; j2 < 10 && !list.isEmpty(); ++j2) {
							EntityLivingBase entitylivingbase = list.get(this.rand.nextInt(list.size()));

							if (entitylivingbase != this && entitylivingbase.isEntityAlive() && this.canEntityBeSeen(entitylivingbase)) {
								if (entitylivingbase instanceof EntityPlayer) {
									if (!((EntityPlayer) entitylivingbase).capabilities.disableDamage) {
										this.updateWatchedTargetId(i, entitylivingbase.getEntityId());
									}
								} else {
									this.updateWatchedTargetId(i, entitylivingbase.getEntityId());
								}

								break;
							}

							list.remove(entitylivingbase);
						}
					}
				}
			}

			if (this.getAttackTarget() != null) {
				this.updateWatchedTargetId(0, this.getAttackTarget().getEntityId());
			} else {
				this.updateWatchedTargetId(0, 0);
			}

			if (this.blockBreakCounter > 0) {
				--this.blockBreakCounter;

			}

			if (this.ticksExisted % 20 == 0) {
				this.heal(1.0F);
			}

			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	/**
	 * Initializes this Wither's explosion sequence and makes it invulnerable. Called immediately after spawning.
	 */
	public void ignite() {
		this.setInvulTime(220);
		this.setHealth(this.getMaxHealth() / 3.0F);
	}

	/**
	 * Sets the Entity inside a web block.
	 */
	@Override
	public void setInWeb() {
	}

	/**
	 * Add the given player to the list of players tracking this entity. For instance, a player may track a boss in order to view its associated boss bar.
	 */
	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	/**
	 * Removes the given player from the list of players tracking this entity. See {@link Entity#addTrackingPlayer} for more information on tracking.
	 */
	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	private double getHeadX(int p_82214_1_) {
		if (p_82214_1_ <= 0) {
			return this.posX;
		} else {
			float f = (this.renderYawOffset + (float) (180 * (p_82214_1_ - 1))) * 0.017453292F;
			float f1 = MathHelper.cos(f);
			return this.posX + (double) f1 * 1.3D;
		}
	}

	private double getHeadY(int p_82208_1_) {
		return p_82208_1_ <= 0 ? this.posY + 3.0D : this.posY + 2.2D;
	}

	private double getHeadZ(int p_82213_1_) {
		if (p_82213_1_ <= 0) {
			return this.posZ;
		} else {
			float f = (this.renderYawOffset + (float) (180 * (p_82213_1_ - 1))) * 0.017453292F;
			float f1 = MathHelper.sin(f);
			return this.posZ + (double) f1 * 1.3D;
		}
	}

	private float rotlerp(float p_82204_1_, float p_82204_2_, float p_82204_3_) {
		float f = MathHelper.wrapDegrees(p_82204_2_ - p_82204_1_);

		if (f > p_82204_3_) {
			f = p_82204_3_;
		}

		if (f < -p_82204_3_) {
			f = -p_82204_3_;
		}

		return p_82204_1_ + f;
	}

	private void launchWitherSkullToEntity(int p_82216_1_, EntityLivingBase p_82216_2_) {
		this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.posX, p_82216_2_.posY + (double) p_82216_2_.getEyeHeight() * 0.5D, p_82216_2_.posZ, p_82216_1_ == 0 && this.rand.nextFloat() < 0.001F);
	}

	/**
	 * Launches a Wither skull toward (par2, par4, par6)
	 */
	private void launchWitherSkullToCoords(int p_82209_1_, double x, double y, double z, boolean invulnerable) {
		this.world.playEvent(null, 1024, new BlockPos(this), 0);
		double d0 = this.getHeadX(p_82209_1_);
		double d1 = this.getHeadY(p_82209_1_);
		double d2 = this.getHeadZ(p_82209_1_);
		double d3 = x - d0;
		double d4 = y - d1;
		double d5 = z - d2;
		EntityHerobrineWitherSkull entitywitherskull = new EntityHerobrineWitherSkull(this.world, this, d3, d4, d5);

		if (invulnerable) {
			entitywitherskull.setInvulnerable(true);
		}

		entitywitherskull.posY = d1;
		entitywitherskull.posX = d0;
		entitywitherskull.posZ = d2;
		this.world.spawnEntity(entitywitherskull);
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		this.launchWitherSkullToEntity(0, target);
	}

	@Override
	public void setSwingingArms(boolean swingingArms) {

	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else if (source != DamageSource.DROWN && !(source.getTrueSource() instanceof EntityWitherbrine)) {
			if (this.getInvulTime() > 0 && source != DamageSource.OUT_OF_WORLD) {
				return false;
			} else {
				if (this.isArmored()) {
					Entity entity = source.getImmediateSource();

					if (entity instanceof EntityArrow) {
						return false;
					}
				}

				Entity entity1 = source.getTrueSource();

				if (entity1 != null && !(entity1 instanceof EntityPlayer) && entity1 instanceof EntityLivingBase && ((EntityLivingBase) entity1).getCreatureAttribute() == this.getCreatureAttribute()) {
					return false;
				} else {
					if (this.blockBreakCounter <= 0) {
						this.blockBreakCounter = 20;
					}

					for (int i = 0; i < this.idleHeadUpdates.length; ++i) {
						this.idleHeadUpdates[i] += 3;
					}

					return super.attackEntityFrom(source, amount);
				}
			}
		} else {
			return false;
		}
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {

	}

	/**
	 * Makes the entity despawn if requirements are reached
	 */
	@Override
	protected void despawnEntity() {
		this.idleTime = 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 15728880;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	/**
	 * adds a PotionEffect to the entity
	 */
	@Override
	public void addPotionEffect(PotionEffect potioneffectIn) {
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6000000238418579D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
	}

	@SideOnly(Side.CLIENT)
	public float getHeadYRotation(int p_82207_1_) {
		return this.yRotationHeads[p_82207_1_];
	}

	@SideOnly(Side.CLIENT)
	public float getHeadXRotation(int p_82210_1_) {
		return this.xRotationHeads[p_82210_1_];
	}

	public int getInvulTime() {
		return this.dataManager.get(INVULNERABILITY_TIME);
	}

	public void setInvulTime(int time) {
		this.dataManager.set(INVULNERABILITY_TIME, time);
	}

	/**
	 * Returns the target entity ID if present, or -1 if not @param par1 The target offset, should be from 0-2
	 */
	public int getWatchedTargetId(int head) {
		return this.dataManager.get(HEAD_TARGETS[head]);
	}

	/**
	 * Updates the target entity ID
	 */
	public void updateWatchedTargetId(int targetOffset, int newId) {
		this.dataManager.set(HEAD_TARGETS[targetOffset], newId);
	}

	/**
	 * Returns whether the wither is armored with its boss armor or not by checking whether its health is below half of its maximum.
	 */
	public boolean isArmored() {
		return this.getHealth() <= this.getMaxHealth() / 2.0F;
	}

	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return false;
	}

	/**
	 * Returns false if this Entity is a boss, true otherwise.
	 */
	@Override
	public boolean isNonBoss() {
		return false;
	}

	@Override
	public float getHealthPerc() {
		return getHealth() / getMaxHealth();
	}

	@Override
	public ITextComponent getAlternateBossName() {
		return new TextComponentString("Witherbrine");
	}

	class AIDoNothing extends EntityAIBase {
		AIDoNothing() {
			this.setMutexBits(7);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			return EntityWitherbrine.this.getInvulTime() > 0;
		}
	}
}