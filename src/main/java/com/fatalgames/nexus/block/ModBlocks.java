package com.fatalgames.nexus.block;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.custom.TerrestrialTransmutationTable;
import com.fatalgames.nexus.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NexusMod.MOD_ID);


    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TERRESTRIAL_BLOCK = registerBlock("terrestrial_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TERRESTRIAL_ORE = registerBlock("terrestrial_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TERRESTRIAL_DEEPSLATE_ORE = registerBlock("terrestrial_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                    BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TERRESTRIAL_TRANSMUTATION_TABLE = registerBlock("terrestrial_transmutation_table",
            () -> new TerrestrialTransmutationTable(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));



    public static final DeferredBlock<Block> METEORITE_BLOCK = registerBlock("meteorite_block",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                    BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<Block> NEXIUM_BLOCK = registerBlock("nexium_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));





    public static final DeferredBlock<Block> STEEL_STAIRS = registerBlock("steel_stairs",
            () -> new StairBlock(ModBlocks.STEEL_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_SLAB = registerBlock("steel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));





    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}


