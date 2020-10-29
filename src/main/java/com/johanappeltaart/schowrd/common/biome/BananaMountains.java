package com.johanappeltaart.schowrd.common.biome;

import com.johanappeltaart.schowrd.init.ModBlocks;
import com.johanappeltaart.schowrd.init.ModFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;

public class BananaMountains {
    public static Biome BANANA_MOUNTAINS = new Biome.Builder()
            .scale(1.45f)//0.45F, 0.3F//0.1 0.2
            .temperature(8)
            .category(Biome.Category.PLAINS)
            .depth(0.6f)
            .precipitation(Biome.RainType.SNOW)
            .downfall(0.25f)
            .withMobSpawnSettings(
                    new MobSpawnInfoBuilder(MobSpawnInfo.EMPTY)
                            .withCreatureSpawnProbability(0.9f)
                            .withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.FOX, 50, 10, 20))
                            .withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.MOOSHROOM, 50, 10, 20))
                            .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.BEE, 1, 1, 2))
                            .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.MAGMA_CUBE, 50, 10, 20))
                            .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.BLAZE, 50, 10, 20))
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
                            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.BANANA_TREES)
                            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_PLAIN_DECORATED)
                            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER)
                            .withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, ModFeatures.BANANA_BLOCK_PACKED)
                            .withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.BLUE_ICE)
                            .withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Features.ICEBERG_BLUE)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_SAND)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_CLAY)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_GRAVEL)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Features.FOSSIL)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Features.MONSTER_ROOM)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_COAL)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_IRON)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GOLD)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_REDSTONE)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIAMOND)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_LAPIS)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.SPRING_LAVA)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.BANANA_BLOCK)
                            //nether stuff
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_OPEN)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_SOUL_FIRE)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA)
                            .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED)


                            .withCarver(GenerationStage.Carving.AIR, WorldCarver.CAVE.func_242761_a(new ProbabilityConfig(0.2f)))
                            .withCarver(GenerationStage.Carving.AIR, WorldCarver.CANYON.func_242761_a(new ProbabilityConfig(0.3f)))
                            .withSurfaceBuilder(DefaultSurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(ModBlocks.BANANA_GRASS_BLOCK.get().getDefaultState(), ModBlocks.BANANA_DIRT.get().getDefaultState(), ModBlocks.BANANA_GRAVEL.get().getDefaultState())))
                            .build()
            )
            .build();
}