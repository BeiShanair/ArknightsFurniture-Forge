package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PostItNote extends FurnitureHorizontalFacingBlock {
    private static final VoxelShape SHAPE_N = Block.box(-6, 0, 15, 22, 26, 16);
    private static final VoxelShape SHAPE_S = Block.box(-6, 0, 0, 22, 26, 1);
    private static final VoxelShape SHAPE_W = Block.box(15, 0, -6, 16, 26, 22);
    private static final VoxelShape SHAPE_E = Block.box(0, 0, -6, 1, 26, 22);

    public PostItNote(Properties pProperties) {
        super(pProperties);
    }

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
