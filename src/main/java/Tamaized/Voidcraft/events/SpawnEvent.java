package Tamaized.Voidcraft.events;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import Tamaized.Voidcraft.common.voidCraft;
import Tamaized.Voidcraft.mobs.EntityVoidBossMob;
import Tamaized.Voidcraft.mobs.EntityVoidMob;
import Tamaized.Voidcraft.mobs.EntityVoidNPC;

public class SpawnEvent {
	
	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event){
		if(!event.world.isRemote && event.world.provider.getDimensionId() == voidCraft.dimensionIdVoid) {
	    	if(event.entity instanceof EntityLivingBase && !(event.entity instanceof EntityVoidMob && event.entity instanceof EntityVoidBossMob && event.entity instanceof EntityVoidNPC)){
	    		event.setCanceled(true);
	    		System.out.println(event.entity.getClass());
	    	}
	    }
	}

}