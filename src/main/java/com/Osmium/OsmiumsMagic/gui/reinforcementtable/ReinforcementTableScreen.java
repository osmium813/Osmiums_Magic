package com.Osmium.OsmiumsMagic.gui.reinforcementtable;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ReinforcementTableScreen extends AbstractContainerScreen<ReinforcementTableMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Osmiumsmagic.MOD_ID, "textures/gui/container/reinforcement_table.png");

    public ReinforcementTableScreen(ReinforcementTableMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        // ---- Essenceゲージ描画 ----
        int essence = menu.getEssenceCount(); // 0〜16
        int maxEssence = menu.getMaxEssenceCount();

        // テクスチャ上のゲージ位置（右端にある想定）
        int texU = 180;
        int texV = 4;
        int texWidth = 16;
        int texHeight = 76; // 80 - 4 = 76ピクセル分

        // 実際の描画座標（GUI上）
        int drawX = x + 152;
        int drawYBottom = y + 80;

        // ゲージの高さを計算（整数）
        int filled = (essence * texHeight) / maxEssence;

        if (filled > 0) {
            // 下から上に向かって描画するため、上端とテクスチャ座標を調整
            int drawYTop = drawYBottom - filled;
            int texVStart = texV + (texHeight - filled);

            // 描画！
            guiGraphics.blit(TEXTURE, drawX, drawYTop, texU, texVStart, texWidth, filled);
        }

        // --- プログレスバー描画 ---
        int progress = menu.getProgress();          // BlockEntityのdataから取得
        int maxProgress = menu.getMaxProgress();    // 同上
        if (maxProgress > 0 && progress > 0) {
            int barWidth = (int)(21 * ((float)progress / maxProgress)); // 21px中どこまで進むか

            // テクスチャ上の描画元座標（178,83）
            // GUI上の描画先座標（94,36）
            guiGraphics.blit(TEXTURE,x + 94, y + 36, 178, 83, barWidth, 15);
        }

    }

    @Override
    public void render(GuiGraphics p_283479_, int p_283661_, int p_281248_, float p_281886_) {
        renderBackground(p_283479_);
        super.render(p_283479_, p_283661_, p_281248_, p_281886_);
        renderTooltip(p_283479_, p_283661_, p_281248_);
    }
}
