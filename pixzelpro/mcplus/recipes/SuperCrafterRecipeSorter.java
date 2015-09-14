package net.pixzelpro.mcplus.recipes;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class SuperCrafterRecipeSorter implements Comparator {
	
	final SuperCrafterCraftingManager superCrafter;
	
	public SuperCrafterRecipeSorter(SuperCrafterCraftingManager superCrafterCraftingManager) {
		this.superCrafter = superCrafterCraftingManager;
	}
	
	public int compareRecipes (IRecipe iRecipe1, IRecipe iRecipe2) {
		return iRecipe1 instanceof SuperCrafterShapelessRecipes && iRecipe2 instanceof SuperCrafterShapedRecipes ? 1 : (iRecipe2 instanceof SuperCrafterShapelessRecipes && iRecipe1 instanceof SuperCrafterShapedRecipes ? -1 : (iRecipe2.getRecipeSize() > iRecipe1.getRecipeSize() ? -1 : (iRecipe2.getRecipeSize() > iRecipe1.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}
}