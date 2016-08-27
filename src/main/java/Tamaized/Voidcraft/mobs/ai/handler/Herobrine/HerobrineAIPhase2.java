package Tamaized.Voidcraft.mobs.ai.handler.Herobrine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import Tamaized.Voidcraft.voidCraft;
import Tamaized.Voidcraft.blocks.AIBlock;
import Tamaized.Voidcraft.blocks.tileentity.TileEntityAIBlock;
import Tamaized.Voidcraft.mobs.ai.EntityAIHandler;
import Tamaized.Voidcraft.mobs.ai.handler.IHandlerAI;

public class HerobrineAIPhase2 implements IHandlerAI {

	private EntityAIHandler parent;
	protected World world;
	
	private int tick_Spawn = 0;
	private int tick_Spawn_Call = 5*20;
	private int spawns = 0;
	private int maxSpawns = 1;
	
	private ArrayList<TileEntityAIBlock> aiBlocks = new ArrayList<TileEntityAIBlock>();
	private Map<BlockPos, TileEntityAIBlock> raw = new HashMap<BlockPos, TileEntityAIBlock>();
	
	public HerobrineAIPhase2(EntityAIHandler entityAIHandler) {
		parent = entityAIHandler;
	}

	@Override
	public void Init() {
		world = parent.getEntity().worldObj;
		for(int x=-10; x<10; x++){
			for(int z=-10; z<10; z++){
				world.setBlockState(parent.getPos().add(x, -1, z), voidCraft.blocks.blockNoBreak.getDefaultState());
			}
		}
	}

	@Override
	public void update() {
		if(parent.getEntity() == null){
			for(TileEntityAIBlock te : aiBlocks){
				te.setAiHandler(null);
			}
		}
		
		if(tick_Spawn >= tick_Spawn_Call && !world.isRemote){
			if(spawns < maxSpawns){
				setRandomTileEntity();
			}
			tick_Spawn = 0;
		}
		
		tick_Spawn++;
	}
	
	private void setRandomTileEntity(){
		int randX = (int) Math.floor(Math.random()*16);
		int randZ = (int) Math.floor(Math.random()*16);
		int nX = (parent.getX()-8)+randX;
		int nY = parent.getY();
		int nZ = (parent.getZ()-8)+randZ;
		if(world.getTileEntity(new BlockPos(nX, nY, nZ)) == null){
			world.setBlockState(new BlockPos(nX, nY, nZ), ((AIBlock) voidCraft.blocks.AIBlock).getDefaultState());
			world.setBlockState(new BlockPos(nX, nY+1, nZ), ((AIBlock) voidCraft.blocks.AIBlock).getDefaultState());
			world.setBlockState(new BlockPos(nX, nY+2, nZ), ((AIBlock) voidCraft.blocks.AIBlock).getDefaultState());
			TileEntityAIBlock b = (TileEntityAIBlock) world.getTileEntity(new BlockPos(nX, nY, nZ));
			((TileEntityAIBlock) world.getTileEntity(new BlockPos(nX, nY+1, nZ))).setParent(b);
			((TileEntityAIBlock) world.getTileEntity(new BlockPos(nX, nY+2, nZ))).setParent(b);
			raw.put(new BlockPos(nX, nY, nZ), b);
			b.setAiHandler(parent);
			b.setAi(this);
			aiBlocks.add(b);
			spawns++;
		}else{
			setRandomTileEntity();
		}
	}

	@Override
	public void kill() {
		for(TileEntityAIBlock te : aiBlocks){
			te.setAiHandler(null);
		}
	}

	public void removeTileEntity(BlockPos i){
		aiBlocks.remove(raw.get(i));
		raw.remove(i);
		spawns--;
	}

}
