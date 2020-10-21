package com.johanappeltaart.schowrd.util;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.client.gui.BananaChestScreen;
import com.johanappeltaart.schowrd.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Schowrd.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ScreenManager.registerFactory(ModContainerTypes.BANANA_CHEST.get(), BananaChestScreen::new);
    }

}
