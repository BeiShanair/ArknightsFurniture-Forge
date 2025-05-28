package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UnknownBones extends FurnitureHorizontalFacingBlock {
    public static final VoxelShape SHAPE_N = Block.box(0, 0, 14, 16, 22, 16);
    public static final VoxelShape SHAPE_W = Block.box(14, 0, 0, 16, 22, 16);
    public static final VoxelShape SHAPE_S = Block.box(0, 0, 0, 16, 22, 2);
    public static final VoxelShape SHAPE_E = Block.box(0, 0, 0, 2, 22, 16);

    public UnknownBones(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case WEST -> SHAPE_W;
            case EAST -> SHAPE_E;
            case SOUTH -> SHAPE_S;
            default -> SHAPE_N;
        };
    }
}
