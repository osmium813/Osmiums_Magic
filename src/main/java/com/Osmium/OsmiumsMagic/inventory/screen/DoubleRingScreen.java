package com.Osmium.OsmiumsMagic.inventory.screen;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.inventory.menu.DoubleRingMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

public class DoubleRingScreen extends AbstractContainerScreen<DoubleRingMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Osmiumsmagic.MOD_ID, "textures/gui/container/double_ring.png");

    private static final ResourceLocation EMPTY_RING_SLOT =
            new ResourceLocation(CuriosApi.MODID,"textures/slot/empty_ring_slot.png");

    public DoubleRingScreen(DoubleRingMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }


    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialtick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getParticleShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) /2;

        graphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderRingSlots(graphics, x, y);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, delta);
        renderRingSlotTooltips(graphics, mouseX, mouseY);
        renderTooltip(graphics, mouseX, mouseY);
    }

    private void renderRingSlots(GuiGraphics graphics, int guiX, int guiY) {
        var handler = this.menu.getHandler(); // ← Curiosではなくmenuのhandlerを使う

        for (int i = 0; i < 2; i++) {
            int slotX = 71 + i * 18;
            int slotY = 20;

            ItemStack stack = handler.getStackInSlot(i);

            if (stack.isEmpty()) {
                graphics.blit(EMPTY_RING_SLOT, guiX + slotX, guiY + slotY, 0, 0, 16, 16, 16, 16);
            } else {
                graphics.renderItem(stack, guiX + slotX, guiY + slotY);
                graphics.renderItemDecorations(this.font, stack, guiX + slotX, guiY + slotY);
            }
        }
    }

    private void renderRingSlotTooltips(GuiGraphics graphics, int mouseX, int mouseY) {
        int guiX = (width - imageWidth) / 2;
        int guiY = (height - imageHeight) / 2;

        var handler = this.menu.getHandler(); // ← ここも同様に

        for (int i = 0; i < 2; i++) {
            int slotX = guiX + 71 + i * 18;
            int slotY = guiY + 20;

            ItemStack stack = handler.getStackInSlot(i);

            if (stack.isEmpty() &&
                    mouseX >= slotX && mouseX < slotX + 16 &&
                    mouseY >= slotY && mouseY < slotY + 16) {
                graphics.renderTooltip(this.font, Component.translatable("tooltip.osmiumsmagic.ring"), mouseX, mouseY);
            }
        }
    }
}
