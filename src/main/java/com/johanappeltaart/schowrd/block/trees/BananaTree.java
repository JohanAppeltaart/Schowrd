package com.johanappeltaart.schowrd.block.trees;

import com.johanappeltaart.schowrd.features.ModFeatures;
import net.minecraft.block.trees.BigTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class BananaTree extends BigTree {
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig,?> createTreeFeature(Random p_225546_1_, boolean p_225546_2_) {
        return ModFeatures.BANANA_TREE;
    }
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> createLargeTreeFeature(Random p_225547_1_) {
        return ModFeatures.BIG_BANANA_TREE;
    }
}
