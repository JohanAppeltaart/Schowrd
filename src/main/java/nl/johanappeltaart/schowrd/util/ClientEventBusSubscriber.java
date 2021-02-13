package nl.johanappeltaart.schowrd.util;

import nl.johanappeltaart.schowrd.Schowrd;
import nl.johanappeltaart.schowrd.client.gui.SecretBananaChestScreen;
//import com.johanappeltaart.schowrd.client.render.BananaBoatRenderer;
import nl.johanappeltaart.schowrd.init.ModBlocks;
//import nl.johanappeltaart.schowrd.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Schowrd.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
//        ScreenManager.registerFactory(ModContainerTypes.BANANA_CHEST, SecretBananaChestScreen::new);
        RenderTypeLookup.setRenderLayer(ModBlocks.BANANA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BANANA_GRASS_BLOCK.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.BANANA_LEAVES.get(), RenderType.getCutoutMipped());
//        RenderTypeLookup.setRenderLayer(ModBlocks.DDD_BANANA.get(),RenderType.getCutoutMipped());

//        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BANANA_BOAT.get(), BananaBoatRenderer::new);
    }

}
