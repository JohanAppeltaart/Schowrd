package com.johanappeltaart.schowrd.client.gui;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.container.BananaChestContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.inventory.ChestScreen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Optional;

//public class BananaChestScreen extends ChestScreen {
//
//    public BananaChestScreen(ChestContainer p_i51095_1_, PlayerInventory p_i51095_2_, ITextComponent p_i51095_3_) {
//        super(p_i51095_1_, p_i51095_2_, p_i51095_3_);
//    }
//}
@OnlyIn(Dist.CLIENT)
public class BananaChestScreen extends ContainerScreen<BananaChestContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Schowrd.MOD_ID, "textures/gui/banana_chest.png");

    public BananaChestScreen(BananaChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 175;
        this.ySize = 183;
    }

    @Override
    protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
    }

}