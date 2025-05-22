package com.besson.arknights.block.sideline;

import com.besson.arknights.block.ModAbstractContainerBE;
import com.besson.arknights.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CheckerboardBookcaseBE extends ModAbstractContainerBE {

    protected CheckerboardBookcaseBE(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }
    public CheckerboardBookcaseBE(BlockPos pos, BlockState state) {
        this(ModBlockEntities.CHECKERBOARD_BOOKCASE.get(), pos, state);
    }
    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.checkerboard_bookcase");
    }
}
