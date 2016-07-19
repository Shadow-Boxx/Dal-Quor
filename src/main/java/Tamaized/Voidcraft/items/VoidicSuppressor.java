package Tamaized.Voidcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import Tamaized.TamModized.api.voidcraft.power.VoidicPowerItem;

public class VoidicSuppressor extends VoidicPowerItem {

	public VoidicSuppressor(CreativeTabs tab, String n, int maxStackSize) {
		super(tab, n, maxStackSize);
	}

	@Override
	protected int getDefaultVoidicPower() {
		return 0;
	}

	@Override
	protected int getDefaultMaxVoidicPower() {
		return 2000;
	}

}