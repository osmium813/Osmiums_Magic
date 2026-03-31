package com.Osmium.OsmiumsMagic.datagen;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.recipe.ReinforcementRecipeBuilder;
import com.Osmium.OsmiumsMagic.recipe.SynthesisRecipeBuilder;
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
                .pattern("YYY")
                .pattern("YZY")
                .pattern("YYY")
                .define('Z', Items.AMETHYST_SHARD)
                .define('Y', ItemRegistry.ARCANE_ESSENCE.get())
                .crafttime(200)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.MAGIC_CLOTH.get()), has(ItemRegistry.MAGIC_CLOTH.get()))
                .save(pWriter);


        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_RING_TIER_TWO.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
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
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
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
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ModItems.CAST_TIME_RING_TIER_ONE.get())
                .crafttime(300)
                .needessence(8)
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_ONE.get()), has(ModItems.CAST_TIME_RING_TIER_ONE.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_RING_TIER_THREE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ModItems.MANA_RING_TIER_TWO.get())
                .crafttime(300)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_TWO.get()), has(ModItems.MANA_RING_TIER_TWO.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.COOLDOWN_RING_TIER_THREE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ModItems.COOLDOWN_RING_TIER_TWO.get())
                .crafttime(300)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_TWO.get()), has(ModItems.COOLDOWN_RING_TIER_TWO.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.CAST_TIME_RING_TIER_THREE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ModItems.CAST_TIME_RING_TIER_TWO.get())
                .crafttime(300)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_TWO.get()), has(ModItems.CAST_TIME_RING_TIER_TWO.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_SALVAGE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ItemRegistry.ARCANE_SALVAGE.get())
                .crafttime(300)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_TWO.get()), has(ModItems.CAST_TIME_RING_TIER_TWO.get()))
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

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING_TIER_ONE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', Items.DIAMOND)
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ModItems.MANA_CAST_TIME_RING.get())
                .crafttime(500)
                .needessence(4)
                .unlockedBy(getHasName(ModItems.MANA_CAST_TIME_RING.get()), has(ModItems.MANA_CAST_TIME_RING.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING_TIER_TWO.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ModItems.MANA_CAST_TIME_RING_TIER_ONE.get())
                .crafttime(500)
                .needessence(8)
                .unlockedBy(getHasName(ModItems.MANA_CAST_TIME_RING_TIER_ONE.get()), has(ModItems.MANA_CAST_TIME_RING_TIER_ONE.get()))
                .save(pWriter);

        ReinforcementRecipeBuilder.reinforcement(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING_TIER_THREE.get())
                .pattern("XYX")
                .pattern("YZY")
                .pattern("XYX")
                .define('X', ModItems.MANA_SHARD.get())
                .define('Y', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', ModItems.MANA_CAST_TIME_RING_TIER_TWO.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_CAST_TIME_RING_TIER_TWO.get()), has(ModItems.MANA_CAST_TIME_RING_TIER_TWO.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ItemRegistry.MANA_RING.get())
                .define('B', ItemRegistry.CAST_TIME_RING.get())
                .crafttime(500)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.MANA_RING.get()), has(ItemRegistry.MANA_RING.get()))
                .unlockedBy(getHasName(ItemRegistry.CAST_TIME_RING.get()), has(ItemRegistry.CAST_TIME_RING.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_COOLDOWN_CAST_TIME_RING.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ItemRegistry.MANA_RING.get())
                .define('B', ItemRegistry.COOLDOWN_RING.get())
                .crafttime(500)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.MANA_RING.get()), has(ItemRegistry.MANA_RING.get()))
                .unlockedBy(getHasName(ItemRegistry.COOLDOWN_RING.get()), has(ItemRegistry.COOLDOWN_RING.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.COOLDOWN_CAST_TIME_RING.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ItemRegistry.COOLDOWN_RING.get())
                .define('B', ItemRegistry.CAST_TIME_RING.get())
                .crafttime(500)
                .needessence(4)
                .unlockedBy(getHasName(ItemRegistry.COOLDOWN_RING.get()), has(ItemRegistry.COOLDOWN_RING.get()))
                .unlockedBy(getHasName(ItemRegistry.CAST_TIME_RING.get()), has(ItemRegistry.CAST_TIME_RING.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING_TIER_ONE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_ONE.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_ONE.get())
                .crafttime(500)
                .needessence(8)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_ONE.get()), has(ModItems.MANA_RING_TIER_ONE.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_ONE.get()), has(ModItems.CAST_TIME_RING_TIER_ONE.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_ONE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_ONE.get())
                .define('B', ModItems.COOLDOWN_RING_TIER_ONE.get())
                .crafttime(500)
                .needessence(8)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_ONE.get()), has(ModItems.MANA_RING_TIER_ONE.get()))
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_ONE.get()), has(ModItems.COOLDOWN_RING_TIER_ONE.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.COOLDOWN_CAST_TIME_RING_TIER_ONE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.COOLDOWN_RING_TIER_ONE.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_ONE.get())
                .crafttime(500)
                .needessence(8)
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_ONE.get()), has(ModItems.COOLDOWN_RING_TIER_ONE.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_ONE.get()), has(ModItems.CAST_TIME_RING_TIER_ONE.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING_TIER_TWO.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_TWO.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_TWO.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_TWO.get()), has(ModItems.MANA_RING_TIER_TWO.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_TWO.get()), has(ModItems.CAST_TIME_RING_TIER_TWO.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_TWO.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_TWO.get())
                .define('B', ModItems.COOLDOWN_RING_TIER_TWO.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_TWO.get()), has(ModItems.MANA_RING_TIER_TWO.get()))
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_TWO.get()), has(ModItems.COOLDOWN_RING_TIER_TWO.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.COOLDOWN_CAST_TIME_RING_TIER_TWO.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.COOLDOWN_RING_TIER_TWO.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_TWO.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_TWO.get()), has(ModItems.COOLDOWN_RING_TIER_TWO.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_TWO.get()), has(ModItems.CAST_TIME_RING_TIER_TWO.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING_TIER_THREE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ModItems.MANA_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_THREE.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_THREE.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_THREE.get()), has(ModItems.MANA_RING_TIER_THREE.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_THREE.get()), has(ModItems.CAST_TIME_RING_TIER_THREE.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_THREE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ModItems.MANA_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_THREE.get())
                .define('B', ModItems.COOLDOWN_RING_TIER_THREE.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_THREE.get()), has(ModItems.MANA_RING_TIER_THREE.get()))
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_THREE.get()), has(ModItems.COOLDOWN_RING_TIER_THREE.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.COOLDOWN_CAST_TIME_RING_TIER_THREE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ModItems.MANA_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.COOLDOWN_RING_TIER_THREE.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_THREE.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_THREE.get()), has(ModItems.COOLDOWN_RING_TIER_THREE.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_THREE.get()), has(ModItems.CAST_TIME_RING_TIER_THREE.get()))
                .save(pWriter);

        /*SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING_TIER_FOUR.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_FOUR.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_FOUR.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_FOUR.get()), has(ModItems.MANA_RING_TIER_FOUR.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_FOUR.get()), has(ModItems.CAST_TIME_RING_TIER_FOUR.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_FOUR.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_FOUR.get())
                .define('B', ModItems.COOLDOWN_RING_TIER_FOUR.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_FOUR.get()), has(ModItems.MANA_RING_TIER_FOUR.get()))
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_FOUR.get()), has(ModItems.COOLDOWN_RING_TIER_FOUR.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.COOLDOWN_CAST_TIME_RING_TIER_FOUR.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.COOLDOWN_RING_TIER_FOUR.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_FOUR.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_FOUR.get()), has(ModItems.COOLDOWN_RING_TIER_FOUR.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_FOUR.get()), has(ModItems.CAST_TIME_RING_TIER_FOUR.get()))
                .save(pWriter);*/

        /*SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_CAST_TIME_RING_TIER_FIVE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_FIVE.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_FIVE.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_FIVE.get()), has(ModItems.MANA_RING_TIER_FIVE.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_FIVE.get()), has(ModItems.CAST_TIME_RING_TIER_FIVE.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.MANA_COOLDOWN_CAST_TIME_RING_TIER_FIVE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.MANA_RING_TIER_FIVE.get())
                .define('B', ModItems.COOLDOWN_RING_TIER_FIVE.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.MANA_RING_TIER_FIVE.get()), has(ModItems.MANA_RING_TIER_FIVE.get()))
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_FIVE.get()), has(ModItems.COOLDOWN_RING_TIER_FIVE.get()))
                .save(pWriter);

        SynthesisRecipeBuilder.Synthesis(RecipeCategory.MISC, ModItems.COOLDOWN_CAST_TIME_RING_TIER_FIVE.get())
                .pattern("XYX")
                .pattern("YABY")
                .pattern("XYX")
                .define('X', ItemRegistry.ARCANE_INGOT.get())
                .define('Y', ItemRegistry.ARCANE_SALVAGE.get())
                .define('A', ModItems.COOLDOWN_RING_TIER_FIVE.get())
                .define('B', ModItems.CAST_TIME_RING_TIER_FIVE.get())
                .crafttime(500)
                .needessence(12)
                .unlockedBy(getHasName(ModItems.COOLDOWN_RING_TIER_FIVE.get()), has(ModItems.COOLDOWN_RING_TIER_FIVE.get()))
                .unlockedBy(getHasName(ModItems.CAST_TIME_RING_TIER_FIVE.get()), has(ModItems.CAST_TIME_RING_TIER_FIVE.get()))
                .save(pWriter);*/
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
