package com.besson.arknights.block.lifecycle;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ControlDisplay extends FurnitureHorizontalFacingBlock {
    public ControlDisplay(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(-14, 9, 13.5, 30, 32, 15.5);
    private static final VoxelShape SHAPE_S = Block.box(-14, 9, 0.5, 30, 32, 2.5);
    private static final VoxelShape SHAPE_W = Block.box(13.5, 9, -14, 15.5, 32, 30);
    private static final VoxelShape SHAPE_E = Block.box(0.5, 9, -14, 2.5, 32, 30);

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
