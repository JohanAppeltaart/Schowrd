package com.johanappeltaart.schowrd.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class BananaGravel extends FallingBlock {
	public BananaGravel() {
		super(Properties.create(Material.EARTH,MaterialColor.GRAY)
				.hardnessAndResistance(0.5f)
				.slipperiness(1.1f)
				.sound(SoundType.GROUND)
				.tickRandomly()
				.harvestLevel(0)
				.harvestTool(ToolType.SHOVEL)
				);
	}
	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState state, IBlockReader reader, BlockPos pos) {
		return -14671872;
	}
}
