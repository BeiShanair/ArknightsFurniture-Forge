package com.besson.arknights.block.lifecycle;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CabinFireExtinguisherKit extends FurnitureHorizontalFacingBlock {
    public CabinFireExtinguisherKit(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(1, 0, 9, 15, 21, 16);
    private static final VoxelShape SHAPE_W = Block.box(9, 0, 1, 16, 21, 15);
    private static final VoxelShape SHAPE_S = Block.box(1, 0, 0, 15, 21, 7);
    private static final VoxelShape SHAPE_E = Block.box(0, 0, 1, 7, 21, 15);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case WEST -> SHAPE_W;
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }
}
