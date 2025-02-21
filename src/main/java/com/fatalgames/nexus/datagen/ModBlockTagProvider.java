package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TERRESTRIAL_BLOCK.get())
                .add(ModBlocks.TERRESTRIAL_ORE.get())
                .add(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE.get())
                .add(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE.get())
                .add(ModBlocks.NEXIUM_BLOCK.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.METEORITE_BLOCK.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TERRESTRIAL_ORE.get())
                .add(ModBlocks.STEEL_BLOCK.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TERRESTRIAL_BLOCK.get())
                .add(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE.get())
                .add(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE.get())
                .add(ModBlocks.NEXIUM_BLOCK.get())
                .add(ModBlocks.METEORITE_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.STEEL_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.STEEL_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.STEEL_WALL.get());

    }
}
