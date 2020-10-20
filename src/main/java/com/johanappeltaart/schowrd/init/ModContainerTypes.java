package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.container.BananaChestContainer;
import com.johanappeltaart.schowrd.tileentity.BananaChestTileEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =  DeferredRegister.create(ForgeRegistries.CONTAINERS, Schowrd.MOD_ID);
//    public static final RegistryObject<ContainerType<BananaChestContainer>> BANANA_CHEST = CONTAINER_TYPES.register("banana_chest",()->BananaChestContainer::new);
    public static final RegistryObject<ContainerType<BananaChestContainer>> BANANA_CHEST = CONTAINER_TYPES.register("banana_chest", ChestContainer::createGeneric9X6);

}
