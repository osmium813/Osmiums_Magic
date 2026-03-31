package com.Osmium.OsmiumsMagic.regi;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.gui.reinforcementtable.ReinforcementTableMenu;
import com.Osmium.OsmiumsMagic.gui.synthesis_table.SynthesisTableMenu;
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

    public static final RegistryObject<MenuType<ReinforcementTableMenu>> REINFORCEMENT_TABLE_MANU =
            registerMenuType("reinforcement_table_menu", ReinforcementTableMenu::new);
    public static final RegistryObject<MenuType<SynthesisTableMenu>> SYNTHESIS_TABLE_MANU =
            registerMenuType("synthesis_table_menu", SynthesisTableMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
