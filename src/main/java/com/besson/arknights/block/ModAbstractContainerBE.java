package com.besson.arknights.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class ModAbstractContainerBE extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> inv = createInventory();
    protected ModAbstractContainerBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return ChestMenu.oneRow(pContainerId, pInventory);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.inv;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItemStacks) {
        this.inv = pItemStacks;
    }

    public NonNullList<ItemStack> createInventory() {
        return NonNullList.withSize(27, ItemStack.EMPTY);
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.inv = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.loadAllItems(pTag, this.inv);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.saveAllItems(pTag, this.inv);
        }
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null && !this.level.isClientSide()){
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

    @Override
    public void setItem(int pIndex, ItemStack pStack) {
        super.setItem(pIndex, pStack);
        this.setChanged();
    }

    @Override
    public ItemStack removeItem(int pIndex, int pCount) {
        ItemStack result = super.removeItem(pIndex, pCount);
        this.setChanged();
        return result;
    }

    @Override
    public ItemStack removeItemNoUpdate(int pIndex) {
        ItemStack result = super.removeItemNoUpdate(pIndex);
        this.setChanged();
        return result;
    }

    @Override
    public void clearContent() {
        super.clearContent();
        this.setChanged();
    }
}
