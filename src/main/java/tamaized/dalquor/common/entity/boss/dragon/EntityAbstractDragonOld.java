package tamaized.dalquor.common.entity.boss.dragon;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import tamaized.tammodized.common.entity.EntityDragonOld;
import tamaized.dalquor.client.entity.boss.bossbar.RenderAlternateBossBars;
import tamaized.dalquor.client.entity.boss.bossbar.RenderAlternateBossBars.AlternateBossBarWrapper;
import tamaized.dalquor.client.entity.boss.bossbar.RenderAlternateBossBars.IAlternateBoss;

public abstract class EntityAbstractDragonOld extends EntityDragonOld implements IAlternateBoss {

	public final AlternateBossBarWrapper bossBarWrapper;
	private Ticket chunkLoadTicket;

	public EntityAbstractDragonOld(World p_i1700_1_) {
		super(p_i1700_1_);
		bossBarWrapper = new RenderAlternateBossBars.AlternateBossBarWrapper(this, BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS);
		if (chunkLoadTicket != null) {
			for (ChunkPos pos : chunkLoadTicket.getChunkList()) {
				ForgeChunkManager.unforceChunk(chunkLoadTicket, pos);
			}
			ForgeChunkManager.forceChunk(chunkLoadTicket, world.getChunk(getPosition()).getPos());
		}
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (chunkLoadTicket != null) {
			for (ChunkPos pos : chunkLoadTicket.getChunkList()) {
				ForgeChunkManager.unforceChunk(chunkLoadTicket, pos);
			}
			for (int x = -1; x <= 1; x++)
				for (int z = -1; z <= 1; z++)
					ForgeChunkManager.forceChunk(chunkLoadTicket, world.getChunk((getPosition().getX() >> 4) + x, (getPosition().getZ() >> 4) + z).getPos());
		}
	}

	@Override
	public float getHealthPerc() {
		return getHealth() / getMaxHealth();
	}

}
