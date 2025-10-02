package com.Osmium.OsmiumsMagic.regi.tab;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> tag (String name) {
            return BlockTags.create(new ResourceLocation(Osmiumsmagic.MOD_ID,name));
        }
    }

    public static class Items {

        public static final TagKey<Item> RINGS =
                ItemTags.create(new ResourceLocation("curios", "ring"));

        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(Osmiumsmagic.MOD_ID));
        }
    }
}
