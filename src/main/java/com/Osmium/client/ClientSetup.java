package com.Osmium.client;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.regi.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Osmiumsmagic.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.FIRE_LANCE, );
    }
}
