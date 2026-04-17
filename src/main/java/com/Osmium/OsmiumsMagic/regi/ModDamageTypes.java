package com.Osmium.OsmiumsMagic.regi;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {

    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE,
                new ResourceLocation(Osmiumsmagic.MOD_ID, name));
    }

    public static final ResourceKey<DamageType> CURSE_MAGIC = register("curse_magic");

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(CURSE_MAGIC,
                new DamageType("curse_magic",
                        DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0f));
    }
}
