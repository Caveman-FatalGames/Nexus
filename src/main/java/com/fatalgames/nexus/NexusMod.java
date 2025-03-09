package com.fatalgames.nexus;

import com.fatalgames.nexus.fluid.BaseFluidType;
import com.fatalgames.nexus.fluid.ModFluidTypes;
import com.fatalgames.nexus.fluid.ModFluids;
import com.fatalgames.nexus.screen.custom.SteelTankScreen;
import com.fatalgames.nexus.block.entity.ModBlockEntities;
import com.fatalgames.nexus.recipe.ModRecipes;
import com.fatalgames.nexus.block.entity.renderer.SteelPedestalBlockEntityRenderer;
import com.fatalgames.nexus.block.entity.renderer.SteelTankEntityRenderer;
import com.fatalgames.nexus.component.ModDataComponentTypes;
import com.fatalgames.nexus.item.ModArmorMaterials;
import com.fatalgames.nexus.item.ModCreativeModeTabs;
import com.fatalgames.nexus.item.ModItems;
import com.fatalgames.nexus.screen.custom.SteelForgeScreen;
import com.fatalgames.nexus.screen.custom.SteelGeneratorScreen;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.screen.ModMenuTypes;
import com.fatalgames.nexus.screen.custom.SteelPedestalScreen;
import com.fatalgames.nexus.sound.ModSounds;
import com.fatalgames.nexus.util.ModItemProperties;
import com.fatalgames.nexus.villager.ModVillagers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(NexusMod.MOD_ID)
public class NexusMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "nexus";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public NexusMod(IEventBus modEventBus, ModContainer modContainer) {

        ModCreativeModeTabs.register(modEventBus);


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);

        ModArmorMaterials.register(modEventBus);

        ModSounds.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModVillagers.register(modEventBus);





        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);




        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.TERRESTRIAL_FLOWER.getId(), ModBlocks.POTTED_TERRESTRIAL_FLOWER);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {



        }





    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            ModItemProperties.addCustomItemProperties();

            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_TERRESTRIAL_GOOP.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_TERRESTRIAL_GOOP.get(), RenderType.translucent());
            });
        }

        @SubscribeEvent
        public static void onClientExtensions(RegisterClientExtensionsEvent event) {
            event.registerFluidType(((BaseFluidType) ModFluidTypes.TERRESTRIAL_GOOP_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.TERRESTRIAL_GOOP_FLUID_TYPE.get());
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.STEEL_PEDESTAL_BE.get(), SteelPedestalBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.STEEL_TANK_BE.get(), SteelTankEntityRenderer::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.PEDESTAL_MENU.get(), SteelPedestalScreen::new);
            event.register(ModMenuTypes.STEEL_FORGE_MENU.get(), SteelForgeScreen::new);

            event.register(ModMenuTypes.STEEL_GENERATOR_MENU.get(), SteelGeneratorScreen::new);

            event.register(ModMenuTypes.STEEL_TANK_MENU.get(), SteelTankScreen::new);


        }
    }
}
