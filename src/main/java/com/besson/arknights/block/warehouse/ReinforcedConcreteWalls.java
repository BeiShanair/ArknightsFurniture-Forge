package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.ModDoubleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ReinforcedConcreteWalls extends ModDoubleBlock {
    public static final VoxelShape SHAPE = Block.box(0,0,0,16,16,16);

    public ReinforcedConcreteWalls(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
