package com.Osmium.OsmiumsMagic.inventory.menu;

import com.Osmium.OsmiumsMagic.regi.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.common.inventory.DynamicStackHandler;

public class DoubleRingMenu extends AbstractContainerMenu {

    private final DynamicStackHandler handler;
    private final ItemStack ringItem; // DoubleRingアイテム

    public DoubleRingMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        super(ModMenuTypes.DOUBLE_RING_MENU.get(), id);

        this.ringItem = inventory.player.getMainHandItem(); // もしくは offHandItem()

        // --- NBTからロード ---
        this.handler = new DynamicStackHandler(2, index -> new SlotContext("ring", inventory.player, index, false, false));
        CompoundTag tag = ringItem.getOrCreateTag();
        if (tag.contains("DoubleRingInv")) {
            handler.deserializeNBT(tag.getCompound("DoubleRingInv"));
        }

        // --- GUIスロット追加 ---
        this.addSlot(new SlotItemHandler(handler, 0, 71, 20));
        this.addSlot(new SlotItemHandler(handler, 1, 89, 20));

        // --- プレイヤーインベントリ ---
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inventory, col + row * 9 + 9, 8 + col * 18, 51 + row * 18));
            }
        }
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inventory, col, 8 + col * 18, 109));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return player.getMainHandItem().is(ModItems.DOUBLE_RING.get());
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        // --- GUIを閉じたときにNBTへ保存 ---
        CompoundTag tag = ringItem.getOrCreateTag();
        tag.put("DoubleRingInv", handler.serializeNBT());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            itemstack = stackInSlot.copy();

            int containerSlots = 2; // GUI側スロット数

            if (index < containerSlots) {
                if (!this.moveItemStackTo(stackInSlot, containerSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
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

    public IItemHandlerModifiable getHandler() {
        return handler;
    }
}
