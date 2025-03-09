package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.block.custom.PolyvineCropBlock;
import com.fatalgames.nexus.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());

        this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        this.dropSelf(ModBlocks.EBONY_SAPLING.get());

        this.add(ModBlocks.EBONY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));


        dropSelf(ModBlocks.EBONY_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.EBONY_BUTTON.get());
        dropSelf(ModBlocks.EBONY_FENCE.get());
        dropSelf(ModBlocks.EBONY_FENCE_GATE.get());
        dropSelf(ModBlocks.EBONY_WALL.get());
        dropSelf(ModBlocks.EBONY_TRAPDOOR.get());
        this.add(ModBlocks.EBONY_DOOR.get(),
                block -> createDoorTable(ModBlocks.EBONY_DOOR.get()));
        dropSelf(ModBlocks.EBONY_STAIRS.get());
        this.add(ModBlocks.EBONY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.EBONY_SLAB.get()));



        this.add(ModBlocks.STEEL_ORE.get(),
                block -> createOreDrop(ModBlocks.STEEL_ORE.get(), ModItems.STEEL_DUST.get()));
        this.add(ModBlocks.STEEL_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.STEEL_DEEPSLATE_ORE.get(), ModItems.STEEL_DUST.get(), 2, 3));


        dropSelf(ModBlocks.STEEL_LIGHT_BLOCK.get());
        dropSelf(ModBlocks.STEEL_GLASS.get());
        dropSelf(ModBlocks.STEEL_BLOCK.get());
        dropSelf(ModBlocks.STEEL_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.STEEL_BUTTON.get());
        dropSelf(ModBlocks.STEEL_FENCE.get());
        dropSelf(ModBlocks.STEEL_FENCE_GATE.get());
        dropSelf(ModBlocks.STEEL_WALL.get());
        dropSelf(ModBlocks.STEEL_TRAPDOOR.get());
        this.add(ModBlocks.STEEL_DOOR.get(),
                block -> createDoorTable(ModBlocks.STEEL_DOOR.get()));
        dropSelf(ModBlocks.STEEL_STAIRS.get());
        this.add(ModBlocks.STEEL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STEEL_SLAB.get()));


        dropSelf(ModBlocks.STEEL_PEDESTAL.get());
        dropSelf(ModBlocks.STEEL_FORGE.get());
        dropSelf(ModBlocks.STEEL_GENERATOR.get());
        dropSelf(ModBlocks.STEEL_TANK.get());



        dropSelf(ModBlocks.TERRESTRIAL_BLOCK.get());
        dropSelf(ModBlocks.TERRESTRIAL_GLASS.get());
        dropSelf(ModBlocks.TERRESTRIAL_LIGHT_BLOCK.get());
        dropSelf(ModBlocks.TERRESTRIAL_TRANSMUTATION_TABLE.get());





        this.add(ModBlocks.TERRESTRIAL_ORE.get(),
                block -> createOreDrop(ModBlocks.TERRESTRIAL_ORE.get(), ModItems.RAW_TERRESTRIAL.get()));
        this.add(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.TERRESTRIAL_DEEPSLATE_ORE.get(), ModItems.RAW_TERRESTRIAL.get(), 2, 3));





        this.add(ModBlocks.NEXIUM_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.NEXIUM_BLOCK.get(), ModItems.RAW_NEXIUM.get(), 1, 2));

        this.add(ModBlocks.METEORITE_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.METEORITE_BLOCK.get(), ModItems.NEXIUM_DUST.get(), 2, 3));



        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.POLYVINE.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PolyvineCropBlock.AGE, 5));

        this.add(ModBlocks.POLYVINE.get(), block ->
                applyExplosionDecay(block, LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .add(LootItem.lootTableItem(ModItems.POLYVINE.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))) // 1-4 Polyvine
                                                .when(lootItemConditionBuilder))
                                        .add(LootItem.lootTableItem(ModItems.POLYMER.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))) // 1-2 Polymer
                                                .when(lootItemConditionBuilder))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .add(LootItem.lootTableItem(ModItems.POLYVINE_SEEDS.get())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))) // Always 2 Seeds
                                                .when(lootItemConditionBuilder))
                        )
                )
        );


        this.dropSelf(ModBlocks.TERRESTRIAL_FLOWER.get());
        this.add(ModBlocks.POTTED_TERRESTRIAL_FLOWER.get(), createPotFlowerItemTable(ModBlocks.TERRESTRIAL_FLOWER));



    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
