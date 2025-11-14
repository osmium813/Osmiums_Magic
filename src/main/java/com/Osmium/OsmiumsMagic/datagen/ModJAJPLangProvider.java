package com.Osmium.OsmiumsMagic.datagen;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.regi.ModBlocks;
import com.Osmium.OsmiumsMagic.regi.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModJAJPLangProvider extends LanguageProvider {
    public ModJAJPLangProvider(PackOutput output, String locale) {
        super(output, Osmiumsmagic.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.osmium_magic_items", "Osmium's Magic アイテム");
        add("itemGroup.osmium_magic_ornaments", "Osmium's Magic 装飾品");
        add("itemGroup.osmium_magic_blocks", "Osmium's Magic ブロック");

        addItem(ModItems.MANA_INGOT, "マナインゴット");

        addItem(ModItems.MANA_RING_TIER_ONE, "マナのリング(Tier　Ⅰ)");
        addItem(ModItems.MANA_RING_TIER_TWO, "マナのリング(Tier Ⅱ)");
        addItem(ModItems.MANA_RING_TIER_THREE, "マナのリング(Tier Ⅲ)");
        addItem(ModItems.MANA_RING_TIER_FOUR, "マナのリング(Tier Ⅳ)");
        addItem(ModItems.MANA_RING_TIER_FIVE, "マナのリング(Tier Ⅴ)");

        addItem(ModItems.COOLDOWN_RING_TIER_ONE, "回復のリング(Tier Ⅰ)");
        addItem(ModItems.COOLDOWN_RING_TIER_TWO, "回復のリング(Tier Ⅱ)");
        addItem(ModItems.COOLDOWN_RING_TIER_THREE, "回復のリング(Tier Ⅲ)");
        addItem(ModItems.COOLDOWN_RING_TIER_FOUR, "回復のリング(Tier Ⅳ)");
        addItem(ModItems.COOLDOWN_RING_TIER_FIVE, "回復のリング(Tier Ⅴ)");

        addItem(ModItems.CAST_TIME_RING_TIER_ONE, "利便のリング(Tier Ⅰ)");
        addItem(ModItems.CAST_TIME_RING_TIER_TWO, "利便のリング(Tier Ⅱ)");
        addItem(ModItems.CAST_TIME_RING_TIER_THREE, "利便のリング(Tier Ⅲ)");
        addItem(ModItems.CAST_TIME_RING_TIER_FOUR, "利便のリング(Tier Ⅳ)");
        addItem(ModItems.CAST_TIME_RING_TIER_FIVE, "利便のリング(Tier Ⅴ)");

        addItem(ModItems.MANA_COOLDOWN_RING, "マナと回復のリング");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_ONE, "マナと回復のリング(Tier Ⅰ)");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_TWO, "マナと回復のリング(Tier Ⅱ)");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_THREE, "マナと回復のリング(Tier Ⅲ)");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_FOUR, "マナと回復のリング(Tier Ⅳ)");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_FIVE, "マナと回復のリング(Tier Ⅴ)");

        addItem(ModItems.MANA_CAST_TIME_RING, "マナと利便のリング");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_ONE, "マナと利便のリング(Tier Ⅰ)");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_TWO, "マナと利便のリング(Tier Ⅱ)");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_THREE, "マナと利便のリング(Tier Ⅲ)");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_FOUR, "マナと利便のリング(Tier Ⅳ)");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_FIVE, "マナと利便のリング(Tier Ⅴ)");

        addItem(ModItems.COOLDOWN_CAST_TIME_RING, "回復と利便のリング");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_ONE, "回復と利便のリング(Tier Ⅰ)");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_TWO, "回復と利便のリング(Tier Ⅱ)");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_THREE, "回復と利便のリング(Tier Ⅲ)");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_FOUR, "回復と利便のリング(Tier Ⅳ)");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_FIVE, "回復と利便のリング(Tier Ⅴ)");
        
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING, "マナと回復と利便のリング");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_ONE, "マナと回復と利便のリング(Tier Ⅰ)");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_TWO, "マナと回復と利便のリング(Tier Ⅱ)");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_THREE, "マナと回復と利便のリング(Tier Ⅲ)");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_FOUR, "マナと回復と利便のリング(Tier Ⅳ)");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_FIVE, "マナと回復と利便のリング(Tier Ⅴ)");

        addBlock(ModBlocks.REINFORCEMENT_TABLE, "強化台");
    }
}
