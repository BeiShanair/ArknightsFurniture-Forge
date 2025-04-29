package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PileOfCartons extends FurnitureHorizontalFacingBlock {
    private static final VoxelShape SHAPE_NS = Block.box(-16, 0, -4, 32, 20, 20);
    private static final VoxelShape SHAPE_WE = Block.box(-4, 0, -16, 20, 20, 32);

    public PileOfCartons(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST, WEST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }
}
