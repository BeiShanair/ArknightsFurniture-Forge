package com.besson.arknights.block.sideline;

import com.besson.arknights.block.ModAbstractChestBlock;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class CheckerboardBookcase extends ModAbstractChestBlock<CheckerboardBookcaseBE> {

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public CheckerboardBookcase(Properties settings, Supplier<BlockEntityType<? extends CheckerboardBookcaseBE>> blockEntityTypeSupplier) {
        super(settings, blockEntityTypeSupplier);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CheckerboardBookcaseBE(pos, state);
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
        BlockPos btr = btl.relative(dir.getCounterClockWise());
        BlockPos mbl = btl.above();
        BlockPos mbr = mbl.relative(dir.getCounterClockWise());
        BlockPos mtl = mbl.above();
        BlockPos mtr = mtl.relative(dir.getCounterClockWise());
        BlockPos tl = mtl.above();
        BlockPos tr = tl.relative(dir.getCounterClockWise());

        if (!canPlace(world, bbr, btl, btr, mbl, mbr, mtl, mtr, tl, tr)){
            return;
        }
        world.setBlock(bbr, ModBlocks.CHECKERBOARD_BOOKCASE_BBR.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(btl, ModBlocks.CHECKERBOARD_BOOKCASE_BTL.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(btr, ModBlocks.CHECKERBOARD_BOOKCASE_BTR.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(mbl, ModBlocks.CHECKERBOARD_BOOKCASE_MBL.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(mbr, ModBlocks.CHECKERBOARD_BOOKCASE_MBR.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(mtl, ModBlocks.CHECKERBOARD_BOOKCASE_MTL.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(mtr, ModBlocks.CHECKERBOARD_BOOKCASE_MTR.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(tl, ModBlocks.CHECKERBOARD_BOOKCASE_TL.get().defaultBlockState().setValue(FACING, dir), 3);
        world.setBlock(tr, ModBlocks.CHECKERBOARD_BOOKCASE_TR.get().defaultBlockState().setValue(FACING, dir), 3);
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

    private void removeAllParts(Level world, BlockPos mainPos, Direction dir){
        BlockPos bbr = mainPos.relative(dir.getCounterClockWise());
        BlockPos btl = mainPos.above();
        BlockPos btr = btl.relative(dir.getCounterClockWise());
        BlockPos mbl = btl.above();
        BlockPos mbr = mbl.relative(dir.getCounterClockWise());
        BlockPos mtl = mbl.above();
        BlockPos mtr = mtl.relative(dir.getCounterClockWise());
        BlockPos tl = mtl.above();
        BlockPos tr = tl.relative(dir.getCounterClockWise());

        BlockPos[] pos = {mainPos, bbr, btl, btr, mbl, mbr, mtl, mtr, tl, tr};

        for (BlockPos p : pos){
            if (isBookcase(world.getBlockState(p))){
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
        BlockPos bbr = pos.relative(dir.getCounterClockWise());
        BlockPos btl = pos.above();
        BlockPos btr = btl.relative(dir.getCounterClockWise());
        BlockPos mbl = btl.above();
        BlockPos mbr = mbl.relative(dir.getCounterClockWise());
        BlockPos mtl = mbl.above();
        BlockPos mtr = mtl.relative(dir.getCounterClockWise());
        BlockPos tl = mtl.above();
        BlockPos tr = tl.relative(dir.getCounterClockWise());

        boolean placeable = canPlace(world, bbr, btl, btr, mbl, mbr, mtl, mtr, tl, tr);
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

    private BlockPos findMainPos(BlockState state, BlockPos pos){
        if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_BBL.get())){
            return pos;
        }
        Direction dir = state.getValue(FACING);
        if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_BBR.get())){
            return pos.relative(dir.getClockWise());
        } else if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_BTL.get())) {
            return pos.below();
        } else if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_BTR.get())) {
            return pos.below().relative(dir.getClockWise());
        } else if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_MBL.get())) {
            return pos.below(2);
        } else if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_MBR.get())) {
            return pos.below(2).relative(dir.getClockWise());
        } else if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_MTL.get())) {
            return pos.below(3);
        } else if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_MTR.get())) {
            return pos.below(3).relative(dir.getClockWise());
        } else if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_TL.get())) {
            return pos.below(4);
        } else if (state.is(ModBlocks.CHECKERBOARD_BOOKCASE_TR.get())) {
            return pos.below(4).relative(dir.getClockWise());
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
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_BBL.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_BBR.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_BTL.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_BTR.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_MBL.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_MBR.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_MTL.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_MTR.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_TL.get()) ||
               state.is(ModBlocks.CHECKERBOARD_BOOKCASE_TR.get());
    }
}
