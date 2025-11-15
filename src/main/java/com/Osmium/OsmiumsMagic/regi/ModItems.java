package com.Osmium.OsmiumsMagic.regi;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.curios.DoubleAttributeCurio;
import com.Osmium.OsmiumsMagic.curios.TripleAttributeCurio;
import com.Osmium.OsmiumsMagic.rarity.ModRarity;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.curios.SimpleAttributeCurio;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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

    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_ONE = ITEMS.register("mana_ring_tier_one", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.COMMON), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 200, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_TWO = ITEMS.register("mana_ring_tier_two", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 300, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_THREE = ITEMS.register("mana_ring_tier_three", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.RARE), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 400, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_FOUR = ITEMS.register("mana_ring_tier_four", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 500, AttributeModifier.Operation.ADDITION)));
    public static final RegistryObject<CurioBaseItem> MANA_RING_TIER_FIVE = ITEMS.register("mana_ring_tier_five", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(ModRarity.LEGENDARY), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 600, AttributeModifier.Operation.ADDITION)));

    public static final RegistryObject<CurioBaseItem> COOLDOWN_RING_TIER_ONE = ITEMS.register("cooldown_ring_tier_one", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.COMMON), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.2, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_RING_TIER_TWO = ITEMS.register("cooldown_ring_tier_two", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.25, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_RING_TIER_THREE = ITEMS.register("cooldown_ring_tier_three", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.RARE), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.3, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_RING_TIER_FOUR = ITEMS.register("cooldown_ring_tier_four", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.35, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_RING_TIER_FIVE = ITEMS.register("cooldown_ring_tier_five", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(ModRarity.LEGENDARY), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.4, AttributeModifier.Operation.MULTIPLY_BASE)));

    public static final RegistryObject<CurioBaseItem> CAST_TIME_RING_TIER_ONE = ITEMS.register("cast_time_ring_tier_one", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.COMMON), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.2, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> CAST_TIME_RING_TIER_TWO = ITEMS.register("cast_time_ring_tier_two", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.25, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> CAST_TIME_RING_TIER_THREE = ITEMS.register("cast_time_ring_tier_three", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.RARE), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.3, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> CAST_TIME_RING_TIER_FOUR = ITEMS.register("cast_time_ring_tier_four", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.35, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> CAST_TIME_RING_TIER_FIVE = ITEMS.register("cast_time_ring_tier_five", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(ModRarity.LEGENDARY), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.4, AttributeModifier.Operation.MULTIPLY_BASE)));

    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_RING = ITEMS.register("mana_cooldown_ring", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 100, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.15, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_RING_TIER_ONE = ITEMS.register("mana_cooldown_ring_tier_one", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.COMMON), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 200, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.2, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_RING_TIER_TWO = ITEMS.register("mana_cooldown_ring_tier_two", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 300, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.25, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_RING_TIER_THREE = ITEMS.register("mana_cooldown_ring_tier_three", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.RARE), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 400, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.3, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_RING_TIER_FOUR = ITEMS.register("mana_cooldown_ring_tier_four", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 500, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.35, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_RING_TIER_FIVE = ITEMS.register("mana_cooldown_ring_tier_five", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(ModRarity.LEGENDARY), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 600, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.4, AttributeModifier.Operation.MULTIPLY_BASE)));

    public static final RegistryObject<CurioBaseItem> MANA_CAST_TIME_RING = ITEMS.register("mana_cast_time_ring", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 100, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.15, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_CAST_TIME_RING_TIER_ONE = ITEMS.register("mana_cast_time_ring_tier_one", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.COMMON), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 200, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.2, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_CAST_TIME_RING_TIER_TWO = ITEMS.register("mana_cast_time_ring_tier_two", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 300, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.25, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_CAST_TIME_RING_TIER_THREE = ITEMS.register("mana_cast_time_ring_tier_three", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.RARE), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 400, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.3, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_CAST_TIME_RING_TIER_FOUR = ITEMS.register("mana_cast_time_ring_tier_four", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 500, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.35, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> MANA_CAST_TIME_RING_TIER_FIVE = ITEMS.register("mana_cast_time_ring_tier_five", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(ModRarity.LEGENDARY), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 600, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.4, AttributeModifier.Operation.MULTIPLY_BASE)));

    public static final RegistryObject<CurioBaseItem> COOLDOWN_CAST_TIME_RING = ITEMS.register("cooldown_cast_time_ring", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.15, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.15, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_CAST_TIME_RING_TIER_ONE = ITEMS.register("cooldown_cast_time_ring_tier_one", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.COMMON), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.2, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.2, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_CAST_TIME_RING_TIER_TWO = ITEMS.register("cooldown_cast_time_ring_tier_two", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.25, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.25, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_CAST_TIME_RING_TIER_THREE = ITEMS.register("cooldown_cast_time_ring_tier_three", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.RARE), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.3, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.3, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_CAST_TIME_RING_TIER_FOUR = ITEMS.register("cooldown_cast_time_ring_tier_four", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.35, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.35, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final RegistryObject<CurioBaseItem> COOLDOWN_CAST_TIME_RING_TIER_FIVE = ITEMS.register("cooldown_cast_time_ring_tier_five", () -> new DoubleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(ModRarity.LEGENDARY), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.4, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.CAST_TIME_REDUCTION.get(),  new AttributeModifier("ct", 0.4, AttributeModifier.Operation.MULTIPLY_BASE)));

    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_CAST_TIME_RING = ITEMS.register("mana_cooldown_cast_time_ring", () -> new TripleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 100, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.15, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.15, AttributeModifier.Operation.MULTIPLY_BASE))
    );
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_CAST_TIME_RING_TIER_ONE = ITEMS.register("mana_cooldown_cast_time_ring_tier_one", () -> new TripleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.COMMON), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 200, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.2, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.2, AttributeModifier.Operation.MULTIPLY_BASE))
    );
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_CAST_TIME_RING_TIER_TWO = ITEMS.register("mana_cooldown_cast_time_ring_tier_two", () -> new TripleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 300, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.25, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.25, AttributeModifier.Operation.MULTIPLY_BASE))
    );
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_CAST_TIME_RING_TIER_THREE = ITEMS.register("mana_cooldown_cast_time_ring_tier_three", () -> new TripleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.RARE), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 400, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.3, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.3, AttributeModifier.Operation.MULTIPLY_BASE))
    );
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_CAST_TIME_RING_TIER_FOUR = ITEMS.register("mana_cooldown_cast_time_ring_tier_four", () -> new TripleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 500, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.35, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.35, AttributeModifier.Operation.MULTIPLY_BASE))
    );
    public static final RegistryObject<CurioBaseItem> MANA_COOLDOWN_CAST_TIME_RING_TIER_FIVE = ITEMS.register("mana_cooldown_cast_time_ring_tier_five", () -> new TripleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1).rarity(ModRarity.LEGENDARY), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 600, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.COOLDOWN_REDUCTION.get(),  new AttributeModifier("cd", 0.4, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.4, AttributeModifier.Operation.MULTIPLY_BASE))
    );

    public static final RegistryObject<Item> MANA_INGOT = ITEMS.register("mana_ingot", () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));
    public static final RegistryObject<Item> MANA_SHARD = ITEMS.register("mana_shard", () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));


}
