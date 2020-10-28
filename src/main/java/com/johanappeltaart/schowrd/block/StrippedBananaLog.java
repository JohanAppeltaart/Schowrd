package com.johanappeltaart.schowrd.block;

import com.johanappeltaart.schowrd.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.Property;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.concurrent.atomic.AtomicReference;

public class StrippedBananaLog extends RotatedPillarBlock {
    public StrippedBananaLog() {
        super(Properties.create(
                Material.WOOD,MaterialColor.GOLD)
                .hardnessAndResistance(2.0F)
                .slipperiness(1.2F)
                .sound(SoundType.WOOD));
    }
}
