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

public class BlackVintageChair extends FurnitureHorizontalFacingBlock {
    public BlackVintageChair(Properties settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(2.75, 0, 13.25, 4.5, 15, 15),
            Block.box(3, 6.75, 3.5, 13, 8, 14),
            Block.box(2, 15, 13, 14, 16, 15),
            Block.box(2.25, 8, 2.5, 13.75, 8.5, 13.5),
            Block.box(2.75, 0, 3.25, 4.5, 8, 5),
            Block.box(11.5, 0, 3.25, 13.25, 8, 5),
            Block.box(11.5, 0, 13.25, 13.25, 15, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(13.25, 0, 11.5, 15, 15, 13.25),
            Block.box(3.5, 6.75, 3, 14, 8, 13),
            Block.box(13, 15, 2, 15, 16, 14),
            Block.box(2.5, 8, 2.25, 14.5, 8.5, 13.75),
            Block.box(3.25, 0, 11.5, 5, 8, 13.25),
            Block.box(3.25, 0, 2.75, 5, 8, 4.5),
            Block.box(13.25, 0, 2.75, 15, 15, 4.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(11.5, 0, 1, 13.25, 15, 2.75),
            Block.box(3, 6.75, 2, 13, 8, 12.5),
            Block.box(2, 15, 1, 14, 16, 3),
            Block.box(2.25, 8, 1.5, 13.75, 8.5, 13.5),
            Block.box(11.5, 0, 11, 13.25, 8, 12.75),
            Block.box(2.75, 0, 11, 4.5, 8, 12.75),
            Block.box(2.75, 0, 1, 4.5, 15, 2.75)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(1, 0, 2.75, 2.75, 15, 4.5),
            Block.box(2, 6.75, 3, 12.5, 8, 13),
            Block.box(1, 15, 2, 3, 16, 14),
            Block.box(1.5, 8, 2.25, 13.5, 8.5, 13.75),
            Block.box(11, 0, 2.75, 12.75, 8, 4.5),
            Block.box(11, 0, 11.5, 12.75, 8, 13.25),
            Block.box(1, 0, 11.5, 2.75, 15, 13.25)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)){
            case WEST -> SHAPE_W;
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()){
            return SeatEntity.create(pLevel, pPos, 0.4, pPlayer, pState.getValue(FACING));
        }
        return InteractionResult.SUCCESS;
    }
}
