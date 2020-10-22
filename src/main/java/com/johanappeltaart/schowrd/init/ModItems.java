package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.armor.ModArmorMaterial;
import com.johanappeltaart.schowrd.block.BlockItemBase;
import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.items.*;
import com.johanappeltaart.schowrd.tools.ModItemTier;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Schowrd.MOD_ID);

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", Banana::new);
    public static final RegistryObject<Item> BANANA_GOO = ITEMS.register("banana_goo", Banana_Goo::new);
    public static final RegistryObject<Item> BAKED_BANANA = ITEMS.register("baked_banana", Baked_Banana::new);
    public static final RegistryObject<Item> CARAMEL_BANANA = ITEMS.register("caramel_banana", Caramel_Banana::new);
    public static final RegistryObject<Item> CARAMEL = ITEMS.register("caramel", Caramel::new);
    public static final RegistryObject<Item> BANANA_ON_IRON = ITEMS.register("banana_on_iron", ItemBase::new);
    public static final RegistryObject<Item> BANANA_IRON = ITEMS.register("banana_iron", ItemBase::new);
    public static final RegistryObject<Item> BANANA_IRON_NUGGET = ITEMS.register("banana_iron_nugget", ItemBase::new);

    //Tools
    public static final RegistryObject<SwordItem> BANANA_SCHOWRD = ITEMS.register("banana_schowrd",
            ()-> new SwordItem(ModItemTier.BANANA,10,0.0f,new Item.Properties().group(Schowrd.TAB).food(new Food.Builder().hunger(6).saturation(2.0f).effect(()->new EffectInstance(Effects.GLOWING,200),0.8f).effect(()->new EffectInstance(Effects.POISON,40),0.5f).build())));

    public static final RegistryObject<PickaxeItem> BANANA_PICKAXE = ITEMS.register("banana_pickaxe",
            ()-> new PickaxeItem(ModItemTier.BANANA,0,-2.4f,new Item.Properties().group(Schowrd.TAB).food(new Food.Builder().hunger(9).saturation(3.0f).effect(()->new EffectInstance(Effects.GLOWING,200),0.8f).effect(()->new EffectInstance(Effects.POISON,60),0.5f).build())));

    public static final RegistryObject<ShovelItem> BANANA_SHOVEL = ITEMS.register("banana_shovel",
            ()-> new ShovelItem(ModItemTier.BANANA,0,-2.4f,new Item.Properties().group(Schowrd.TAB).food(new Food.Builder().hunger(3).saturation(1.0f).effect(()->new EffectInstance(Effects.GLOWING,200),0.8f).effect(()->new EffectInstance(Effects.POISON,20),0.5f).build())));

    public static final RegistryObject<AxeItem> BANANA_AXE = ITEMS.register("banana_axe",
            ()-> new AxeItem(ModItemTier.BANANA,0,-2.4f,new Item.Properties().group(Schowrd.TAB).food(new Food.Builder().hunger(9).saturation(3.0f).effect(()->new EffectInstance(Effects.GLOWING,200),0.8f).effect(()->new EffectInstance(Effects.POISON,60),0.5f).build())));

    public static final RegistryObject<HoeItem> BANANA_HOE = ITEMS.register("banana_hoe",
            ()-> new HoeItem(ModItemTier.BANANA,0,-2.4f,new Item.Properties().group(Schowrd.TAB).food(new Food.Builder().hunger(3).saturation(1.0f).effect(()->new EffectInstance(Effects.GLOWING,200),0.8f).effect(()->new EffectInstance(Effects.POISON,20),0.5f).build())));

    //Armor Items
    public static final RegistryObject<ArmorItem> BANANA_HELMET = ITEMS.register("banana_helmet",()->
       new ArmorItem(ModArmorMaterial.BANANA, EquipmentSlotType.HEAD,new Item.Properties().group(Schowrd.TAB)));
    public static final RegistryObject<ArmorItem> BANANA_CHESTPLATE = ITEMS.register("banana_chestplate",()->
        new ArmorItem(ModArmorMaterial.BANANA, EquipmentSlotType.CHEST,new Item.Properties().group(Schowrd.TAB)));
    public static final RegistryObject<ArmorItem> BANANA_LEGGINGS = ITEMS.register("banana_leggings",()->
        new ArmorItem(ModArmorMaterial.BANANA, EquipmentSlotType.LEGS,new Item.Properties().group(Schowrd.TAB)));
    public static final RegistryObject<ArmorItem> BANANA_BOOTS = ITEMS.register("banana_boots",()->
        new ArmorItem(ModArmorMaterial.BANANA, EquipmentSlotType.FEET,new Item.Properties().group(Schowrd.TAB)));

    //boat
    public static final RegistryObject<BoatItem> BANANA_BOAT = ITEMS.register("banana_boat",
            ()->new BoatItem(BoatEntity.Type.JUNGLE, new Item.Properties().group(Schowrd.TAB).maxStackSize(1)));//ItemGroup.TRANSPORTATION

    //cake item
    public static final RegistryObject<Item>BANANA_CAKE_ITEM = ITEMS.register("banana_cake",
            () -> new   BlockItemBase(ModBlocks.BANANA_CAKE.get()));



    //Block Items
    public static final RegistryObject<Item>BANANA_BLOCK_ITEM = ITEMS.register("banana_block",
            () -> new BlockItemBase(ModBlocks.BANANA_BLOCK.get()));
    public static final RegistryObject<Item>BANANA_IRON_BLOCK_ITEM = ITEMS.register("banana_iron_block",
            () -> new BlockItemBase(ModBlocks.BANANA_IRON_BLOCK.get()));
    public static final RegistryObject<Item>BANANA_CHEST_ITEM = ITEMS.register("banana_chest",
            () -> new BlockItemBase(ModBlocks.BANANA_CHEST.get()));

    //tree block items
    public static final RegistryObject<Item>BANANA_PLANKS_ITEM = ITEMS.register("banana_planks",
            () -> new BlockItemBase(ModBlocks.BANANA_PLANKS.get()));
    public static final RegistryObject<Item>BANANA_LEAVES_ITEM = ITEMS.register("banana_leaves",
            () -> new BlockItemBase(ModBlocks.BANANA_LEAVES.get()));
    public static final RegistryObject<Item>BANANA_LOG_ITEM = ITEMS.register("banana_log",
            () -> new BlockItemBase(ModBlocks.BANANA_LOG.get()));
    public static final RegistryObject<Item>STRIPPED_BANANA_LOG_ITEM = ITEMS.register("stripped_banana_log",
            () -> new BlockItemBase(ModBlocks.STRIPPED_BANANA_LOG.get()));
    public static final RegistryObject<Item>BANANA_SAPLING= ITEMS.register("banana_sapling",
            () -> new BlockItemBase(ModBlocks.BANANA_SAPLING.get()));

}
