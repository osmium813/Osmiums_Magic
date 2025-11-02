package com.Osmium.OsmiumsMagic.recipe;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReinforcementRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final List<Ingredient> ingredients;
    private final ItemStack result;
    private final int essenceCost;
    private final int craftTime; // tick単位

    public ReinforcementRecipe(ResourceLocation id, List<Ingredient> ingredients, ItemStack result, int essenceCost, int craftTime) {
        this.id = id;
        this.ingredients = ingredients;
        this.result = result;
        this.essenceCost = essenceCost;
        this.craftTime = craftTime;
    }

    @Override
    public boolean matches(SimpleContainer inv, Level p_44003_) {
        for (int i = 0; i < 9; i++) {
            if(!ingredients.get(i).test(inv.getItem(i))) {
                return  false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return result;
    }

    public int getEssenceCost() {
        return essenceCost;
    }

    public int getCraftTime() {
        return craftTime;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class  Type implements RecipeType<ReinforcementRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "reinforcement";
    }

    public static class Serializer implements RecipeSerializer<ReinforcementRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Osmiumsmagic.MOD_ID, "reinforcement");

        @Override
        public ReinforcementRecipe fromJson(ResourceLocation id, JsonObject json) {
            // === pattern & key 読み込み ===
            JsonArray patternArray = json.getAsJsonArray("pattern");
            List<String> pattern = new ArrayList<>();
            for (int i = 0; i < patternArray.size(); i++) {
                pattern.add(patternArray.get(i).getAsString());
            }

            JsonObject keyObject = json.getAsJsonObject("key");
            Map<Character, Ingredient> keyMap = new HashMap<>();
            for (var entry : keyObject.entrySet()) {
                keyMap.put(entry.getKey().charAt(0), Ingredient.fromJson(entry.getValue()));
            }

            // === pattern展開（3x3固定） ===
            List<Ingredient> ingredients = new ArrayList<>();
            for (String line : pattern) {
                for (char symbol : line.toCharArray()) {
                    if (symbol == ' ') {
                        ingredients.add(Ingredient.EMPTY);
                    } else {
                        ingredients.add(keyMap.get(symbol));
                    }
                }
            }

            // 結果とエッセンス
            ItemStack result = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("result"));
            int essence = json.get("essence").getAsInt();
            int craftTime = json.has("craft_time") ? json.get("craft_time").getAsInt() : 100;

            return new ReinforcementRecipe(id, ingredients, result, essence, craftTime);
        }

        @Override
        public @Nullable ReinforcementRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            int size = buf.readInt();
            List<Ingredient> ingredients = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ingredients.add(Ingredient.fromNetwork(buf));
            }

            ItemStack result = buf.readItem();
            int essence = buf.readInt();
            int craftTime = buf.readInt();
            return new ReinforcementRecipe(id, ingredients, result, essence, craftTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, ReinforcementRecipe recipe) {
            buf.writeInt(recipe.ingredients.size());
            for (Ingredient ing : recipe.ingredients) {
                ing.toNetwork(buf);
            }
            buf.writeItem(recipe.result);
            buf.writeInt(recipe.essenceCost);
            buf.writeInt(recipe.craftTime);
        }
    }
}
