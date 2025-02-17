package com.fatalgames.nexus.item;

import com.fatalgames.nexus.NexusMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NexusMod.MOD_ID);


    public static final DeferredItem<Item> RAW_TERRESTRIAL =
            ITEMS.registerItem("raw_terrestrial", Item::new, new Item.Properties());





    public static final DeferredItem<Item> RAW_NEXIUM =
            ITEMS.registerItem("raw_nexium", Item::new, new Item.Properties());




    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
