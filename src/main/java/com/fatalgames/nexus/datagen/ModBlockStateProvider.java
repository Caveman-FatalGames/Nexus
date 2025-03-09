package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.block.custom.PolyvineCropBlock;
import com.fatalgames.nexus.block.custom.SteelLightBlock;
import com.fatalgames.nexus.block.custom.TerrestrialLightBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NexusMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {


        logBlock(((RotatedPillarBlock) ModBlocks.EBONY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.EBONY_WOOD.get()), blockTexture(ModBlocks.EBONY_LOG.get()), blockTexture(ModBlocks.EBONY_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_WOOD.get()), blockTexture(ModBlocks.STRIPPED_EBONY_LOG.get()), blockTexture(ModBlocks.STRIPPED_EBONY_LOG.get()));


        leavesBlock(ModBlocks.EBONY_LEAVES);
        saplingBlock(ModBlocks.EBONY_SAPLING);
        blockItem(ModBlocks.EBONY_LOG);
        blockItem(ModBlocks.EBONY_WOOD);
        blockItem(ModBlocks.STRIPPED_EBONY_LOG);
        blockItem(ModBlocks.STRIPPED_EBONY_WOOD);

        blockWithItem(ModBlocks.EBONY_PLANKS);
        blockItem(ModBlocks.EBONY_SLAB);
        blockItem(ModBlocks.EBONY_STAIRS);
        blockItem(ModBlocks.EBONY_PRESSURE_PLATE);
        blockItem(ModBlocks.EBONY_FENCE_GATE);
        blockItem(ModBlocks.EBONY_TRAPDOOR, "_bottom");




        stairsBlock(((StairBlock) ModBlocks.EBONY_STAIRS.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.EBONY_SLAB.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.EBONY_PRESSURE_PLATE.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.EBONY_BUTTON.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.EBONY_FENCE.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.EBONY_FENCE_GATE.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.EBONY_WALL.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.EBONY_DOOR.get()), modLoc("block/ebony_door_bottom"), modLoc("block/ebony_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.EBONY_TRAPDOOR.get()), modLoc("block/ebony_trapdoor"), true, "cutout");


        blockWithItem(ModBlocks.STEEL_ORE);
        blockWithItem(ModBlocks.STEEL_DEEPSLATE_ORE);


        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockItem(ModBlocks.STEEL_SLAB);
        blockItem(ModBlocks.STEEL_STAIRS);
        blockItem(ModBlocks.STEEL_PRESSURE_PLATE);
        blockItem(ModBlocks.STEEL_FENCE_GATE);
        blockItem(ModBlocks.STEEL_TRAPDOOR, "_bottom");


        blockWithItemWithRenderType(ModBlocks.STEEL_GLASS, "translucent");
        blockWithItemWithRenderType(ModBlocks.STEEL_TANK, "translucent");


        blockItem(ModBlocks.STEEL_FORGE);
        blockItem(ModBlocks.STEEL_GENERATOR);


        stairsBlock(((StairBlock) ModBlocks.STEEL_STAIRS.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.STEEL_SLAB.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.STEEL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.STEEL_BUTTON.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.STEEL_FENCE.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.STEEL_FENCE_GATE.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.STEEL_WALL.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.STEEL_DOOR.get()), modLoc("block/steel_door_bottom"), modLoc("block/steel_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.STEEL_TRAPDOOR.get()), modLoc("block/steel_trapdoor"), true, "cutout");


        blockWithItem(ModBlocks.TERRESTRIAL_BLOCK);


        blockWithItem(ModBlocks.TERRESTRIAL_ORE);
        blockWithItem(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE);


        blockWithItemWithRenderType(ModBlocks.TERRESTRIAL_GLASS, "translucent");


        blockWithItem(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE);



        blockWithItem(ModBlocks.METEORITE_BLOCK);


        blockWithItem(ModBlocks.NEXIUM_BLOCK);

        customLamp(ModBlocks.TERRESTRIAL_LIGHT_BLOCK, "terrestrial_light_block_on", "terrestrial_light_block_off", TerrestrialLightBlock.CLICKED);
        customLamp(ModBlocks.STEEL_LIGHT_BLOCK, "steel_light_block_on", "steel_light_block_off", SteelLightBlock.CLICKED);

        makeCrop(((PolyvineCropBlock) ModBlocks.POLYVINE.get()), "polyvine_crop_stage","polyvine_crop_stage");


        simpleBlock(ModBlocks.TERRESTRIAL_FLOWER.get(),
                models().cross(blockTexture(ModBlocks.TERRESTRIAL_FLOWER.get()).getPath(), blockTexture(ModBlocks.TERRESTRIAL_FLOWER.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_TERRESTRIAL_FLOWER.get(), models().singleTexture("potted_terrestrial_flower", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.TERRESTRIAL_FLOWER.get())).renderType("cutout"));



    }


    private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));

    }

        private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void blockWithItemWithRenderType(DeferredBlock<Block> deferredBlock, String renderType) {
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(deferredBlock.getId().getPath(),
                modLoc("block/" + deferredBlock.getId().getPath())).renderType(renderType));
    }

    private void customLamp(DeferredBlock<Block> block, String onTexture, String offTexture, BooleanProperty property) {
        getVariantBuilder(block.get()).forAllStates(state -> {
            if(state.getValue(property)) { // Use the correct property dynamically
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(onTexture,
                        ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "block/" + onTexture)))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(offTexture,
                        ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "block/" + offTexture)))};
            }
        });

        simpleBlockItem(block.get(), models().cubeAll(onTexture,
                ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "block/" + onTexture)));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PolyvineCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "block/" + textureName +
                        state.getValue(((PolyvineCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }




    private void blockWithItem(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nexus:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nexus:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
