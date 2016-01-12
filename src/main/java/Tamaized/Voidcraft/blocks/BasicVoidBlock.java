package Tamaized.Voidcraft.blocks;

import Tamaized.Voidcraft.common.voidCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BasicVoidBlock extends Block implements IBasicVoidBlock{
	
	private final String name;

	public BasicVoidBlock(Material p_i45394_1_, String n) {
		super(p_i45394_1_);
		name = n;
		setUnlocalizedName(voidCraft.modid+":"+name);
		GameRegistry.registerBlock(this, getName());
	}

	@Override
	public String getName() {
		return name;
	}

}
