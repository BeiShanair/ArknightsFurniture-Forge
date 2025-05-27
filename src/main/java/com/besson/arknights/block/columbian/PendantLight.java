package com.besson.arknights.block.columbian;

import com.besson.arknights.block.ModSwitchableLight;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class PendantLight extends ModSwitchableLight {
    public PendantLight(Properties settings) {
        super(settings.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
    }
    private static final VoxelShape SHAPE = Stream.of(
            Block.box(6.7, 0, 6.7, 9.3, 1, 9.3),
            Block.box(6.7, 3, 6.7, 9.3, 4, 9.3),
            Block.box(6, 1, 6, 10, 3, 10),
            Block.box(7.5, 4, 7.5, 8.5, 16, 8.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
