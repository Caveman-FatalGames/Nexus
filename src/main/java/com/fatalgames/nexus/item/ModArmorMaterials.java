package com.fatalgames.nexus.item;

import com.fatalgames.nexus.NexusMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, NexusMod.MOD_ID);

    public static final Holder<ArmorMaterial> TERRESTRIAL_INGOT =
            ARMOR_MATERIALS.register("terrestrial_ingot", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 4);
                    }), 20, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(ModItems.TERRESTRIAL_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID, "terrestrial"))),
                    0, 0));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
