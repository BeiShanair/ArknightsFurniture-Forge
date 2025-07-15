package com.besson.arknights.block.lifecycle;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DiyWorkbench extends FurnitureHorizontalFacingBlock {
    public DiyWorkbench(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_NS = Block.box(-16, 0, -8, 32, 18, 24);
    private static final VoxelShape SHAPE_WE = Block.box(-8, 0, -16, 24, 18, 32);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case WEST, EAST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }
}
