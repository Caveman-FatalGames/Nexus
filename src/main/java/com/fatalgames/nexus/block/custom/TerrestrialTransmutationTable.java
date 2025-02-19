package com.fatalgames.nexus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TerrestrialTransmutationTable extends Block {
    public TerrestrialTransmutationTable(Properties properties){
        super(properties);
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(Items.COAL, itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(Items.SAND);
    }

}
