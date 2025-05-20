package com.besson.arknights.block.warehouse;

import com.besson.arknights.block.ModAbstractContainerBE;
import com.besson.arknights.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LargeShelfBE extends ModAbstractContainerBE {
    protected LargeShelfBE(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public LargeShelfBE(BlockPos pos, BlockState state) {
        this(ModBlockEntities.LARGE_SHELF.get(), pos, state);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.large_shelf");
    }
    @Override
    public NonNullList<ItemStack> createInventory() {
        return NonNullList.withSize(9, ItemStack.EMPTY);
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new ChestMenu(MenuType.GENERIC_9x1, pContainerId, pInventory, this, 1);
    }

    @Override
    public int getContainerSize() {
        return 9;
    }
}
