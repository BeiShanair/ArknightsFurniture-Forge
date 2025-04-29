package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DormitoryDoorFrames extends FurnitureHorizontalFacingBlock {
    public static final VoxelShape SHAPE_N = Shapes.join(
            Block.box(-3.45, 0, 13, -1, 32, 16),
            Block.box(17, 0, 13, 19.5, 32, 16), BooleanOp.OR);

    public static final VoxelShape SHAPE_W = Shapes.join(
            Block.box(13, 0, 17, 16, 32, 19.45),
            Block.box(13, 0, -3.5, 16, 32, -1), BooleanOp.OR);

    public static final VoxelShape SHAPE_S = Shapes.join(
            Block.box(17, 0, 0, 19.45, 32, 3),
            Block.box(-3.5, 0, 0, -1, 32, 3), BooleanOp.OR);

    public static final VoxelShape SHAPE_E = Shapes.join(
            Block.box(0, 0, -3.5, 3, 32, -1),
            Block.box(0, 0, 17, 3, 32, 19.5), BooleanOp.OR);

    public DormitoryDoorFrames(Properties pProperties) {
        super(pProperties);
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
