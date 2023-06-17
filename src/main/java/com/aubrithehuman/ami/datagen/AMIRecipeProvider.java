package com.aubrithehuman.ami.datagen;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class AMIRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public AMIRecipeProvider(DataGenerator p_125973_) {
		super(p_125973_);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
//		doorBuilder(null, null)
	}

}
