package com.Osmium.OsmiumsMagic.regi;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.regi.tab.ModTags;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModSchoolRegistry {

    public static final DeferredRegister<SchoolType> SCHOOLS =
            DeferredRegister.create(SchoolRegistry.SCHOOL_REGISTRY_KEY, Osmiumsmagic.MOD_ID);

    public static final RegistryObject<SchoolType> CURSE = SCHOOLS.register("curse", () ->
            new SchoolType(
                    new ResourceLocation(Osmiumsmagic.MOD_ID, "curse"),
                    ModTags.Items.RINGS,
                    Component.translatable("school.osmiumsmagic.curse")
                            .withStyle(ChatFormatting.GRAY),

                    LazyOptional.of(ModAttributes.CURSE_SPELL_POWER::get),
                    LazyOptional.of(ModAttributes.CURSE_MAGIC_RESIST::get),

                    LazyOptional.of(SoundRegistry.ENDER_CAST::get),
                    ModDamageTypes.CURSE_MAGIC
            ));

    public static void register(IEventBus bus) {
        ;SCHOOLS.register(bus);
    }
}
