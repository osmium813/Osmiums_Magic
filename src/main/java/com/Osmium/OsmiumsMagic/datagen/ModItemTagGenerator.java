package com.Osmium.OsmiumsMagic.datagen;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.regi.ModItems;
import com.Osmium.OsmiumsMagic.regi.tab.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Osmiumsmagic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.RINGS)
                .add(ModItems.MANA_RING_TIER_ONE.get())
                .add(ModItems.MANA_RING_TIER_TWO.get())
                .add(ModItems.MANA_RING_TIER_THREE.get())
                .add(ModItems.MANA_RING_TIER_FOUR.get())
                .add(ModItems.MANA_RING_TIER_FIVE.get())
                .add(ModItems.COOLDOWN_RING_TIER_ONE.get())
                .add(ModItems.COOLDOWN_RING_TIER_TWO.get())
                .add(ModItems.COOLDOWN_RING_TIER_THREE.get())
                .add(ModItems.COOLDOWN_RING_TIER_FOUR.get())
                .add(ModItems.COOLDOWN_RING_TIER_FIVE.get())
                .add(ModItems.CAST_TIME_RING_TIER_ONE.get())
                .add(ModItems.CAST_TIME_RING_TIER_TWO.get())
                .add(ModItems.CAST_TIME_RING_TIER_THREE.get())
                .add(ModItems.CAST_TIME_RING_TIER_FOUR.get())
                .add(ModItems.CAST_TIME_RING_TIER_FIVE.get())
                .add(ModItems.MANA_COOLDOWN_RING.get())
                .add(ModItems.MANA_COOLDOWN_RING_TIER_ONE.get())
                .add(ModItems.MANA_COOLDOWN_RING_TIER_TWO.get())
                .add(ModItems.MANA_COOLDOWN_RING_TIER_THREE.get())
                .add(ModItems.MANA_COOLDOWN_RING_TIER_FOUR.get())
                .add(ModItems.MANA_COOLDOWN_RING_TIER_FIVE.get())
                .add(ModItems.MANA_CAST_TIME_RING.get())
                .add(ModItems.MANA_CAST_TIME_RING_TIER_ONE.get())
                .add(ModItems.MANA_CAST_TIME_RING_TIER_TWO.get())
                .add(ModItems.MANA_CAST_TIME_RING_TIER_THREE.get())
                .add(ModItems.MANA_CAST_TIME_RING_TIER_FOUR.get())
                .add(ModItems.MANA_CAST_TIME_RING_TIER_FIVE.get())
                .add(ModItems.COOLDOWN_CAST_TIME_RING.get())
                .add(ModItems.COOLDOWN_CAST_TIME_RING_TIER_ONE.get())
                .add(ModItems.COOLDOWN_CAST_TIME_RING_TIER_TWO.get())
                .add(ModItems.COOLDOWN_CAST_TIME_RING_TIER_THREE.get())
                .add(ModItems.COOLDOWN_CAST_TIME_RING_TIER_FOUR.get())
                .add(ModItems.COOLDOWN_CAST_TIME_RING_TIER_FIVE.get())
                .add(ModItems.MANA_COOLDOWN_CAST_TIME_RING.get())
                .add(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_ONE.get())
                .add(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_TWO.get())
                .add(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_THREE.get())
                .add(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_FOUR.get())
                .add(ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_FIVE.get())
        ;
    }
}
