package com.Osmium.OsmiumsMagic.compat;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.recipe.ReinforcementRecipe;
import com.Osmium.OsmiumsMagic.regi.ModBlocks;
import com.mojang.blaze3d.systems.RenderSystem;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReinforcementCategory implements IRecipeCategory<ReinforcementRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Osmiumsmagic.MOD_ID, "reinforcement");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Osmiumsmagic.MOD_ID,
            "textures/gui/container/reinforcement_table_jei.png");

    public static final RecipeType<ReinforcementRecipe> REINFORCEMENT_RECIPE_TYPE =
            new RecipeType<>(UID, ReinforcementRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ReinforcementCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.REINFORCEMENT_TABLE.get()));
    }

    @Override
    public RecipeType<ReinforcementRecipe> getRecipeType() {
        return REINFORCEMENT_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.osmiumsmagic.reinforcement_table");
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ReinforcementRecipe recipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 20,12).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 44,6).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 67,12).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 15,35).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 44,35).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 73,35).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 20,58).addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 44,64).addIngredients(recipe.getIngredients().get(7));
        builder.addSlot(RecipeIngredientRole.INPUT, 67,58).addIngredients(recipe.getIngredients().get(8));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 126,35).addItemStack(recipe.getResultItem(null));

    }

    @Override
    public void draw(ReinforcementRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        // --- Essenceゲージ ---
        int essence = recipe.getEssenceCost(); // レシピごとの必要エッセンス
        int maxEssence = 16; // GUI側と合わせる（固定値でOK）

        // テクスチャ上のゲージ領域（ReinforcementTableScreenと同じ）
        int texU = 180;
        int texV = 4;
        int texWidth = 17;
        int texHeight = 76;

        // JEI表示上の位置（ReinforcementScreenのGUI位置に合わせる）
        int drawX = 152;
        int drawYBottom = 80;

        // 実際のゲージ高さを計算
        int filled = (essence * texHeight) / maxEssence;

        if (filled > 0) {
            int drawYTop = drawYBottom - filled;
            int texVStart = texV + (texHeight - filled);
            guiGraphics.blit(TEXTURE, drawX, drawYTop, texU, texVStart, texWidth, filled);
        }
    }

    @Override
    public @NotNull List<Component> getTooltipStrings(ReinforcementRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        // JEI内のエッセンスゲージの当たり判定
        int barX = 104;
        int barY = 4;
        int barWidth = 16;
        int barHeight = 76;

        if (mouseX >= barX && mouseX <= barX + barWidth && mouseY >= barY && mouseY <= barY + barHeight) {
            return List.of(Component.literal("必要エッセンス: " + recipe.getEssenceCost()));
        }

        return List.of();
    }
}
