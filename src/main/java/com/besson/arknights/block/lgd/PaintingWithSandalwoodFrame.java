package com.besson.arknights.block.lgd;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PaintingWithSandalwoodFrame extends FurnitureHorizontalFacingBlock {
    public PaintingWithSandalwoodFrame(Properties settings) {
        super(settings);
    }
    public static final VoxelShape SHAPE_N = Block.box(0, 0, 15, 16, 29, 16);
    public static final VoxelShape SHAPE_W = Block.box(15, 0, 0, 16, 29, 16);
    public static final VoxelShape SHAPE_S = Block.box(0, 0, 0, 16, 29, 1);
    public static final VoxelShape SHAPE_E = Block.box(0, 0, 0, 1, 29, 16);

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
