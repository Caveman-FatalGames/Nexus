package com.fatalgames.nexus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class TerrestrialLightBlock extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public TerrestrialLightBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if(!pLevel.isClientSide()) {
            boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlock(pPos, pState.setValue(CLICKED, !currentState), 3);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CLICKED);
    }
}
