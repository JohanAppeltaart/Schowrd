//package com.johanappeltaart.schowrd.client.render.color;
//
//import com.google.common.collect.Maps;
//import com.johanappeltaart.schowrd.Schowrd;
//import com.johanappeltaart.schowrd.block.BananaBlock;
//import com.johanappeltaart.schowrd.init.ModBlocks;
//import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.color.BlockColors;
//import net.minecraft.client.renderer.color.IBlockColor;
//import net.minecraft.state.Property;
//import net.minecraft.util.text.Color;
//import net.minecraft.world.GrassColors;
//import net.minecraft.world.biome.BiomeColors;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//import java.util.Map;
//import java.util.Set;
//
//@OnlyIn(Dist.CLIENT)
//public class ModBlockColors {
//    public static final DeferredRegister<BlockColors> BLOCK_COLORS_DEFERRED_REGISTER = (Minecraft.getInstance().getBlockColors());
//
//
//    public static final RegistryObject<BlockColors> BANANA_BLOCK = BLOCK_COLORS_DEFERRED_REGISTER.register("banana_block",BiomeColors.getGrassColor(worlin,blockpos));
////    private BlockColors Minecraft.getMinecraft().getBlockColors();
////    private final java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Block>, IBlockColor> colors = new java.util.HashMap<>();
////    private final Map<Block, Set<Property<?>>> colorStates = Maps.newHashMap();
////    public static BlockColors init(){
////        BlockColors blockcolors = new BlockColors();
////        blockcolors.register((state, reader, pos, color) -> {
////            return reader != null && pos != null ? BiomeColors.getGrassColor(reader, pos) : GrassColors.get(0.5D, 1.0D);
////        }, ModBlocks.BANANA_GRASS_BLOCK.get());
////        return blockcolors;
////    }
////
////
////    public void register(IBlockColor blockColor, Block... blocksIn) {
////        for(Block block : blocksIn) {
////            this.colors.put(block.delegate, blockColor);
////        }
////
////    }
//}
