package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CargoTrolley extends FurnitureHorizontalFacingBlock {
    private static final VoxelShape SHAPE_NS = Block.box(-8, 0, -2, 24, 21, 18);

    private static final VoxelShape SHAPE_WE = Block.box(-2, 0, -8, 18, 21, 24);

    public CargoTrolley(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST, WEST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }
}
