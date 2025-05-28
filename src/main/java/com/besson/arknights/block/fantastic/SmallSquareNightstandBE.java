package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.ModAbstractContainerBE;
import com.besson.arknights.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SmallSquareNightstandBE extends ModAbstractContainerBE {

    protected SmallSquareNightstandBE(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }
    public SmallSquareNightstandBE(BlockPos pos, BlockState state) {
        this(ModBlockEntities.SMALL_SQUARE_NIGHTSTAND.get(), pos, state);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.small_square_nightstand");
    }
}
