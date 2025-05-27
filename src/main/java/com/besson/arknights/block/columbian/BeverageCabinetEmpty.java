package com.besson.arknights.block.columbian;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BeverageCabinetEmpty extends FurnitureHorizontalFacingBlock {
    public BeverageCabinetEmpty(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(-1.95, 0, 5, 17.9, 19.75, 15.9);
    private static final VoxelShape SHAPE_W = Block.box(5, 0, -1.9, 15.9, 19.75, 17.95);
    private static final VoxelShape SHAPE_S = Block.box(-1.9, 0, 0.1, 17.95, 19.75, 11);
    private static final VoxelShape SHAPE_E = Block.box(0.1, 0, -1.95, 11, 19.75, 17.9);

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
