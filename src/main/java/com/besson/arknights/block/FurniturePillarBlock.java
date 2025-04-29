package com.besson.arknights.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class FurniturePillarBlock extends FurnitureHorizontalFacingBlock{
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type2",Type.class);
    public FurniturePillarBlock(Properties pProperties) {
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
        boolean top = pLevel.getBlockState(pPos.above()).is(this);
        boolean bottom = pLevel.getBlockState(pPos.below()).is(this);
        if (top && bottom){
            return pState.setValue(TYPE, Type.MIDDLE);
        } else if (bottom) {
            return pState.setValue(TYPE, Type.TOP);
        } else if (top) {
            return pState.setValue(TYPE, Type.BOTTOM);
        } else {
            return pState.setValue(TYPE, Type.SINGLE);
        }
    }

    public enum Type implements StringRepresentable{
        SINGLE("single"),
        TOP("top"),
        BOTTOM("bottom"),
        MIDDLE("middle");

        private final String id;
        Type(String id) {
            this.id = id;
        }
        @Override
        public String getSerializedName() {
            return id;
        }
    }
}
