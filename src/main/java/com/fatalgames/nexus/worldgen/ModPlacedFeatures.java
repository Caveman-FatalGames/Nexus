package com.fatalgames.nexus.worldgen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> EBONY_PLACED_KEY = registerKey("ebony_placed");

    public static final ResourceKey<PlacedFeature> STEEL_ORE_PLACED_KEY = registerKey("steel_ore_placed");
    public static final ResourceKey<PlacedFeature> STEEL_DEEPSLATE_ORE_PLACED_KEY = registerKey("steel_deepslate_ore_placed");
    public static final ResourceKey<PlacedFeature> TERRESTRIAL_ORE_PLACED_KEY = registerKey("terrestrial_ore_placed");
    public static final ResourceKey<PlacedFeature> TERRESTRIAL_DEEPSLATE_ORE_PLACED_KEY = registerKey("terrestrial_deepslate_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, EBONY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EBONY_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.EBONY_SAPLING.get()));

        register(context, STEEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STEEL_ORE_KEY),
                ModOrePlacements.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, STEEL_DEEPSLATE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STEEL_DEEPSLATE_ORE_KEY),
                ModOrePlacements.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, TERRESTRIAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TERRESTRIAL_ORE_KEY),
                ModOrePlacements.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, TERRESTRIAL_DEEPSLATE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TERRESTRIAL_DEEPSLATE_ORE_KEY),
                ModOrePlacements.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
