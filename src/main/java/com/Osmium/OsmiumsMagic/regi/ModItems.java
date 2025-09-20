package com.Osmium.OsmiumsMagic.regi;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.curios.SimpleAttributeCurio;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Osmiumsmagic.MOD_ID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_ONE = ITEMS.register("mana_ring_tier_one", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 200, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_TWO = ITEMS.register("mana_ring_tier_two", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 300, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_THREE = ITEMS.register("mana_ring_tier_three", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 400, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_FOUR = ITEMS.register("mana_ring_tier_four", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 500, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_FIVE = ITEMS.register("mana_ring_tier_five", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 600, AttributeModifier.Operation.ADDITION)));

}
