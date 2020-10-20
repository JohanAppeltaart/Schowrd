package com.johanappeltaart.schowrd.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BananaPlanks extends Block {
	public BananaPlanks() {
		super(Block.Properties.create(Material.WOOD,MaterialColor.WOOD)
				.hardnessAndResistance(2.0f)
				.slipperiness(1.1f)
				.sound(SoundType.WOOD)
				.harvestLevel(0)
				.harvestTool(ToolType.AXE)
				);
	}
}
