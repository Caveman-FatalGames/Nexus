package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.item.ModItems;
import com.fatalgames.nexus.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, NexusMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.SAND);

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.TERRESTRIAL_HELMET.get())
                .add(ModItems.TERRESTRIAL_CHESTPLATE.get())
                .add(ModItems.TERRESTRIAL_LEGGINGS.get())
                .add(ModItems.TERRESTRIAL_BOOTS.get());



        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EBONY_LOG.get().asItem())
                .add(ModBlocks.EBONY_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_EBONY_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_EBONY_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.EBONY_PLANKS.get().asItem());
    }
}
