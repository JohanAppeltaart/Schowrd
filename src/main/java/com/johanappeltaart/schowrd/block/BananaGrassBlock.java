package com.johanappeltaart.schowrd.block;

import net.minecraft.block.Block;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BananaGrassBlock extends GrassBlock {
	public BananaGrassBlock() {
		super(Properties.create(Material.GOURD,MaterialColor.ORANGE_TERRACOTTA)
				.hardnessAndResistance(0.6f)
				.slipperiness(1.1f)
				.sound(SoundType.PLANT)
				.tickRandomly()
				.harvestLevel(0)
				.harvestTool(ToolType.SHOVEL)
				);
	}
}
