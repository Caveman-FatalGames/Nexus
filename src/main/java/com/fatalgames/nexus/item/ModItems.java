package com.fatalgames.nexus.item;

import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.item.custom.OreDataTabletItem;
import com.fatalgames.nexus.item.custom.SteelOreDetectorItem;
import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.item.custom.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NexusMod.MOD_ID);


    // RANDOM ITEMS //

    public static final DeferredItem<Item> OBSIDIAN_ROD =
            ITEMS.registerItem("obsidian_rod", Item::new, new Item.Properties());

    public static final DeferredItem<Item> ORE_DATA_TABLET = ITEMS.register("ore_data_tablet",
            () -> new OreDataTabletItem(new Item.Properties().stacksTo(1)));


    // PLASTIC ITEMS //

    public static final DeferredItem<Item> POLYVINE_SEEDS = ITEMS.register("polyvine_seeds",
            () -> new ItemNameBlockItem(ModBlocks.POLYVINE.get(), new Item.Properties()));

    public static final DeferredItem<Item> POLYVINE =
            ITEMS.registerItem("polyvine", Item::new, new Item.Properties());

    public static final DeferredItem<Item> POLYMER =
            ITEMS.registerItem("polymer", Item::new, new Item.Properties());

    public static final DeferredItem<Item> PLASTIC_BALL =
            ITEMS.registerItem("plastic_ball", Item::new, new Item.Properties());

    public static final DeferredItem<Item> PLASTIC_SHEET =
            ITEMS.registerItem("plastic_sheet", Item::new, new Item.Properties());


    // STEEL ITEMS //

    public static final DeferredItem<Item> RAW_STEEL =
            ITEMS.registerItem("raw_steel", Item::new, new Item.Properties());

    public static final DeferredItem<Item> STEEL_DUST =
            ITEMS.registerItem("steel_dust", Item::new, new Item.Properties());

    public static final DeferredItem<Item> STEEL_INGOT =
            ITEMS.registerItem("steel_ingot", Item::new, new Item.Properties());

    public static final DeferredItem<Item> STEEL_NUTS_AND_BOLTS =
            ITEMS.registerItem("steel_nuts_and_bolts", Item::new, new Item.Properties());

    public static final DeferredItem<Item> STEEL_PLATE =
            ITEMS.registerItem("steel_plate", Item::new, new Item.Properties());


    // STEEL TOOLS, WEAPONS AND ARMOR //

    public static final DeferredItem<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModToolTiers.STEEL,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STEEL, -1.2f, 0f))));

    public static final DeferredItem<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModToolTiers.STEEL,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STEEL, 3.3f, -3.1f))));

    public static final DeferredItem<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModToolTiers.STEEL,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STEEL, 6.8f, -3f))));

    public static final DeferredItem<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 2.8f, -2.8f))));

    public static final DeferredItem<Item> STEEL_PAXEL = ITEMS.register("steel_paxel",
            () -> new PaxelItem(ModToolTiers.STEEL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 3.2f, -2.5f))));

    public static final DeferredItem<Item> STEEL_HAMMER = ITEMS.register("steel_hammer",
            () -> new HammerItem(ModToolTiers.STEEL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 2.8f, -2.9f))));

    public static final DeferredItem<Item> STEEL_SAW =
            ITEMS.registerItem("steel_saw", SteelSawItem::new, new Item.Properties().durability(320));

    public static final DeferredItem<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new ModEffectSwordItem(ModToolTiers.STEEL,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 4.7f, -2.4f)), MobEffects.MOVEMENT_SLOWDOWN));

    public static final DeferredItem<Item> STEEL_BOW = ITEMS.register("steel_bow",
            () -> new BowItem(new Item.Properties().durability(400)));

    public static final DeferredItem<Item> STEEL_ORE_DETECTOR = ITEMS.register("steel_ore_detector",
            () -> new SteelOreDetectorItem(new Item.Properties().durability(100)));


    // TERRESTRIAL ITEMS //

    public static final DeferredItem<Item> RAW_TERRESTRIAL =
            ITEMS.registerItem("raw_terrestrial", Item::new, new Item.Properties());

    public static final DeferredItem<Item> TERRESTRIAL_DUST =
            ITEMS.registerItem("terrestrial_dust", Item::new, new Item.Properties());

    public static final DeferredItem<Item> TERRESTRIAL_INGOT =
            ITEMS.registerItem("terrestrial_ingot", Item::new, new Item.Properties());


    // TERRESTRIAL TOOLS, WEAPONS AND ARMOR //

    public static final DeferredItem<Item> TERRESTRIAL_HOE = ITEMS.register("terrestrial_hoe",
            () -> new HoeItem(ModToolTiers.TERRESTRIAL,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.TERRESTRIAL, -1.5f, 0f))));

    public static final DeferredItem<Item> TERRESTRIAL_SHOVEL = ITEMS.register("terrestrial_shovel",
            () -> new ShovelItem(ModToolTiers.TERRESTRIAL,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.TERRESTRIAL, 3.5f, -3f))));

    public static final DeferredItem<Item> TERRESTRIAL_AXE = ITEMS.register("terrestrial_axe",
            () -> new AxeItem(ModToolTiers.TERRESTRIAL,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.TERRESTRIAL, 7f, -2.8f))));

    public static final DeferredItem<Item> TERRESTRIAL_PICKAXE = ITEMS.register("terrestrial_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TERRESTRIAL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.TERRESTRIAL, 3f, -2.5f))));

    public static final DeferredItem<Item> TERRESTRIAL_PAXEL = ITEMS.register("terrestrial_paxel",
            () -> new PaxelItem(ModToolTiers.TERRESTRIAL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.TERRESTRIAL, 3.5f, -2.2f))));

    public static final DeferredItem<Item> TERRESTRIAL_HAMMER = ITEMS.register("terrestrial_hammer",
            () -> new HammerItem(ModToolTiers.TERRESTRIAL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.TERRESTRIAL, 3f, -2.7f))));

    public static final DeferredItem<Item> TERRESTRIAL_SAW =
            ITEMS.registerItem("terrestrial_saw", TerrestrialSawItem::new, new Item.Properties().durability(640));

    public static final DeferredItem<Item> TERRESTRIAL_SWORD = ITEMS.register("terrestrial_sword",
            () -> new ModEffectSwordItem(ModToolTiers.TERRESTRIAL,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.TERRESTRIAL, 5, -2.2f)), MobEffects.POISON));

    public static final DeferredItem<Item> TERRESTRIAL_HELMET = ITEMS.register("terrestrial_helmet",
            () -> new ModArmorItem(ModArmorMaterials.TERRESTRIAL_INGOT, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))));

    public static final DeferredItem<Item> TERRESTRIAL_CHESTPLATE = ITEMS.register("terrestrial_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TERRESTRIAL_INGOT, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));

    public static final DeferredItem<Item> TERRESTRIAL_LEGGINGS = ITEMS.register("terrestrial_leggings",
            () -> new ArmorItem(ModArmorMaterials.TERRESTRIAL_INGOT, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(16))));

    public static final DeferredItem<Item> TERRESTRIAL_BOOTS = ITEMS.register("terrestrial_boots",
            () -> new ArmorItem(ModArmorMaterials.TERRESTRIAL_INGOT, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(16))));






    public static final DeferredItem<Item> TERRESTRIAL_FRUIT =
            ITEMS.registerItem("terrestrial_fruit", Item::new, new Item.Properties().food(ModFoodProperties.TERRESTRIAL_FRUIT));

    public static final DeferredItem<Item> TERRESTRIAL_STEAK =
            ITEMS.registerItem("terrestrial_steak", Item::new, new Item.Properties().food(ModFoodProperties.TERRESTRIAL_STEAK));




    public static final DeferredItem<Item> TERRESTRIAL_COAL =
            ITEMS.registerItem("terrestrial_coal", properties -> new FuelItem(properties, 10000), new Item.Properties().food(ModFoodProperties.TERRESTRIAL_FRUIT));




    // NEXIUM ITEMS //

    public static final DeferredItem<Item> NEXIUM_ROD =
            ITEMS.registerItem("nexium_rod", Item::new, new Item.Properties());

    public static final DeferredItem<Item> NEXIUM_EYE =
            ITEMS.registerItem("nexium_eye", Item::new, new Item.Properties());

    public static final DeferredItem<Item> RAW_NEXIUM =
            ITEMS.registerItem("raw_nexium", Item::new, new Item.Properties());

    public static final DeferredItem<Item> NEXIUM_DUST =
            ITEMS.registerItem("nexium_dust", Item::new, new Item.Properties());

    public static final DeferredItem<Item> NEXIUM_INGOT =
            ITEMS.registerItem("nexium_ingot", Item::new, new Item.Properties());


    public static final DeferredItem<Item> NEXIUM_HAMMER = ITEMS.register("nexium_hammer",
            () -> new HammerItem(ModToolTiers.NEXIUM,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.NEXIUM, 5f, -1.5f))));







    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}

