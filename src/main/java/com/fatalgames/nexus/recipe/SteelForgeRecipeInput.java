package com.fatalgames.nexus.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record SteelForgeRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getItem(int pIndex) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
}