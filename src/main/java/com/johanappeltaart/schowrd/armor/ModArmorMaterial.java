package com.johanappeltaart.schowrd.armor;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    BANANA(Schowrd.MOD_ID + ":banana", 8, new int[]{6, 12, 16, 6}, 10, SoundEvents.BLOCK_BELL_USE, 6.0F, 0.5F
            , () -> {return Ingredient.fromItems(ModItems.BANANA_IRON.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float field_234660_o_;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float field_234660_o_, Supplier<Ingredient> repairMaterial){
        this.name= name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness  = toughness;
        this.field_234660_o_ = field_234660_o_;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }
    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }
    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }
    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public float getToughness() {
        return this.toughness;
    }
    @Override
    public float func_230304_f_() {
        return this.field_234660_o_;
    }
}
