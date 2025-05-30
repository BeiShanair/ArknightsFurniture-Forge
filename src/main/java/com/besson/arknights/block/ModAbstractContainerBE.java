package com.besson.arknights.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class ModAbstractContainerBE extends RandomizableContainerBlockEntity {
    protected NonNullList<ItemStack> inv = createInventory();

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter(){

        @Override
        protected void onOpen(Level pLevel, BlockPos pPos, BlockState pState) {
            playSound(pLevel, pPos, pState, SoundEvents.CHEST_OPEN);
        }

        @Override
        protected void onClose(Level pLevel, BlockPos pPos, BlockState pState) {
            playSound(pLevel, pPos, pState, SoundEvents.CHEST_CLOSE);
        }

        @Override
        protected void openerCountChanged(Level pLevel, BlockPos pPos, BlockState pState, int pCount, int pOpenCount) {
            pLevel.blockEvent(pPos, pState.getBlock(), 1, pOpenCount);
        }

        @Override
        protected boolean isOwnContainer(Player pPlayer) {
            if (!(pPlayer.containerMenu instanceof ChestMenu)) {
                return false;
            } else {
                Container container = ((ChestMenu)pPlayer.containerMenu).getContainer();
                return container == ModAbstractContainerBE.this;
            }
        }
    };
    protected ModAbstractContainerBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public NonNullList<ItemStack> createInventory() {
        return NonNullList.withSize(27, ItemStack.EMPTY);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.inv;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItemStacks) {
        this.inv = pItemStacks;
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new ChestMenu(MenuType.GENERIC_9x3, pContainerId, pInventory, this, 3);
    }

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
    public void startOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.incrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.decrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
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

    static void playSound(Level pLevel, BlockPos pPos, BlockState pState, SoundEvent pSound) {
        double d0 = (double)pPos.getX() + 0.5D;
        double d1 = (double)pPos.getY() + 0.5D;
        double d2 = (double)pPos.getZ() + 0.5D;
        pLevel.playSound((Player)null, d0, d1, d2, pSound, SoundSource.BLOCKS, 0.5F, pLevel.random.nextFloat() * 0.1F + 0.9F);
    }
}
