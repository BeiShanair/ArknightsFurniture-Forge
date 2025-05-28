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

public class MetallicWallpaper1 extends FurnitureHorizontalFacingBlock {
    public MetallicWallpaper1(Properties settings) {
        super(settings);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(world, pos, state, placer, itemStack);
        if (world.isClientSide()){
            return;
        }
        Direction dir = state.getValue(FACING);
        BlockPos up = pos.above();

        if (!world.getBlockState(up).isAir()){
            return;
        }
        world.setBlock(up, ModBlocks.METALLIC_WALLPAPER_TOP.get().defaultBlockState().setValue(FACING, dir), 3);
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
        BlockPos up = pos.above();

        boolean placeable = world.getBlockState(up).isAir();
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
        BlockPos top = mainPos.above();

        BlockPos[] pos = {mainPos, top};

        for (BlockPos p : pos){
            if (isBookcase(world.getBlockState(p))){
                world.removeBlock(p, false);
            }
        }
    }
    private boolean isBookcase(BlockState state){
        return state.is(this) ||
                state.is(ModBlocks.METALLIC_WALLPAPER_TOP.get()) ||
                state.is(ModBlocks.METALLIC_WALLPAPER_BOTTOM.get());
    }

    private BlockPos findMainPos(BlockState state, BlockPos pos){
        if (state.is(ModBlocks.METALLIC_WALLPAPER_BOTTOM.get())){
            return pos;
        }
        Direction dir = state.getValue(FACING);
        if (state.is(ModBlocks.METALLIC_WALLPAPER_TOP.get())){
            return pos.below();
        }
        return null;
    }
}
