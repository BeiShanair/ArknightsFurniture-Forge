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

public class SquareTable extends FurnitureHorizontalFacingBlock {
    public SquareTable(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_NS = Stream.of(
            Block.box(-16, 14, 0, 32, 16, 16),
            Block.box(-16, 0, 0, 32, 2, 16),
            Block.box(-16, 2, 0, -14, 14, 16),
            Block.box(30, 2, 0, 32, 14, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_WE = Stream.of(
            Block.box(0, 14, -16, 16, 16, 32),
            Block.box(0, 0, -16, 16, 2, 32),
            Block.box(0, 2, 30, 16, 14, 32),
            Block.box(0, 2, -16, 16, 14, -14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST, WEST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }
}
