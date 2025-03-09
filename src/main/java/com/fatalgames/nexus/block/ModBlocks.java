package com.fatalgames.nexus.block;

import com.fatalgames.nexus.block.custom.SteelForge;
import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.custom.*;
import com.fatalgames.nexus.item.ModItems;
import com.fatalgames.nexus.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NexusMod.MOD_ID);


    public static final DeferredBlock<Block> STEEL_LIGHT_BLOCK = registerBlock("steel_light_block",
            () -> new SteelLightBlock(BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(SteelLightBlock.CLICKED) ? 15 : 0)));

    public static final DeferredBlock<Block> STEEL_GLASS = registerBlock("steel_glass",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.3f)
                    .noOcclusion() // Makes sure it does not block light
                    .isViewBlocking((state, world, pos) -> false) // Prevents culling issues
                    .requiresCorrectToolForDrops()
            ));


    public static final DeferredBlock<Block> STEEL_ORE = registerBlock("steel_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_DEEPSLATE_ORE = registerBlock("steel_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                    BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));



    public static final DeferredBlock<Block> TERRESTRIAL_BLOCK = registerBlock("terrestrial_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TERRESTRIAL_GLASS = registerBlock("terrestrial_glass",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.3f)
                    .noOcclusion() // Makes sure it does not block light
                    .isViewBlocking((state, world, pos) -> false) // Prevents culling issues
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> TERRESTRIAL_LIGHT_BLOCK = registerBlock("terrestrial_light_block",
            () -> new TerrestrialLightBlock(BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(TerrestrialLightBlock.CLICKED) ? 15 : 0)));

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


    public static final DeferredBlock<Block> EBONY_LOG = registerBlock("ebony_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> EBONY_WOOD = registerBlock("ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> EBONY_PLANKS = registerBlock("ebony_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> EBONY_LEAVES = registerBlock("ebony_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> EBONY_SAPLING = registerBlock("ebony_sapling",
            () -> new SaplingBlock(ModTreeGrowers.EBONY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> EBONY_STAIRS = registerBlock("ebony_stairs",
            () -> new StairBlock(ModBlocks.EBONY_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f)));

    public static final DeferredBlock<Block> EBONY_SLAB = registerBlock("ebony_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f)));

    public static final DeferredBlock<Block> EBONY_PRESSURE_PLATE = registerBlock("ebony_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, Block.Properties.of().strength(3f)));

    public static final DeferredBlock<Block> EBONY_BUTTON = registerBlock("ebony_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, Block.Properties.of().strength(3f).noCollission()));

    public static final DeferredBlock<Block> EBONY_FENCE = registerBlock("ebony_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(4f)));

    public static final DeferredBlock<Block> EBONY_FENCE_GATE = registerBlock("ebony_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(3f)));

    public static final DeferredBlock<Block> EBONY_WALL = registerBlock("ebony_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f)));

    public static final DeferredBlock<Block> EBONY_DOOR = registerBlock("ebony_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(3f).noOcclusion()));

    public static final DeferredBlock<Block> EBONY_TRAPDOOR = registerBlock("ebony_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(3f).noOcclusion()));




    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_STAIRS = registerBlock("steel_stairs",
            () -> new StairBlock(ModBlocks.STEEL_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_SLAB = registerBlock("steel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_PRESSURE_PLATE = registerBlock("steel_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, Block.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_BUTTON = registerBlock("steel_button",
            () -> new ButtonBlock(BlockSetType.IRON, 10, Block.Properties.of().strength(4f).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<Block> STEEL_FENCE = registerBlock("steel_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_FENCE_GATE = registerBlock("steel_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_WALL = registerBlock("steel_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_DOOR = registerBlock("steel_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> STEEL_TRAPDOOR = registerBlock("steel_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()));



    public static final DeferredBlock<Block> STEEL_PEDESTAL = registerBlock("steel_pedestal",
            () -> new SteelPedestalBlock(BlockBehaviour.Properties.of().noOcclusion().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_FORGE = registerBlock("steel_forge",
            () -> new SteelForge(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STEEL_GENERATOR = registerBlock("steel_generator",
            () -> new SteelGenerator(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));




    public static final DeferredBlock<Block> POLYVINE = BLOCKS.register("polyvine",
            () -> new PolyvineCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));


    public static final DeferredBlock<Block> TERRESTRIAL_FLOWER = registerBlock("terrestrial_flower",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 8, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM)));

    public static final DeferredBlock<Block> POTTED_TERRESTRIAL_FLOWER = BLOCKS.register("potted_terrestrial_flower",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), TERRESTRIAL_FLOWER, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));



    public static final DeferredBlock<Block> STEEL_TANK = registerBlock("steel_tank",
            () -> new SteelTank(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));


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


