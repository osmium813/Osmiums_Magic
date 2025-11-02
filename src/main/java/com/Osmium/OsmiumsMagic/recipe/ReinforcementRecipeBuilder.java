package com.Osmium.OsmiumsMagic.recipe;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ReinforcementRecipeBuilder {

    private final RecipeCategory category;
    private final Item result;
    private final Map<Character, Ingredient> key = new LinkedHashMap<>();
    private final JsonArray pattern = new JsonArray();

    private int craftTime;
    private int needEssence;

    private final Map<String, CriterionTriggerInstance> criteria = new LinkedHashMap<>();

    public ReinforcementRecipeBuilder(RecipeCategory category, ItemLike result) {
        this.category = category;
        this.result = result.asItem();
    }

    public static ReinforcementRecipeBuilder reinforcement(RecipeCategory category, ItemLike result) {
        return new ReinforcementRecipeBuilder(category, result);
    }

    public ReinforcementRecipeBuilder pattern(String line) {
        pattern.add(line);
        return this;
    }

    public ReinforcementRecipeBuilder define(char symbol, ItemLike item) {
        key.put(symbol, Ingredient.of(item));
        return this;
    }

    public ReinforcementRecipeBuilder crafttime(int time) {
        this.craftTime = time;
        return this;
    }

    public ReinforcementRecipeBuilder needessence(int essence) {
        this.needEssence = essence;
        return this;
    }

    public ReinforcementRecipeBuilder unlockedBy(String name, CriterionTriggerInstance criterion) {
        criteria.put(name, criterion);
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer) {
        save(consumer, Osmiumsmagic.MOD_ID + ":" + result.toString().toLowerCase() + "_reinforcement");
    }

    public void save(Consumer<FinishedRecipe> consumer, String id) {
        consumer.accept(new Result(new ResourceLocation(id), result, key, pattern, craftTime, needEssence, criteria));
    }

    public record Result(ResourceLocation id, Item result, Map<Character, Ingredient> key, JsonArray pattern,
                         int craftTime, int needEssence, Map<String, CriterionTriggerInstance> criteria) implements FinishedRecipe {
        @Override
        public void serializeRecipeData(JsonObject json) {
            json.addProperty("type", Osmiumsmagic.MOD_ID + ":reinforcement");

            JsonArray patternJson = new JsonArray();
            pattern.forEach(patternJson::add);
            json.add("pattern", patternJson);

            JsonObject keyJson = new JsonObject();
            key.forEach((symbol, ingredient) -> keyJson.add(String.valueOf(symbol), ingredient.toJson()));
            json.add("key", keyJson);

            JsonObject resultJson = new JsonObject();
            resultJson.addProperty("item", net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(result).toString());
            json.add("result", resultJson);

            json.addProperty("craft_time", craftTime);
            json.addProperty("essence", needEssence);
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ReinforcementRecipe.Serializer.INSTANCE;
        }

        @Override
        public @Nullable JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public @Nullable ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
