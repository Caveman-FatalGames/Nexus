package com.fatalgames.nexus.datagen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;


public class ModItemModelProvider extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NexusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {



        basicItem(ModItems.POLYVINE_SEEDS.get());
        flowerItem(ModBlocks.TERRESTRIAL_FLOWER);

        basicItem(ModItems.PLASTIC_BALL.get());
        basicItem(ModItems.PLASTIC_SHEET.get());



        basicItem(ModItems.STEEL_DUST.get());
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.STEEL_NUTS_AND_BOLTS.get());
        basicItem(ModItems.STEEL_PLATE.get());

        buttonItem(ModBlocks.STEEL_BUTTON, ModBlocks.STEEL_BLOCK);
        fenceItem(ModBlocks.STEEL_FENCE, ModBlocks.STEEL_BLOCK);
        wallItem(ModBlocks.STEEL_WALL, ModBlocks.STEEL_BLOCK);
        basicItem(ModBlocks.STEEL_DOOR.asItem());


        basicItem(ModItems.STEEL_ORE_DETECTOR.get());
        basicItem(ModItems.ORE_DATA_TABLET.get());



        basicItem(ModItems.OBSIDIAN_ROD.get());
        basicItem(ModItems.NEXIUM_ROD.get());



        basicItem(ModItems.RAW_TERRESTRIAL.get());
        basicItem(ModItems.TERRESTRIAL_DUST.get());
        basicItem(ModItems.TERRESTRIAL_INGOT.get());


        handheldItem(ModItems.TERRESTRIAL_HOE.get());
        handheldItem(ModItems.TERRESTRIAL_SHOVEL.get());
        handheldItem(ModItems.TERRESTRIAL_PICKAXE.get());
        handheldItem(ModItems.TERRESTRIAL_AXE.get());


        handheldItem(ModItems.TERRESTRIAL_SAW.get());
        handheldItem(ModItems.TERRESTRIAL_PAXEL.get());
        handheldItem(ModItems.TERRESTRIAL_HAMMER.get());


        handheldItem(ModItems.TERRESTRIAL_SWORD.get());


        basicItem(ModItems.TERRESTRIAL_HELMET.get());
        basicItem(ModItems.TERRESTRIAL_CHESTPLATE.get());
        basicItem(ModItems.TERRESTRIAL_LEGGINGS.get());
        basicItem(ModItems.TERRESTRIAL_BOOTS.get());


        basicItem(ModItems.TERRESTRIAL_COAL.get());

        basicItem(ModItems.TERRESTRIAL_FRUIT.get());
        basicItem(ModItems.TERRESTRIAL_STEAK.get());


        basicItem(ModItems.RAW_NEXIUM.get());
        basicItem(ModItems.NEXIUM_DUST.get());
        basicItem(ModItems.NEXIUM_INGOT.get());
        basicItem(ModItems.NEXIUM_EYE.get());

        handheldItem(ModItems.NEXIUM_HAMMER.get());







    }

    public void flowerItem(DeferredBlock<Block> block) {
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,
                        "block/" + block.getId().getPath()));
    }


    private void trimmedArmorItem(DeferredItem<Item> itemDeferredItem) {
        final String MOD_ID = NexusMod.MOD_ID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }



    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(NexusMod.MOD_ID,"item/" + item.getId().getPath()));
    }

}
