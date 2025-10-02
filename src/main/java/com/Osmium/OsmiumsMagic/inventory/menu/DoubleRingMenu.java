package com.Osmium.OsmiumsMagic.inventory.menu;

import com.Osmium.OsmiumsMagic.regi.ModItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class DoubleRingMenu extends AbstractContainerMenu {
    private final ItemStackHandler handler;

    public DoubleRingMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        super(ModMenuTypes.DOUBLE_RING_MENU.get(), id);
        this.handler = new ItemStackHandler(2);
        this.addSlot(new SlotItemHandler(handler, 0,71,20));
        this.addSlot(new SlotItemHandler(handler, 1,89,20));

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            itemstack = stackInSlot.copy();

            int containerSlots = 2; // DoubleRingMenu のスロット数

            if (index < containerSlots) {
                // GUI側のスロット → プレイヤーインベントリへ
                if (!this.moveItemStackTo(stackInSlot, containerSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // プレイヤーインベントリ → GUI側へ
                if (!this.moveItemStackTo(stackInSlot, 0, containerSlots, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stackInSlot.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return player.getMainHandItem().is(ModItems.DOUBLE_RING.get());
    }
}
