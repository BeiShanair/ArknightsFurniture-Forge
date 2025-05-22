package com.besson.arknights.block.sideline;

import com.besson.arknights.block.ModAbstractContainerBE;
import com.besson.arknights.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NightstandBE extends ModAbstractContainerBE {

    protected NightstandBE(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }
    public NightstandBE(BlockPos pos, BlockState state) {
        this(ModBlockEntities.NIGHTSTAND.get(), pos, state);
    }


    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.nightstand");
    }
}
