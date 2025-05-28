package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WireSideTable extends FurnitureHorizontalFacingBlock {
    public WireSideTable(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Block.box(6, 0, 6, 26, 20, 26);
    private static final VoxelShape SHAPE_S = Block.box(-10, 0, -10, 10, 20, 10);
    private static final VoxelShape SHAPE_W = Block.box(6, 0, -10, 26, 20, 10);
    private static final VoxelShape SHAPE_E = Block.box(-10, 0, 6, 10, 20, 26);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }
}
