package com.johanappeltaart.schowrd.client.gui;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.container.SecretBananaChestContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//public class BananaChestScreen extends ChestScreen {
//
//    public BananaChestScreen(ChestContainer p_i51095_1_, PlayerInventory p_i51095_2_, ITextComponent p_i51095_3_) {
//        super(p_i51095_1_, p_i51095_2_, p_i51095_3_);
//    }
//}
@OnlyIn(Dist.CLIENT)
public class SecretBananaChestScreen extends ContainerScreen<SecretBananaChestContainer> implements IHasContainer<SecretBananaChestContainer> {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Schowrd.MOD_ID, "textures/gui/banana_chest.png");
    private final int inventoryRows;

    public SecretBananaChestScreen(SecretBananaChestContainer p_i51095_1_, PlayerInventory p_i51095_2_, ITextComponent p_i51095_3_) {
        super(p_i51095_1_, p_i51095_2_, p_i51095_3_);
        this.passEvents = false;
        int i = 222;
        int j = 114;
        this.inventoryRows = 22;//p_i51095_1_.getNumRows();
        this.ySize = 114 + this.inventoryRows * 18;
        this.playerInventoryTitleY = this.ySize - 94;
    }

    public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        this.renderBackground(p_230430_1_);
        super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
        this.renderHoveredTooltip(p_230430_1_, p_230430_2_, p_230430_3_);
    }

    protected void drawGuiContainerBackgroundLayer(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.blit(p_230450_1_, i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.blit(p_230450_1_, i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }

//
//    public BananaChestScreen(BananaChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
//        super(screenContainer, inv, titleIn);
//        this.guiLeft = 0;
//        this.guiTop = 0;
//        this.xSize = 175;
//        this.ySize = 183;
//    }
//
//    @Override
//    protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
//    }
//    /** The ResourceLocation containing the chest GUI texture. */
//    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Schowrd.MOD_ID, "textures/gui/banana_chest.png");
////    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
//    /** Window height is calculated with these values; the more rows, the higher */
//    private final int inventoryRows;
//
//    public SecretBananaChestScreen(SecretBananaChestContainer p_i51095_1_, PlayerInventory p_i51095_2_, ITextComponent p_i51095_3_) {
//        super(p_i51095_1_, p_i51095_2_, p_i51095_3_);
//        this.passEvents = false;
//        int i = 222;
//        int j = 114;
//        this.inventoryRows = p_i51095_1_.getNumRows();
//        this.ySize = 185;//114+ this.inventoryRows * 18;
//        this.playerInventoryTitleY = this.ySize - 94;
//    }
//
//    public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
//        this.renderBackground(p_230430_1_);
//        super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
//        this.drawMouseoverTooltip(p_230430_1_, p_230430_2_, p_230430_3_);
//    }
//
//    //drawguicontainerbackground
//    protected void drawBackground(MatrixStack matrixStack, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        this.client.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
//        int i = (this.width - this.xSize) / 2;
//        int j = (this.height - this.ySize) / 2;
////        this.func_238474_b_(p_230450_1_,i,j,0,0,this.xSize,this.ySize);
//        this.drawTexture(matrixStack, i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);//17
//        this.drawTexture(matrixStack, i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
//    }

}