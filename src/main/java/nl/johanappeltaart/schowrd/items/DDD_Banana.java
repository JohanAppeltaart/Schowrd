package nl.johanappeltaart.schowrd.items;

import nl.johanappeltaart.schowrd.Schowrd;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.item.ItemGroup;

public class DDD_Banana extends BlockItem {

	public DDD_Banana(Block block) {
		super(block,new Properties()
				.group(Schowrd.TAB)
				.food(new Food.Builder()
				.hunger(18)
				.saturation(6.0f)
				.effect(()->new EffectInstance(Effects.GLOWING,1200),0.8f)
				.build()
				)
			);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
		player.addPotionEffect(new EffectInstance(Effects.SPEED, 100,1));
		return true;
	}

	@Override
	public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
		player.addPotionEffect(new EffectInstance(Effects.SLOWNESS,20,1));
	}

//	@Override
//	public ItemStack getContainerItem(ItemStack itemStack) {
//		return null;
//	}
	//	@Override
//	public boolean hasContainerItem(ItemStack stack) {
//		stack.getAttachedEntity().add
//		return false;
//	}
//
//	@Override
//	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {
//		playerEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100,1));
//		return super.onItemRightClick(world, playerEntity, hand);
//	}


//	@Override
//	public ItemStack getContainerItem(ItemStack itemStack) {
//		itemStack.addEnchantment(Enchantment.getEnchantmentByID(3),10);
//		return null;
//	}
}
