package com.johanappeltaart.schowrd;

import com.johanappeltaart.schowrd.capabilities.CapabilityPlayerPosAndDim;
import com.johanappeltaart.schowrd.configs.BoundlessBananasDungeonsConfigs;
//import com.johanappeltaart.schowrd.dimension.BoundlessBananasDimension;
//import com.johanappeltaart.schowrd.configs.BoundlessBananasDimensionConfigs;
import com.johanappeltaart.schowrd.features.ModFeatures;
import com.johanappeltaart.schowrd.init.*;
import com.johanappeltaart.schowrd.util.ConfigHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("schowrd")
public class Schowrd
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "schowrd";
//    public static final ResourceLocation MOD_DIMENSION_ID = new ResourceLocation(Schowrd.MOD_ID, "boundlessbananas");

//    public static BoundlessBananasDimensionConfigs.BoundlessBananasDimensionConfigValues BoundlessBananasDimensionConfig = null;
//    public static BoundlessBananasDungeonsConfigs.BoundlessBananasDungeonsConfigValues BoundlessBananasDungeonsConfig = null;

    public Schowrd() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModContainerTypes.CONTAINER_TYPE.register((FMLJavaModLoadingContext.get().getModEventBus()));
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
//        ModFeatures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

//        BoundlessBananasDimensionConfig = ConfigHelper.register(ModConfig.Type.SERVER, BoundlessBananasDimensionConfigs.BoundlessBananasDimensionConfigValues::new, "schowrd-dimension.toml");
//        BoundlessBananasDungeonsConfig = ConfigHelper.register(ModConfig.Type.SERVER, BoundlessBananasDungeonsConfigs.BoundlessBananasDungeonsConfigValues::new, "schowrd-dungeons.toml");


    }

    private void setup(final FMLCommonSetupEvent event)
    {
//        CapabilityPlayerPosAndDim.register();
//        BoundlessBananasDimension.setupDimension();

//        DeferredWorkQueue.runLater(()->{
//            //GlobalEntityTypeAttributes.put(ModEntityTypes.BANANA_BOAT.get(),
////            GlobalEntityTypeAttributes.put(ModEntityTypes.BANANA_BOAT.get(),BananaBoatEntity.getRenderDistanceWeight());
//            GlobalEntityTypeAttributes.func_233837_b_(ModEntityTypes.BANANA_BOAT.get());
//        });

        // some preinit code
        LOGGER.info("HELLO FROM BANANAS");
        LOGGER.info("BANANA BLOCK =! >> {}", Blocks.BONE_BLOCK.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
//        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }
    
    public static final ItemGroup TAB = new ItemGroup("schowrdTab") {
    	@Override  
    	public ItemStack createIcon() {
    		return new ItemStack(ModItems.BANANA.get());
    	}
    };

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
