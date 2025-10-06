package com.Osmium.OsmiumsMagic.handler;

import com.Osmium.OsmiumsMagic.regi.tab.ModTags;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class DuplicationRingHandler extends ItemStackHandler {

    public DuplicationRingHandler(int size){
        super(size);
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        return stack.is(ModTags.Items.RINGS);
    }
}
