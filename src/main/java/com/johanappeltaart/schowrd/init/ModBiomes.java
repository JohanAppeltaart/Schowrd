package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.common.biome.BananaMountains;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Schowrd.MOD_ID);

    public static final RegistryObject<Biome> BANANA_MOUNTAINS = BIOMES.register("banana_mountains",()-> BananaMountains.BANANA_MOUNTAINS);

    public static void registerBiomes(){
        registerBiome(BANANA_MOUNTAINS.get(), BiomeType.WARM,"banana_mountains");
    }
    private static void registerBiome(Biome biome, BiomeType types,String name){
        BiomeManager.addBiome(types,new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY,new ResourceLocation("schowrd",name)),1));
    }
}

