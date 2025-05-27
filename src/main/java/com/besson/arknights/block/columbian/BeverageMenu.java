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

public class BeverageMenu extends FurnitureHorizontalFacingBlock {
    public BeverageMenu(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Shapes.join(
            Block.box(0, 13, 15, 19, 25, 16),
            Block.box(-6, 0, 15, 13, 11, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_W = Shapes.join(
            Block.box(15, 13, -3, 16, 25, 16),
            Block.box(15, 0, 3, 16, 11, 22), BooleanOp.OR);
    private static final VoxelShape SHAPE_S = Shapes.join(
            Block.box(-3, 13, 0, 16, 25, 1),
            Block.box(3, 0, 0, 22, 11, 1), BooleanOp.OR);
    private static final VoxelShape SHAPE_E = Shapes.join(
            Block.box(0, 13, 0, 1, 25, 19),
            Block.box(0, 0, -6, 1, 11, 13), BooleanOp.OR);

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
