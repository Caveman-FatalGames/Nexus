package com.fatalgames.nexus.item.custom;

import com.fatalgames.nexus.component.FoundBlockData;
import com.fatalgames.nexus.component.ModDataComponentTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class OreDataTabletItem extends Item {
    public OreDataTabletItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        // Ensure we only process the MAIN HAND to prevent duplicates
        if (pLevel.isClientSide() || pUsedHand != InteractionHand.MAIN_HAND) {
            return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
        }

        ItemStack tablet = pPlayer.getItemInHand(pUsedHand);

        if (pPlayer.isShiftKeyDown()) {
            // Sneaking: Clear stored locations
            tablet.set(ModDataComponentTypes.FOUND_BLOCKS.get(), List.of());
            if (!pLevel.isClientSide()) {
                pPlayer.sendSystemMessage(Component.literal("Cleared all stored ore locations."));
            }
        } else {
            // Not sneaking: Show stored locations
            List<FoundBlockData> foundBlocks = tablet.get(ModDataComponentTypes.FOUND_BLOCKS.get());

            if (foundBlocks == null || foundBlocks.isEmpty()) {
                if (!pLevel.isClientSide()) {
                    pPlayer.sendSystemMessage(Component.literal("No stored ore locations."));
                }
            } else {
                if (!pLevel.isClientSide()) {
                    pPlayer.sendSystemMessage(Component.literal("Stored Ore Locations:"));
                    for (int i = 0; i < foundBlocks.size(); i++) {
                        pPlayer.sendSystemMessage(Component.literal((i + 1) + ": " + foundBlocks.get(i).getOutputString()));
                    }
                }
            }
        }

        return InteractionResultHolder.success(tablet);
    }





    @Override
    public boolean isFoil(ItemStack pStack) {
        List<FoundBlockData> foundBlocks = pStack.get(ModDataComponentTypes.FOUND_BLOCKS.get());
        return foundBlocks != null && !foundBlocks.isEmpty(); // Only glow if locations are stored
    }


    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        List<FoundBlockData> foundBlocks = pStack.get(ModDataComponentTypes.FOUND_BLOCKS.get());

        if (foundBlocks != null && !foundBlocks.isEmpty()) {
            pTooltipComponents.add(Component.literal("Stored Ore Locations:"));
            for (int i = 0; i < foundBlocks.size(); i++) {
                FoundBlockData data = foundBlocks.get(i);
                pTooltipComponents.add(Component.literal((i + 1) + ": " + data.getOutputString()));
            }
        } else {
            pTooltipComponents.add(Component.literal("No stored locations."));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}