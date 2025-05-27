package com.besson.arknights.block.columbian;

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

public class RedBrownCabinet extends ModAbstractChestBlock<RedBrownCabinetBE> {

    private static final VoxelShape SHAPE = Block.box(0,0,0,16,16,16);

    public RedBrownCabinet(Properties settings, Supplier<BlockEntityType<? extends RedBrownCabinetBE>> blockEntityTypeSupplier) {
        super(settings, blockEntityTypeSupplier);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new RedBrownCabinetBE(pPos, pState);
    }
}
