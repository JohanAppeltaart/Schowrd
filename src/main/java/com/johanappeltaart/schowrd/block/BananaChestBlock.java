package com.johanappeltaart.schowrd.block;

import com.johanappeltaart.schowrd.init.ModTileEntityTypes;
import com.johanappeltaart.schowrd.tileentity.BananaChestTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.function.Supplier;

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
