//package com.johanappeltaart.schowrd.generation.layer;
//
//import com.johanappeltaart.schowrd.Schowrd;
//import com.johanappeltaart.schowrd.generation.BoundlessBananasBiomeProvider;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.layer.traits.ICastleTransformer;
//
//
//public enum BoundlessBananasBiomePillarLayer implements ICastleTransformer {
//    INSTANCE;
//
//    private static final ResourceLocation HIVE_PILLAR = new ResourceLocation(Schowrd.MOD_ID, "hive_pillar");
//    public int apply(INoiseRandom context, int n, int e, int s, int w, int center) {
//
//        if (context.random(12) == 0 && n == center && e == center && s == center && w == center) {
//            return BoundlessBananasBiomeProvider.layersBiomeRegistry.getId(BoundlessBananasBiomeProvider.layersBiomeRegistry.getOrDefault(HIVE_PILLAR));
//        }
//
//        return center;
//    }
//
//}