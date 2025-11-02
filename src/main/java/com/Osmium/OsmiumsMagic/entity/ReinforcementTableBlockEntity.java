package com.Osmium.OsmiumsMagic.entity;

import com.Osmium.OsmiumsMagic.gui.reinforcementtable.ReinforcementTableMenu;
import com.Osmium.OsmiumsMagic.recipe.ReinforcementRecipe;
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

    private final ItemStackHandler itemHandler = new ItemStackHandler(11){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            if (slot == 10) {
                return stack.getItem() == ItemRegistry.ARCANE_ESSENCE.get();
            }
            return true;
        }
    };

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
    private int progress = 0;
    private int maxProgress;

    public ReinforcementTableBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.REINFORCEMENT_TABLE_BE.get(), p_155229_, p_155230_);

        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> ReinforcementTableBlockEntity.this.essencecount;
                    case 1 -> ReinforcementTableBlockEntity.this.maxEssenceCount;
                    case 2 -> ReinforcementTableBlockEntity.this.progress;
                    case 3 -> ReinforcementTableBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> ReinforcementTableBlockEntity.this.essencecount = pValue;
                    case 1 -> ReinforcementTableBlockEntity.this.maxEssenceCount = pValue;
                    case 2 -> ReinforcementTableBlockEntity.this.progress = pValue;
                    case 3 -> ReinforcementTableBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 4;
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
        tag.putInt("alloy_smelter.progress", progress);

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        essencecount = tag.getInt("reinforcement_table.essencecount");
        progress = tag.getInt("alloy_smelter.progress");
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (hasRecipe()) {
            setMaxProgress();
            increaseCraftingProgress();

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
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
        if (level == null) return false;

        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }

        return level.getRecipeManager()
                .getAllRecipesFor(ReinforcementRecipe.Type.INSTANCE)
                .stream()
                .anyMatch(recipe -> recipe.matches(inv, level)
                        && essencecount >= recipe.getEssenceCost());
    }

    private void craftItem() {
        if (level == null) return;

        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }

        var optionalRecipe = level.getRecipeManager()
                .getAllRecipesFor(ReinforcementRecipe.Type.INSTANCE)
                .stream()
                .filter(recipe -> recipe.matches(inv, level))
                .findFirst();

        if (optionalRecipe.isEmpty()) return;

        ReinforcementRecipe recipe = optionalRecipe.get();

        if (essencecount < recipe.getEssenceCost()) return;

        // 完成品のセット
        ItemStack result = recipe.getResultItem(level.registryAccess()).copy();
        itemHandler.setStackInSlot(OUTPUT_SLOT, result);

        // 消費処理
        essencecount -= recipe.getEssenceCost();

        // 素材の消費（1個ずつ）
        for (int i = 0; i < 9; i++) {
            itemHandler.getStackInSlot(i).shrink(1);
        }

        setChanged();
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

    private void resetProgress() {
        progress = 0;
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private void setMaxProgress() {
        if (level == null) return;

        // 現在のスロットの内容をSimpleContainerに詰める
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }

        // レシピマネージャーから現在の入力にマッチするレシピを探す
        var optionalRecipe = level.getRecipeManager()
                .getAllRecipesFor(ReinforcementRecipe.Type.INSTANCE)
                .stream()
                .filter(recipe -> recipe.matches(inv, level))
                .findFirst();

        // レシピが見つかったら、そのクラフト時間をmaxProgressに設定
        if (optionalRecipe.isPresent()) {
            ReinforcementRecipe recipe = optionalRecipe.get();
            this.maxProgress = recipe.getCraftTime(); // ← JSONの"craft_time"がここに反映される！
        } else {
            this.maxProgress = 0; // 該当レシピがなければ0にリセット
        }
    }
}
