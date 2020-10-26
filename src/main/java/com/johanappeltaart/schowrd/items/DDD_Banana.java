package com.johanappeltaart.schowrd.items;

import com.johanappeltaart.schowrd.Schowrd;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.item.ItemGroup;

public class DDD_Banana extends BlockItem {

	public DDD_Banana(Block block) {
		super(block,new Properties()
				.group(Schowrd.TAB)
				.food(new Food.Builder()
				.hunger(3)
				.saturation(1.0f)
				.effect(()->new EffectInstance(Effects.GLOWING,200),0.8f)
				.build()
				)
			);
	}

}
