package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.ModSwitchableLight;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FlushMountSquareCeilingLight extends ModSwitchableLight {
    public FlushMountSquareCeilingLight(Properties settings) {
        super(settings.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
    }
    private static final VoxelShape SHAPE = Block.box(-8, 15, -8, 24, 16, 24);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
