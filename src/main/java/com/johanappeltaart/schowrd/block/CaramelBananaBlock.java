package com.johanappeltaart.schowrd.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CaramelBananaBlock extends Block {
	public CaramelBananaBlock() {
		super(Properties.create(Material.CLAY)
				.hardnessAndResistance(1.4f)
				.slipperiness(3.0f)
				.sound(SoundType.SHROOMLIGHT)
				.harvestLevel(0)
				.harvestTool(ToolType.HOE)
				);
	}

}
