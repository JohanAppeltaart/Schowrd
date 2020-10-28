package com.johanappeltaart.schowrd.items;

import com.google.common.collect.ImmutableMap;
import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.init.ModBlocks;
import com.johanappeltaart.schowrd.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

public class BananaAxeItem extends AxeItem {
//      ()-> new AxeItem(ModItemTier.BANANA,0,-2.4f,new Item.Properties().group(Schowrd.TAB).food(new Food.Builder().hunger(9).saturation(3.0f).effect(()->new EffectInstance(Effects.GLOWING,200),0.8f).effect(()->new EffectInstance(Effects.POISON,60),0.5f).build()
//ImmutableMap.Builder<Block, Block>())
//    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).put(ModBlocks.BANANA_LOG.get(),ModBlocks.STRIPPED_BANANA_LOG.get()).put(Blocks.DIRT,Blocks.DIAMOND_BLOCK).build();
//    AxeItem
    public BananaAxeItem() {//IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder
        super(ModItemTier.BANANA, 0, -2.4F,new Item.Properties()
                .group(Schowrd.TAB)
                .food(new Food.Builder()
                        .hunger(9)
                        .saturation(3.0f)
                .effect(()->new EffectInstance(Effects.GLOWING,200),0.8f)
                .effect(()->new EffectInstance(Effects.POISON,60),0.5f)
              .build()
        ));
    }

//    @Override
//    public ActionResultType onItemUse(ItemUseContext context) {
//        World world = context.getWorld();
//        BlockPos blockpos = context.getPos();
//        BlockState blockstate = world.getBlockState(blockpos);
////        BlockState block = blockstate.getToolModifiedState(world, blockpos, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.AXE);
//        BlockState block = BananaAxeItem.getAxeStrippingState(blockstate);
//        if (block != null) {
//            PlayerEntity playerentity = context.getPlayer();
//            world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
//            if (!world.isRemote) {
//                world.setBlockState(blockpos, block, 11);
//                if (playerentity != null) {
//                    context.getItem().damageItem(1, playerentity, (p_220040_1_) -> {
//                        p_220040_1_.sendBreakAnimation(context.getHand());
//                    });
//                }
//            }
//
//            return ActionResultType.func_233537_a_(world.isRemote);
//        } else {
//            return ActionResultType.PASS;
//        }
//    }
//    public static BlockState getAxeStrippingState(BlockState originalState) {
//        Block block = BLOCK_STRIPPING_MAP.get(originalState.getBlock());
//        return block != null ? block.getDefaultState().with(RotatedPillarBlock.AXIS, originalState.get(RotatedPillarBlock.AXIS)) : null;
//    }
}
