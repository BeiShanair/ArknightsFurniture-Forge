package com.besson.arknights.block.sideline;

import com.besson.arknights.block.ModSwitchableLight;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WallLight extends ModSwitchableLight {
    public WallLight(Properties settings) {
        super(settings.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
    }
    private static final VoxelShape SHAPE_N = Block.box(1, 6, 12, 15, 10, 16);
    private static final VoxelShape SHAPE_W = Block.box(12, 6, 1, 16, 10, 15);
    private static final VoxelShape SHAPE_S = Block.box(1, 6, 0, 15, 10, 4);
    private static final VoxelShape SHAPE_E = Block.box(0, 6, 1, 4, 10, 15);

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
