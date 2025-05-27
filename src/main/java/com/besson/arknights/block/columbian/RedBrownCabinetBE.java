package com.besson.arknights.block.columbian;

import com.besson.arknights.block.ModAbstractContainerBE;
import com.besson.arknights.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RedBrownCabinetBE extends ModAbstractContainerBE {

    protected RedBrownCabinetBE(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public RedBrownCabinetBE(BlockPos blockPos, BlockState blockState) {
        this(ModBlockEntities.RED_BROWN_CABINET.get(), blockPos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.red_brown_cabinet");
    }
}
