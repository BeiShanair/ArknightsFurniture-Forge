package com.besson.arknights.block.sideline;

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

public class GrayishWallBottom extends FurnitureHorizontalFacingBlock {
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public GrayishWallBottom(Properties settings) {
        super(settings);
    }

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
        BlockPos bbr = pos.relative(dir.getCounterClockWise());
        BlockPos btl = pos.above();
        BlockPos btr = pos.relative(dir.getCounterClockWise()).above();

        if (!canPlace(world, bbr, btl, btr)) {
            return;
        }
        world.setBlock(bbr, ModBlocks.GRAYISH_WALL_BBR.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(btl, ModBlocks.GRAYISH_WALL_BTL.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(btr, ModBlocks.GRAYISH_WALL_BTR.get().defaultBlockState().setValue(FACING, dir), 3);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())){
            super.onRemove(state, world, pos, newState, moved);
            return;
        }

        BlockPos mainPos = findMainBlockPosition(state, pos);
        if (mainPos == null) {
            return;
        }

        Direction dir = state.getValue(FACING);
        removeAllParts(world, mainPos, dir);

        super.onRemove(state, world, pos, newState, moved);
    }

    private void removeAllParts(Level world, BlockPos mainPos, Direction dir) {
        BlockPos[] partPositions = {
                mainPos, // bottom-left (this block)
                mainPos.relative(dir.getCounterClockWise()), // bottom-right
                mainPos.above(), // top-left
                mainPos.relative(dir.getCounterClockWise()).above() // top-right
        };

        for (BlockPos partPos : partPositions) {
            if (isWall(world.getBlockState(partPos))) {
                world.removeBlock(partPos, false);
            }
        }
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
        BlockPos bbr = pos.relative(dir.getCounterClockWise());
        BlockPos btl = pos.above();
        BlockPos btr = pos.relative(dir.getCounterClockWise()).above();

        boolean placeable = canPlace(world, bbr, btl, btr);
        return placeable ? state : null;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis() == Direction.Axis.Y){
            if (neighborState.isAir()){
                return state;
            }
            BlockPos mainPos = findMainBlockPosition(state, pos);
            if (mainPos != null && isPartOfThisSet(mainPos, neighborPos, (Level) world)) {
                if (world.getBlockState(neighborPos).isAir()) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
            return state.setValue(FACING, state.getValue(FACING));

        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }
    private boolean isPartOfThisSet(BlockPos mainPos, BlockPos pos, Level world) {
        Direction dir = world.getBlockState(mainPos).getValue(FACING);
        BlockPos[] validPositions = {
                mainPos,
                mainPos.relative(dir.getCounterClockWise()),
                mainPos.above(),
                mainPos.relative(dir.getCounterClockWise()).above()
        };

        for (BlockPos validPos : validPositions) {
            if (validPos.equals(pos)) {
                return true;
            }
        }
        return false;
    }

    private BlockPos findMainBlockPosition(BlockState state, BlockPos pos) {
        if (state.is(ModBlocks.GRAYISH_WALL_BBL.get())) {
            return pos;
        }
        Direction dir = state.getValue(FACING);
        if (state.is(ModBlocks.GRAYISH_WALL_BBR.get())){
            return pos.relative(dir.getClockWise());
        } else if (state.is(ModBlocks.GRAYISH_WALL_BTL.get())){
            return pos.below();
        } else if (state.is(ModBlocks.GRAYISH_WALL_BTR.get())) {
            return pos.below().relative(dir.getClockWise());
        }
        return null;
    }

    private boolean canPlace(Level world, BlockPos... pos) {
        for (BlockPos blockPos : pos) {
            if (!world.getBlockState(blockPos).isAir()) {
                return false;
            }
        }
        return true;
    }

    private boolean isWall(BlockState state){
        return state.is(this) ||
                state.is(ModBlocks.GRAYISH_WALL_BBL.get()) ||
                state.is(ModBlocks.GRAYISH_WALL_BBR.get()) ||
                state.is(ModBlocks.GRAYISH_WALL_BTL.get()) ||
                state.is(ModBlocks.GRAYISH_WALL_BTR.get());
    }
}
