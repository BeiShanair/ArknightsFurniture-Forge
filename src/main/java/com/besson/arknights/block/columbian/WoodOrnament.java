package com.besson.arknights.block.columbian;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WoodOrnament extends FurnitureHorizontalFacingBlock {
    public static final VoxelShape SHAPE_NS = Block.box(5, 0, 7, 11, 2.5, 9);
    public static final VoxelShape SHAPE_WE = Block.box(7, 0, 5, 9, 2.5, 11);
    public WoodOrnament(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case WEST, EAST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }
}
