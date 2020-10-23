package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.container.SecretBananaChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//public class ModContainerTypes<T extends Container> extends net.minecraftforge.registries.ForgeRegistryEntry<ContainerType<?>> implements IForgeContainerType<T>{
    public class ModContainerTypes{
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPE =  DeferredRegister.create(ForgeRegistries.CONTAINERS, Schowrd.MOD_ID);
//    public static final RegistryObject<ContainerType<BananaChestContainer>> BANANA_CHEST = CONTAINER_TYPE.register("banana_chest",()->BananaChestContainer::new);
    public static final RegistryObject<ContainerType<SecretBananaChestContainer>> BANANA_CHEST = CONTAINER_TYPE.register("banana_chest",()-> IForgeContainerType.create(SecretBananaChestContainer::new));
//    public static final RegistryObject<ContainerType>  BANANA_CHEST = register("banana_chest", BananaChestContainer::createBananaChest);IForgeContainerType.create(BananaChestContainer::new)


//    private final ModContainerTypes.IFactory<T> factory;
//
//    private static <T extends Container> ContainerType<T> register(String key, ModContainerTypes.IFactory<T> factory) {
//        return CONTAINER_TYPE.register(Registry.MENU, key, new ContainerType<>(factory));
//    }
//
//    public ModContainerTypes(ContainerType.IFactory<T> factory) {
//        this.factory = factory;
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    public T create(int windowId, PlayerInventory player) {
//        return this.factory.create(windowId, player);
//    }
//
//    @Override
//    public T create(int windowId, PlayerInventory playerInv, net.minecraft.network.PacketBuffer extraData) {
//        if (this.factory instanceof net.minecraftforge.fml.network.IContainerFactory) {
//            return ((net.minecraftforge.fml.network.IContainerFactory<T>) this.factory).create(windowId, playerInv, extraData);
//        }
//        return create(windowId, playerInv);
//    }
//
//    public interface IFactory<T extends ModContainer> extends ContainerType.IFactory<T> {
//        @OnlyIn(Dist.CLIENT)
//        T create(int p_create_1_, PlayerInventory p_create_2_);
//    }
}
