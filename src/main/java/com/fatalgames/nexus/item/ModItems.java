package com.fatalgames.nexus.item;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.item.custom.FuelItem;
import com.fatalgames.nexus.item.custom.TerrestrialSawItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NexusMod.MOD_ID);


    public static final DeferredItem<Item> STEEL_INGOT =
            ITEMS.registerItem("steel_ingot", Item::new, new Item.Properties());



    public static final DeferredItem<Item> RAW_TERRESTRIAL =
            ITEMS.registerItem("raw_terrestrial", Item::new, new Item.Properties());

    public static final DeferredItem<Item> TERRESTRIAL_INGOT =
            ITEMS.registerItem("terrestrial_ingot", Item::new, new Item.Properties());




    public static final DeferredItem<Item> TERRESTRIAL_SAW =
            ITEMS.registerItem("terrestrial_saw", TerrestrialSawItem::new, new Item.Properties().durability(64));

    public static final DeferredItem<Item> TERRESTRIAL_FRUIT =
            ITEMS.registerItem("terrestrial_fruit", Item::new, new Item.Properties().food(ModFoodProperties.TERRESTRIAL_FRUIT));




    public static final DeferredItem<Item> TERRESTRIAL_COAL =
            ITEMS.registerItem("terrestrial_coal", properties -> new FuelItem(properties, 10000), new Item.Properties().food(ModFoodProperties.TERRESTRIAL_FRUIT));






    public static final DeferredItem<Item> RAW_NEXIUM =
            ITEMS.registerItem("raw_nexium", Item::new, new Item.Properties());




    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
