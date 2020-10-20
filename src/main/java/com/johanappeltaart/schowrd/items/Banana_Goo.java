package com.johanappeltaart.schowrd.items;

import com.johanappeltaart.schowrd.Schowrd;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.item.ItemGroup;

public class Banana_Goo extends Item {

	public Banana_Goo() {
		super(new Item.Properties()
				.group(Schowrd.TAB)
				.food(new Food.Builder()
				.hunger(1)
				.saturation(0f)
				.effect(()->new EffectInstance(Effects.HUNGER,360),0.7f)
				.effect(()->new EffectInstance(Effects.POISON,60),0.9f)
				.effect(()->new EffectInstance(Effects.NAUSEA,120),0.3f)
				.build()
				)
			);
	}

}
