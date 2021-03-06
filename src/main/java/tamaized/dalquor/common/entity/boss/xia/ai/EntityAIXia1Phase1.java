package tamaized.dalquor.common.entity.boss.xia.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import tamaized.tammodized.common.particles.ParticleHelper;
import tamaized.tammodized.common.particles.ParticlePacketHandlerRegistry;
import tamaized.dalquor.client.particles.network.XiaLaserPacketHandler;
import tamaized.dalquor.common.damagesources.DamageSourceVoidicInfusion;
import tamaized.dalquor.common.entity.boss.xia.EntityBossXia;
import tamaized.dalquor.common.entity.mob.lich.EntityLichInferno;
import tamaized.dalquor.registry.ModParticles;
import tamaized.dalquor.registry.ModPotions;

public class EntityAIXia1Phase1 extends EntityAIBase implements EntityBossXia.IDamageListener {

	private static final AxisAlignedBB teleportationBox = new AxisAlignedBB(-18, 0, -25, 18, 5, 6);
	private final EntityBossXia boss;
	private int teleportTick = 20 * 3;
	private int actionTick = 20 * 10;
	private int tick = 1;
	private int resetAnimationTick = 0;
	private boolean isTeleporting = false;

	public EntityAIXia1Phase1(EntityBossXia entity) {
		boss = entity;
		setMutexBits(1);
	}

	@Override
	public void startExecuting() {
		boss.updateInitialPos();
	}

	@Override
	public boolean shouldExecute() {
		return boss.getPhase() == 0;
	}

	@Override
	public boolean execute() {
		return shouldExecute();
	}

	@Override
	public void onTakeDamage() {
		doTeleport();
	}

	@Override
	public void onDoDamage(Entity entity) {

	}

	private void actionTeleport() {
		isTeleporting = true;
		spawnLaser();
	}

	private void spawnLaser() {
		XiaLaserPacketHandler.XiaLaserParticleData data = ((XiaLaserPacketHandler) ParticlePacketHandlerRegistry.getHandler(ModParticles.xiaTeleportHandler)).new XiaLaserParticleData(boss.getEntityId(), 0, -90, new float[]{1.0f, 1.0f, 1.0f});
		ParticleHelper.sendPacketToClients(boss.world, ModParticles.xiaTeleportHandler, new Vec3d(boss.posX, boss.posY, boss.posZ), 64, new ParticleHelper.ParticlePacketHelper(ModParticles.xiaTeleportHandler, data));
	}

	private void doTeleport() {
		BlockPos pos = getNextTeleportLocation();
		boss.setPositionAndUpdate(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
		isTeleporting = false;
	}

	private BlockPos getNextTeleportLocation() {
		if (boss.getInitialPos() == null)
			return boss.getPosition();
		double x = (boss.world.rand.nextDouble() * (teleportationBox.maxX - teleportationBox.minX)) + teleportationBox.minX;
		double y = teleportationBox.maxY;
		double z = (boss.world.rand.nextDouble() * (teleportationBox.maxZ - teleportationBox.minZ)) + teleportationBox.minZ;
		BlockPos pos = new BlockPos(boss.getInitialPos().getX() + x, boss.getInitialPos().getY() + y, boss.getInitialPos().getZ() + z);
		while (boss.world.isAirBlock(pos.down()))
			pos = pos.down();
		return pos;
	}

	@Override
	public void updateTask() {
		if (resetAnimationTick == 0) {
			resetAnimationTick--;
			boss.setLimbRotations(0, 0, 0, 0);
		} else if (resetAnimationTick >= 0) {
			resetAnimationTick--;
		}

		if (tick % actionTick == 0) {
			actionTick = (5 + boss.getRNG().nextInt(6)) * 20;
			switch (boss.getRNG().nextInt(5)) {
				default:
				case 0: {
					boss.setLimbRotations(180, 180, 0, 0);
					resetAnimationTick = 20 * 4;
					actionTeleport();
				}
				break;
				case 1: { // Ring of Voidic Fire
					boss.setLimbRotations(180, 0, 0, 0);
					resetAnimationTick = 20 * 4;
					boss.world.spawnEntity(new EntityLichInferno(boss.world, boss.getPosition(), 10, 10));
				}
				break;
				case 2: { // Use the force luke :P some sort of choke mechanic idk
					if (boss.getAttackTarget() == null)
						break;
					resetAnimationTick = 20 * 4;
					boss.setLimbRotations(90, 90, 0, 0);
					boss.getAttackTarget().attackEntityFrom(new DamageSourceVoidicInfusion(), 8.0f);
				}
				break;
				case 3: { // litBolt
					if (boss.getAttackTarget() == null)
						break;
					boss.setLimbRotations(90, 0.0f, 0, 0);
					resetAnimationTick = 20 * 2;
					EntityLightningBolt entitylightningbolt = new EntityLightningBolt(boss.world, boss.getAttackTarget().posX, boss.getAttackTarget().posY, boss.getAttackTarget().posZ, false);
					entitylightningbolt.setLocationAndAngles(boss.getAttackTarget().posX, boss.getAttackTarget().posY + 1 + entitylightningbolt.getYOffset(), boss.getAttackTarget().posZ, boss.getAttackTarget().rotationYaw, boss.getAttackTarget().rotationPitch);
					boss.world.addWeatherEffect(entitylightningbolt);
				}
				break;
				case 4: { // Give Voidic Infusion to the player
					if (boss.getAttackTarget() == null)
						break;
					boss.setLimbRotations(0, 90, 0, 0);
					resetAnimationTick = 20 * 2;
					if (boss.getAttackTarget() instanceof EntityPlayer) {
						EntityPlayer player = (EntityPlayer) boss.getAttackTarget();
						player.addPotionEffect(new PotionEffect(ModPotions.voidicInfusion, 20 * 10));
					}
				}
				break;
			}
			tick = 1;
		}
		if (isTeleporting) {
			spawnLaser();
			if (tick % teleportTick == 0) {
				teleportTick = (1 + boss.getRNG().nextInt(3)) * 20;
				doTeleport();
			}

		}
		tick++;
	}
}
