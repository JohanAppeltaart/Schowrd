package com.johanappeltaart.schowrd.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BananaBlock extends Block {

	public BananaBlock() {
		super(Block.Properties.create(Material.CACTUS)
				.hardnessAndResistance(1.0f)
				.slipperiness(2.0f)
				.sound(SoundType.CROP)
				.harvestLevel(0)
				.harvestTool(ToolType.HOE)
				);
	}

}
