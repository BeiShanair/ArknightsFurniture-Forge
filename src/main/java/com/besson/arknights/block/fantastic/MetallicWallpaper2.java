package com.besson.arknights.block.fantastic;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import com.besson.arknights.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class MetallicWallpaper2 extends FurnitureHorizontalFacingBlock {
    public MetallicWallpaper2(Properties settings) {
        super(settings);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(world, pos, state, placer, itemStack);
        if (world.isClientSide()){
            return;
        }
        Direction dir = state.getValue(FACING);
        BlockPos rb = pos.relative(dir.getCounterClockWise());
        BlockPos lt = pos.above();
        BlockPos rt = lt.relative(dir.getCounterClockWise());

        if (!canPlace(world, rb, lt, rt)){
            return;
        }
        world.setBlock(rb, ModBlocks.METALLIC_WALLPAPER_RB.get().defaultBlockState().setValue(FACING, dir),3);
        world.setBlock(lt, ModBlocks.METALLIC_WALLPAPER_LT.get().defaultBlockState().setValue(FACING, dir),3);
        world.setBlock(rt, ModBlocks.METALLIC_WALLPAPER_RT.get().defaultBlockState().setValue(FACING, dir),3);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())){
            super.onRemove(state, world, pos, newState, moved);
            return;
        }

        BlockPos mainPos = findMainPos(state, pos);
        if (mainPos == null){
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
        BlockPos rb = pos.relative(dir.getCounterClockWise());
        BlockPos lt = pos.above();
        BlockPos rt = lt.relative(dir.getCounterClockWise());

        boolean placeable = canPlace(world, rb, lt, rt);
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
        BlockPos rb = mainPos.relative(dir.getCounterClockWise());
        BlockPos lt = mainPos.above();
        BlockPos rt = lt.relative(dir.getCounterClockWise());

        BlockPos[] pos = {mainPos, rb, lt, rt};

        for (BlockPos p : pos){
            if (isBookcase(world.getBlockState(p))){
                world.removeBlock(p, false);
            }
        }
    }

    private boolean isBookcase(BlockState state){
        return state.is(this) ||
                state.is(ModBlocks.METALLIC_WALLPAPER_LB.get()) ||
                state.is(ModBlocks.METALLIC_WALLPAPER_RB.get()) ||
                state.is(ModBlocks.METALLIC_WALLPAPER_LT.get()) ||
                state.is(ModBlocks.METALLIC_WALLPAPER_RT.get());
    }

    private BlockPos findMainPos(BlockState state, BlockPos pos){
        if (state.is(ModBlocks.METALLIC_WALLPAPER_LB.get())){
            return pos;
        }
        Direction dir = state.getValue(FACING);
        if (state.is(ModBlocks.METALLIC_WALLPAPER_RB.get())){
            return pos.relative(dir.getClockWise());
        } else if (state.is(ModBlocks.METALLIC_WALLPAPER_LT.get())) {
            return pos.below();
        } else if (state.is(ModBlocks.METALLIC_WALLPAPER_RT.get())) {
            return pos.below().relative(dir.getClockWise());
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
