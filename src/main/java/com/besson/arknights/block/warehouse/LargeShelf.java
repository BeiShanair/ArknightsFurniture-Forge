package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.ModAbstractChestBlock;
import com.besson.arknights.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class LargeShelf extends ModAbstractChestBlock<LargeShelfBE> {

    private static final VoxelShape SHAPE_NS = Block.box(-16, 0, -4, 32, 16, 20);
    private static final VoxelShape SHAPE_WE = Block.box(-4, 0, -16, 20, 16, 32);

    public LargeShelf(Properties pProperties, Supplier<BlockEntityType<? extends LargeShelfBE>> pBlockEntityType) {
        super(pProperties, pBlockEntityType);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST, WEST -> SHAPE_WE;
            default -> SHAPE_NS;
        };
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.arknights.large_shelf"));
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (pLevel.isClientSide()){
            return;
        }
        Direction direction = pState.getValue(FACING);
        BlockPos midPos1 = pPos.above();
        BlockPos midPos2 = pPos.above(2);
        BlockPos topPos = pPos.above(3);
        if (!canPlace(pLevel, midPos1, midPos2, topPos)) {
            return;
        }
        pLevel.setBlock(midPos1, ModBlocks.LARGE_SHELF2.get().defaultBlockState().setValue(FACING, direction), 3);
        pLevel.setBlock(midPos2, ModBlocks.LARGE_SHELF3.get().defaultBlockState().setValue(FACING, direction), 3);
        pLevel.setBlock(topPos, ModBlocks.LARGE_SHELF4.get().defaultBlockState().setValue(FACING, direction), 3);
    }

    private boolean canPlace(Level pLevel, BlockPos... pos) {
        for (BlockPos blockPos : pos) {
            if (!pLevel.getBlockState(blockPos).isAir()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.is(pNewState.getBlock())){
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
            return;
        }

        // 向上破坏
        for (int i = 1; i <= 3; i++) {
            BlockPos upPos = pPos.above(i);
            if (isShelfBlock(pLevel.getBlockState(upPos))) {
                pLevel.removeBlock(upPos, false);
            }
        }

        // 向下破坏
        for (int i = 1; i <= 3; i++) {
            BlockPos downPos = pPos.below(i);
            if (isShelfBlock(pLevel.getBlockState(downPos))) {
                pLevel.removeBlock(downPos, false);
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);

    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Level level = pContext.getLevel();
        BlockPos mainPos = pContext.getClickedPos();
        BlockState state = super.getStateForPlacement(pContext);
        if (state == null) {
            return null;
        }
        BlockPos midPos1 = mainPos.above();
        BlockPos midPos2 = mainPos.above(2);
        BlockPos topPos = mainPos.above(3);
        boolean placeable = canPlace(level, midPos1, midPos2, topPos);
        return placeable ? state : null;

    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pDirection.getAxis() == Direction.Axis.Y) {
            if (pNeighborState.isAir()) {
                return pState; // 放置时允许
            }
            if (isShelfBlock(pNeighborState) && pLevel.getBlockState(pNeighborPos).isAir()) {
                return Blocks.AIR.defaultBlockState();
            }
            return pState.setValue(FACING, pState.getValue(FACING));
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    private boolean isShelfBlock(BlockState state) {
        return state.is(this) ||
                state.is(ModBlocks.LARGE_SHELF1.get()) ||
                state.is(ModBlocks.LARGE_SHELF2.get()) ||
                state.is(ModBlocks.LARGE_SHELF3.get()) ||
                state.is(ModBlocks.LARGE_SHELF4.get());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new LargeShelfBE(pPos, pState);
    }
}
