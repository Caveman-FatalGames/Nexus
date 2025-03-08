package com.fatalgames.nexus.fluid;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, NexusMod.MOD_ID);

    public static final Supplier<FlowingFluid> SOURCE_TERRESTRIAL_GOOP= FLUIDS.register("source_terrestrial_goop",
            () -> new BaseFlowingFluid.Source(ModFluids.TERRESTRIAL_GOOP_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_TERRESTRIAL_GOOP= FLUIDS.register("flowing_terrestrial_goop",
            () -> new BaseFlowingFluid.Flowing(ModFluids.TERRESTRIAL_GOOP_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> TERRESTRIAL_GOOP_BLOCK = ModBlocks.BLOCKS.register("terrestrial_goop_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TERRESTRIAL_GOOP.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredItem<Item> TERRESTRIAL_GOOP_BUCKET = ModItems.ITEMS.registerItem("terrestrial_goop_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_TERRESTRIAL_GOOP.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties TERRESTRIAL_GOOP_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.TERRESTRIAL_GOOP_FLUID_TYPE, SOURCE_TERRESTRIAL_GOOP, FLOWING_TERRESTRIAL_GOOP)
            .slopeFindDistance(2).levelDecreasePerBlock(1)
            .block(ModFluids.TERRESTRIAL_GOOP_BLOCK).bucket(ModFluids.TERRESTRIAL_GOOP_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
