package Tamaized.Voidcraft.Addons.JEI.alchemy;

import Tamaized.Voidcraft.Addons.JEI.VoidCraftRecipeWrapperJEI;
import Tamaized.Voidcraft.machina.addons.TERecipesAlchemy.AlchemyRecipe;
import Tamaized.Voidcraft.machina.tileentity.TileEntityVoidicAlchemy;
import mezz.jei.api.gui.IGuiIngredientGroup;

public class AlchemyRecipeWrapperJEI extends VoidCraftRecipeWrapperJEI<AlchemyRecipe> {

	public AlchemyRecipeWrapperJEI(AlchemyRecipe r) {
		super(r);
	}

	@Override
	public void setupSlots(IGuiIngredientGroup g) {
		g.init(TileEntityVoidicAlchemy.SLOT_OUTPUT, false, 37, 20);
		g.init(TileEntityVoidicAlchemy.SLOT_INPUT_1, true, 13, -5);
		g.init(TileEntityVoidicAlchemy.SLOT_INPUT_2, true, 2, 20);
		g.init(TileEntityVoidicAlchemy.SLOT_INPUT_3, true, 13, 45);
		g.init(TileEntityVoidicAlchemy.SLOT_INPUT_4, true, 61, -5);
		g.init(TileEntityVoidicAlchemy.SLOT_INPUT_5, true, 72, 20);
		g.init(TileEntityVoidicAlchemy.SLOT_INPUT_6, true, 61, 45);

		g.set(TileEntityVoidicAlchemy.SLOT_OUTPUT, getOutput());
		
		g.set(TileEntityVoidicAlchemy.SLOT_INPUT_1, getInputs().get(0));
		g.set(TileEntityVoidicAlchemy.SLOT_INPUT_2, getInputs().get(1));
		g.set(TileEntityVoidicAlchemy.SLOT_INPUT_3, getInputs().get(2));
		g.set(TileEntityVoidicAlchemy.SLOT_INPUT_4, getInputs().get(3));
		g.set(TileEntityVoidicAlchemy.SLOT_INPUT_5, getInputs().get(4));
		g.set(TileEntityVoidicAlchemy.SLOT_INPUT_6, getInputs().get(5));

	}

}