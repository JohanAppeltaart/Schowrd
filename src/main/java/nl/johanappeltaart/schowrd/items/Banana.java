package nl.johanappeltaart.schowrd.items;

import nl.johanappeltaart.schowrd.Schowrd;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.item.ItemGroup;

public class Banana extends Item {

	public Banana() {
		super(new Item.Properties()
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
