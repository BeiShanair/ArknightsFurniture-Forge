package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.ModAbstractChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class Carton extends ModAbstractChestBlock<CartonBE> {

    private static final VoxelShape SHAPE_N = Block.box(0, 0, 0, 24, 32, 24);
    private static final VoxelShape SHAPE_W = Block.box(0, 0, -8, 24, 32, 16);
    private static final VoxelShape SHAPE_S = Block.box(-8, 0, -8, 16, 32, 16);
    private static final VoxelShape SHAPE_E = Block.box(-8, 0, 0, 16, 32, 24);

    public Carton(Properties pProperties, Supplier<BlockEntityType<? extends CartonBE>> pBlockEntityType) {
        super(pProperties, pBlockEntityType);
    }


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case WEST -> SHAPE_W;
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CartonBE(pPos, pState);
    }
}
