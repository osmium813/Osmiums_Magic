package com.Osmium.OsmiumsMagic.regi;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;

public class ModRecipeTypes {
    public static final RecipeType<ReinforcementRecipe> REINFORCEMENT =
        RecipeType.register(Osmiumsmagic.MOD_ID + ":reinforcement");

    public static final DeferredRegister<RecipeType<?>> RECIPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Osmiumsmagic.MOD_ID);

    public static void register(IEventBus eventBus){
        RECIPES.register(eventBus);
    }
}
