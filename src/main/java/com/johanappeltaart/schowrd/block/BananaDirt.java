package com.johanappeltaart.schowrd.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BananaDirt extends Block {
	public BananaDirt() {
		super(Properties.create(Material.EARTH,MaterialColor.DIRT)
				.hardnessAndResistance(0.5f)
				.slipperiness(1.1f)
				.sound(SoundType.GROUND)
				.tickRandomly()
				.harvestLevel(0)
				.harvestTool(ToolType.SHOVEL)
				);
	}
}
