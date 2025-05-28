package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UnknownSpecimens extends FurnitureHorizontalFacingBlock {
    public static final VoxelShape SHAPE_N = Block.box(-7.66, -10.48, 14, 23.66, 31.18, 15.74);
    public static final VoxelShape SHAPE_W = Block.box(14, -10.48, -7.66, 15.74, 31.18, 23.66);
    public static final VoxelShape SHAPE_S = Block.box(-7.66, -10.48, 0.26, 23.66, 31.18, 2);
    public static final VoxelShape SHAPE_E = Block.box(0.26, -10.48, -7.66, 2, 31.18, 23.66);
    public UnknownSpecimens(Properties settings) {
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
