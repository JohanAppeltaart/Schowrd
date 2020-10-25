package com.johanappeltaart.schowrd.surfacebuilders;

//import com.telepathicgrunt.schowrd.Bumblezone;
import com.johanappeltaart.schowrd.Schowrd;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class BzSurfaceBuilders {
    public static final SurfaceBuilder<SurfaceBuilderConfig> BANANA_SURFACE_BUILDER = new HoneySurfaceBuilder(SurfaceBuilderConfig.CODEC);

    public static void registerSurfaceBuilders() {
        Registry.register(Registry.SURFACE_BUILDER, new ResourceLocation(Schowrd.MOD_ID, "banana_surface_builder"), BANANA_SURFACE_BUILDER);
    }
}
