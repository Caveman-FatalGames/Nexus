package com.fatalgames.nexus.item;

import com.fatalgames.nexus.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier TERRESTRIAL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_TERRESTRIAL_TOOL, 1800, 9f, 1.5f, 10,
            () -> Ingredient.of(ModItems.TERRESTRIAL_INGOT.get()));
}
