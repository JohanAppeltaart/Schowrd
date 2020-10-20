package com.johanappeltaart.schowrd.container;

import com.johanappeltaart.schowrd.init.ModContainerTypes;
import com.johanappeltaart.schowrd.init.ModTileEntityTypes;
import com.johanappeltaart.schowrd.tileentity.BananaChestTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;


public class BananaChestContainer extends ChestContainer {

    public final ChestTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public BananaChestContainer(final int windowId, final PlayerInventory playerInventory, final ChestTileEntity tileEntity, int rows){
        super(ModContainerTypes.BANANA_CHEST.get(),windowId,playerInventory,new Inventory(11*rows),rows);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(),tileEntity.getPos());

        //Main Inventory

    }

//    public BananaChestContainer(BananaChestContainer bananaChest, int id, PlayerInventory player, int rows) {
//        super(bananaChest, id, player, new Inventory(9 * rows), rows);
//    }

//    private void ChestContainer(ContainerType<?> type, int id, PlayerInventory player, int rows) {
//        this();
//    }

    public static BananaChestContainer createGeneric11X22(int id, PlayerInventory player) {
        return new BananaChestContainer(id, player, ModContainerTypes.BANANA_CHEST, 22);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
