package com.Osmium.OsmiumsMagic.datagen;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.regi.ModItems;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Osmiumsmagic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        curioItem(ModItems.MANA_RING_TIER_ONE);
        curioItem(ModItems.MANA_RING_TIER_TWO);
        curioItem(ModItems.MANA_RING_TIER_THREE);
        curioItem(ModItems.MANA_RING_TIER_FOUR);
        curioItem(ModItems.MANA_RING_TIER_FIVE);
        curioItem(ModItems.CAST_TIME_RING_TIER_ONE);
        curioItem(ModItems.CAST_TIME_RING_TIER_TWO);
        curioItem(ModItems.CAST_TIME_RING_TIER_THREE);
        curioItem(ModItems.CAST_TIME_RING_TIER_FOUR);
        curioItem(ModItems.CAST_TIME_RING_TIER_FIVE);
        curioItem(ModItems.COOLDOWN_RING_TIER_ONE);
        curioItem(ModItems.COOLDOWN_RING_TIER_TWO);
        curioItem(ModItems.COOLDOWN_RING_TIER_THREE);
        curioItem(ModItems.COOLDOWN_RING_TIER_FOUR);
        curioItem(ModItems.COOLDOWN_RING_TIER_FIVE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Osmiumsmagic.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder curioItem(RegistryObject<CurioBaseItem> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Osmiumsmagic.MOD_ID, "item/" + item.getId().getPath()));
    }
}
