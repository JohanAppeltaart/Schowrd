package com.johanappeltaart.schowrd.common.biome;

import com.johanappeltaart.schowrd.init.ModBlocks;
import com.johanappeltaart.schowrd.init.ModFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;

public class BananaPlains{
    public static Biome BANANA_PLAINS = new Biome.Builder()
            .scale(1.45f)//0.45F, 0.3F//0.1 0.2
            .temperature(8)
            .category(Biome.Category.FOREST)
            .depth(0.6f)
            .precipitation(Biome.RainType.SNOW)
            .downfall(0.25f)
            .withMobSpawnSettings(
                    new MobSpawnInfoBuilder(MobSpawnInfo.EMPTY)
                    .withCreatureSpawnProbability(0.9f)
                    .withSpawner(EntityClassification.AMBIENT,new MobSpawnInfo.Spawners(EntityType.FOX,50,10,20))
                    .withSpawner(EntityClassification.MONSTER,new MobSpawnInfo.Spawners(EntityType.BEE,1,1,2))
                    .withSpawner(EntityClassification.MONSTER,new MobSpawnInfo.Spawners(EntityType.MAGMA_CUBE,50,10,20))
                    .withSpawner(EntityClassification.MONSTER,new MobSpawnInfo.Spawners(EntityType.BLAZE,50,10,20))
                    .copy()
            )
            .setEffects(
                    new BiomeAmbience.Builder()
                            .setFogColor(12638463)
                            .withFoliageColor(2512021)
                            .setWaterColor(16445696)
                            .setWaterFogColor(16445696)
                            .withSkyColor(16760576)
                            .withGrassColor(2512021)
                            .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                            .build()
            )
            .withGenerationSettings(
                    new BiomeGenerationSettingsBuilder(BiomeGenerationSettings.DEFAULT_SETTINGS)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DEBRIS_LARGE)
                            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,ModFeatures.BANANA_TREES)
//                            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.BANANA_TREE)
//                            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,ModFeatures.MEGA_BANANA_TREE)
                            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_DEFAULT)
                            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER)
                            .withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Features.ICEBERG_PACKED)
                            .withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Features.ICEBERG_BLUE)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_SAND)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_CLAY)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_GRAVEL)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Features.MONSTER_ROOM)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_COAL)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_IRON)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GOLD)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_REDSTONE)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIAMOND)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_LAPIS)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.SPRING_LAVA)
                            .withSurfaceBuilder(DefaultSurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(ModBlocks.BANANA_GRASS_BLOCK.get().getDefaultState(),ModBlocks.BANANA_DIRT.get().getDefaultState(),ModBlocks.DDD_BANANA.get().getDefaultState())))
                            .build()
            )
            .build();
}
//
//    public ExampleBiome(Builder biomeBuilder) {
//        super(biomeBuilder);
//        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
//        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
//        this.addCarver(GenerationStage.Carving.AIR,
//                Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
//        this.addCarver(GenerationStage.Carving.AIR,
//                Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.02F)));
//
//        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
//                Feature.RANDOM_BOOLEAN_SELECTOR
//                        .withConfiguration(new TwoFeatureChoiceConfig(
//                                Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM),
//                                Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
//                        .withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
//        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
//                Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
//                        Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(1, 0.25F))));
//        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
//                Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
//                        Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(1, 0.125F))));
//        // this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
//        // Feature.NORMAL_TREE.withConfiguration(JazzTree.JAZZ_TREE_CONFIG).withPlacement(
//        // Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7,
//        // 0.1f, 1))));
//
//        DefaultBiomeFeatures.addOres(this);
//        DefaultBiomeFeatures.addExtraGoldOre(this);
//        DefaultBiomeFeatures.addExtraEmeraldOre(this);
//    }
//
//    @Override
//    public int getGrassColor(double posX, double posZ) {
//        return 0xFF0000;
//    }
//
//    @Override
//    public int getFoliageColor() {
//        return 0xFF0000;
//    }
//}
