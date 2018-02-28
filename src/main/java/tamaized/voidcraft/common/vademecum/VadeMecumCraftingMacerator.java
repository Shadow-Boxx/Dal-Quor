package tamaized.voidcraft.common.vademecum;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import tamaized.voidcraft.VoidCraft;
import tamaized.voidcraft.client.gui.VadeMecumGUI;
import tamaized.voidcraft.registry.VoidCraftTERecipes;

public class VadeMecumCraftingMacerator implements IVadeMecumCrafting {

	private static final ResourceLocation TEXTURE = new ResourceLocation(VoidCraft.modid, "textures/gui/vademecum/crafting_macerator.png");

	private final String title;
	private final ItemStack input;
	private final ItemStack output;

	public VadeMecumCraftingMacerator(String title, ItemStack output) {
		this.title = I18n.format(title);
		input = VoidCraftTERecipes.macerator.getInput(output);
		this.output = output;
	}

	@Override
	public void render(VadeMecumGUI gui, FontRenderer render, int x, int y, int mx, int my) {
		VadeMecumGUI.drawCenteredStringNoShadow(render, TextFormatting.UNDERLINE + title, x + 65, y, 0x000000);
		GlStateManager.color(1, 1, 1, 1);
		gui.mc.getTextureManager().bindTexture(TEXTURE);
		gui.drawTexturedModalRect(x, y + 35, 128, 128, 0, 0, 256, 256);

		gui.renderItemStack(input, x + 25, y + 92, mx, my);

		gui.renderItemStack(output, x + 93, y + 92, mx, my);
	}

}