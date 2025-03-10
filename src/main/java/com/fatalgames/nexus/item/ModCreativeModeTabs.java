package com.fatalgames.nexus.item;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.fluid.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NexusMod.MOD_ID);


    public static final Supplier<CreativeModeTab> NEXUS_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("nexus_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.nexus.nexus_items_tab"))
                    .icon(() -> new ItemStack(ModItems.NEXIUM_EYE.get()))
                    .displayItems((pParameters, pOutput) -> {



                        pOutput.accept(ModItems.POLYMER);
                        pOutput.accept(ModItems.PLASTIC_BALL);
                        pOutput.accept(ModItems.PLASTIC_SHEET);



                        pOutput.accept(ModItems.RAW_STEEL);
                        pOutput.accept(ModItems.STEEL_DUST);
                        pOutput.accept(ModItems.STEEL_INGOT);

                        pOutput.accept(ModItems.STEEL_NUTS_AND_BOLTS);
                        pOutput.accept(ModItems.STEEL_PLATE);


                        pOutput.accept(ModItems.RAW_TERRESTRIAL);
                        pOutput.accept(ModItems.TERRESTRIAL_DUST);
                        pOutput.accept(ModItems.TERRESTRIAL_INGOT);

                        pOutput.accept(ModItems.TERRESTRIAL_COAL);


                        pOutput.accept(ModItems.RAW_NEXIUM);
                        pOutput.accept(ModItems.NEXIUM_DUST);
                        pOutput.accept(ModItems.NEXIUM_INGOT);
                        pOutput.accept(ModItems.NEXIUM_EYE);


                        pOutput.accept(ModItems.OBSIDIAN_ROD);
                        pOutput.accept(ModItems.NEXIUM_ROD);


                        pOutput.accept(ModItems.ORE_DATA_TABLET);
                        pOutput.accept(ModItems.STEEL_ORE_DETECTOR);





                    }).build());

    public static final Supplier<CreativeModeTab> NEXUS_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("nexus_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.nexus.nexus_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.NEXIUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "nexus_items_tab"))
                    .displayItems((pParameters, pOutput) -> {


                        // EBONY //

                        pOutput.accept(ModBlocks.EBONY_LOG);
                        pOutput.accept(ModBlocks.STRIPPED_EBONY_LOG);
                        pOutput.accept(ModBlocks.STRIPPED_EBONY_WOOD);
                        pOutput.accept(ModBlocks.EBONY_PLANKS);
                        pOutput.accept(ModBlocks.EBONY_STAIRS);
                        pOutput.accept(ModBlocks.EBONY_SLAB);
                        pOutput.accept(ModBlocks.EBONY_PRESSURE_PLATE);
                        pOutput.accept(ModBlocks.EBONY_BUTTON);
                        pOutput.accept(ModBlocks.EBONY_FENCE);
                        pOutput.accept(ModBlocks.EBONY_FENCE_GATE);
                        pOutput.accept(ModBlocks.EBONY_WALL);
                        pOutput.accept(ModBlocks.EBONY_DOOR);
                        pOutput.accept(ModBlocks.EBONY_TRAPDOOR);


                        // STEEL //

                        pOutput.accept(ModBlocks.STEEL_ORE);
                        pOutput.accept(ModBlocks.STEEL_DEEPSLATE_ORE);
                        pOutput.accept(ModBlocks.STEEL_BLOCK);
                        pOutput.accept(ModBlocks.STEEL_STAIRS);
                        pOutput.accept(ModBlocks.STEEL_SLAB);
                        pOutput.accept(ModBlocks.STEEL_PRESSURE_PLATE);
                        pOutput.accept(ModBlocks.STEEL_BUTTON);
                        pOutput.accept(ModBlocks.STEEL_FENCE);
                        pOutput.accept(ModBlocks.STEEL_FENCE_GATE);
                        pOutput.accept(ModBlocks.STEEL_WALL);
                        pOutput.accept(ModBlocks.STEEL_DOOR);
                        pOutput.accept(ModBlocks.STEEL_TRAPDOOR);

                        pOutput.accept(ModBlocks.STEEL_LIGHT_BLOCK);
                        pOutput.accept(ModBlocks.STEEL_GLASS);
                        pOutput.accept(ModBlocks.STEEL_TANK);
                        pOutput.accept(ModBlocks.STEEL_PEDESTAL);
                        pOutput.accept(ModBlocks.STEEL_FORGE);
                        pOutput.accept(ModBlocks.STEEL_GENERATOR);


                        // TERRESTRIAL //


                        pOutput.accept(ModBlocks.TERRESTRIAL_ORE);
                        pOutput.accept(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE);

                        pOutput.accept(ModBlocks.TERRESTRIAL_BLOCK);
                        pOutput.accept(ModBlocks.TERRESTRIAL_GLASS);
                        pOutput.accept(ModBlocks.TERRESTRIAL_LIGHT_BLOCK);

                        pOutput.accept(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE);


                        // NEXIUM //


                        pOutput.accept(ModBlocks.METEORITE_BLOCK);
                        pOutput.accept(ModBlocks.NEXIUM_BLOCK);




                    }).build());


    public static final Supplier<CreativeModeTab> NEXUS_TOOLS_TAB =
            CREATIVE_MODE_TABS.register("nexus_tools_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.nexus.nexus_tools_tab"))
                    .icon(() -> new ItemStack(ModItems.TERRESTRIAL_PICKAXE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "nexus_blocks_tab"))
                    .displayItems((pParameters, pOutput) -> {


                        // STEEL //

                        pOutput.accept(ModItems.STEEL_HOE);
                        pOutput.accept(ModItems.STEEL_SHOVEL);
                        pOutput.accept(ModItems.STEEL_AXE);
                        pOutput.accept(ModItems.STEEL_PICKAXE);

                        pOutput.accept(ModItems.STEEL_SAW);
                        pOutput.accept(ModItems.STEEL_PAXEL);
                        pOutput.accept(ModItems.STEEL_HAMMER);


                        // TERRESTRIAL //

                        pOutput.accept(ModItems.TERRESTRIAL_HOE);
                        pOutput.accept(ModItems.TERRESTRIAL_SHOVEL);
                        pOutput.accept(ModItems.TERRESTRIAL_AXE);
                        pOutput.accept(ModItems.TERRESTRIAL_PICKAXE);


                        pOutput.accept(ModItems.TERRESTRIAL_SAW);
                        pOutput.accept(ModItems.TERRESTRIAL_PAXEL);
                        pOutput.accept(ModItems.TERRESTRIAL_HAMMER);


                        // NEXIUM //

                        pOutput.accept(ModItems.NEXIUM_HAMMER);






                    }).build());


    public static final Supplier<CreativeModeTab> NEXUS_ARMOR_AND_WEAPONS_TAB =
            CREATIVE_MODE_TABS.register("nexus_armor_and_weapons_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.nexus.nexus_armor_and_weapons_tab"))
                    .icon(() -> new ItemStack(ModItems.TERRESTRIAL_SWORD.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "nexus_tools_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        // STEEL //

                        pOutput.accept(ModItems.STEEL_SWORD);
                        pOutput.accept(ModItems.STEEL_BOW);


                        // TERRESTRIAL //

                        pOutput.accept(ModItems.TERRESTRIAL_SWORD);

                        pOutput.accept(ModItems.TERRESTRIAL_HELMET);
                        pOutput.accept(ModItems.TERRESTRIAL_CHESTPLATE);
                        pOutput.accept(ModItems.TERRESTRIAL_LEGGINGS);
                        pOutput.accept(ModItems.TERRESTRIAL_BOOTS);




                    }).build());



    public static final Supplier<CreativeModeTab> NEXUS_FOOD_AND_FLUIDS =
            CREATIVE_MODE_TABS.register("nexus_food_and_fluids_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.nexus.nexus_food_and_fluids_tab"))
                    .icon(() -> new ItemStack(ModItems.TERRESTRIAL_FRUIT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "nexus_armor_and_weapons_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModFluids.TERRESTRIAL_GOOP_BUCKET);

                        pOutput.accept(ModBlocks.EBONY_SAPLING);
                        pOutput.accept(ModBlocks.EBONY_LEAVES);

                        pOutput.accept(ModItems.POLYVINE_SEEDS);
                        pOutput.accept(ModItems.POLYVINE);

                        pOutput.accept(ModBlocks.TERRESTRIAL_FLOWER);
                        pOutput.accept(ModItems.TERRESTRIAL_FRUIT);

                        pOutput.accept(ModItems.TERRESTRIAL_FRUIT);
                        pOutput.accept(ModItems.TERRESTRIAL_STEAK);




                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }



}
