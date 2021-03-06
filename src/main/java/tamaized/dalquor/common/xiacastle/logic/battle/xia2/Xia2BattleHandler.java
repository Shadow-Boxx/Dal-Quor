package tamaized.dalquor.common.xiacastle.logic.battle.xia2;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tamaized.dalquor.common.capabilities.CapabilityList;
import tamaized.dalquor.common.entity.boss.xia.EntityBossXia2;
import tamaized.dalquor.common.world.dim.xia.WorldProviderXia;
import tamaized.dalquor.common.xiacastle.logic.battle.IBattleHandler;
import tamaized.dalquor.registry.ModItems;

public class Xia2BattleHandler implements IBattleHandler {

	private int phase = 0;
	private int tick = 0;
	private int childPhase = 0;
	private int childPhaseModulate = 20;
	private boolean readyForInput = false;

	private boolean running = false;
	private boolean isDone = false;

	private World worldObj;
	private BlockPos pos;

	private EntityBossXia2 xia;

	@Override
	public void update() {
		if (worldObj != null && !worldObj.isRemote && running) {
			if (xia == null || !xia.isActive()) {
				stop();
				return;
			}
		}
	}

	public EntityBossXia2 getBoss(){
		return xia;
	}

	@Override
	public void start(World world, BlockPos p) {
		worldObj = world;
		pos = p;
		stop();
		phase = 0;
		isDone = false;
		readyForInput = false;
		xia = new EntityBossXia2(worldObj, this);
		xia.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
		ItemStack vade = new ItemStack(ModItems.vadeMecum);
		if (vade.hasCapability(CapabilityList.VADEMECUMITEM, null))
			vade.getCapability(CapabilityList.VADEMECUMITEM, null).setBookState(true);
		xia.setHeldItem(EnumHand.MAIN_HAND, vade);
		worldObj.spawnEntity(xia);
		xia.start();
		running = true;
	}

	@Override
	public void stop() {
		readyForInput = false;
		isDone = false;
		if (xia != null) {
			if (xia.isDone())
				isDone = true;
			worldObj.removeEntity(xia);
		}
		xia = null;
		running = false;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public boolean isDone() {
		return isDone;
	}

	@Override
	public void setDone() {
		stop();
		isDone = true;
		if (worldObj != null && worldObj.provider instanceof WorldProviderXia)
			worldObj.provider.onWorldSave();
	}

}
