package com.besson.arknights.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SeatEntity extends Entity {
    public SeatEntity(Level pLevel) {
        super(ModBlockEntities.SEAT.get(), pLevel);
        this.blocksBuilding = true;
    }
    private SeatEntity(Level pLevel, BlockPos pPos, double yOffset, Direction pDirection) {
        this(pLevel);
        this.setPos(pPos.getX() + 0.5, pPos.getY() + yOffset, pPos.getZ() + 0.5);
        this.setRot(pDirection.toYRot(), 0);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()){
            if (this.getPassengers().isEmpty() || this.level().isEmptyBlock(this.blockPosition())) {
                this.remove(RemovalReason.DISCARDED);
                this.level().updateNeighbourForOutputSignal(this.blockPosition(), this.level().getBlockState(this.blockPosition()).getBlock());
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        return 0.0;
    }

    @Override
    protected boolean canRide(Entity pVehicle) {
        return true;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return super.getAddEntityPacket();
    }

    public static InteractionResult create(Level pLevel, BlockPos pPos, double yOffset, Player pPlayer, Direction pDirection) {
        if (!pLevel.isClientSide()) {
            List<SeatEntity> seats = pLevel.getEntitiesOfClass(
                    SeatEntity.class, new AABB(pPos.getX(), pPos.getY(), pPos.getZ(), pPos.getX() + 1, pPos.getY() + 1, pPos.getZ() + 1));

            if (seats.isEmpty()) {
                SeatEntity seat = new SeatEntity(pLevel, pPos, yOffset, pDirection);
                pLevel.addFreshEntity(seat);
                pPlayer.startRiding(seat,false);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pPassenger) {
        Direction direction = this.getMotionDirection();
        Direction[] offsets = {direction, direction.getClockWise(), direction.getCounterClockWise(), direction.getOpposite()};
        for (Direction dir : offsets) {
            Vec3 vec3 = DismountHelper.findSafeDismountLocation(pPassenger.getType(), this.level(), this.blockPosition().relative(dir), false);
            if (vec3 != null) {
                return vec3.add(0, 0.25, 0);
            }
        }
        return super.getDismountLocationForPassenger(pPassenger);
    }

    @Override
    protected void addPassenger(Entity pPassenger) {
        super.addPassenger(pPassenger);
        pPassenger.setYRot(this.getYRot());
    }

    @Override
    protected void positionRider(Entity pPassenger, MoveFunction pCallback) {
        super.positionRider(pPassenger, pCallback);
        this.clampYaw(pPassenger);
    }

    private void clampYaw(Entity passenger){
        passenger.setYBodyRot(this.getYRot());
        float wrappedYaw = Mth.wrapDegrees(passenger.getYRot() - this.getYRot());
        float clampedYaw = Mth.clamp(wrappedYaw, -120.0F, 120.0F);
        passenger.yRotO += clampedYaw - wrappedYaw;
        passenger.setYRot(passenger.getYRot() + clampedYaw - wrappedYaw);
        passenger.setYHeadRot(passenger.getYRot());
    }
}
