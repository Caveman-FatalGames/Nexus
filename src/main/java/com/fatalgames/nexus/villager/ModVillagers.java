package com.fatalgames.nexus.villager;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.sound.ModSounds;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, NexusMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, NexusMod.MOD_ID);

    public static final Holder<PoiType> BLACKSMITH_POI = POI_TYPES.register("blacksmith_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.STEEL_FORGE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final Holder<VillagerProfession> BLACKSMITH = VILLAGER_PROFESSIONS.register("blacksmith",
            () -> new VillagerProfession("blacksmith", holder -> holder.value() == BLACKSMITH_POI.value(),
                    holder -> holder.value() == BLACKSMITH_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.FORGE_PLACED.get()));




    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
