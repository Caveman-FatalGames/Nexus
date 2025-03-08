package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.block.custom.PolyvineCropBlock;
import com.fatalgames.nexus.block.custom.TerrestrialLightBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
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

        blockWithItem(ModBlocks.STEEL_ORE);
        blockWithItem(ModBlocks.STEEL_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockItem(ModBlocks.STEEL_SLAB);
        blockItem(ModBlocks.STEEL_STAIRS);
        blockItem(ModBlocks.STEEL_PRESSURE_PLATE);
        blockItem(ModBlocks.STEEL_FENCE_GATE);
        blockItem(ModBlocks.STEEL_TRAPDOOR, "_bottom");

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
        blockWithItemWithRenderType(ModBlocks.TERRESTRIAL_GLASS, "translucent");


        blockWithItem(ModBlocks.TERRESTRIAL_ORE);
        blockWithItem(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE);


        blockWithItem(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE);



        blockWithItem(ModBlocks.METEORITE_BLOCK);


        blockWithItem(ModBlocks.NEXIUM_BLOCK);

        customLamp();

        makeCrop(((PolyvineCropBlock) ModBlocks.POLYVINE.get()), "polyvine_crop_stage","polyvine_crop_stage");


        simpleBlock(ModBlocks.TERRESTRIAL_FLOWER.get(),
                models().cross(blockTexture(ModBlocks.TERRESTRIAL_FLOWER.get()).getPath(), blockTexture(ModBlocks.TERRESTRIAL_FLOWER.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_TERRESTRIAL_FLOWER.get(), models().singleTexture("potted_terrestrial_flower", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.TERRESTRIAL_FLOWER.get())).renderType("cutout"));



    }

    private void blockWithItemWithRenderType(DeferredBlock<Block> deferredBlock, String renderType) {
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(deferredBlock.getId().getPath(),
                modLoc("block/" + deferredBlock.getId().getPath())).renderType(renderType));
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.TERRESTRIAL_LIGHT_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(TerrestrialLightBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("terrestrial_light_block_on",
                        ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "block/" + "terrestrial_light_block_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("terrestrial_light_block_off",
                        ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "block/" + "terrestrial_light_block_off")))};
            }
        });
        simpleBlockItem(ModBlocks.TERRESTRIAL_LIGHT_BLOCK.get(), models().cubeAll("terrestrial_light_block_on",
                ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "block/" + "terrestrial_light_block_on")));
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
