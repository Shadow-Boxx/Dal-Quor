package tamaized.voidcraft.common.vademecum.contents.documentation.weapons.voidsword;

import net.minecraft.item.ItemStack;
import tamaized.voidcraft.VoidCraft;
import tamaized.voidcraft.common.capabilities.vadeMecum.IVadeMecumCapability;
import tamaized.voidcraft.common.vademecum.IVadeMecumPage;
import tamaized.voidcraft.common.vademecum.IVadeMecumPageProvider;
import tamaized.voidcraft.common.vademecum.VadeMecumCraftingNormal;
import tamaized.voidcraft.common.vademecum.VadeMecumPageCrafting;

public class VadeMecumPageListVoidSword implements IVadeMecumPageProvider {

	public IVadeMecumPage[] getPageList(IVadeMecumCapability cap) {
		return new IVadeMecumPage[]{new VadeMecumPageCrafting(new VadeMecumCraftingNormal(new ItemStack(VoidCraft.tools.voidSword).getDisplayName(), new ItemStack(VoidCraft.tools.voidSword)))};
	}

}
