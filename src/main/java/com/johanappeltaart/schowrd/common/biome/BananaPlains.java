package com.johanappeltaart.schowrd.common.biome;

import com.johanappeltaart.schowrd.init.ModBlocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;

public class BananaPlains{
    public static Biome BANANA_PLAINS = new Biome.Builder()
            .scale(0.1f)
            .temperature(8)
            .category(Biome.Category.FOREST)
            .depth(0.2f)
            .precipitation(Biome.RainType.SNOW)
            .downfall(0.25f)
            .withMobSpawnSettings(
                    new MobSpawnInfoBuilder(MobSpawnInfo.EMPTY)
                    .withCreatureSpawnProbability(0.9f)
                    .withSpawner(EntityClassification.AMBIENT,new MobSpawnInfo.Spawners(EntityType.COMMAND_BLOCK_MINECART,10,2,100))
                    .copy()
            )
            .setEffects(
                    new BiomeAmbience.Builder()
                            .setFogColor(12638463)
                            .withFoliageColor(2512021)
                            .setWaterColor(1251202)
                            .setWaterFogColor(1251202)
                            .withSkyColor(0)
                            .withGrassColor(2512021)
                            .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                            .build()
            )
            .withGenerationSettings(
                    new BiomeGenerationSettingsBuilder(BiomeGenerationSettings.DEFAULT_SETTINGS)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GOLD)
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
