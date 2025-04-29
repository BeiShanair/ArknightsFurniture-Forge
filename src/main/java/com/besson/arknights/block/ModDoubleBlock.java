package com.besson.arknights.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

public class ModDoubleBlock extends FurnitureHorizontalFacingBlock{
    public static final EnumProperty<DoubleBlockType> TYPE = EnumProperty.create("double_block_type", DoubleBlockType.class);
    public ModDoubleBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, DoubleBlockType.SINGLE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(TYPE);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pNeighborState.is(this) && pDirection.getAxis().isHorizontal()){
            DoubleBlockType doubleBlockType = pNeighborState.getValue(TYPE);
            if (pState.getValue(TYPE) == DoubleBlockType.SINGLE &&
                    doubleBlockType != DoubleBlockType.SINGLE &&
                    pState.getValue(FACING) == pNeighborState.getValue(FACING) &&
                    getFacing(pNeighborState) == pDirection.getOpposite()){
                return pState.setValue(TYPE, doubleBlockType.getOpposite());
            }
        } else if (getFacing(pState) == pDirection){
            return pState.setValue(TYPE, DoubleBlockType.SINGLE);
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    private Direction getFacing(BlockState state) {
        Direction direction = state.getValue(FACING);
        return state.getValue(TYPE) == DoubleBlockType.RIGHT ? direction.getClockWise() : direction.getCounterClockWise();
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        DoubleBlockType doubleBlockType = DoubleBlockType.SINGLE;
        Direction direction = pContext.getHorizontalDirection().getOpposite();
        if (direction == this.getNeighborDirection(pContext, direction.getClockWise())){
            doubleBlockType = DoubleBlockType.RIGHT;
        } else if (direction == this.getNeighborDirection(pContext, direction.getCounterClockWise())){
            doubleBlockType = DoubleBlockType.LEFT;
        }
        return this.defaultBlockState().setValue(FACING, direction).setValue(TYPE, doubleBlockType);
    }

    @Nullable
    public Direction getNeighborDirection(BlockPlaceContext pContext, Direction dir) {
        BlockState blockState = pContext.getLevel().getBlockState(pContext.getClickedPos().relative(dir));
        return blockState.is(this) && blockState.getValue(TYPE) == DoubleBlockType.SINGLE ? blockState.getValue(FACING) : null;
    }

    public enum DoubleBlockType implements StringRepresentable{
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right");

        private final String id;
        DoubleBlockType(String id) {
            this.id = id;
        }
        @Override
        public String getSerializedName() {
            return id;
        }

        public DoubleBlockType getOpposite() {
            return switch (this) {
                case LEFT -> RIGHT;
                case RIGHT -> LEFT;
                default -> SINGLE;
            };
        }
    }
}
