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
        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        // ---- ゲージ描画 ----
    int essence = this.menu.blockEntity.essencecount; // 0〜16 の値
    int maxEssence = 16;

    // テクスチャ上のゲージ部分（180, 4）〜（196, 80）
    int texU = 180;
    int texV = 4;
    int texWidth = 16;
    int texHeight = 76; // 80 - 4 = 76ピクセル

    // essence に応じて高さを決定（整数で計算）
    float filled = (essence / maxEssence) * texHeight;

    // 描画先の座標（152, 4）〜（168, 80）
    int drawX = x + 152;
    int drawYBottom = y + 80;
    int drawYTop = drawYBottom - filled; // 下から上に伸ばす

    // テクスチャの対応部分も下から切り取る
    int texVStart = texV + (texHeight - filled);

    // 実際の描画
    guiGraphics.blit(TEXTURE, drawX, drawYTop, texU, texVStart, texWidth, filled);
    }

    @Override
    public void render(GuiGraphics p_283479_, int p_283661_, int p_281248_, float p_281886_) {
        renderBackground(p_283479_);
        super.render(p_283479_, p_283661_, p_281248_, p_281886_);
        renderTooltip(p_283479_, p_283661_, p_281248_);
    }
}
