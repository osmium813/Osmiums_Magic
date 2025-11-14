package com.Osmium.OsmiumsMagic.datagen;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.regi.ModBlocks;
import com.Osmium.OsmiumsMagic.regi.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput output, String locale) {
        super(output, Osmiumsmagic.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.osmium_magic_items", "Osmium's Magic Items");
        add("itemGroup.osmium_magic_ornaments", "Osmium's Magic Ornaments");
        add("itemGroup.osmium_magic_blocks", "Osmium's Magic Blocks");

        addItem(ModItems.MANA_INGOT, "Mana Ingot");
        addItem(ModItems.MANA_CRYSTAR, "Mana Crystar");

        addItem(ModItems.MANA_RING_TIER_ONE, "Ring of Mana(Tier Ⅰ)");
        addItem(ModItems.MANA_RING_TIER_TWO, "Ring of Mana(Tier Ⅱ)");
        addItem(ModItems.MANA_RING_TIER_THREE, "Ring of Mana(Tier Ⅲ)");
        addItem(ModItems.MANA_RING_TIER_FOUR, "Ring of Mana(Tier Ⅳ)");
        addItem(ModItems.MANA_RING_TIER_FIVE, "Ring of Mana(Tier Ⅴ)");

        addItem(ModItems.COOLDOWN_RING_TIER_ONE, "Ring of Recovery(Tier Ⅰ)");
        addItem(ModItems.COOLDOWN_RING_TIER_TWO, "Ring of Recovery(Tier Ⅱ)");
        addItem(ModItems.COOLDOWN_RING_TIER_THREE, "Ring of Recovery(Tier Ⅲ)");
        addItem(ModItems.COOLDOWN_RING_TIER_FOUR, "Ring of Recovery(Tier Ⅳ)");
        addItem(ModItems.COOLDOWN_RING_TIER_FIVE, "Ring of Recovery(Tier Ⅴ)");
        
        addItem(ModItems.CAST_TIME_RING_TIER_ONE, "Ring of Expediency(Tier Ⅰ)");
        addItem(ModItems.CAST_TIME_RING_TIER_TWO, "Ring of Expediency(Tier Ⅱ)");
        addItem(ModItems.CAST_TIME_RING_TIER_THREE, "Ring of Expediency(Tier Ⅲ)");
        addItem(ModItems.CAST_TIME_RING_TIER_FOUR, "Ring of Expediency(Tier Ⅳ)");
        addItem(ModItems.CAST_TIME_RING_TIER_FIVE, "Ring of Expediency(Tier Ⅴ)");

        addItem(ModItems.MANA_COOLDOWN_RING, "Ring of Mana and Recovery and Recovery");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_ONE, "Ring of Mana and Recovery(Tier Ⅰ)");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_TWO, "Ring of Mana and Recovery(Tier Ⅱ)");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_THREE, "Ring of Mana and Recovery(Tier Ⅲ)");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_FOUR, "Ring of Mana and Recovery(Tier Ⅳ)");
        addItem(ModItems.MANA_COOLDOWN_RING_TIER_FIVE, "Ring of Mana and Recovery(Tier Ⅴ)");

        addItem(ModItems.MANA_CAST_TIME_RING, "Ring of Mana and Expediency");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_ONE, "Ring of Mana and Expediency(Tier Ⅰ)");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_TWO, "Ring of Mana and Expediency(Tier Ⅱ)");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_THREE, "Ring of Mana and Expediency(Tier Ⅲ)");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_FOUR, "Ring of Mana and Expediency(Tier Ⅳ)");
        addItem(ModItems.MANA_CAST_TIME_RING_TIER_FIVE, "Ring of Mana and Expediency(Tier Ⅴ)");

        addItem(ModItems.COOLDOWN_CAST_TIME_RING, "Ring of Recovery and Expediency");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_ONE, "Ring of Recovery and Expediency(Tier Ⅰ)");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_TWO, "Ring of Recovery and Expediency(Tier Ⅱ)");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_THREE, "Ring of Recovery and Expediency(Tier Ⅲ)");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_FOUR, "Ring of Recovery and Expediency(Tier Ⅳ)");
        addItem(ModItems.COOLDOWN_CAST_TIME_RING_TIER_FIVE, "Ring of Recovery and Expediency(Tier Ⅴ)");

        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING, "Ring of Mana, Recovery and Expediency");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_ONE, "Ring of Mana, Recovery and Expediency(Tier Ⅰ)");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_TWO, "Ring of Mana, Recovery and Expediency(Tier Ⅱ)");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_THREE, "Ring of Mana, Recovery and Expediency(Tier Ⅲ)");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_FOUR, "Ring of Mana, Recovery and Expediency(Tier Ⅳ)");
        addItem(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_FIVE, "Ring of Mana, Recovery and Expediency(Tier Ⅴ)");

        addBlock(ModBlocks.REINFORCEMENT_TABLE, "Reinforcement Table");
    }
}
