package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PottedBroadleafPlant extends FurnitureHorizontalFacingBlock {
    public PottedBroadleafPlant(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = Block.box(3.5, 0, 3.5, 12.5, 14, 12.5);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
