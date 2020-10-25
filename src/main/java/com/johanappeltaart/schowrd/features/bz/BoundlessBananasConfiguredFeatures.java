//package com.johanappeltaart.schowrd.features;
//
//import com.google.common.collect.ImmutableSet;
//import com.johanappeltaart.schowrd.Schowrd;
//import com.johanappeltaart.schowrd.features.decorators.BzPlacements;
////import com.telepathicgrunt.the_Schowrd.Bumblezone;
////import com.telepathicgrunt.the_Schowrd.blocks.BoundlessBananasBlocks;
////import com.telepathicgrunt.the_Schowrd.features.decorators.BzPlacements;
//import net.minecraft.block.Blocks;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.util.registry.WorldGenRegistries;
//import net.minecraft.world.gen.feature.*;
//import net.minecraft.world.gen.placement.IPlacementConfig;
//import net.minecraft.world.gen.placement.Placement;
//import net.minecraft.world.gen.placement.TopSolidRangeConfig;
//
//public class BoundlessBananasConfiguredFeatures {
//    private static final LiquidsConfig SUGAR_WATER_SPRING_CONFIG = new LiquidsConfig(Fluids.WATER.getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.HONEY_BLOCK, Blocks.HONEYCOMB_BLOCK));
//    public static final ConfiguredFeature<?,?> SUGAR_WATERFALL_HIGH = Feature.SPRING_FEATURE.configure(SUGAR_WATER_SPRING_CONFIG).decorate(Placement.RANGE.configure(new TopSolidRangeConfig(128, 0, 128)).repeat(2));
//    public static final ConfiguredFeature<?,?> SUGAR_WATERFALL_LOW = Feature.SPRING_FEATURE.configure(SUGAR_WATER_SPRING_CONFIG).decorate(Placement.RANGE.configure(new TopSolidRangeConfig(128, 40, 72)).repeat(5));
//    public static final ConfiguredFeature<?,?> SUGAR_WATERFALL_FULL_RANGE = Feature.SPRING_FEATURE.configure(SUGAR_WATER_SPRING_CONFIG).decorate(Placement.RANGE.configure(new TopSolidRangeConfig(40, 0, 128)).repeat(2));
//    public static final ConfiguredFeature<?,?> HONEYCOMB_CAVES = BzFeatures.HONEYCOMB_CAVES.configure(IFeatureConfig.NO_FEATURE_CONFIG).decorate(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
//    public static final ConfiguredFeature<?,?> HONEYCOMB_HOLE = BzFeatures.HONEYCOMB_HOLE.configure(IFeatureConfig.NO_FEATURE_CONFIG).decorate(BzPlacements.HONEYCOMB_HOLE_PLACER.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
//    public static final ConfiguredFeature<?,?> BEE_DUNGEON = BzFeatures.BEE_DUNGEON.configure(IFeatureConfig.NO_FEATURE_CONFIG).decorate(BzPlacements.BEE_DUNGEON_PLACER.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
////    public static final ConfiguredFeature<?,?> SPIDER_INFESTED_BEE_DUNGEON = BzFeatures.SPIDER_INFESTED_BEE_DUNGEON.configure(IFeatureConfig.NO_FEATURE_CONFIG).decorate(BzPlacements.BEE_DUNGEON_PLACER.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
////    public static final ConfiguredFeature<?,?> HONEY_CRYSTALS_COMMON = BzFeatures.HONEY_CRYSTAL_FEATURE.configure(IFeatureConfig.NO_FEATURE_CONFIG).decorate(BzPlacements.RANDOM_3D_UNDERGROUND_CHUNK_PLACEMENT.configure(new FeatureSpreadConfig(4)));
////    public static final ConfiguredFeature<?,?> HONEY_CRYSTALS_UNCOMMON = BzFeatures.HONEY_CRYSTAL_FEATURE.configure(IFeatureConfig.NO_FEATURE_CONFIG).decorate(BzPlacements.RANDOM_3D_UNDERGROUND_CHUNK_PLACEMENT.configure(new FeatureSpreadConfig(2)));
////    public static final ConfiguredFeature<?,?> HONEY_CRYSTALS_RARE = BzFeatures.HONEY_CRYSTAL_FEATURE.configure(IFeatureConfig.NO_FEATURE_CONFIG).decorate(BzPlacements.RANDOM_3D_UNDERGROUND_CHUNK_PLACEMENT.configure(new FeatureSpreadConfig(1)));
//    public static final ConfiguredFeature<?,?> CAVE_SUGAR_WATERFALL = BzFeatures.CAVE_SUGAR_WATERFALL.configure(IFeatureConfig.NO_FEATURE_CONFIG).decorate(Placement.RANGE.configure(new TopSolidRangeConfig(8, 0, 248)).repeat(100));
//
//    public static void registerConfiguredFeatures(){
//        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
//
//        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "sugar_waterfall_high"), SUGAR_WATERFALL_HIGH);
//        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "sugar_waterfall_low"), SUGAR_WATERFALL_LOW);
//        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "sugar_waterfall_full_range"), SUGAR_WATERFALL_FULL_RANGE);
//        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "honeycomb_caves"), HONEYCOMB_CAVES);
//        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "honeycomb_holes"), HONEYCOMB_HOLE);
//        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "bee_dungeon"), BEE_DUNGEON);
////        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "spider_infested_bee_dungeon"), SPIDER_INFESTED_BEE_DUNGEON);
////        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "honey_crystals_common"), HONEY_CRYSTALS_COMMON);
////        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "honey_crystals_uncommon"), HONEY_CRYSTALS_UNCOMMON);
////        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "honey_crystals_rare"), HONEY_CRYSTALS_RARE);
//        Registry.register(registry, new ResourceLocation(Schowrd.MOD_ID, "cave_sugar_waterfall"), CAVE_SUGAR_WATERFALL);
//    }
//}
