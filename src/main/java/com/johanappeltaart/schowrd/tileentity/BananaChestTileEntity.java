package com.johanappeltaart.schowrd.tileentity;

import com.johanappeltaart.schowrd.block.SecretBananaChest;
import com.johanappeltaart.schowrd.container.SecretBananaChestContainer;
import com.johanappeltaart.schowrd.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleSidedInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class BananaChestTileEntity extends LockableLootTileEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(36, ItemStack.EMPTY);//was 96
    /** The current angle of the lid (between 0 and 1) */
    protected float lidAngle;
    /** The angle of the lid last tick */
    protected float prevLidAngle;
    /** The number of players currently using this chest */
    protected int numPlayersUsing;
    /**
     * A counter that is incremented once each tick. Used to determine when to recompute ; this is done every 200 ticks
     * (but staggered between different chests). However, the new value isn't actually sent to clients when it is
     * changed.
     */
    private int ticksSinceSync;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemhandler = LazyOptional.of(()-> items);

    public BananaChestTileEntity(TileEntityType<?> typeIn){
        super(typeIn);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.banana_chest");
    }

    protected Container createMenu(int id, PlayerInventory player) {
        return new SecretBananaChestContainer(id,player,this);
    }//was not 22 rows was null

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContents = itemsIn;
    }

    public BananaChestTileEntity(){
        this(ModTileEntityTypes.SECRET_BANANA_CHEST.get());
    }


    @Override
    public int getSizeInventory() {
        return 36;
    }//wad 96

    public void fromTag(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.fromTag(p_230337_1_,p_230337_2_);
//        super.func_230337_a_(p_230337_1_, p_230337_2_);
        this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(p_230337_2_)) {
            ItemStackHelper.loadAllItems(p_230337_2_, this.chestContents);
        }

    }
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if(!this.checkLootAndWrite(compound)){
            ItemStackHelper.saveAllItems(compound,this.chestContents);
        }
        return compound;//lol kan weghalen of toch niet
    }

//    @Override
//    public void read(CompoundNBT compound) {
//        this.chestContents = NonNullList.withSize(this.getSizeInventory(),ItemStack.EMPTY);
//        if(!this.checkLootAndRead(compound)){
//            ItemStackHelper.loadAllItems(compound,this.chestContents);
//        }
//    }

    public void tick() {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        ++this.ticksSinceSync;
        this.numPlayersUsing = calculatePlayersUsingSync(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
        this.prevLidAngle = this.lidAngle;
        float f = 0.1F;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            this.playSound(SoundEvents.BLOCK_CHEST_OPEN);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
            float f1 = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1F;
            } else {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            float f2 = 0.5F;
            if (this.lidAngle < 0.5F && f1 >= 0.5F) {
                this.playSound(SoundEvents.BLOCK_CHEST_CLOSE);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }

    }

    public static int calculatePlayersUsingSync(World p_213977_0_, LockableTileEntity p_213977_1_, int p_213977_2_, int p_213977_3_, int p_213977_4_, int p_213977_5_, int p_213977_6_) {
        if (!p_213977_0_.isRemote && p_213977_6_ != 0 && (p_213977_2_ + p_213977_3_ + p_213977_4_ + p_213977_5_) % 200 == 0) {
            p_213977_6_ = calculatePlayersUsing(p_213977_0_, p_213977_1_, p_213977_3_, p_213977_4_, p_213977_5_);
        }

        return p_213977_6_;
    }

    public static int calculatePlayersUsing(World p_213976_0_, LockableTileEntity p_213976_1_, int p_213976_2_, int p_213976_3_, int p_213976_4_) {
        int i = 0;
        float f = 5.0F;

        for(PlayerEntity playerentity : p_213976_0_.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB((double)((float)p_213976_2_ - 5.0F), (double)((float)p_213976_3_ - 5.0F), (double)((float)p_213976_4_ - 5.0F), (double)((float)(p_213976_2_ + 1) + 5.0F), (double)((float)(p_213976_3_ + 1) + 5.0F), (double)((float)(p_213976_4_ + 1) + 5.0F)))) {
            if (playerentity.openContainer instanceof ChestContainer) {
                IInventory iinventory = ((ChestContainer)playerentity.openContainer).getLowerChestInventory();
                if (iinventory == p_213976_1_ || iinventory instanceof DoubleSidedInventory && ((DoubleSidedInventory)iinventory).isPartOfLargeChest(p_213976_1_)) {
                    ++i;
                }
            }
        }

        return i;
    }
    private void playSound(SoundEvent sound){
        double dx = (double)this.pos.getX() + 0.5D;
        double dy = (double)this.pos.getY() + 0.5D;
        double dz = (double)this.pos.getZ() + 0.5D;
        this.world.playSound((PlayerEntity)null,dx,dy,dz,sound, SoundCategory.BLOCKS,0.5f,this.world.rand.nextFloat()*0.1f+0.9f);
    }
//private void playSound(SoundEvent soundIn) {
//    ChestType chesttype = this.getBlockState().get(ChestBlock.TYPE);
//    if (chesttype != ChestType.LEFT) {
//        double d0 = (double)this.pos.getX() + 0.5D;
//        double d1 = (double)this.pos.getY() + 0.5D;
//        double d2 = (double)this.pos.getZ() + 0.5D;
//        if (chesttype == ChestType.RIGHT) {
//            Direction direction = ChestBlock.getDirectionToAttached(this.getBlockState());
//            d0 += (double)direction.getXOffset() * 0.5D;
//            d2 += (double)direction.getZOffset() * 0.5D;
//        }
//
//        this.world.playSound((PlayerEntity)null, d0, d1, d2, soundIn, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
//    }
//}

    @Override
    public void openInventory(PlayerEntity player) {
        playSound(SoundEvents.BLOCK_CHEST_OPEN);
//        if(!player.isSpectator()){
            if(this.numPlayersUsing<0){
                this.numPlayersUsing = 0;
//            }
        }
        ++this.numPlayersUsing;
        this.onOpenOrClose();
    }

    @Override
    public void closeInventory(PlayerEntity player) {
//        if(!player.isSpectator()){
            --this.numPlayersUsing;
            this.onOpenOrClose();
//        }
    }
    protected void onOpenOrClose(){
//        playSound(SoundEvent.field_232678_a_);
        Block block = this.getBlockState().getBlock();
        if(block instanceof SecretBananaChest){
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
        NonNullList<ItemStack> list = te.getItems();
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

//    @Override
//    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
//        if(cap == getCapabilityItemHandler.ITEM_HANDLER_CAPABILTIY){
//            return itemhandler.cast();
//        }
//        return super.getCapability(cap, side);
//    }
@Override
public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, Direction side) {
    if (!this.removed && cap == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        if (this.itemhandler == null)
            this.itemhandler = net.minecraftforge.common.util.LazyOptional.of(this::createHandler);
        return this.itemhandler.cast();
    }
    return super.getCapability(cap, side);
}


    private IItemHandlerModifiable createHandler() {
        return new InvWrapper(this);
//        BlockState state = this.getBlockState();
//        if (!(state.getBlock() instanceof ChestBlock)) {
//            return new net.minecraftforge.items.wrapper.InvWrapper(this);
//        }
//        IInventory inv = BananaChest.getChestInventory((ChestBlock) state.getBlock(), state, getWorld(), getPos(), true);
//        return new net.minecraftforge.items.wrapper.InvWrapper(inv == null ? this : inv);
    }

    @Override
    public void remove() {
        super.remove();
        if(itemhandler != null){
             itemhandler.invalidate();
        }
    }
}
