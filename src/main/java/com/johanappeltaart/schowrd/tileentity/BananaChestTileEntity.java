package com.johanappeltaart.schowrd.tileentity;

import com.johanappeltaart.schowrd.block.BananaChest;
import com.johanappeltaart.schowrd.container.BananaChestContainer;
import com.johanappeltaart.schowrd.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;

public class BananaChestTileEntity extends LockableLootTileEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(96, ItemStack.EMPTY);
    protected int numPlayersUsing;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemhandler = LazyOptional.of(()-> items);

    public BananaChestTileEntity(TileEntityType<?> typeIn){
        super(typeIn);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.banana_chest");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new BananaChestContainer(id,player,this);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContents = itemsIn;
    }

    public BananaChestTileEntity(){
        this(ModTileEntityTypes.BANANA_CHEST.get());
    }


    @Override
    public int getSizeInventory() {
        return 96;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if(!this.checkLootAndWrite(compound)){
            ItemStackHelper.saveAllItems(compound,this.chestContents);
        }
        return null;//lol kan weghalen of toch niet
    }

//    @Override
//    public void read(CompoundNBT compound) {
//        this.chestContents = NonNullList.withSize(this.getSizeInventory(),ItemStack.EMPTY);
//        if(!this.checkLootAndRead(compound)){
//            ItemStackHelper.loadAllItems(compound,this.chestContents);
//        }
//    }

    private void playSound(SoundEvent sound){
        double dx = (double)this.pos.getX() + 0.5D;
        double dy = (double)this.pos.getY() + 0.5D;
        double dz = (double)this.pos.getZ() + 0.5D;
        this.world.playSound((PlayerEntity),null,dx,dy,dz,sound, SoundCategory.BLOCKS,0.5f,this.world.rand.nextFloat()*0.1f+0.9f);
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if(!player.isSpectator()){
            if(this.numPlayersUsing<0){
                this.numPlayersUsing = 0;
            }
        }
        ++this.numPlayersUsing;
        this.onOpenOrClose();
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if(!player.isSpectator()){
            --this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }
    protected void onOpenOrClose(){
        Block block = this.getBlockState().getBlock();
        if(block instanceof BananaChest){
            this.world.addBlockEvent(this.pos,block,1,this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos,block);
        }
    }
    public static int getPlayersUsing(IBlockReader reader, BlockPos pos){
        BlockState blockstate = reader.getBlockState(pos);
        if(blockstate.hasTileEntity()){
            TileEntity tileentity = reader.getTileEntity(pos);
            if(tileentity instanceof BananaChestTileEntity){
                return((BananaChestTileEntity)tileentity).numPlayersUsing;
            }
        }
        return 0;
    }
    public static void swapContents(BananaChestTileEntity te, BananaChestTileEntity otherTe){
        NonNullList<ItemSTack> list = te.getItems();
        te.setItems(otherTe.getItems());
//        otherTe
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if(this.itemhandler != null){
            this.itemhandler.invalidate();
            this.itemhandler = null;
        }
    }

    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
        if(cap == getCapabilityItemHandler.ITEM_HANDLER_CAPABILTIY){
            return itemhandler.cast();
        }
        return super.getCapability(cap, side);
    }

    private IItemHandlerModifiable createHandler(){
        return new InvWrapper(this);
    }

    @Override
    public void remove() {
        super.remove();
        if(itemhandler != null){
             itemhandler.invalidate();
        }
    }
}
