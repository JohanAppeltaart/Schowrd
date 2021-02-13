//package com.johanappeltaart.schowrd.dimension;
//
//import com.johanappeltaart.schowrd.Schowrd;
//import com.johanappeltaart.schowrd.generation.BoundlessBananasBiomeProvider;
//import com.johanappeltaart.schowrd.generation.BoundlessBananasChunkGenerator;
//import net.minecraft.util.RegistryKey;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.World;
//import net.minecraftforge.event.world.BiomeLoadingEvent;
//
//public class BoundlessBananasDimension{
//    public static final RegistryKey<World> BOUNDLESSBANANAS_WORLD_KEY = RegistryKey.of(Registry.DIMENSION, new ResourceLocation(Schowrd.MOD_ID,"boundlessbananas"));
//
//    public static void setupDimension(){
//        BoundlessBananasChunkGenerator.registerChunkgenerator();
//        BoundlessBananasBiomeProvider.registerBiomeProvider();
//    }
//
////    public static void biomeModification(final BiomeLoadingEvent event) {
////        boolean needToAddModCompatFeatures = ModChecker.productiveBeesPresent;
////
////        if(needToAddModCompatFeatures && event.getName().getNamespace().equals(Schowrd.MOD_ID)){
////            //Add our features to the bumblezone biomes
////            ProductiveBeesRedirection.PBAddHoneycombs(event);
////        }
////    }
//}
