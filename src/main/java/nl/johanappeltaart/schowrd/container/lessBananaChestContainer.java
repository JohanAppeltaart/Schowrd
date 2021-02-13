//package com.johanappeltaart.schowrd.container;
//
//import com.johanappeltaart.schowrd.init.ModBlocks;
//import com.johanappeltaart.schowrd.init.ModContainerTypes;
//import com.johanappeltaart.schowrd.tileentity.SecretBananaChestTileEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.inventory.container.Slot;
//import net.minecraft.item.ItemStack;
//import net.minecraft.network.PacketBuffer;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.IWorldPosCallable;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//import java.util.Objects;
//
//public class lessBananaChestContainer extends Container {
////    private final IInventory lowerChestInventory;
////private final IWorldPosCallable worldPos;
//    private final int numRows = 6;//36;//was 22// 108 slots
//public final SecretBananaChestTileEntity tileEntity;
//    private final IWorldPosCallable canInteractWithCallable;
//
//public lessBananaChestContainer(final int windowId, final PlayerInventory playerInventory, final SecretBananaChestTileEntity tileEntity) {
//    super(ModContainerTypes.BANANA_CHEST.get(), windowId);//,new Inventory(9*22),22
////    this.lowerChestInventory = inventory;
//    this.tileEntity = tileEntity;
////    this.worldPos = iworldposcallable;
//    this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
//
//    // Main Inventory
//    int startX = 8;
//    int startY = 18;
//    int slotSizePlus2 = 18;
//    for (int row = 0; row < 4; ++row) {
//        for (int column = 0; column < 9; ++column) {
//            this.addSlot(new Slot(tileEntity, (row * 9) + column, startX + (column * slotSizePlus2),
//                    startY + (row * slotSizePlus2)));
//        }
//    }
//
//    // Main Player Inventory
//    int startPlayerInvY = startY * 5 + 12;
//    for (int row = 0; row < 3; ++row) {
//        for (int column = 0; column < 9; ++column) {
//            this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
//                    startPlayerInvY + (row * slotSizePlus2)));
//        }
//    }
//
//    // Hotbar
//    int hotbarY = startPlayerInvY + (startPlayerInvY / 2) + 7;
//    for (int column = 0; column < 9; ++column) {
//        this.addSlot(new Slot(playerInventory, column, startX + (column * slotSizePlus2), hotbarY));
//    }
//}
//
//    private static SecretBananaChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data){
//        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
//        Objects.requireNonNull(data, "data cannot be null");
//        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
//        if (tileAtPos instanceof SecretBananaChestTileEntity) {
//            return (SecretBananaChestTileEntity) tileAtPos;
//        }
//        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
//    }
//
////    public BananaChestContainer(final int windowId,final PlayerInventory playerInventory,final PacketBuffer data){
////        this(windowId,playerInventory,getTileEntity(playerInventory,data));
////    }
//    public lessBananaChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
//        this(windowId, playerInventory,getTileEntity(playerInventory,data));
//    }
//
//
//    /**
//     * Determines whether supplied player can use this container
//     */
//    public boolean canInteractWith(PlayerEntity playerIn) {
////        return this.lowerChestInventory.isUsableByPlayer(playerIn);
//        return isWithinUsableDistance(canInteractWithCallable,playerIn, ModBlocks.SECRET_BANANA_CHEST.get());
////        return true;/**/
//    }
//
//    /**
//     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
//     * inventory and the other inventory(s).
//     */
//    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
//        ItemStack itemstack = ItemStack.EMPTY;
//        Slot slot = this.inventorySlots.get(index);
//        if (slot != null && slot.getHasStack()) {
//            ItemStack itemstack1 = slot.getStack();
//            itemstack = itemstack1.copy();
//            if (index < this.numRows * 9) {//this.numRows
//                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true)) {
//                    return ItemStack.EMPTY;
//                }
//            } else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
//                return ItemStack.EMPTY;
//            }
//
//            if (itemstack1.isEmpty()) {
//                slot.putStack(ItemStack.EMPTY);
//            } else {
//                slot.onSlotChanged();
//            }
//        }
//
//        return itemstack;
//    }
//
//    /**
//     * Called when the container is closed.
//     */
//    public void onContainerClosed(PlayerEntity playerIn) {
//        super.onContainerClosed(playerIn);
//        this.tileEntity.closeInventory(playerIn);
//    }
//
//    /**
//     * Gets the inventory associated with this chest container.
//     *
//     * @see #//field_75155_e
//     */
//    public IInventory getLowerChestInventory() {
//        return this.tileEntity;
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    public int getNumRows() {
//        return this.numRows;
//    }
//
//
////    private BananaChestContainer(ContainerType<?> type, int id, PlayerInventory player, int rows) {
////        this(type, id, player, new Inventory(9 * rows), rows);
////    }
////
////    public static BananaChestContainer createBananaChest(int id, PlayerInventory player, IInventory blockEntity) {
////        return new BananaChestContainer(ContainerType.GENERIC_9X6, id, player, 6);
////    }
////ContainerType type,
////    public BananaChestContainer(final int id, final PlayerInventory playerInventoryIn, IInventory p_i50092_4_, int rows) {
////        super(ModContainerTypes.BANANA_CHEST.get(),id);
////        assertInventorySize(p_i50092_4_, rows * 9);
////        this.lowerChestInventory = p_i50092_4_;
////        this.numRows = rows;
////        p_i50092_4_.openInventory(playerInventoryIn.player);
////        int i = (this.numRows - 4) * 18;
////
////        for(int j = 0; j < this.numRows; ++j) {
////            for(int k = 0; k < 9; ++k) {
////                this.addSlot(new Slot(p_i50092_4_, k + j * 9, 8 + k * 18, 18 + j * 18));
////            }
////        }
////
////        for(int l = 0; l < 3; ++l) {
////            for(int j1 = 0; j1 < 9; ++j1) {
////                this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
////            }
////        }
////
////        for(int i1 = 0; i1 < 9; ++i1) {
////            this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 161 + i));
////        }
////
////    }
//}
