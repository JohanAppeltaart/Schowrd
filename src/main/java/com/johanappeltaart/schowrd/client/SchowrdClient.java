package com.johanappeltaart.schowrd.client;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("deprecation")
public class SchowrdClient {
    public static void subscribeClientEvents()
    {
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(SchowrdClient::onClientSetup);
//        modEventBus.addListener(SchowrdClient::registerItemColors);
//        forgeBus.addListener(FluidRender::sugarWaterOverlay);
    }

    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup(FMLClientSetupEvent event) {
//        RenderingRegistry.registerEntityRenderingHandler(BzEntities.HONEY_SLIME, HoneySlimeRendering::new);
//        SkyPropertiesAccessor.getBY_ResourceLocation().put(new ResourceLocation(Schowrd.MOD_ID, "sky_property"), new BzSkyProperty());

        DeferredWorkQueue.runLater(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BANANA_SAPLING.get(), RenderType.getCutout());
//            RenderTypeLookup.setRenderLayer(BzBlocks.STICKY_HONEY_RESIDUE, RenderType.getCutout());
//            RenderTypeLookup.setRenderLayer(BzBlocks.HONEY_CRYSTAL, RenderType.getTranslucent());
//            RenderTypeLookup.setRenderLayer(BzBlocks.SUGAR_WATER_BLOCK, RenderType.getTranslucent());
//            RenderTypeLookup.setRenderLayer(BzBlocks.SUGAR_WATER_FLUID, RenderType.getTranslucent());
//            RenderTypeLookup.setRenderLayer(BzBlocks.SUGAR_WATER_FLUID_FLOWING, RenderType.getTranslucent());
        });

    }
}
