package nl.johanappeltaart.schowrd.items;

import nl.johanappeltaart.schowrd.Schowrd;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.item.ItemGroup;

public class Caramel_Banana extends Item {

	public Caramel_Banana() {
		super(new Item.Properties()
				.group(Schowrd.TAB)
				.food(new Food.Builder()
				.hunger(8)
				.saturation(2.0f)
				.effect(()->new EffectInstance(Effects.GLOWING,420),0.9f)
				.effect(()->new EffectInstance(Effects.SPEED,500),1f)
				.effect(()->new EffectInstance(Effects.NAUSEA,100),0.5f)
				.build()
				)
			);
	}

}
