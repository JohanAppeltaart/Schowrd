package com.johanappeltaart.schowrd.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BananaIronBlock extends Block {

	public BananaIronBlock() {
		super(Properties.create(Material.IRON, MaterialColor.GOLD)
				.hardnessAndResistance(1.0f)
				.slipperiness(1.1f)
				.sound(SoundType.METAL)
				.harvestLevel(1)
				.setRequiresTool()
//				.func_235861_h_()
				.harvestTool(ToolType.PICKAXE)
				);
	}

}
