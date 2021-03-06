package tamaized.dalquor.common.vademecum;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import tamaized.dalquor.DalQuor;
import tamaized.dalquor.client.gui.VadeMecumGUI;
import tamaized.dalquor.common.helper.RecipeHelper;

import java.util.List;

public class VadeMecumCraftingFurnace implements IVadeMecumCrafting {

	private static final ResourceLocation TEXTURE = new ResourceLocation(DalQuor.modid, "textures/gui/vademecum/crafting_furnace.png");

	private final String title;
	private final ItemStack input;
	private final ItemStack output;

	public VadeMecumCraftingFurnace(String title, ItemStack output) {
		this.title = I18n.format(title);
		ItemStack result = ItemStack.EMPTY;
		List<ItemStack> list = RecipeHelper.getFurnaceRecipe(output);
		input = list.size() > 0 ? list.get(0) : ItemStack.EMPTY;
		this.output = output;
	}

	@Override
	public void render(VadeMecumGUI gui, FontRenderer render, int x, int y, int mx, int my) {
		VadeMecumGUI.drawCenteredStringNoShadow(render, TextFormatting.UNDERLINE + title, x + 65, y, 0x000000);
		GlStateManager.color(1, 1, 1, 1);
		gui.mc.getTextureManager().bindTexture(TEXTURE);
		gui.drawTexturedModalRect(x, y + 35, 128, 128, 0, 0, 256, 256);

		gui.renderItemStack(input, x + 32, y + 90, mx, my);

		gui.renderItemStack(output, x + 92, y + 90, mx, my);
	}

}
