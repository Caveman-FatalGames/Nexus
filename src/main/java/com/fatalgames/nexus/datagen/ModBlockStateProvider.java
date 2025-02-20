package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.extensions.IDimensionSpecialEffectsExtension;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NexusMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TERRESTRIAL_BLOCK);

        blockWithItem(ModBlocks.TERRESTRIAL_ORE);
        blockWithItem(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE);


        blockWithItem(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE);


        blockWithItem(ModBlocks.NEXIUM_BLOCK);
    }


    private void blockWithItem(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
