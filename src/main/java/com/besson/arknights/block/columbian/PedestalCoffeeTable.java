package com.besson.arknights.block.columbian;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class PedestalCoffeeTable extends FurnitureHorizontalFacingBlock {
    public PedestalCoffeeTable(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = Stream.of(
            Block.box(7, 0, 7, 9, 15, 9),
            Block.box(-2, 14.5, -2, 18, 16, 18),
            Block.box(4.05, 0, 4.35, 11.75, 0.5, 11.75)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
