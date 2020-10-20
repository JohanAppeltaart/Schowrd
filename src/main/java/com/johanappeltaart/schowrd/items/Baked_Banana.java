package com.johanappeltaart.schowrd.items;

import com.johanappeltaart.schowrd.Schowrd;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.item.ItemGroup;

public class Baked_Banana extends Item {

	public Baked_Banana() {
		super(new Item.Properties()
				.group(Schowrd.TAB)
				.food(new Food.Builder()
				.hunger(6)
				.saturation(2.0f)
				.effect(()->new EffectInstance(Effects.GLOWING,420),0.9f)
				.build()
				)
			);
	}

}
