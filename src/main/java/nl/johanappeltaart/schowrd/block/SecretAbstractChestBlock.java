package nl.johanappeltaart.schowrd.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public abstract class SecretAbstractChestBlock<E extends TileEntity> extends ContainerBlock {
    protected final Supplier<TileEntityType<? extends E>> tileEntityType;

    protected SecretAbstractChestBlock(AbstractBlock.Properties builder, Supplier<TileEntityType<? extends E>> tileEntityTypeSupplier) {
        super(builder);
        this.tileEntityType = tileEntityTypeSupplier;
    }

    @OnlyIn(Dist.CLIENT)
    public abstract TileEntityMerger.ICallbackWrapper<? extends ChestTileEntity> combine(BlockState state, World world, BlockPos pos, boolean override);
}
