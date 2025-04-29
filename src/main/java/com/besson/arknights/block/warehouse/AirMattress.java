package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.FurnitureBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AirMattress extends FurnitureBedBlock {
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 4, 16);

    public AirMattress(DyeColor pColor, Properties pProperties) {
        super(pColor, pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
