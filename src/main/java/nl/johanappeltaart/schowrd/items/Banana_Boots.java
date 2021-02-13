package nl.johanappeltaart.schowrd.items;

import nl.johanappeltaart.schowrd.Schowrd;
import nl.johanappeltaart.schowrd.armor.ModArmorMaterial;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.item.ItemGroup;

public class Banana_Boots extends ArmorItem {

	public Banana_Boots() {
		super(ModArmorMaterial.BANANA, EquipmentSlotType.FEET,new Properties()
				.group(Schowrd.TAB)
				.food(new Food.Builder()
				.hunger(12)
				.saturation(4.0f)
				.effect(()->new EffectInstance(Effects.GLOWING,200),0.8f)
     			.effect(()->new EffectInstance(Effects.POISON,20),0.5f)
				.build()
				)
			);
	}


//	@Override
//	public boolean hasContainerItem(ItemStack stack) {
//		assert stack.getHolder() != null;
//		createEntity(stack.getHolder().world, EntityType.CAT.spawn(stack,),stack);
//		return false;
//	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
//		entity.getEntity().isFireImmune();
//		entity.isFireImmune();
		return false;
	}
}
