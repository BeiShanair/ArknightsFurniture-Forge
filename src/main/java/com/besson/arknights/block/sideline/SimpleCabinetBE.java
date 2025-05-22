package com.besson.arknights.block.sideline;

import com.besson.arknights.block.ModAbstractContainerBE;
import com.besson.arknights.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleCabinetBE extends ModAbstractContainerBE {

    protected SimpleCabinetBE(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }
    public SimpleCabinetBE(BlockPos pos, BlockState state) {
        this(ModBlockEntities.SIMPLE_CABINET.get(), pos, state);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.simple_cabinet");
    }
}
