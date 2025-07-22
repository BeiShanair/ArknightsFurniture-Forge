package com.besson.arknights.block.lgd;

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

public class BlackPedestalTable extends FurnitureHorizontalFacingBlock {
    public BlackPedestalTable(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = Stream.of(
            Block.box(11, 0, 11, 12, 0.5, 12),
            Block.box(4, 0.5, 4, 12, 1, 12),
            Block.box(7, 1, 7, 9, 15, 9),
            Block.box(-2, 15, -3, 18, 16, 18),
            Stream.of(
                    Block.box(4, 0, 4, 7.25, 1, 12),
                    Block.box(4, 0.1, 4, 12, 1.1, 7.25),
                    Stream.of(
                            Block.box(8.75, 0, 4, 12, 1, 12),
                            Block.box(4, 0.1, 8.75, 12, 1.1, 12),
                            Block.box(4, 0, 4, 5, 0.5, 5),
                            Block.box(4, 0, 11, 5, 0.5, 12),
                            Block.box(11, 0, 4, 12, 0.5, 5)
                    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get()
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get()
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
