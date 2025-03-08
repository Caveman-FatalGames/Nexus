package com.fatalgames.nexus.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

public class TerrestrialSawItem extends Item {
    private static final int MAX_LOGS = 16; // Maximum logs to break

    public TerrestrialSawItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!(pContext.getPlayer() instanceof ServerPlayer player)) {
            return InteractionResult.PASS; // Ignore on client side
        }

        if (!level.isClientSide() && player != null) {
            BlockPos startPos = pContext.getClickedPos();
            BlockState startBlock = level.getBlockState(startPos);

            if (startBlock.is(BlockTags.LOGS)) {
                int logsBroken = breakLogs((ServerLevel) level, startPos, player, pContext.getItemInHand());

                // If at least one log was broken, consume durability
                if (logsBroken > 0) {
                    pContext.getItemInHand().hurtAndBreak(logsBroken, player, EquipmentSlot.MAINHAND);
                }
            }
        }

        return InteractionResult.CONSUME;
    }

    /**
     * Finds and breaks up to MAX_LOGS connected logs.
     */
    private int breakLogs(ServerLevel level, BlockPos startPos, ServerPlayer player, ItemStack tool) {
        Queue<BlockPos> queue = new LinkedList<>();
        Set<BlockPos> visited = new HashSet<>();
        int logsBroken = 0;

        queue.add(startPos);
        visited.add(startPos);

        while (!queue.isEmpty() && logsBroken < MAX_LOGS) {
            BlockPos currentPos = queue.poll();
            BlockState currentState = level.getBlockState(currentPos);

            if (currentState.is(BlockTags.LOGS)) {
                level.destroyBlock(currentPos, true, player);
                logsBroken++;

                for (BlockPos offset : getNeighborOffsets()) {
                    BlockPos neighborPos = currentPos.offset(offset);
                    if (!visited.contains(neighborPos) && level.getBlockState(neighborPos).is(BlockTags.LOGS)) {
                        queue.add(neighborPos);
                        visited.add(neighborPos);
                    }
                }
            }
        }

        return logsBroken;
    }

    /**
     * Returns the 6 possible neighbor positions (Up, Down, North, South, East, West)
     */
    private List<BlockPos> getNeighborOffsets() {
        return Arrays.asList(
                new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0),
                new BlockPos(0, 1, 0), new BlockPos(0, -1, 0),
                new BlockPos(0, 0, 1), new BlockPos(0, 0, -1)
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.nexus.terrestrial_saw.tooltip.1"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.nexus.terrestrial_saw.shift"));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
