package com.besson.arknights.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ConnectBlock extends FurnitureHorizontalFacingBlock{
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public ConnectBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, Type.SINGLE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(TYPE);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        return this.getRelatedBlockState(pState, pLevel, pPos, pState.getValue(FACING));
    }

    private BlockState getRelatedBlockState(BlockState pState, LevelAccessor pLevel, BlockPos pPos, Direction direction) {
        boolean left = isRelatedInDirection(pLevel, pPos, direction, true);
        boolean right = isRelatedInDirection(pLevel, pPos, direction, false);
        if(left && right){
            return pState.setValue(TYPE, Type.MIDDLE);
        } else if (right) {
            return pState.setValue(TYPE, Type.LEFT);
        } else if (left) {
            return pState.setValue(TYPE, Type.RIGHT);
        } else {
            return pState.setValue(TYPE, Type.SINGLE);
        }
    }
    private boolean isRelatedInDirection(LevelAccessor pLevel, BlockPos pPos, Direction direction, boolean counterclockwise) {
        Direction rotatedOnce = counterclockwise ? direction.getCounterClockWise() : direction.getClockWise();
        return this.isRelatedBlock(pLevel, pPos, rotatedOnce, direction);
    }

    private boolean isRelatedBlock(LevelAccessor pLevel, BlockPos pPos, Direction direction1, Direction direction2) {
        BlockState state = pLevel.getBlockState(pPos.relative(direction1));
        if (state.getBlock() == this){
            Direction blockDirection = state.getValue(FACING);
            return blockDirection.equals(direction2);
        }
        return false;
    }
    public enum Type implements StringRepresentable{
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle");

        private final String id;
        Type(String id){
            this.id = id;
        }
        @Override
        public String getSerializedName() {
            return id;
        }
    }
}
