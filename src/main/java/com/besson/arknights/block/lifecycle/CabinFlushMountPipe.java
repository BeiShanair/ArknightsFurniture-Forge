package com.besson.arknights.block.lifecycle;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CabinFlushMountPipe extends FurnitureHorizontalFacingBlock {
    public CabinFlushMountPipe(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_NS = Shapes.join(
            Block.box(0, 14.35, 7.25, 16, 15.85, 8.75),
            Block.box(0, 11, 6.5, 16, 14, 9.5), BooleanOp.OR);
    private static final VoxelShape SHAPE_WE = Shapes.join(
            Block.box(7.25, 14.35, 0, 8.75, 15.85, 16),
            Block.box(6.5, 11, 0, 9.5, 14, 16), BooleanOp.OR);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case WEST, EAST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }
}
