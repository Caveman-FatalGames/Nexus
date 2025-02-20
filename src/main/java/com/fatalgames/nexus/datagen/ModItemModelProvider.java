package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_TERRESTRIAL.get());

        basicItem(ModItems.TERRESTRIAL_COAL.get());
        basicItem(ModItems.TERRESTRIAL_FRUIT.get());
        basicItem(ModItems.TERRESTRIAL_INGOT.get());
        basicItem(ModItems.TERRESTRIAL_SAW.get());


        basicItem(ModItems.RAW_NEXIUM.get());
        basicItem(ModItems.NEXIUM_DUST.get());


        basicItem(ModItems.STEEL_INGOT.get());

    }
}
