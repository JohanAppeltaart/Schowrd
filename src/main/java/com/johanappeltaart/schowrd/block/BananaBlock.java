package com.johanappeltaart.schowrd.block;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BananaBlock extends Block {
	public BananaBlock() {
		super(Block.Properties.create(Material.CLAY)
				.hardnessAndResistance(1.0f)
				.slipperiness(2.0f)
				.sound(SoundType.CROP)
				.harvestLevel(0)
				.harvestTool(ToolType.HOE)
				);
	}
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		Schowrd.LOGGER.info(entityIn.getArmorInventoryList());
		if(ModItems.BANANA_BOOTS.get()==entityIn.getArmorInventoryList()){
			Schowrd.LOGGER.info("IS triggerd bc has banana boots");
		}
		super.onEntityWalk(worldIn, pos, entityIn);
	}
}
