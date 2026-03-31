package com.Osmium.OsmiumsMagic.recipe;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
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

public class SynthesisRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;
    private final int essenceCost;
    private final int craftTime; // tick単位

    private final int slotA;
    private final int slotB;

    public SynthesisRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, ItemStack result, int essenceCost, int craftTime, int slotA, int slotB) {
        this.id = id;
        this.ingredients = ingredients;
        this.result = result;
        this.essenceCost = essenceCost;
        this.craftTime = craftTime;
        this.slotA = slotA;
        this.slotB = slotB;
    }

    @Override
    public boolean matches(SimpleContainer inv, Level p_44003_) {
        // AとBの両方がレシピに存在する場合の特殊判定
        if (slotA != -1 && slotB != -1) {
            // まず、AとB以外のスロットが一致しているか確認
            for (int i = 0; i < 10; i++) {
                if (i == slotA || i == slotB) continue;
                if (!ingredients.get(i).test(inv.getItem(i))) return false;
            }

            // AとBのスロットを「通常」と「逆」の両方でチェック
            ItemStack itemInA = inv.getItem(slotA);
            ItemStack itemInB = inv.getItem(slotB);
            Ingredient ingA = ingredients.get(slotA);
            Ingredient ingB = ingredients.get(slotB);

            boolean normal = ingA.test(itemInA) && ingB.test(itemInB);
            boolean swapped = ingA.test(itemInB) && ingB.test(itemInA);

            return normal || swapped;
        }

        // AかBのどちらかが無い場合は、従来の全一致判定
        for (int i = 0; i < 10; i++) {
            if (!ingredients.get(i).test(inv.getItem(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
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

    public int getSlotA() {
        return slotA;
    }

    public int getSlotB() {
        return slotB;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SynthesisRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return SynthesisRecipe.Type.INSTANCE;
    }

    public static class  Type implements RecipeType<SynthesisRecipe> {
        public static final SynthesisRecipe.Type INSTANCE = new SynthesisRecipe.Type();
        public static final String ID = "synthesis";
    }

    public static class Serializer implements RecipeSerializer<SynthesisRecipe> {
        public static final SynthesisRecipe.Serializer INSTANCE = new SynthesisRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Osmiumsmagic.MOD_ID, "synthesis");

        @Override
        public SynthesisRecipe fromJson(ResourceLocation id, JsonObject json) {
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

            NonNullList<Ingredient> ingredients = NonNullList.withSize(10, Ingredient.EMPTY);
            int index = 0;
            int slotA = -1;
            int slotB = -1;
            for (String line : pattern) {
                for (char symbol : line.toCharArray()) {
                    // 追加: 'A' と 'B' の位置を記憶する
                    if (symbol == 'A') slotA = index;
                    if (symbol == 'B') slotB = index;

                    if (symbol == ' ') {
                        ingredients.set(index, Ingredient.EMPTY);
                    } else {
                        ingredients.set(index, keyMap.get(symbol));
                    }
                    index++;
                }
            }

            // 結果とエッセンス
            ItemStack result = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("result"));
            int essence = json.get("essence").getAsInt();
            int craftTime = json.has("craft_time") ? json.get("craft_time").getAsInt() : 100;

            return new SynthesisRecipe(id, ingredients, result, essence, craftTime, slotA, slotB);
        }

        @Override
        public @Nullable SynthesisRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            int size = buf.readInt();
            NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);
            for (int i = 0; i < size; i++) {
                ingredients.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack result = buf.readItem();
            int essence = buf.readInt();
            int craftTime = buf.readInt();
            int slotA = buf.readInt();
            int slotB = buf.readInt();
            return new SynthesisRecipe(id, ingredients, result, essence, craftTime, slotA, slotB);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, SynthesisRecipe recipe) {
            buf.writeInt(recipe.ingredients.size());
            for (Ingredient ing : recipe.ingredients) {
                ing.toNetwork(buf);
            }
            buf.writeItem(recipe.result);
            buf.writeInt(recipe.essenceCost);
            buf.writeInt(recipe.craftTime);
            buf.writeInt(recipe.slotA);
            buf.writeInt(recipe.slotB);
        }
    }
}
