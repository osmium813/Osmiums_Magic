package com.Osmium.OsmiumsMagic.regi;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.projectile.spell.firelance.FireLanceProjectile;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Osmiumsmagic.MOD_ID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    public static final RegistryObject<EntityType<FireLanceProjectile>> FIRE_LANCE =
            ENTITIES.register("fire_lance", () -> EntityType.Builder.<FireLanceProjectile>of(FireLanceProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(new ResourceLocation(Osmiumsmagic.MOD_ID, "fire_lance").toString()));
}
