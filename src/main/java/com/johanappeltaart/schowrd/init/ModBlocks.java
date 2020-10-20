package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.block.*;
import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.block.trees.BananaTree;
import net.minecraft.block.*;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraftforge.fml.RegistryObject;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Schowrd.MOD_ID);
    //banana ingot then bars and ingot to tool with furnace idk banana chest
    //banana door big boi door, paxel and idk

    //Blocks
    public static final RegistryObject<Block> BANANA_BLOCK = BLOCKS.register("banana_block", BananaBlock::new);
    public static final RegistryObject<Block> BANANA_IRON_BLOCK = BLOCKS.register("banana_iron_block", BananaBlock::new);
    public static final RegistryObject<Block> BANANA_CAKE = BLOCKS.register("banana_cake", BananaCake::new);

    //Chest
    public static final RegistryObject<Block> BANANA_CHEST = BLOCKS.register("banana_chest", BananaChest::new);

    //Tree Stuff
    public static final RegistryObject<Block> BANANA_PLANKS = BLOCKS.register("banana_planks", BananaPlanks::new);
    public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("banana_log", BananaLog::new);
    public static final RegistryObject<Block> STRIPPED_BANANA_LOG = BLOCKS.register("stripped_banana_log", BananaLog::new);
    public static final RegistryObject<Block> BANANA_LEAVES = BLOCKS.register("banana_leaves",()-> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", ()-> new SaplingBlock(new BananaTree(),Block.Properties.from(Blocks.OAK_SAPLING)));

}
