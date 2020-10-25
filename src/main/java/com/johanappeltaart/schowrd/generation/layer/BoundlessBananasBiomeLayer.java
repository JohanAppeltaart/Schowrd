//package com.johanappeltaart.schowrd.generation.layer;
//
//import com.johanappeltaart.schowrd.Schowrd;
//import com.johanappeltaart.schowrd.generation.BoundlessBananasBiomeProvider;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.SharedSeedRandom;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.PerlinNoiseGenerator;
//import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
//
//import java.util.stream.IntStream;
//
//
//public enum BoundlessBananasBiomeLayer implements IAreaTransformer0 {
//    INSTANCE;
//
//    private static final ResourceLocation SUGAR_WATER = new ResourceLocation(Schowrd.MOD_ID, "sugar_water_floor");
//    private static final ResourceLocation HIVE_WALL = new ResourceLocation(Schowrd.MOD_ID, "hive_wall");
//
//    private static PerlinNoiseGenerator perlinGen;
////	private double max = -100;
////	private double min = 100;
//
//
//    public int apply(INoiseRandom noise, int x, int z) {
//        double perlinNoise = perlinGen.noiseAt((double) x * 0.1D, (double) z * 0.0001D, false);
////
////		max = Math.max(max, perlinNoise);
////		min = Math.min(min, perlinNoise);
////		Schowrd.LOGGER.log(Level.INFO, "Max: " + max +", Min: "+min + ", perlin: "+perlinNoise);
//
//        if (Math.abs(perlinNoise) % 0.1D < 0.07D) {
//            return BoundlessBananasBiomeProvider.layersBiomeRegistry.getId(BoundlessBananasBiomeProvider.layersBiomeRegistry.getOrDefault(HIVE_WALL));
//        }
//        else {
//            return BoundlessBananasBiomeProvider.layersBiomeRegistry.getId(BoundlessBananasBiomeProvider.layersBiomeRegistry.getOrDefault(SUGAR_WATER));
//        }
//    }
//
//
//    public static void setSeed(long seed) {
//        if (perlinGen == null) {
//            SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
//            perlinGen = new PerlinNoiseGenerator(sharedseedrandom, IntStream.rangeClosed(-1, 0));
//        }
//    }
//}