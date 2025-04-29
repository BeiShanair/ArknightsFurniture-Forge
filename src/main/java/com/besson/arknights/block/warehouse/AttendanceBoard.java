package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AttendanceBoard extends FurnitureHorizontalFacingBlock {
    private static final VoxelShape SHAPE_N = Block.box(-16, 0, 14, 32, 32, 16);
    private static final VoxelShape SHAPE_S = Block.box(-16, 0, 0, 32, 32, 2);
    private static final VoxelShape SHAPE_W = Block.box(14, 0, -16, 16, 32, 32);
    private static final VoxelShape SHAPE_E = Block.box(0, 0, -16, 2, 32, 32);

    public AttendanceBoard(Properties pProperties) {
        super(pProperties);
    }

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
