package com.johanappeltaart.schowrd.items;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.johanappeltaart.schowrd.util.BlockposArray;
import com.johanappeltaart.schowrd.util.helpers.KeyboardHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BetterHoeItem extends HoeItem {
    int sizeRadius;

    public BetterHoeItem(int sizeRadius,IItemTier tier,float attackDamageIn, float attackSpeedIn,Properties builderIn) {
        super(tier, (int) attackDamageIn, attackSpeedIn, builderIn);
        //x2 -1 gives x by z size of radius
        this.sizeRadius = sizeRadius;
    }
    @Override
    public ActionResultType onItemUse(ItemUseContext context){
        World world = context.getWorld();
        PlayerEntity playerentity = context.getPlayer();


        @NotNull BlockPos[] blockpositions = BlockposArray.BlockposArrayfromNum(context,(sizeRadius-1),(sizeRadius-1));
        LogManager.getLogger().info("bhibpos length  "+blockpositions.length);
        LogManager.getLogger().info("sizeradios "+sizeRadius);
        //49
        //25  2
        //x x+1*x+1  -1
//        if(blockpositions.length==0){return ActionResultType.func_233537_a_(world.isRemote);}
        boolean tilledABlock = false;
        int blockPosArrayLength = ((sizeRadius+sizeRadius-1)*(sizeRadius+sizeRadius-1)-1);
        for(int i=0;i<=blockPosArrayLength;i++) {
            BlockPos blockpos = blockpositions[i];
            if (context.getFace() != Direction.DOWN && world.isAirBlock(blockpos.up())) {
                BlockState blockstate = world.getBlockState(blockpos).getToolModifiedState(world, blockpos, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);

                if (blockstate != null) {
                    tilledABlock=true;
                    world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (!world.isRemote) {
                        world.setBlockState(blockpos, blockstate, 11);

                    }
                }
            }
                if (i == blockPosArrayLength) {
                    if (!world.isRemote) {
                        if (playerentity != null&&tilledABlock) {
                            context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {
                                p_220043_1_.sendBreakAnimation(context.getHand());
                            });
                        }
                    }

                    return ActionResultType.func_233537_a_(world.isRemote);
                }
        }




        return ActionResultType.PASS;
    }
}
//123
//456
//789
//        BlockPos blockpositions[] = {context.getPos().north().west()
//                ,context.getPos().north()
//                ,context.getPos().north().east()
//                ,context.getPos().west()
//                ,context.getPos()
//                ,context.getPos().east()
//                ,context.getPos().south().west()
//                ,context.getPos().south()
//                ,context.getPos().south().east()
//        };
//        BlockPos blockpos1 = context.getPos().north().west();
//        BlockPos blockpos2 = context.getPos().north();
//        BlockPos blockpos3 = context.getPos().north().east();
//        BlockPos blockpos4 = context.getPos().west();
//        BlockPos blockpos5 = context.getPos();
//        BlockPos blockpos6 = context.getPos().east();
//        BlockPos blockpos7 = context.getPos().south().west();
//        BlockPos blockpos8 = context.getPos().south();
//        BlockPos blockpos9 = context.getPos().south().east();