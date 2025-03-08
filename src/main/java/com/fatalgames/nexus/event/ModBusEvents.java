package com.fatalgames.nexus.event;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.entity.ModBlockEntities;
import com.fatalgames.nexus.block.entity.custom.SteelForgeEntity;
import com.fatalgames.nexus.block.entity.custom.SteelGeneratorEntity;
import com.fatalgames.nexus.block.entity.custom.SteelTankEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = NexusMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {


        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntities.STEEL_GENERATOR_BE.get(), SteelGeneratorEntity::getEnergyStorage);


        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModBlockEntities.STEEL_FORGE_BE.get(), SteelForgeEntity::getItemHandler);
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntities.STEEL_FORGE_BE.get(), SteelForgeEntity::getEnergyStorage);
        event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ModBlockEntities.STEEL_FORGE_BE.get(), SteelForgeEntity::getFluidTank);


        event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ModBlockEntities.STEEL_TANK_BE.get(), SteelTankEntity::getTank);

    }
}
