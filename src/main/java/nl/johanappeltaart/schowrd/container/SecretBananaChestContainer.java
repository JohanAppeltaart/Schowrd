package nl.johanappeltaart.schowrd.container;

//import com.johanappeltaart.schowrd.block.SecretBananaChest;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class SecretBananaChestContainer extends Container implements IForgeRegistryEntry<SecretBananaChestContainer> {
    private final IInventory lowerChestInventory;
    private final int numRows;

    private SecretBananaChestContainer(ContainerType<?> p_i50091_1_, int p_i50091_2_, PlayerInventory p_i50091_3_, int p_i50091_4_) {
        this(p_i50091_1_, p_i50091_2_, p_i50091_3_, new Inventory(9 * p_i50091_4_), p_i50091_4_);
    }

    public static SecretBananaChestContainer createGeneric9X1(int p_216986_0_, PlayerInventory p_216986_1_) {
        return new SecretBananaChestContainer(ContainerType.GENERIC_9X1, p_216986_0_, p_216986_1_, 1);
    }

    public static SecretBananaChestContainer createGeneric9X2(int p_216987_0_, PlayerInventory p_216987_1_) {
        return new SecretBananaChestContainer(ContainerType.GENERIC_9X2, p_216987_0_, p_216987_1_, 2);
    }

    public static SecretBananaChestContainer createGeneric9X3(int p_216988_0_, PlayerInventory p_216988_1_) {
        return new SecretBananaChestContainer(ContainerType.GENERIC_9X3, p_216988_0_, p_216988_1_, 3);
    }

    public static SecretBananaChestContainer createGeneric9X4(int p_216991_0_, PlayerInventory p_216991_1_) {
        return new SecretBananaChestContainer(ContainerType.GENERIC_9X4, p_216991_0_, p_216991_1_, 4);
    }

    public static SecretBananaChestContainer createGeneric9X5(int p_216989_0_, PlayerInventory p_216989_1_) {
        return new SecretBananaChestContainer(ContainerType.GENERIC_9X5, p_216989_0_, p_216989_1_, 5);
    }

    public static SecretBananaChestContainer createGeneric9X6(int p_216990_0_, PlayerInventory p_216990_1_) {
        return new SecretBananaChestContainer(ContainerType.GENERIC_9X6, p_216990_0_, p_216990_1_, 6);
    }

    public static SecretBananaChestContainer createGeneric9X3(int p_216992_0_, PlayerInventory p_216992_1_, IInventory p_216992_2_) {
        return new SecretBananaChestContainer(ContainerType.GENERIC_9X3, p_216992_0_, p_216992_1_, p_216992_2_, 3);
    }

    public static SecretBananaChestContainer createGeneric9X6(int p_216984_0_, PlayerInventory p_216984_1_, IInventory p_216984_2_) {
        return new SecretBananaChestContainer(ContainerType.GENERIC_9X6, p_216984_0_, p_216984_1_, p_216984_2_, 6);
    }

    public SecretBananaChestContainer(ContainerType<?> p_i50092_1_, int p_i50092_2_, PlayerInventory p_i50092_3_, IInventory p_i50092_4_, int p_i50092_5_) {
        super(p_i50092_1_, p_i50092_2_);
        assertInventorySize(p_i50092_4_, p_i50092_5_ * 9);
        this.lowerChestInventory = p_i50092_4_;
        this.numRows = p_i50092_5_;
        p_i50092_4_.openInventory(p_i50092_3_.player);
        int i = (this.numRows - 4) * 18;

        for(int j = 0; j < this.numRows; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(p_i50092_4_, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(p_i50092_3_, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(p_i50092_3_, i1, 8 + i1 * 18, 161 + i));
        }

    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(PlayerEntity p_75145_1_) {
        return this.lowerChestInventory.isUsableByPlayer(p_75145_1_);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack transferStackInSlot(PlayerEntity p_82846_1_, int p_82846_2_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(p_82846_2_);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (p_82846_2_ < this.numRows * 9) {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(PlayerEntity p_75134_1_) {
        super.onContainerClosed(p_75134_1_);
        this.lowerChestInventory.closeInventory(p_75134_1_);
    }

//     * @see #field_75155_e
    /**
     * Gets the inventory associated with this chest container.
     *
     */
    public IInventory getLowerChestInventory() {
        return this.lowerChestInventory;
    }

    @OnlyIn(Dist.CLIENT)
    public int getNumRows() {
        return this.numRows;
    }

    @Override
    public SecretBananaChestContainer setRegistryName(ResourceLocation name) {
        return null;
    }
    @Override
    public ResourceLocation getRegistryName() {
        return null;
    }

    @Override
    public Class<SecretBananaChestContainer> getRegistryType() {
        return null;
    }
}
