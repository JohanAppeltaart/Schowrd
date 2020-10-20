package com.johanappeltaart.schowrd.container;

import com.johanappeltaart.schowrd.init.ModContainerTypes;
import com.johanappeltaart.schowrd.tileentity.BananaChestTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IWorldPosCallable;


public class BananaChestContainer extends Container {

    public final BananaChestTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public BananaChestContainer(final int windowId, final PlayerInventory playerInventory, final BananaChestTileEntity tileEntity){
        super(ModContainerTypes.BANANA_CHEST.get(),windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(),tileEntity.getPos());

        //Main Inventory

    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
