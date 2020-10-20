package com.johanappeltaart.schowrd.init;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.tileentity.BananaChestTileEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES =  DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Schowrd.MOD_ID);

    public static final RegistryObject<TileEntityType<BananaChestTileEntity>> BANANA_CHEST = TILE_ENTITY_TYPES
            .register("banana_chest", ()-> TileEntityType.Builder
                    .create(BananaChestTileEntity::new,ModBlocks.BANANA_CHEST.get()).build(null));
}
