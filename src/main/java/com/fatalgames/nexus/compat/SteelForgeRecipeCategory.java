package com.fatalgames.nexus.compat;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.recipe.SteelForgeRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import com.fatalgames.nexus.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SteelForgeRecipeCategory implements IRecipeCategory<SteelForgeRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "forge");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,
            "textures/gui/steel_forge/steel_forge_gui.png");

    public static final RecipeType<SteelForgeRecipe> STEEL_FORGE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, SteelForgeRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SteelForgeRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.STEEL_FORGE.get()));
    }

    @Override
    public RecipeType<SteelForgeRecipe> getRecipeType() {
        return STEEL_FORGE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Forge");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SteelForgeRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 34).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 34).addItemStack(recipe.getResultItem(null));
    }
}
