package com.Osmium.OsmiumsMagic.inventory.menu;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Osmiumsmagic.MOD_ID);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> resisterMenuTypes(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void resister(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
