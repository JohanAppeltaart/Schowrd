package com.johanappeltaart.schowrd.common.biome;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class ModBiomeMaker {
    private static int getSkyColor(float p_244206_0_) {
        float lvt_1_1_ = p_244206_0_ / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome createBananaPlains(boolean p_244226_0_) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.addPlainsMobs(mobspawninfo$builder);
        if (!p_244226_0_) {
            mobspawninfo$builder.playerSpawnFriendly();
        }

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        if (!p_244226_0_) {
            biomegenerationsettings$builder.structureFeature(StructureFeatures.VILLAGE_PLAINS).structureFeature(StructureFeatures.PILLAGER_OUTPOST);
        }

        DefaultBiomeFeatures.addDefaultUndergroundStructures(biomegenerationsettings$builder);
        biomegenerationsettings$builder.structureFeature(StructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.addLandCarvers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDungeons(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addPlainsTallGrass(biomegenerationsettings$builder);
        if (p_244226_0_) {
            biomegenerationsettings$builder.feature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER);
        }

        DefaultBiomeFeatures.addMineables(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addPlainsFeatures(biomegenerationsettings$builder);
        if (p_244226_0_) {
            biomegenerationsettings$builder.feature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);
        }

        DefaultBiomeFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        if (p_244226_0_) {
            biomegenerationsettings$builder.feature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
        } else {
            DefaultBiomeFeatures.addDefaultVegetation(biomegenerationsettings$builder);
        }

        DefaultBiomeFeatures.addSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addFrozenTopLayer(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).effects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(getSkyColor(0.8F)).moodSound(MoodSoundAmbience.CAVE).build()).spawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }
}
