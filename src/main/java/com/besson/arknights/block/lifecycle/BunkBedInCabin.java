package com.besson.arknights.block.lifecycle;

import com.besson.arknights.block.FurnitureBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BunkBedInCabin extends FurnitureBedBlock {

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

    public BunkBedInCabin(DyeColor color, Properties settings) {
        super(color, settings);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
