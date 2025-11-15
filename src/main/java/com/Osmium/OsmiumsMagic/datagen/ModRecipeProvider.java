package com.Osmium.OsmiumsMagic.datagen;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.recipe.ReinforcementRecipeBuilder;
import com.Osmium.OsmiumsMagic.regi.ModBlocks;
import com.Osmium.OsmiumsMagic.regi.ModItems;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_RING_TIER_ONE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', Items.DIAMOND)
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ItemRegistry.MANA_RING.get())
                .crafttime(200)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.MANA_RING.get()), has(ItemRegistry.MANA_RING.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.COOLDOWN_RING_TIER_ONE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', Items.DIAMOND)
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ItemRegistry.COOLDOWN_RING.get())
                .crafttime(200)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.COOLDOWN_RING.get()), has(ItemRegistry.COOLDOWN_RING.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.CAST_TIME_RING_TIER_ONE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', Items.DIAMOND)
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ItemRegistry.CAST_TIME_RING.get())
                .crafttime(200)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.CAST_TIME_RING.get()), has(ItemRegistry.CAST_TIME_RING.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_INGOT.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('Z', Items.DIAMOND)
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('X', Items.GOLD_INGOT)
                .crafttime(200)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.ARCANE_INGOT.get()), has(ItemRegistry.ARCANE_INGOT.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_SHARD.get())
                .pattern(" Y ")
                .pattern("YZY")
                .pattern(" Y ")
                .define('Z', Items.AMETHYST_SHARD)
                .define('Y', ItemRegistry.MAGIC_CLOTH.get())
                .crafttime(200)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.MAGIC_CLOTH.get()), has(ItemRegistry.MAGIC_CLOTH.get()))
                .save(pWriter);


        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_RING_TIER_TWO.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ModItems.MANA_INGOT.get())
                .define('Z', ModItems.MANA_RING_TIER_ONE.get())
                .crafttime(300)
                .needessence(8)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_ONE.get()), has(ModItems.MANA_RING_TIER_ONE.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.COOLDOWN_RING_TIER_TWO.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ModItems.MANA_INGOT.get())
                .define('Z', ModItems.COOLDOWN_RING_TIER_ONE.get())
                .crafttime(300)
                .needessence(8)
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_ONE.get()), has(ModItems.COOLDOWN_RING_TIER_ONE.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.CAST_TIME_RING_TIER_TWO.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ModItems.MANA_INGOT.get())
                .define('Z', ModItems.CAST_TIME_RING_TIER_ONE.get())
                .crafttime(300)
                .needessence(8)
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_ONE.get()), has(ModItems.CAST_TIME_RING_TIER_ONE.get()))
                .save(pWriter);
        
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.REINFORCEMENT_TABLE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', Items.QUARTZ_BLOCK)
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', Items.ENCHANTING_TABLE)
                .unlockedBy(getHasName(ItemRegistry.ARCANE_INGOT.get()), has(ItemRegistry.ARCANE_INGOT.get()))
                .save(pWriter);
    }
    
    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_).unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, Osmiumsmagic.MOD_ID + ":" + getItemName(p_250066_) + p_249236_ + "_" + getItemName(itemlike));
        }

    }
}
