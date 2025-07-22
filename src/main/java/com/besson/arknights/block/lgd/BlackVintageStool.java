package com.besson.arknights.block.lgd;

import com.besson.arknights.block.FurnitureHorizontalFacingBlock;
import com.besson.arknights.block.SeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class BlackVintageStool extends FurnitureHorizontalFacingBlock {
    public BlackVintageStool(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = Stream.of(
            Block.box(3, 6.75, 3, 13, 8, 13.5),
            Block.box(2.25, 8, 2.5, 13.75, 8.5, 14),
            Block.box(2.5, 0, 2.75, 4.25, 8, 4.5),
            Block.box(2.5, 0, 12, 4.25, 8, 13.75),
            Block.box(11.75, 0, 12, 13.5, 8, 13.75),
            Block.box(11.75, 0, 2.75, 13.5, 8, 4.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()){
            return SeatEntity.create(pLevel, pPos, 0.4, pPlayer, pState.getValue(FACING));
        }
        return InteractionResult.SUCCESS;
    }
}
