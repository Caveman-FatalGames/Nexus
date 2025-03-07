package com.fatalgames.nexus.compat;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.recipe.ModRecipes;
import com.fatalgames.nexus.recipe.SteelForgeRecipe;
import com.fatalgames.nexus.screen.custom.SteelForgeScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEINexusModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SteelForgeRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<SteelForgeRecipe> steelForgeRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.STEEL_FORGE_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(SteelForgeRecipeCategory.STEEL_FORGE_RECIPE_RECIPE_TYPE, steelForgeRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(SteelForgeScreen.class, 70, 30, 25, 20,
                SteelForgeRecipeCategory.STEEL_FORGE_RECIPE_RECIPE_TYPE);
    }
}
