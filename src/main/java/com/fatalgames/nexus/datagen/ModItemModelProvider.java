package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModItems.RAW_TERRESTRIAL.get());
        basicItem(ModItems.TERRESTRIAL_COAL.get());
        basicItem(ModItems.TERRESTRIAL_FRUIT.get());
        basicItem(ModItems.TERRESTRIAL_INGOT.get());
        basicItem(ModItems.TERRESTRIAL_SAW.get());


        basicItem(ModItems.RAW_NEXIUM.get());
        basicItem(ModItems.NEXIUM_DUST.get());
        basicItem(ModItems.NEXIUM_INGOT.get());


        basicItem(ModItems.STEEL_INGOT.get());

        buttonItem(ModBlocks.STEEL_BUTTON, ModBlocks.STEEL_BLOCK);
        fenceItem(ModBlocks.STEEL_FENCE, ModBlocks.STEEL_BLOCK);
        wallItem(ModBlocks.STEEL_WALL, ModBlocks.STEEL_BLOCK);
        basicItem(ModBlocks.STEEL_DOOR.asItem());

    }
    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

}
