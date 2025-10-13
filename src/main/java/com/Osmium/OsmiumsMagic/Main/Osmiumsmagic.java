package com.Osmium.OsmiumsMagic.Main;

import com.Osmium.OsmiumsMagic.regi.ModMenuTypes;
import com.Osmium.OsmiumsMagic.regi.ModBlocks;
import com.Osmium.OsmiumsMagic.regi.ModItems;
import com.Osmium.OsmiumsMagic.regi.tab.OsmiumsmagicTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("osmiumsmagic")
public class Osmiumsmagic {

    public static final String MOD_ID = "osmiumsmagic";

    public Osmiumsmagic() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(bus);
        ModBlocks.register(bus);

        OsmiumsmagicTabs.MOD_TABS.register(bus);

        ModMenuTypes.resister(bus);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
