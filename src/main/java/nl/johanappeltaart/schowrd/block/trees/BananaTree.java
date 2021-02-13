package nl.johanappeltaart.schowrd.block.trees;

import nl.johanappeltaart.schowrd.init.ModFeatures;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class BananaTree extends BigTree {
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return ModFeatures.BANANA_TREE;
    }
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeTreeFeature(Random rand) {
        return ModFeatures.MEGA_BANANA_TREE;
    }

}
