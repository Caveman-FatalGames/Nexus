package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModItems.OBSIDIAN_ROD.get());



        basicItem(ModItems.RAW_TERRESTRIAL.get());
        basicItem(ModItems.TERRESTRIAL_COAL.get());
        basicItem(ModItems.TERRESTRIAL_FRUIT.get());
        basicItem(ModItems.TERRESTRIAL_INGOT.get());


        handheldItem(ModItems.TERRESTRIAL_HOE.get());
        handheldItem(ModItems.TERRESTRIAL_SHOVEL.get());
        handheldItem(ModItems.TERRESTRIAL_PICKAXE.get());
        handheldItem(ModItems.TERRESTRIAL_AXE.get());

        handheldItem(ModItems.TERRESTRIAL_SAW.get());
        handheldItem(ModItems.TERRESTRIAL_PAXEL.get());


        handheldItem(ModItems.TERRESTRIAL_SWORD.get());


        basicItem(ModItems.RAW_NEXIUM.get());
        basicItem(ModItems.NEXIUM_DUST.get());
        basicItem(ModItems.NEXIUM_INGOT.get());
        basicItem(ModItems.NEXIUM_EYE.get());


        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.STEEL_NUTS_AND_BOLTS.get());
        basicItem(ModItems.STEEL_PLATE.get());

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

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,"item/" + item.getId().getPath()));
    }

}
