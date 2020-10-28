package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.common.biome.BananaPlains;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//import com.johanappeltaart.schowrd.common.biome.ModBiomeMaker;
//import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
//import net.minecraftforge.common.B
//import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder.Type;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Schowrd.MOD_ID);

    public static final RegistryObject<Biome> BANANA_PLAINS = BIOMES.register("banana_plains",()-> BananaPlains.BANANA_PLAINS);

    public static void registerBiomes(){
        registerBiome(BANANA_PLAINS.get(), BiomeType.WARM);
    }
    private static void registerBiome(Biome biome, BiomeType types){
        BiomeManager.addBiome(types,new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY,new ResourceLocation("schowrd","banana_plains")),1));
//        new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY,new ResourceLocation("banana_plains")),1);
    }
}
//    private static RegistryKey<Biome> makeKey(String name) {
//        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(name));
//    }
//    public static final RegistryKey<Biome> BANANA_PLAINS = makeKey("banana_plains");
////    public static final RegistryKey<Biome> BANANA_PLAINS_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("banana_plains"));
////    public static final RegistryObject<Biome> BANANA_PLAINS_REG = new BiomeManager.BiomeEntry(ModBiomes.BANANA_PLAINS_KEY, 10);//BiomeManager.BiomeEntry(ModBiomes.BANANA_PLAINS_KEY, 10)
////    public static final RegistryObject<Biome> BANANA_PLAINS = BIOMES.register("banana_plains", () -> ModBiomeMaker.makeBanana_Plains(false));
//
//    public static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType bType,BiomeManager.BiomeEntry bEntry){//, Type... types
//        biome.setRegistryName(name);
//        BiomeManager.addBiome(bType,bEntry);
//        return biome;
//    }
//    ModBiomes.registerBiome(23,ModBiomes.BANANA_PLAINS,);
////    BiomeRegistry.fromRawId
//    public static void registerBiome(int i, RegistryKey<Biome> biomeRegistryKey, Biome biome){
//        WorldGenRegistries.set(WorldGenRegistries.BIOME,i,biomeRegistryKey,biome);
//    }
//    public static final RegistryKey<Biome> BANANA_PLAINS = register("banana_plains");
//
//    private static RegistryKey<Biome> register(String p_242548_0_) {
//        return RegistryKey.of(Registry.BIOME_KEY, new ResourceLocation(p_242548_0_));
//    }

//}



    //    public static final RegistryObject<Biome> BANANA_BIOME = BIOMES.register("banana_biome", ()-> new BananaBiome();//new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(1.2F).temperature(0.5f)
////            .category(Biome.Category.PLAINS)
////            .depth(0.12f)
////            .downfall(0.1f).build()));

//public static final RegistryObject<Biome> BANANA_PLAINS = BIOMES.register("banana_plains", ModBiomeMaker.createBananaPlains(false))
////
//    private static RegistryKey<Biome> register(String p_242548_0_) {
//        return RegistryKey.of(BIOMES, new ResourceLocation(p_242548_0_));
//    }
//    public static void register(BiomeTemplate biome,String name) {
//        BiomeRegistry.deferStandardRegistration(biome, name);
//        ModBiomes.BANANA_PLAINS
//@SubscribeEvent
//public static void registerBiomes(RegistryEvent.Register<Biome> event)
//{
//    //Overworld Biomes
//    registerBiome(new AlpsBiome(), "alps");
//    BiomeRegistry..configureVanillaBiomes();
//    BiomeRegistry.finalizeRegistrations(BiomeRegistry.RegistrationType.VANILLA_BIOME);
//
//    registerVillagerTypes();}
