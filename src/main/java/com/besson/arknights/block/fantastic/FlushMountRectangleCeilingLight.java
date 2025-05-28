package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.ModSwitchableLight;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FlushMountRectangleCeilingLight extends ModSwitchableLight {
    public FlushMountRectangleCeilingLight(Properties settings) {
        super(settings.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
    }
    private static final VoxelShape SHAPE_NS = Block.box(-16, 15, -8, 32, 16, 24);
    private static final VoxelShape SHAPE_WE = Block.box(-8, 15, -16, 24, 16, 32);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST, WEST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }
}
