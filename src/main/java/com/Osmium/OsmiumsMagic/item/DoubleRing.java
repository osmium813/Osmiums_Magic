package com.Osmium.OsmiumsMagic.item;

import com.Osmium.OsmiumsMagic.inventory.menu.DoubleRingMenu;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class DoubleRing extends CurioBaseItem {
    public DoubleRing() {
        super(new Properties().rarity(Rarity.COMMON).stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            NetworkHooks.openScreen((ServerPlayer) player, new SimpleMenuProvider(
                    (id, inventory, p) -> new DoubleRingMenu(id, inventory, null),
                    Component.translatable("screen.osmiumsmagic.double_ring")
            ));
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
