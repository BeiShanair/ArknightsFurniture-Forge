package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.ModSwitchableLight;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CeilingRowLight extends ModSwitchableLight {

    public static final VoxelShape SHAPE_N = Block.box(-15.75, 14, 14, 15.75, 16, 15.95);

    public static final VoxelShape SHAPE_W = Block.box(14, 14, 0.25, 15.95, 16, 31.75);

    public static final VoxelShape SHAPE_S = Block.box(0.25, 14, 0.05, 31.75, 16, 2);

    public static final VoxelShape SHAPE_E = Block.box(0.05, 14, -15.75, 2, 16, 15.75);

    public CeilingRowLight(Properties pProperties) {
        super(pProperties.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
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
