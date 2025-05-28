package com.besson.arknights.block.fantastic;

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

public class EcoExhibitionCabinetBase extends FurnitureHorizontalFacingBlock {
    public EcoExhibitionCabinetBase(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = Block.box(-6, 0, -6, 22, 16, 22);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(world, pos, state, placer, itemStack);
        if (world.isClientSide()){
            return;
        }
        Direction dir = state.getValue(FACING);
        BlockPos top = pos.above(2);

        if (!canPlace(world, top)) {
            return;
        }
        world.setBlock(top, ModBlocks.ECO_EXHIBITION_CABINET.get().defaultBlockState().setValue(FACING, dir), 3);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())) {
            super.onRemove(state, world, pos, newState, moved);
            return;
        }

        BlockPos mainPos = findMainPos(state, pos);
        if (mainPos == null) {
            return;
        }
        Direction dir = state.getValue(FACING);
        removeAllParts(world, mainPos, dir);

        super.onRemove(state, world, pos, newState, moved);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        BlockState state = super.getStateForPlacement(ctx);

        if (state == null){
            return null;
        }
        Direction dir = state.getValue(FACING);
        BlockPos top = pos.above(2);

        boolean placeable = canPlace(world, top);
        return placeable ? state : null;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis() == Direction.Axis.Y){
            if (neighborState.isAir()){
                return state;
            }
            BlockPos mainPos = findMainPos(state, pos);
            if (mainPos == null){
                if (world.getBlockState(neighborPos).isAir()){
                    return Blocks.AIR.defaultBlockState();
                }
            }
            return state.setValue(FACING, state.getValue(FACING));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    private void removeAllParts(Level world, BlockPos mainPos, Direction dir){
        BlockPos top = mainPos.above(2);

        BlockPos[] pos = {mainPos, top};

        for (BlockPos p : pos){
            if (isBookcase(world.getBlockState(p))){
                world.removeBlock(p, false);
            }
        }
    }

    private boolean isBookcase(BlockState state){
        return state.is(this) ||
                state.is(ModBlocks.ECO_EXHIBITION_CABINET.get()) ||
                state.is(ModBlocks.ECO_EXHIBITION_CABINET_BASE.get());
    }

    private BlockPos findMainPos(BlockState state, BlockPos pos){
        if (state.is(ModBlocks.ECO_EXHIBITION_CABINET_BASE.get())){
            return pos;
        }
        else if (state.is(ModBlocks.ECO_EXHIBITION_CABINET.get())){
            return pos.below(2);
        }
        return null;
    }

    private boolean canPlace(Level world, BlockPos... pos){
        for (BlockPos p : pos){
            if (!world.getBlockState(p).isAir()){
                return false;
            }
        }
        return true;
    }
}
