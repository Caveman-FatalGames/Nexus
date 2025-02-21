package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NexusMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockItem(ModBlocks.STEEL_SLAB);
        blockItem(ModBlocks.STEEL_STAIRS);
        blockItem(ModBlocks.STEEL_PRESSURE_PLATE);
        blockItem(ModBlocks.STEEL_FENCE_GATE);
        blockItem(ModBlocks.STEEL_TRAPDOOR, "_bottom");


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


        blockWithItem(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE);



        blockWithItem(ModBlocks.METEORITE_BLOCK);


        blockWithItem(ModBlocks.NEXIUM_BLOCK);
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
