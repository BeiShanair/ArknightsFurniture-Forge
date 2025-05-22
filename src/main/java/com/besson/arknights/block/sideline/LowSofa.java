package com.besson.arknights.block.sideline;

import com.besson.arknights.block.SofaBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LowSofa extends SofaBlock {
    public LowSofa(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_NS = Block.box(0, 0, 2, 16, 14, 14);

    private static final VoxelShape SHAPE_WE = Block.box(2, 0, 0, 14, 14, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST, WEST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }
}
