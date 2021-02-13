package nl.johanappeltaart.schowrd.items;

import nl.johanappeltaart.schowrd.Schowrd;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.item.ItemGroup;

public class Caramel extends Item {

	public Caramel() {
		super(new Item.Properties()
				.group(Schowrd.TAB)
				.food(new Food.Builder()
				.hunger(1)
				.saturation(0.1f)
				.effect(()->new EffectInstance(Effects.SPEED,200),0.7f)
				.effect(()->new EffectInstance(Effects.NAUSEA,160),0.5f)
				.build()
				)
			);
	}

}
