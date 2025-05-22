package com.besson.arknights.block.sideline;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SimpleClock extends FurnitureHorizontalFacingBlock {
    public SimpleClock(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(3, 3, 15, 13, 13, 16);
    private static final VoxelShape SHAPE_W = Block.box(15, 3, 3, 16, 13, 13);
    private static final VoxelShape SHAPE_S = Block.box(3, 3, 0, 13, 13, 1);
    private static final VoxelShape SHAPE_E = Block.box(0, 3, 3, 1, 13, 13);


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)){
            case WEST -> SHAPE_W;
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }
}
