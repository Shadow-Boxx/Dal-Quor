package tamaized.voidcraft.common.vademecum.contents.documentation.tools.voidhoe;

import net.minecraft.item.ItemStack;
import tamaized.voidcraft.VoidCraft;
import tamaized.voidcraft.common.capabilities.vadeMecum.IVadeMecumCapability;
import tamaized.voidcraft.common.vademecum.IVadeMecumPage;
import tamaized.voidcraft.common.vademecum.IVadeMecumPageProvider;
import tamaized.voidcraft.common.vademecum.VadeMecumCraftingNormal;
import tamaized.voidcraft.common.vademecum.VadeMecumPageCrafting;

public class VadeMecumPageListVoidHoe implements IVadeMecumPageProvider {

	public IVadeMecumPage[] getPageList(IVadeMecumCapability cap) {
		return new IVadeMecumPage[]{new VadeMecumPageCrafting(new VadeMecumCraftingNormal(new ItemStack(VoidCraft.tools.voidHoe).getDisplayName(), new ItemStack(VoidCraft.tools.voidHoe)))};
	}

}