package com.besson.arknights.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class FireExtinguisher extends Item {

    public FireExtinguisher(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        if (!world.isClientSide()) {
            BlockHitResult hitResult = rayCast(world, user, 5.0D);
            if (hitResult != null) {
                BlockPos pos = hitResult.getBlockPos();
                if (world.getBlockState(pos).is(Blocks.FIRE)) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                }
            }
        } else {
            double sideOffset = 0.5; // 侧向偏移，右手为正，左手为负
            double downOffset = 0.4; // 向下偏移
            Vec3 look = user.getViewVector(1.0F);
            Vec3 up = new Vec3(0, 1, 0);
            Vec3 right = look.cross(up).normalize().scale(sideOffset);

            double dx = user.getX() + look.x * 1.2 + right.x;
            double dy = user.getEyeY() - downOffset;
            double dz = user.getZ() + look.z * 1.2 + right.z;

            for (int i = 0; i < 20; i++) {
                double vx = look.x * 0.3 + (world.random.nextDouble() - 0.5) * 0.1;
                double vy = look.y * 0.3 + (world.random.nextDouble() - 0.5) * 0.1;
                double vz = look.z * 0.3 + (world.random.nextDouble() - 0.5) * 0.1;
                world.addParticle(ParticleTypes.POOF, dx, dy, dz, vx, vy, vz);
            }
        }
        return InteractionResultHolder.success(user.getItemInHand(hand));
    }

    private BlockHitResult rayCast(Level world, Player user, double distance) {
        return (BlockHitResult) user.pick(distance, 1.0F, false);
    }
}
