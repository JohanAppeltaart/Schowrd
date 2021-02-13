package nl.johanappeltaart.schowrd.init;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;

public class ModFeatures {
public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_TREE = register("banana_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.BANANA_LEAVES.get().getDefaultState()), new AcaciaFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0)), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_BANANA_TREE = register("mega_banana_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.BANANA_LEAVES.get().getDefaultState()), new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), FeatureSpread.func_242253_a(13, 4)), new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).setDecorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(ModBlocks.BANANA_BLOCK.get().getDefaultState())))).build()));
    public static final ConfiguredFeature<?, ?> BANANA_TREES = register("banana_trees",Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BANANA_TREE.withChance(0.025641026F),MEGA_BANANA_TREE.withChance(0.025641026F),MEGA_BANANA_TREE.withChance(0.33333334F),Features.OAK.withChance(0.1F),Features.DARK_OAK.withChance(0.1f)), BANANA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> BANANA_BLOCK = register("banana_block", Feature.ORE.withConfiguration(new OreFeatureConfig(ModOreFeatureConfig.FillerBlockType.BANANA_DIRT_OVERWORLD, ModBlocks.BANANA_BLOCK.get().getDefaultState(), 9)).range(32).square().func_242731_b(2));

    public static final ConfiguredFeature<?, ?> BANANA_BLOCK_PACKED = register("banana_block_packed", Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(ModBlocks.BANANA_BLOCK.get().getDefaultState())).withPlacement(Placement.ICEBERG.configure(NoPlacementConfig.INSTANCE)).chance(16));



    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> p_243968_1_) {
    return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, p_243968_1_);
}
}
