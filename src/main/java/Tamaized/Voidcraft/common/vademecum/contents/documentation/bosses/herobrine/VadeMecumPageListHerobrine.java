package Tamaized.Voidcraft.common.vademecum.contents.documentation.bosses.herobrine;

import Tamaized.Voidcraft.VoidCraft;
import Tamaized.Voidcraft.common.capabilities.vadeMecum.IVadeMecumCapability;
import Tamaized.Voidcraft.common.vademecum.IVadeMecumPage;
import Tamaized.Voidcraft.common.vademecum.IVadeMecumPageProvider;
import Tamaized.Voidcraft.common.vademecum.VadeMecumPage;

public class VadeMecumPageListHerobrine implements IVadeMecumPageProvider {

	public IVadeMecumPage[] getPageList(IVadeMecumCapability cap) {
		return new IVadeMecumPage[] {
				new VadeMecumPage(VoidCraft.modid+".VadeMecum.docs.title.herobrine", VoidCraft.modid+".VadeMecum.docs.desc.herobrine") };
	}

}
