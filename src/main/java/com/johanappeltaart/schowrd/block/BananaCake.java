package com.johanappeltaart.schowrd.block;

import net.minecraft.block.CakeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BananaCake extends CakeBlock {

	public BananaCake() {
		super(CakeBlock.Properties.create(Material.CAKE)
				.hardnessAndResistance(0.5f,0.6f)
				.slipperiness(2.0f)
				.sound(SoundType.CLOTH)
				.harvestLevel(0)
				.harvestTool(ToolType.HOE)
				);
	}

}
