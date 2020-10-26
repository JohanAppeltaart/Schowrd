package com.johanappeltaart.schowrd.init;

import com.google.common.collect.ImmutableList;
import com.johanappeltaart.schowrd.init.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModFeatures {
public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_TREE = register("banana_tree", Feature.TREE.configure((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.BANANA_LEAVES.get().getDefaultState()), new AcaciaFoliagePlacer(FeatureSpread.of(2), FeatureSpread.of(0)), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_BANANA_TREE = register("mega_banana_tree", Feature.TREE.configure((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.BANANA_LEAVES.get().getDefaultState()), new MegaPineFoliagePlacer(FeatureSpread.of(0), FeatureSpread.of(0), FeatureSpread.of(13, 4)), new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(ModBlocks.BANANA_BLOCK.get().getDefaultState())))).build()));

private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> p_243968_1_) {
    return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, p_243968_1_);
}
}
