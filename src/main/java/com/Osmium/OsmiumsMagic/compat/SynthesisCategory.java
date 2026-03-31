package com.Osmium.OsmiumsMagic.compat;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.recipe.SynthesisRecipe;
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

public class SynthesisCategory implements IRecipeCategory<SynthesisRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Osmiumsmagic.MOD_ID, "synthesis");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Osmiumsmagic.MOD_ID,
            "textures/gui/container/synthesis_table_jei.png");

    public static final RecipeType<SynthesisRecipe> SYNTHESIS_RECIPE_TYPE =
            new RecipeType<>(UID, SynthesisRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SynthesisCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SYNTHESIS_TABLE.get()));
    }

    @Override
    public RecipeType<SynthesisRecipe> getRecipeType() {
        return SYNTHESIS_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.osmiumsmagic.synthesis_table");
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
    public void setRecipe(IRecipeLayoutBuilder builder, SynthesisRecipe recipe, IFocusGroup iFocusGroup) {
        int[][] slotCoords = {
                {12, 12}, {40, 6},  {69, 12}, // 0, 1, 2
                {7, 35},  {29, 35}, {51, 35}, {74, 35}, // 3, 4, 5, 6
                {12, 58}, {40, 64}, {69, 58}  // 7, 8, 9
        };

        int slotA = recipe.getSlotA();
        int slotB = recipe.getSlotB();

        for (int i = 0; i < 10; i++) {
            var slotBuilder = builder.addSlot(RecipeIngredientRole.INPUT, slotCoords[i][0], slotCoords[i][1]);

            // AとBのスロットだけ特殊処理を行う
            if (i == slotA && slotB != -1) {
                // スロットAには「本来のA」→「本来のB」の順で登録
                slotBuilder.addIngredients(recipe.getIngredients().get(slotA));
                slotBuilder.addIngredients(recipe.getIngredients().get(slotB));
            }
            else if (i == slotB && slotA != -1) {
                // スロットBには「本来のB」→「本来のA」の順で登録
                slotBuilder.addIngredients(recipe.getIngredients().get(slotB));
                slotBuilder.addIngredients(recipe.getIngredients().get(slotA));
            }
            else {
                // それ以外は通常通り
                slotBuilder.addIngredients(recipe.getIngredients().get(i));
            }
        }

        // 出力スロット
        builder.addSlot(RecipeIngredientRole.OUTPUT, 126, 35).addItemStack(recipe.getResultItem(null));

    }

    // 共通定数にするのがベスト
    private static final int BAR_X = 152;
    private static final int BAR_Y = 4;
    private static final int BAR_WIDTH = 17;
    private static final int BAR_HEIGHT = 76;

    @Override
    public void draw(SynthesisRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
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
        int drawX = BAR_X;
        int drawYBottom = BAR_Y + BAR_HEIGHT;

        // 実際のゲージ高さを計算
        int filled = (essence * texHeight) / maxEssence;

        if (filled > 0) {
            int drawYTop = drawYBottom - filled;
            int texVStart = texV + (texHeight - filled);
            guiGraphics.blit(TEXTURE, drawX, drawYTop, texU, texVStart, texWidth, filled);
        }
    }

    @Override
    public @NotNull List<Component> getTooltipStrings(SynthesisRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
            if (mouseX >= BAR_X && mouseX <= BAR_X + BAR_WIDTH &&
                    mouseY >= BAR_Y && mouseY <= BAR_Y + BAR_HEIGHT) {

                return List.of(Component.literal("必要エッセンス: " + recipe.getEssenceCost()));
            }

            return List.of();
            }
}
