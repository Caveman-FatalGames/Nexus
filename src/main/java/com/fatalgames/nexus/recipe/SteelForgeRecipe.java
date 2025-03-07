package com.fatalgames.nexus.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record SteelForgeRecipe(Ingredient inputItem, ItemStack output) implements Recipe<SteelForgeRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(SteelForgeRecipeInput pInput, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItem.test(pInput.getItem(0));
    }

    @Override
    public ItemStack assemble(SteelForgeRecipeInput pInput, HolderLookup.Provider pRegistries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.STEEL_FORGE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.STEEL_FORGE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<SteelForgeRecipe> {
        public static final MapCodec<SteelForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(SteelForgeRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(SteelForgeRecipe::output)
        ).apply(inst, SteelForgeRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, SteelForgeRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, SteelForgeRecipe::inputItem,
                        ItemStack.STREAM_CODEC, SteelForgeRecipe::output,
                        SteelForgeRecipe::new);

        @Override
        public MapCodec<SteelForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SteelForgeRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
