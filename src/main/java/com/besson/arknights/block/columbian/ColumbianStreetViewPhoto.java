package com.besson.arknights.block.columbian;

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

public class ColumbianStreetViewPhoto extends FurnitureHorizontalFacingBlock {
    public ColumbianStreetViewPhoto(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(6, -5, 15, 19, 2, 16),
            Block.box(5, 2, 15, 12, 13, 16),
            Block.box(4, 13, 15, 10, 22, 16),
            Block.box(12, 6, 15, 23, 13, 16),
            Block.box(-7, 12, 15, 4, 19, 16),
            Block.box(10, 13, 15, 21, 20, 16),
            Block.box(-6, 0, 15, 5, 7, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(15, -5, -3, 16, 2, 10),
            Block.box(15, 2, 4, 16, 13, 11),
            Block.box(15, 13, 6, 16, 22, 12),
            Block.box(15, 6, -7, 16, 13, 4),
            Block.box(15, 12, 12, 16, 19, 23),
            Block.box(15, 13, -5, 16, 20, 6),
            Block.box(15, 0, 11, 16, 7, 22)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(-3, -5, 0, 10, 2, 1),
            Block.box(4, 2, 0, 11, 13, 1),
            Block.box(6, 13, 0, 12, 22, 1),
            Block.box(-7, 6, 0, 4, 13, 1),
            Block.box(12, 12, 0, 23, 19, 1),
            Block.box(-5, 13, 0, 6, 20, 1),
            Block.box(11, 0, 0, 22, 7, 1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(0, -5, 6, 1, 2, 19),
            Block.box(0, 2, 5, 1, 13, 12),
            Block.box(0, 13, 4, 1, 22, 10),
            Block.box(0, 6, 12, 1, 13, 23),
            Block.box(0, 12, -7, 1, 19, 4),
            Block.box(0, 13, 10, 1, 20, 21),
            Block.box(0, 0, -6, 1, 7, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;

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
