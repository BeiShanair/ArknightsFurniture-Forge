package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PottedSucculentPlant extends FurnitureHorizontalFacingBlock {
    public PottedSucculentPlant(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = Block.box(5.35, 0, 5.25, 10.7, 19.825, 10.65);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

}
