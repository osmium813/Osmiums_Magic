package com.Osmium.OsmiumsMagic.gui.synthesis_table;

import com.Osmium.OsmiumsMagic.entity.block.SynthesisTableBlockEntity;
import com.Osmium.OsmiumsMagic.regi.ModBlocks;
import com.Osmium.OsmiumsMagic.regi.ModMenuTypes;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class SynthesisTableMenu extends AbstractContainerMenu {
    public final SynthesisTableBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public SynthesisTableMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public class InputSlot extends SlotItemHandler {
        public InputSlot(IItemHandler handler, int index, int x, int y) {
            super(handler, index, x, y);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return true;
        }
    }

    public SynthesisTableMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.SYNTHESIS_TABLE_MANU.get(), pContainerId);
        checkContainerSize(inv, 2);
        blockEntity = ((SynthesisTableBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 0, 12,12));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 1, 40,6));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 2, 69,12));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 3, 7,35));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 4, 29,35));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 5, 51,35));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 6, 74,35));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 7, 12,58));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 8, 40,64));
            this.addSlot(new SynthesisTableMenu.InputSlot(iItemHandler, 9, 69,58));

            this.addSlot(new SlotItemHandler(iItemHandler, 10, 126,35) {
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false;
                }
            });
            this.addSlot(new SlotItemHandler(iItemHandler, 11, 134,64){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return stack.getItem() == ItemRegistry.ARCANE_ESSENCE.get();
                }
            });
        });

        this.addDataSlots(data);
    }


    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUM_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUM_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int TE_INVENTORY_SLOT_COUNT = 12;

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = slots.get(index);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copy = sourceStack.copy();

        // プレイヤー → ブロック
        if (index < VANILLA_SLOT_COUNT) {

            // エッセンスなら専用スロットへ
            if (sourceStack.getItem() == ItemRegistry.ARCANE_ESSENCE.get()) {
                if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX + 10,
                        TE_INVENTORY_FIRST_SLOT_INDEX + 12, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // 入力スロット(0〜8)のみに入れる
                if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX,
                        TE_INVENTORY_FIRST_SLOT_INDEX + 10, false)) {
                    return ItemStack.EMPTY;
                }
            }

        }
        // ブロック → プレイヤー
        else {
            if (!moveItemStackTo(sourceStack, 0, VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(player, sourceStack);
        return copy;
    }
    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.SYNTHESIS_TABLE.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public SynthesisTableBlockEntity getBlockEntity() {
        return blockEntity;
    }

    public int getEssenceCount() {
        return data.get(0); // ← クライアントでも常に同期された値を取得できる
    }

    public int getMaxEssenceCount() {
        return data.get(1);
    }

    public int getProgress() {
        return data.get(2);
    }

    public int getMaxProgress() {
        return data.get(3);
    }
}
