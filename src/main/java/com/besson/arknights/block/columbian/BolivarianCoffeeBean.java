package com.besson.arknights.block.columbian;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BolivarianCoffeeBean extends FurnitureHorizontalFacingBlock {
    public BolivarianCoffeeBean(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(0, 0, 13, 16, 24, 16);
    private static final VoxelShape SHAPE_W = Block.box(13, 0, 0, 16, 24, 16);
    private static final VoxelShape SHAPE_S = Block.box(0, 0, 0, 16, 24, 3);
    private static final VoxelShape SHAPE_E = Block.box(0, 0, 0, 3, 24, 16);

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
