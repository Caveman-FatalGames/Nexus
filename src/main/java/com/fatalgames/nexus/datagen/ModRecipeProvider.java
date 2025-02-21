package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput){

        List<ItemLike> TERRESTRIAL_SMELTABLES = List.of(ModItems.RAW_TERRESTRIAL, ModBlocks.TERRESTRIAL_ORE, ModBlocks.TERRESTRIAL_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TERRESTRIAL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TERRESTRIAL_INGOT.get())
                .unlockedBy("has_terrestrial_ingot", has(ModItems.TERRESTRIAL_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TERRESTRIAL_COAL.get(), 8)
                .pattern("CCC")
                .pattern("CDC")
                .pattern("CCC")
                .define('C', Items.COAL)
                .define('D', ModItems.TERRESTRIAL_INGOT.get())
                .unlockedBy("has_terrestrial_ingot", has(ModItems.TERRESTRIAL_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TERRESTRIAL_FRUIT.get(), 4)
                .pattern(" C ")
                .pattern("CDC")
                .pattern(" C ")
                .define('C', Items.APPLE)
                .define('D', ModItems.TERRESTRIAL_INGOT.get())
                .unlockedBy("has_terrestrial_ingot", has(ModItems.TERRESTRIAL_INGOT)).save(pRecipeOutput);



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK.get())).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TERRESTRIAL_INGOT.get(), 9)
                .requires(ModBlocks.TERRESTRIAL_BLOCK.get())
                .unlockedBy("has_terrestrial_block", has(ModBlocks.TERRESTRIAL_BLOCK.get())).save(pRecipeOutput);


        oreSmelting(pRecipeOutput, TERRESTRIAL_SMELTABLES, RecipeCategory.MISC, ModItems.TERRESTRIAL_INGOT.get(), 0.25f, 200, "terrestrial_ingot");
        oreBlasting(pRecipeOutput, TERRESTRIAL_SMELTABLES, RecipeCategory.MISC, ModItems.TERRESTRIAL_INGOT.get(), 0.25f, 100, "terrestrial_ingot");

        List<ItemLike> NEXIUM_INGOT_SMELTABLES = List.of(ModItems.RAW_NEXIUM);

        oreSmelting(pRecipeOutput, NEXIUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.NEXIUM_INGOT.get(), 0.25f, 200, "nexium_ingot");
        oreBlasting(pRecipeOutput, NEXIUM_INGOT_SMELTABLES , RecipeCategory.MISC, ModItems.NEXIUM_INGOT.get(), 0.25f, 100, "nexium_ingot");

        stairBuilder(ModBlocks.STEEL_STAIRS.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel_ingot")
                        .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_SLAB.get(), ModItems.STEEL_INGOT);

        pressurePlate(pRecipeOutput, ModBlocks.STEEL_PRESSURE_PLATE.get(), ModItems.STEEL_INGOT.get());

        buttonBuilder(ModBlocks.STEEL_BUTTON.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel_ingot")
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);

        fenceBuilder(ModBlocks.STEEL_FENCE.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel_ingot")
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);

        fenceGateBuilder(ModBlocks.STEEL_FENCE_GATE.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel_ingot")
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);

        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_WALL.get(), ModItems.STEEL_INGOT.get());

        doorBuilder(ModBlocks.STEEL_DOOR.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel_ingot")
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);

        trapdoorBuilder(ModBlocks.STEEL_TRAPDOOR.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel_ingot")
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get())).save(pRecipeOutput);


    }


    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, NexusMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
