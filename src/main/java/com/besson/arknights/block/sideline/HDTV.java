package com.besson.arknights.block.sideline;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class HDTV extends FurnitureHorizontalFacingBlock {
    public HDTV(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(2, 0, 9, 14, 1, 16),
            Block.box(7, 1, 14, 9, 5, 16),
            Block.box(-10, 2, 13, 26, 19, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(9, 0, 2, 16, 1, 14),
            Block.box(14, 1, 7, 16, 5, 9),
            Block.box(13, 2, -10, 14, 19, 26)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(2, 0, 0, 14, 1, 7),
            Block.box(7, 1, 0, 9, 5, 2),
            Block.box(-10, 2, 2, 26, 19, 3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(0, 0, 2, 7, 1, 14),
            Block.box(0, 1, 7, 2, 5, 9),
            Block.box(2, 2, -10, 3, 19, 26)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

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
