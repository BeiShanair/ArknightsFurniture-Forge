package com.besson.arknights.block.sideline;

import com.besson.arknights.block.ModSwitchableLight;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CeilingLight extends ModSwitchableLight {
    public CeilingLight(Properties settings) {
        super(settings.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
    }

    private static final VoxelShape SHAPE = Block.box(6, 15.625, 6, 10, 16, 10);

    @Override
    public net.minecraft.world.phys.shapes.VoxelShape getShape(net.minecraft.world.level.block.state.BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
