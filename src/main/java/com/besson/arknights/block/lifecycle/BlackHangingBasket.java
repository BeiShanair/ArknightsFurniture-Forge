package com.besson.arknights.block.lifecycle;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlackHangingBasket extends FurnitureHorizontalFacingBlock {
    public BlackHangingBasket(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(5, 0, 12.75, 11, 13, 16);
    private static final VoxelShape SHAPE_W = Block.box(12.75, 0, 5, 16, 13, 11);
    private static final VoxelShape SHAPE_S = Block.box(5, 0, 0, 11, 13, 3.25);
    private static final VoxelShape SHAPE_E = Block.box(0, 0, 5, 3.25, 13, 11);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case WEST -> SHAPE_W;
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }
}
