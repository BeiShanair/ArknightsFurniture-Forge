package com.besson.arknights.block.lifecycle;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NoteBoardInCabinDisplay extends FurnitureHorizontalFacingBlock {
    public NoteBoardInCabinDisplay(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(1, 1, 15, 15, 15, 16);
    private static final VoxelShape SHAPE_S = Block.box(1, 1, 0, 15, 15, 1);
    private static final VoxelShape SHAPE_W = Block.box(15, 1, 1, 16, 15, 15);
    private static final VoxelShape SHAPE_E = Block.box(0, 1, 1, 1, 15, 15);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }
}
