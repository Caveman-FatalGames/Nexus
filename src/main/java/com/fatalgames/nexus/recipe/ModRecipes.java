package com.fatalgames.nexus.recipe;

import com.fatalgames.nexus.NexusMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, NexusMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, NexusMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<SteelForgeRecipe>> STEEL_FORGE_SERIALIZER =
            SERIALIZERS.register("forge", SteelForgeRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<SteelForgeRecipe>> STEEL_FORGE_TYPE =
            TYPES.register("forge", () -> new RecipeType<SteelForgeRecipe>() {
                @Override
                public String toString() {
                    return "forge";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
