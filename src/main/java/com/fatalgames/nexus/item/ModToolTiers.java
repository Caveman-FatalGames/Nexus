package com.fatalgames.nexus.item;

import com.fatalgames.nexus.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier STEEL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL, 1200, 8f, 1.2f, 10,
            () -> Ingredient.of(ModItems.STEEL_INGOT.get()));

    public static final Tier TERRESTRIAL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_TERRESTRIAL_TOOL, 1800, 9f, 1.5f, 10,
            () -> Ingredient.of(ModItems.TERRESTRIAL_INGOT.get()));

    public static final Tier NEXIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_NEXIUM_TOOL, 5000, 10f, 5f, 30,
            () -> Ingredient.of(ModItems.NEXIUM_INGOT.get()));
}
