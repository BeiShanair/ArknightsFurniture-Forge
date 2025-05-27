package com.besson.arknights.block.columbian;

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

public class BrownBookcase extends FurnitureHorizontalFacingBlock {
    public BrownBookcase(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

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
        BlockPos rb = pos.relative(dir.getCounterClockWise());
        BlockPos lm = pos.above();
        BlockPos rm = lm.relative(dir.getCounterClockWise());
        BlockPos lt = lm.above();
        BlockPos rt = rm.above();

        if (!canPlace(world, rb, lm, rm, lt, rt)){
            return;
        }
        world.setBlock(rb, ModBlocks.BROWN_BOOKCASE_RB.get().defaultBlockState().setValue(FACING, dir),3);
        world.setBlock(lm, ModBlocks.BROWN_BOOKCASE_LM.get().defaultBlockState().setValue(FACING, dir),3);
        world.setBlock(rm, ModBlocks.BROWN_BOOKCASE_RM.get().defaultBlockState().setValue(FACING, dir),3);
        world.setBlock(lt, ModBlocks.BROWN_BOOKCASE_LT.get().defaultBlockState().setValue(FACING, dir),3);
        world.setBlock(rt, ModBlocks.BROWN_BOOKCASE_RT.get().defaultBlockState().setValue(FACING, dir),3);
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

        if (state == null) {
            return null;
        }
        Direction dir = state.getValue(FACING);
        BlockPos rb = pos.relative(dir.getCounterClockWise());
        BlockPos lm = pos.above();
        BlockPos rm = lm.relative(dir.getCounterClockWise());
        BlockPos lt = lm.above();
        BlockPos rt = rm.above();

        boolean canPlace = canPlace(world, rb, lm, rm, lt, rt);
        return canPlace ? state : null;
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
        BlockPos lm = mainPos.above();
        BlockPos rm = lm.relative(dir.getCounterClockWise());
        BlockPos lt = lm.above();
        BlockPos rt = rm.above();

        BlockPos[] pos = {mainPos, rb, lm, rm, lt, rt};

        for (BlockPos p : pos){
            if (isBookcase(world.getBlockState(p))){
                world.removeBlock(p, false);
            }
        }
    }

    private BlockPos findMainPos(BlockState state, BlockPos pos){
        if (state.is(ModBlocks.BROWN_BOOKCASE_LB.get())){
            return pos;
        }
        Direction dir = state.getValue(FACING);
        if (state.is(ModBlocks.BROWN_BOOKCASE_RB.get())){
            return pos.relative(dir.getClockWise());
        } else if (state.is(ModBlocks.BROWN_BOOKCASE_LM.get())) {
            return pos.below();
        } else if (state.is(ModBlocks.BROWN_BOOKCASE_RM.get())) {
            return pos.below().relative(dir.getClockWise());
        } else if (state.is(ModBlocks.BROWN_BOOKCASE_LT.get())) {
            return pos.below(2);
        } else if (state.is(ModBlocks.BROWN_BOOKCASE_RT.get())) {
            return pos.below(2).relative(dir.getClockWise());
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
    private boolean isBookcase(BlockState state){
        return state.is(this) ||
                state.is(ModBlocks.BROWN_BOOKCASE_LT.get()) ||
                state.is(ModBlocks.BROWN_BOOKCASE_RT.get()) ||
                state.is(ModBlocks.BROWN_BOOKCASE_LM.get()) ||
                state.is(ModBlocks.BROWN_BOOKCASE_RM.get()) ||
                state.is(ModBlocks.BROWN_BOOKCASE_LB.get()) ||
                state.is(ModBlocks.BROWN_BOOKCASE_RB.get());
    }
}
