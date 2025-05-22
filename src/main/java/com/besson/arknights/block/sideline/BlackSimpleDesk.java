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

public class BlackSimpleDesk extends FurnitureHorizontalFacingBlock {
    public BlackSimpleDesk(Properties properties) {
        super(properties);
    }
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(world, pos, state, placer, itemStack);
        if (world.isClientSide()){
            return;
        }
        Direction dir = state.getValue(FACING);
        BlockPos lbr = pos.relative(dir.getCounterClockWise());
        BlockPos ltl = pos.relative(dir.getOpposite());
        BlockPos ltr = pos.relative(dir.getOpposite()).relative(dir.getCounterClockWise());
        BlockPos rbl = lbr.relative(dir.getCounterClockWise());
        BlockPos rbr = rbl.relative(dir.getCounterClockWise());
        BlockPos rtl = ltr.relative(dir.getCounterClockWise());
        BlockPos rtr = rtl.relative(dir.getCounterClockWise());

        if (!canPlace(world, lbr, ltl, ltr, rbl, rbr, rtl, rtr)){
            return;
        }
        world.setBlock(lbr, ModBlocks.SIMPLE_BLACK_DESK_LBR.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(ltl, ModBlocks.SIMPLE_BLACK_DESK_LTL.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(ltr, ModBlocks.SIMPLE_BLACK_DESK_LTR.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(rbl, ModBlocks.SIMPLE_BLACK_DESK_RBL.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(rbr, ModBlocks.SIMPLE_BLACK_DESK_RBR.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(rtl, ModBlocks.SIMPLE_BLACK_DESK_RTL.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(rtr, ModBlocks.SIMPLE_BLACK_DESK_RTR.get().defaultBlockState().setValue(FACING, dir), 3);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())){
            super.onRemove(state, world, pos, newState, moved);
            return;
        }

        BlockPos mainPos = findMainBlockPosition(state, pos);
        if (mainPos == null){
            return;
        }

        Direction dir = state.getValue(FACING);
        removeAllParts(world, mainPos, dir);

        super.onRemove(state, world, pos, newState, moved);
    }

    private void removeAllParts(Level world, BlockPos mainPos, Direction dir){
        BlockPos lbr = mainPos.relative(dir.getCounterClockWise());
        BlockPos ltl = mainPos.relative(dir.getOpposite());
        BlockPos ltr = mainPos.relative(dir.getOpposite()).relative(dir.getCounterClockWise());
        BlockPos rbl = lbr.relative(dir.getCounterClockWise());
        BlockPos rbr = rbl.relative(dir.getCounterClockWise());
        BlockPos rtl = ltr.relative(dir.getCounterClockWise());
        BlockPos rtr = rtl.relative(dir.getCounterClockWise());
        BlockPos[] partPositions = {mainPos, lbr, ltl, ltr, rbl, rbr, rtl, rtr};

        for (BlockPos p : partPositions){
            if (isDesk(world.getBlockState(p))){
                world.removeBlock(p, false);
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
        BlockPos lbr = pos.relative(dir.getCounterClockWise());
        BlockPos ltl = pos.relative(dir.getOpposite());
        BlockPos ltr = pos.relative(dir.getOpposite()).relative(dir.getCounterClockWise());
        BlockPos rbl = lbr.relative(dir.getCounterClockWise());
        BlockPos rbr = rbl.relative(dir.getCounterClockWise());
        BlockPos rtl = ltr.relative(dir.getCounterClockWise());
        BlockPos rtr = rtl.relative(dir.getCounterClockWise());

        boolean placeable = canPlace(world, lbr, ltl, ltr, rbl, rbr, rtl, rtr);
        return placeable ? state : null;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (neighborState.isAir()){
            return state;
        }
        BlockPos mainPos = findMainBlockPosition(state, pos);
        if (mainPos != null){
            if (world.getBlockState(neighborPos).isAir()){
                return Blocks.AIR.defaultBlockState();
            }
        }
        return state.setValue(FACING, state.getValue(FACING));
    }

    private BlockPos findMainBlockPosition(BlockState state, BlockPos pos) {
        if (state.is(ModBlocks.SIMPLE_BLACK_DESK_LBL.get())){
            return pos;
        }
        Direction dir = state.getValue(FACING);
        if (state.is(ModBlocks.SIMPLE_BLACK_DESK_LBR.get())){
            return pos.relative(dir.getClockWise());
        } else if (state.is(ModBlocks.SIMPLE_BLACK_DESK_LTL.get())) {
            return pos.relative(dir);
        } else if (state.is(ModBlocks.SIMPLE_BLACK_DESK_LTR.get())) {
            return pos.relative(dir.getClockWise()).relative(dir);
        } else if (state.is(ModBlocks.SIMPLE_BLACK_DESK_RBL.get())) {
            return pos.relative(dir.getClockWise(), 2);
        } else if (state.is(ModBlocks.SIMPLE_BLACK_DESK_RBR.get())) {
            return pos.relative(dir.getClockWise(), 3);
        } else if (state.is(ModBlocks.SIMPLE_BLACK_DESK_RTL.get())) {
            return pos.relative(dir.getClockWise(), 2).relative(dir);
        } else if (state.is(ModBlocks.SIMPLE_BLACK_DESK_RTR.get())) {
            return pos.relative(dir.getClockWise(), 3).relative(dir);
        }
        return null;
    }


    private boolean canPlace(Level world, BlockPos... pos) {
        for (BlockPos p : pos){
            if (!world.getBlockState(p).isAir()){
                return false;
            }
        }
        return true;
    }
    private boolean isDesk(BlockState state){
        return state.is(this) ||
                state.is(ModBlocks.SIMPLE_BLACK_DESK_LBL.get()) ||
                state.is(ModBlocks.SIMPLE_BLACK_DESK_LBR.get()) ||
                state.is(ModBlocks.SIMPLE_BLACK_DESK_LTL.get()) ||
                state.is(ModBlocks.SIMPLE_BLACK_DESK_LTR.get()) ||
                state.is(ModBlocks.SIMPLE_BLACK_DESK_RBL.get()) ||
                state.is(ModBlocks.SIMPLE_BLACK_DESK_RBR.get()) ||
                state.is(ModBlocks.SIMPLE_BLACK_DESK_RTL.get()) ||
                state.is(ModBlocks.SIMPLE_BLACK_DESK_RTR.get());
    }
}
