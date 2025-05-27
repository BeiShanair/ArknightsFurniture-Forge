package com.besson.arknights.block.columbian;

import com.besson.arknights.block.ModSwitchableLight;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SoftCeilingLight extends ModSwitchableLight {
    public SoftCeilingLight(Properties settings) {
        super(settings.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
    }
    private static final VoxelShape SHAPE = Block.box(0, 14, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
