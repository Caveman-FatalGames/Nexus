package com.fatalgames.nexus.worldgen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> TERRESTRIAL_FLOWER_KEY = registerKey("terrestrial_flower");

    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_KEY = registerKey("ebony");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STEEL_ORE_KEY = registerKey("steel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STEEL_DEEPSLATE_ORE_KEY = registerKey("steel_deepslate_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TERRESTRIAL_ORE_KEY = registerKey("terrestrial_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TERRESTRIAL_DEEPSLATE_ORE_KEY = registerKey("terrestrial_deepslate_ore");


    public static final ResourceKey<ConfiguredFeature<?, ?>> NEXIUM_BLOCK_GEODE_KEY = registerKey("terrestrial_block_geode");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, TERRESTRIAL_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TERRESTRIAL_FLOWER.get())))));



        register(context, EBONY_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
                new StraightTrunkPlacer(4, 5, 3),
                BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(4), ConstantInt.of(2), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());


        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldSteelOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.STEEL_ORE.get().defaultBlockState()),
                OreConfiguration.target(stoneReplaceables, ModBlocks.TERRESTRIAL_ORE.get().defaultBlockState()));


        register(context, STEEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSteelOres, 9));
        register(context, STEEL_DEEPSLATE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSteelOres, 9));



        List<OreConfiguration.TargetBlockState> overworldTerrestrialOres = List.of(
                OreConfiguration.target(deepslateReplaceables, ModBlocks.STEEL_DEEPSLATE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.TERRESTRIAL_DEEPSLATE_ORE.get().defaultBlockState()));


        register(context, TERRESTRIAL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTerrestrialOres,9));
        register(context, TERRESTRIAL_DEEPSLATE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTerrestrialOres, 9));



        // GEODE //

        register(context, NEXIUM_BLOCK_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.DEEPSLATE),
                        BlockStateProvider.simple(ModBlocks.METEORITE_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.OBSIDIAN),
                        BlockStateProvider.simple(Blocks.CRYING_OBSIDIAN),
                        List.of(ModBlocks.NEXIUM_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),

                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));



    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
