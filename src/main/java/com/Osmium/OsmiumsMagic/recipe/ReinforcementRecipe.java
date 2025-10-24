package com.Osmium.OsmiumsMagic.recipe;

import com.Osmium.OsmiumsMagic.regi.ModRecipeTypes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class ReinforcementRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final List<Ingredient> ingredients; // スロット0~8用
    private final ItemStack result;             // スロット9
    private final int essenceCost;              // スロット10（arcane essenceの必要数）

    public ReinforcementRecipe(ResourceLocation id, List<Ingredient> ingredients, ItemStack result, int essenceCost) {
        this.id = id;
        this.ingredients = ingredients;
        this.result = result;
        this.essenceCost = essenceCost;
    }

    @Override
    public boolean matches(SimpleContainer inv, Level world) {
        // スロット0~8を確認
        for (int i = 0; i < 9; i++) {
            if (!ingredients.get(i).test(inv.getItem(i))) {
                return false;
            }
        }
        // essenceのチェック（ここではinv.getItem(10).getCount() >= essenceCostをチェックしてもいい）
        return true;
    }

    @Override
    public ItemStack assemble(SimpleContainer inv) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return result;
    }

    public int getEssenceCost() {
        return essenceCost;
    }

    @Override
    public ResourceLocation getId() { return id; }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.REINFORCEMENT_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.REINFORCEMENT;
    }
}
