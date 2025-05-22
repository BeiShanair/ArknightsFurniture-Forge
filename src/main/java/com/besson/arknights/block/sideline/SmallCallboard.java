package com.besson.arknights.block.sideline;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmallCallboard extends FurnitureHorizontalFacingBlock {
    public SmallCallboard(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(-16, 0, 15.1, 32, 32, 16);
    private static final VoxelShape SHAPE_W = Block.box(15.1, 0, -16, 16, 32, 32);
    private static final VoxelShape SHAPE_S = Block.box(-16, 0, 0, 32, 32, 0.9);
    private static final VoxelShape SHAPE_E = Block.box(0, 0, -16, 0.9, 32, 32);

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
