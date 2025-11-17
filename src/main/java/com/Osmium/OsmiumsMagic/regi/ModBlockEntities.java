package com.Osmium.OsmiumsMagic.regi;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.entity.block.ReinforcementTableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Osmiumsmagic.MOD_ID);

    public static final RegistryObject<BlockEntityType<ReinforcementTableBlockEntity>> REINFORCEMENT_TABLE_BE =
            BLOCK_ENTITIES.register("reinforcement_table_be", () ->
                    BlockEntityType.Builder.of(ReinforcementTableBlockEntity::new,
                            ModBlocks.REINFORCEMENT_TABLE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
