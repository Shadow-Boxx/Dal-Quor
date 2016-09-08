package Tamaized.Voidcraft.xiaCastle.logic.battle;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import Tamaized.Voidcraft.entity.EntityVoidNPC;
import Tamaized.Voidcraft.entity.nonliving.EntityVoidBoss;

public class EntityVoidNPCAIBase extends EntityAIBase{
	
	public EntityVoidBoss entity;
	public boolean execute = false;
	
	protected EntityLiving theWatcher;
    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    protected float maxDistanceForPlayer = 30;
    protected ArrayList<Class> watchedClass = new ArrayList<Class>();
    
    private EntityAIHandler ai;
	
	private double[] spawnLoc = new double[3];

	public EntityVoidNPCAIBase(EntityVoidBoss entityBoss, ArrayList<Class> c) {
		watchedClass = new ArrayList<Class>();
		watchedClass.addAll(c);
		entity = entityBoss;
		theWatcher = entity;
		ai = new EntityAIHandler(entityBoss, (int) entityBoss.posX, (int) entityBoss.posY, (int) entityBoss.posZ);
	}

	@Override
	public boolean shouldExecute() {
		return (execute && entity!=null);
	}

	public void kill() {
		execute = false;
		entity.posX = spawnLoc[0];
		entity.posY = spawnLoc[1];
		entity.posZ = spawnLoc[2];
		entity = null;
		
		ai.kill();
	}

	public void Init() {
		spawnLoc[0] = entity.posX;
		spawnLoc[1] = entity.posY;
		spawnLoc[2] = entity.posZ;
		
		ai.Init(entity.getCurrentPhase());
	
		execute = true;
	}

	@Override
	public void updateTask(){
		if(!execute) return;
		ai.update();
	}

}