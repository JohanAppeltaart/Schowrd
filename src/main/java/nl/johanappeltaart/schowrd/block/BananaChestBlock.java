package nl.johanappeltaart.schowrd.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BananaChestBlock extends Block{//extends AbstractChestBlock<BananaChestTileEntity> implements IWaterLoggable{

    public BananaChestBlock() {
        super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WARPED_HYPHAE)
                .hardnessAndResistance(2.0f)
                .slipperiness(1.1f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
//                , ModTileEntityTypes.SECRET_BANANA_CHEST::get
                //(Supplier<TileEntityType<? extends BananaChestTileEntity>>)
        );
    }

//    @Override
//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
//    }
//    @Override
//    public TileEntityMerger.ICallbackWrapper<? extends ChestTileEntity> combine(BlockState state, World world, BlockPos pos, boolean override) {
//        return null;
//    }
//    @Override
//    public TileEntity createNewTileEntity(IBlockReader worldIn) {
//        return null;
//    }
}
