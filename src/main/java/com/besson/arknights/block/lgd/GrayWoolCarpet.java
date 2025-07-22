package com.besson.arknights.block.lgd;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import com.besson.arknights.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class GrayWoolCarpet extends FurnitureHorizontalFacingBlock {
    public static final VoxelShape SHAPE = Block.box(-16, 0, -16, 32, 0.45, 32);

    public GrayWoolCarpet(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (pLevel.isClientSide()){
            return;
        }
        Direction dir = pState.getValue(FACING);
        BlockPos right = pPos.relative(dir.getCounterClockWise(), 3);

        if (!pLevel.getBlockState(right).isAir()){
            return;
        }
        pLevel.setBlock(right, ModBlocks.GRAY_WOOL_CARPET_RIGHT.get().defaultBlockState().setValue(FACING, dir), 3);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.is(pNewState.getBlock())){
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
            return;
        }

        BlockPos mainPos = findMainPos(pState, pPos);
        if (mainPos == null){
            return;
        }

        Direction dir = pState.getValue(FACING);
        removeAllParts(pLevel, mainPos, dir);

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Level world = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = super.getStateForPlacement(pContext);

        if (state == null){
            return null;
        }

        Direction dir = state.getValue(FACING);
        BlockPos right = pos.relative(dir.getCounterClockWise(), 3);

        boolean placeable = world.getBlockState(right).isAir();
        return placeable ? state : null;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pNeighborState.isAir()){
            return pState;
        }

        BlockPos mainPos = findMainPos(pState, pPos);
        if (mainPos == null){
            if (pLevel.getBlockState(pNeighborPos).isAir()){
                return Blocks.AIR.defaultBlockState();
            }
        }
        return pState.setValue(FACING, pState.getValue(FACING));
    }

    private void removeAllParts(Level world, BlockPos mainPos, Direction dir){
        BlockPos right = mainPos.relative(dir.getCounterClockWise(), 3);

        BlockPos[] pos = {mainPos, right};

        for (BlockPos p : pos){
            if (isBookcase(world.getBlockState(p))){
                world.removeBlock(p, false);
            }
        }
    }

    private BlockPos findMainPos(BlockState state, BlockPos pos){
        if (state.is(ModBlocks.GRAY_WOOL_CARPET_LEFT.get())){
            return pos;
        }
        Direction dir = state.getValue(FACING);
        if (state.is(ModBlocks.GRAY_WOOL_CARPET_RIGHT.get())){
            return pos.relative(dir.getClockWise(), 3);
        }
        return null;
    }
    private boolean isBookcase(BlockState state){
        return state.is(this) ||
                state.is(ModBlocks.GRAY_WOOL_CARPET_LEFT.get()) ||
                state.is(ModBlocks.GRAY_WOOL_CARPET_RIGHT.get());
    }
}
