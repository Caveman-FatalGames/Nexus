package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
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
        stairsBlock(((StairBlock) ModBlocks.STEEL_STAIRS.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.STEEL_SLAB.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));

        
        blockItem(ModBlocks.STEEL_SLAB);
        blockItem(ModBlocks.STEEL_STAIRS);

        blockWithItem(ModBlocks.STEEL_BLOCK);


        blockWithItem(ModBlocks.TERRESTRIAL_BLOCK);


        blockWithItem(ModBlocks.TERRESTRIAL_ORE);
        blockWithItem(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE);


        blockWithItem(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE);


        blockWithItem(ModBlocks.NEXIUM_BLOCK);
    }



    private void blockWithItem(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nexus:block/" + deferredBlock.getId().getPath()));
    }
}
