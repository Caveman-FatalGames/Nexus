package com.fatalgames.nexus.block.entity;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.block.entity.custom.SteelForgeEntity;
import com.fatalgames.nexus.block.entity.custom.SteelPedestalBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, NexusMod.MOD_ID);

    public static final Supplier<BlockEntityType<SteelPedestalBlockEntity>> STEEL_PEDESTAL_BE =
            BLOCK_ENTITIES.register("steel_pedestal_be", () -> BlockEntityType.Builder.of(
                    SteelPedestalBlockEntity::new, ModBlocks.STEEL_PEDESTAL.get()).build(null));


    public static final Supplier<BlockEntityType<SteelForgeEntity>> STEEL_FORGE_BE =
            BLOCK_ENTITIES.register("steel_forge_be", () -> BlockEntityType.Builder.of(
                    SteelForgeEntity::new, ModBlocks.STEEL_FORGE.get()).build(null));





    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
