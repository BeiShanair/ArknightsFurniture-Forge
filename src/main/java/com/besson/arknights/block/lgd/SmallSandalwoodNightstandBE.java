package com.besson.arknights.block.lgd;

import com.besson.arknights.block.ModAbstractContainerBE;
import com.besson.arknights.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SmallSandalwoodNightstandBE extends ModAbstractContainerBE {

    protected SmallSandalwoodNightstandBE(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }
    public SmallSandalwoodNightstandBE(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.SMALL_SANDALWOOD_NIGHTSTAND.get(), blockPos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.small_sandalwood_nightstand");
    }
}
