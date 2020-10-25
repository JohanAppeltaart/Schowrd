package com.johanappeltaart.schowrd.features;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.DarkOakFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModFeatures {
//    public static final DeferredRegister<T extends IForgeRegistryEntry<T>> FEATURE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, Schowrd.MOD_ID);
//    public static final ConfiguredFeature<BaseTreeFeatureConfig,?> BANANA_TREE = FEATURE_DEFERRED_REGISTER.register("banana_tree",Feature.TREE.configure((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.BANANA_LEAVES.get().getDefaultState()), new AcaciaFoliagePlacer(FeatureSpread.of(2), FeatureSpread.of(0)), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA = register("banana", Feature.TREE.configure((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.BANANA_LEAVES.get().getDefaultState()), new AcaciaFoliagePlacer(FeatureSpread.of(2), FeatureSpread.of(0)), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));

//    private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value)
//    {
//        return Registry.register(Registry.FEATURE, new ResourceLocation(Schowrd.MOD_ID, key), value);
//    }
private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
    return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
}
}
