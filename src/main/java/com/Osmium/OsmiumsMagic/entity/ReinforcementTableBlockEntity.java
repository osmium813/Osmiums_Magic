package com.Osmium.OsmiumsMagic.entity;

import com.Osmium.OsmiumsMagic.gui.reinforcementtable.ReinforcementTableMenu;
import com.Osmium.OsmiumsMagic.regi.ModBlockEntities;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReinforcementTableBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(11);

    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;
    private static final int INPUT_SLOT_4 = 3;
    private static final int INPUT_SLOT_5 = 4;
    private static final int INPUT_SLOT_6 = 5;
    private static final int INPUT_SLOT_7 = 6;
    private static final int INPUT_SLOT_8 = 7;
    private static final int INPUT_SLOT_9 = 8;
    private static final int OUTPUT_SLOT = 9;
    private static final int INPUT_ESSENCE_SLOT = 10;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private ContainerData data;
    public int essencecount = 0;
    private int maxEssenceCount = 16;
    private int tickCounter = 0;

    public ReinforcementTableBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.REINFORCEMENT_TABLE_BE.get(), p_155229_, p_155230_);

        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> ReinforcementTableBlockEntity.this.essencecount;
                    case 1 -> ReinforcementTableBlockEntity.this.maxEssenceCount;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> ReinforcementTableBlockEntity.this.essencecount = pValue;
                    case 1 -> ReinforcementTableBlockEntity.this.maxEssenceCount = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i ++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.osmiumsmagic.reinforcement_table");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new ReinforcementTableMenu(containerId, playerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("reinforcement_table.essencecount", essencecount);

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        essencecount = tag.getInt("reinforcement_table.essencecount");
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (hasRecipe()) {
            craftItem();
        }

        tickCounter++;
        if (tickCounter >= 20) {
            tickCounter = 0;
            if (essencecount < maxEssenceCount) {
                if (hasEssence()) {
                    reduceEssence();
                    increaseEssenceCount();
                }
            }
        }
    }

    private boolean hasRecipe() {
        return false;
    }

    private void craftItem() {
        
    }

    private boolean hasEssence() {
        ItemStack stack = itemHandler.getStackInSlot(INPUT_ESSENCE_SLOT);
        return !stack.isEmpty() && stack.getItem() == ItemRegistry.ARCANE_ESSENCE.get();
    }

    private void reduceEssence(){
        ItemStack stack = itemHandler.getStackInSlot(INPUT_ESSENCE_SLOT);
        stack.shrink(1);
        itemHandler.setStackInSlot(INPUT_ESSENCE_SLOT, stack);
    }

    private void increaseEssenceCount() {
        essencecount++;
    }
}
