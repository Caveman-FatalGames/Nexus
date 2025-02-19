package com.fatalgames.nexus.item;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NexusMod.MOD_ID);


    public static final Supplier<CreativeModeTab> NEXUS_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("nexus_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.nexus.nexus_items_tab"))
                    .icon(() -> new ItemStack(ModItems.RAW_NEXIUM.get()))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.RAW_TERRESTRIAL);
                        pOutput.accept(ModItems.TERRESTRIAL_INGOT);


                        pOutput.accept(ModItems.RAW_NEXIUM);


                        pOutput.accept(ModItems.TERRESRIAL_SAW)   ;



                    }).build());

    public static final Supplier<CreativeModeTab> NEXUS_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("nexus_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.nexus.nexus_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.NEXIUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "nexus_items_tab"))
                    .displayItems((pParameters, pOutput) -> {


                        pOutput.accept(ModBlocks.TERRESTRIAL_ORE);
                        pOutput.accept(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE);

                        pOutput.accept(ModBlocks.TERRESTRIAL_BLOCK);




                        pOutput.accept(ModBlocks.NEXIUM_BLOCK);




                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }



}
