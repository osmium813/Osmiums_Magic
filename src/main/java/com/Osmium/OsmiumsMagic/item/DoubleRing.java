package com.Osmium.OsmiumsMagic.item;

import com.Osmium.OsmiumsMagic.inventory.menu.DoubleRingMenu;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.Nullable;

public class DoubleRing extends CurioBaseItem implements MenuProvider {
    public DoubleRing() {
        super(new Properties().rarity(Rarity.COMMON).stacksTo(1));
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("container.osmiumsmagic.double_ring");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new DoubleRingMenu(id, inv);
    }
}
