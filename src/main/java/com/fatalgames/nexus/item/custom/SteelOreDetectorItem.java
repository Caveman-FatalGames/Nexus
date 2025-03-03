package com.fatalgames.nexus.item.custom;

import com.fatalgames.nexus.component.FoundBlockData;
import com.fatalgames.nexus.component.ModDataComponentTypes;
import com.fatalgames.nexus.item.ModItems;
import com.fatalgames.nexus.block.ModBlocks;
import com.fatalgames.nexus.util.InventoryUtil;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SteelOreDetectorItem extends Item {
    public SteelOreDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            int searchRadius = 4; // 9x9 area
            int minY = pContext.getLevel().getMinBuildHeight(); // Bedrock level

            Set<BlockPos> foundOreClusters = new HashSet<>(); // Store unique ore cluster centers
            Set<BlockPos> visitedPositions = new HashSet<>(); // Track already checked positions

            for (int x = -searchRadius; x <= searchRadius; x++) {
                for (int z = -searchRadius; z <= searchRadius; z++) {
                    for (int y = positionClicked.getY(); y >= minY; y--) {
                        BlockPos scanPos = new BlockPos(positionClicked.getX() + x, y, positionClicked.getZ() + z);

                        if (visitedPositions.contains(scanPos)) continue; // Skip already checked blocks

                        BlockState blockState = pContext.getLevel().getBlockState(scanPos);

                        if (isValuableBlock(blockState)) {
                            // Check if this ore belongs to a nearby detected cluster
                            if (isNearCluster(foundOreClusters, scanPos, 3)) {
                                continue; // Skip adding duplicates from the same cluster
                            }

                            // Mark this as a new cluster
                            foundOreClusters.add(scanPos);
                            visitedPositions.add(scanPos);

                            outputValuableCoordinates(scanPos, player, blockState.getBlock());

                            if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.ORE_DATA_TABLET.get())) {
                                addDataToOreDataTablet(player, scanPos, blockState.getBlock());
                            }

                            foundBlock = true;
                        }
                    }
                }
            }

            if (!foundBlock) {
                outputNoValuableFound(player);
            } else {
                pContext.getLevel().playSeededSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ANVIL_STEP, SoundSource.BLOCKS, 1f, 1f, 0);
            }
        }

        return InteractionResult.SUCCESS;
    }




    private static final int MAX_SAVED_LOCATIONS = 5;

    private void addDataToOreDataTablet(Player player, BlockPos below, Block block) {
        ItemStack oreDataTablet = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.ORE_DATA_TABLET.get()));

        if (oreDataTablet.isEmpty()) {
            return; // No tablet found in inventory, exit
        }

        // Retrieve existing stored locations
        List<FoundBlockData> foundBlocks = oreDataTablet.get(ModDataComponentTypes.FOUND_BLOCKS.get());

        if (foundBlocks == null) {
            foundBlocks = new ArrayList<>();
        } else {
            foundBlocks = new ArrayList<>(foundBlocks); // Ensure it's mutable
        }

        // Check if this position is already stored to prevent duplicates
        boolean alreadyStored = foundBlocks.stream()
                .anyMatch(data -> data.position().equals(below));

        if (alreadyStored) {
            return; // Skip adding if already stored
        }

        // Add the new found block location
        foundBlocks.add(new FoundBlockData(block.defaultBlockState(), below));

        // Ensure we only keep the last 5 locations
        while (foundBlocks.size() > MAX_SAVED_LOCATIONS) {
            foundBlocks.remove(0); // Remove the oldest entry
        }

        // Save updated data back to the tablet
        oreDataTablet.set(ModDataComponentTypes.FOUND_BLOCKS.get(), foundBlocks);
    }



    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.nexus.metal_detector.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuable Found: " + I18n.get(block.getDescriptionId())
                + " at (" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(ModBlocks.STEEL_ORE) || blockState.is(ModBlocks.STEEL_DEEPSLATE_ORE);

    }

    private boolean isNearCluster(Set<BlockPos> foundOreClusters, BlockPos newPos, int clusterRadius) {
        for (BlockPos pos : foundOreClusters) {
            if (Math.abs(pos.getX() - newPos.getX()) <= clusterRadius &&
                    Math.abs(pos.getY() - newPos.getY()) <= clusterRadius &&
                    Math.abs(pos.getZ() - newPos.getZ()) <= clusterRadius) {
                return true; // If another ore is nearby, it's part of the same cluster
            }
        }
        return false;
    }
}
