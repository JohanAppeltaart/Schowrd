package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.entity.item.BananaBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Schowrd.MOD_ID);

    //Boat Entity
    public static RegistryObject<EntityType<BananaBoatEntity>> BANANA_BOAT = ENTITY_TYPES.register("banana_boat",
            ()->EntityType.Builder.create(BananaBoatEntity::new, EntityClassification.AMBIENT)
                    .build(new ResourceLocation(Schowrd.MOD_ID, "banana_boat").toString()));

}
