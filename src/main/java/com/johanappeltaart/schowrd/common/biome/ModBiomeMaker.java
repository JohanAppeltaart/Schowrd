//package com.johanappeltaart.schowrd.common.biome;
//
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.world.biome.*;
//import net.minecraft.world.gen.GenerationStage;
//import net.minecraft.world.gen.feature.Features;
//import net.minecraft.world.gen.feature.structure.StructureFeatures;
//import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
//
//public class ModBiomeMaker {
//    private static int getSkyColorWithTemperatureModifier(float p_244206_0_) {
//        float lvt_1_1_ = p_244206_0_ / 3.0F;
//        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
//        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
//    }
//
//    public static Biome makeBanana_Plains(boolean isSunflowerVariant) {
//        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
//        DefaultBiomeFeatures.withSpawnsWithHorseAndDonkey(mobspawninfo$builder);
//        if (!isSunflowerVariant) {
//            mobspawninfo$builder.isValidSpawnBiomeForPlayer();
//        }
//
//        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);
//        if (!isSunflowerVariant) {
//            biomegenerationsettings$builder.withStructure(StructureFeatures.field_244154_t).withStructure(StructureFeatures.field_244135_a);
//        }
//
//        DefaultBiomeFeatures.withStrongholdAndMineshaft(biomegenerationsettings$builder);
//        biomegenerationsettings$builder.withStructure(StructureFeatures.field_244159_y);
//        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
//        DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
//        DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
//        DefaultBiomeFeatures.withNoiseTallGrass(biomegenerationsettings$builder);
//        if (isSunflowerVariant) {
//            biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER);
//        }
//
//        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
//        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
//        DefaultBiomeFeatures.withDisks(biomegenerationsettings$builder);
//        DefaultBiomeFeatures.withPlainGrassVegetation(biomegenerationsettings$builder);
//        if (isSunflowerVariant) {
//            biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);
//        }
//
//        DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
//        if (isSunflowerVariant) {
//            biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
//        } else {
//            DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomegenerationsettings$builder);
//        }
//
//        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
//        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
//        return (new Biome.Builder()).precipitation(Biome.RainType.SNOW).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(mobspawninfo$builder.copy()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
//    }
//}
