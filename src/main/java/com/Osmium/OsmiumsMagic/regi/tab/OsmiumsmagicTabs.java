package com.Osmium.OsmiumsMagic.regi.tab;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.regi.ModBlocks;
import com.Osmium.OsmiumsMagic.regi.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class OsmiumsmagicTabs {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS =DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Osmiumsmagic.MOD_ID);


    public static final RegistryObject<CreativeModeTab> OSMIUM_MAGIC_ORNAMENTS = MOD_TABS.register("osmium_magic_ornaments",
            () ->{return CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MANA_RING_TIER_ONE.get()))
                    .title(Component.translatable("itemGroup.osmium_magic_ornaments"))
                    .displayItems((param,output)->{
                        for (Item item:OsmiumsmagicMain.ornaments){
                            output.accept(item);
                        }
                    }).build();
            }
    );

    public static final RegistryObject<CreativeModeTab> OSMIUM_MAGIC_ITEMS = MOD_TABS.register("osmium_magic_items",
            () ->{return CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MANA_INGOT.get()))
                    .title(Component.translatable("itemGroup.osmium_magic_items"))
                    .displayItems((param,output)->{
                        for (Item item:OsmiumsmagicMain.material){
                            output.accept(item);
                        }
                    }).build();
            }
    );

    public static final RegistryObject<CreativeModeTab> OSMIUM_MAGIC_BLOCKS = MOD_TABS.register("osmium_magic_blocks",
            () ->{return CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.REINFORCEMENT_TABLE.get().asItem()))
                    .title(Component.translatable("itemGroup.osmium_magic_blocks"))
                    .displayItems((param, output) ->{
                        for (Block item:OsmiumsmagicMain.block) {
                            output.accept(item);
                        }
                    })
                    .build();});
}
