package nl.johanappeltaart.schowrd.world.biomes;

import nl.johanappeltaart.schowrd.init.BiomeTemplate;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;

public class BananaBiome extends BiomeTemplate {
    public BananaBiome()
    {
//        this.addWeight(BOPClimates.ICE_CAP, 5);
        this.setBeachBiome(null);
        this.setRiverBiome(null);
    }

    @Override
    protected void configureBiome(Biome.Builder builder)
    {
        builder.precipitation(Biome.RainType.SNOW).category(Biome.Category.ICY).depth(7.5F).scale(0.2F).temperature(-0.25F).downfall(0.3F);

        builder.setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(calculateSkyColor(-0.25F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build());
    }

    @Override
    protected void configureGeneration(BiomeGenerationSettings.Builder builder)
    {
//        builder.surfaceBuilder(new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.DEEP_TOP_LAYER, BOPSurfaceBuilders.SNOW_SNOW_GRAVEL_SURFACE));

        // Structures
//        DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
//        builder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);

        // Underground
//        DefaultBiomeFeatures.addLandCarvers(builder);
//        DefaultBiomeFeatures.addDungeons(builder);
//        DefaultBiomeFeatures.addDefaultUndergroundStructures(builder);
//        DefaultBiomeFeatures.addDefaultOres(builder);
//        DefaultBiomeFeatures.addDefaultDisks(builder);
//
//        // Other Features
//        DefaultBiomeFeatures.addSprings(builder);
//        DefaultBiomeFeatures.addEmeraldOre(builder);
//        DefaultBiomeFeatures.addInfestedStone(builder);
//        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    @Override
    protected void configureMobSpawns(MobSpawnInfo.Builder builder)
    {
        // Entities
        builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SNOW_GOLEM, 15, 1, 3));
        builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.LLAMA, 5, 4, 6));
        builder.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.STRAY, 80, 4, 4));
    }
}
