//package com.johanappeltaart.schowrd.generation.layer;
//
//import com.johanappeltaart.schowrd.Schowrd;
//import com.johanappeltaart.schowrd.generation.BoundlessBananasBiomeProvider;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.layer.traits.ICastleTransformer;
//
//
//public enum BoundlessBananasBiomeScalePillarLayer implements ICastleTransformer {
//    INSTANCE;
//
//    private static final ResourceLocation HIVE_PILLAR = new ResourceLocation(Schowrd.MOD_ID, "hive_pillar");
//
//    public int apply(INoiseRandom context, int n, int e, int s, int w, int center) {
//        int hive_pillar_id = BoundlessBananasBiomeProvider.layersBiomeRegistry.getId(BoundlessBananasBiomeProvider.layersBiomeRegistry.getOrDefault(HIVE_PILLAR));
//        if(center != hive_pillar_id){
//            boolean borderingHivePillar = false;
//
//            if((n == hive_pillar_id ||
//                e == hive_pillar_id) ||
//                    (w == hive_pillar_id ||
//                    s == hive_pillar_id)) {
//                borderingHivePillar = true;
//            }
//
//            if (borderingHivePillar) {
//                return hive_pillar_id;
//            }
//        }
//        return center;
//    }
//}