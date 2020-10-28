package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.block.*;
import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.block.trees.BananaTree;
import net.minecraft.block.*;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Schowrd.MOD_ID);
    //banana ingot then bars and ingot to tool with furnace idk banana chest
    //banana door big boi door, paxel and idk
    //banana boots give slipperynes
    //banana biome with dirt an grass and grass blocks and flowers idk?

    //Blocks
    public static final RegistryObject<Block> BANANA_BLOCK = BLOCKS.register("banana_block", BananaBlock::new);
    public static final RegistryObject<Block> BANANA_IRON_BLOCK = BLOCKS.register("banana_iron_block", BananaBlock::new);
    public static final RegistryObject<CakeBlock> BANANA_CAKE = BLOCKS.register("banana_cake", BananaCake::new);
    public static final RegistryObject<Block> BANANA_GRASS_BLOCK = BLOCKS.register("banana_grass_block", BananaGrassBlock::new);
    public static final RegistryObject<Block> BANANA_DIRT = BLOCKS.register("banana_dirt", BananaDirt::new);
//    public static final RegistryObject<Block> BANANA_DIRT = BLOCKS.register("banana_dirt",()-> new Block(Block.Properties.from(Blocks.DIRT)));
    public static final RegistryObject<Block> DDD_BANANA = BLOCKS.register("ddd_banana", DDD_Banana::new);
    //Chest
    public static final RegistryObject<Block> SECRET_BANANA_CHEST = BLOCKS.register("secret_banana_chest",BananaChestBlock::new);
    //Door
    public static final RegistryObject<DoorBlock> BANANA_DOOR = BLOCKS.register("banana_door",BananaDoorBlock::new);
    //fence stuff
    public static final RegistryObject<FenceBlock> BANANA_FENCE = BLOCKS.register("banana_fence",BananaFenceBlock::new);
    public static final RegistryObject<FenceGateBlock> BANANA_FENCE_GATE = BLOCKS.register("banana_fence_gate",BananaFenceGateBlock::new);

    //Tree Stuff
    public static final RegistryObject<Block> BANANA_PLANKS = BLOCKS.register("banana_planks", BananaPlanks::new);
    public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("banana_log", BananaLog::new);
    public static final RegistryObject<Block> STRIPPED_BANANA_LOG = BLOCKS.register("stripped_banana_log", StrippedBananaLog::new);
    public static final RegistryObject<Block> BANANA_LEAVES = BLOCKS.register("banana_leaves",()-> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", ()-> new SaplingBlock(new BananaTree(),Block.Properties.from(Blocks.OAK_SAPLING)));

}
