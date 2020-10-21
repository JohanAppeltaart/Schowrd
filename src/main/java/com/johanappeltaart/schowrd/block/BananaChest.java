package com.johanappeltaart.schowrd.block;

import com.johanappeltaart.schowrd.init.ModTileEntityTypes;
import com.johanappeltaart.schowrd.tileentity.BananaChestTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.DoubleSidedInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
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
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Properties;

public class BananaChest extends Block {


	public BananaChest() {
		super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIAMOND)
				.hardnessAndResistance(2.5f)
				.slipperiness(1.5f)
				.sound(SoundType.WOOD)
				.harvestTool(ToolType.AXE)
//				,
//				()-> {return TileEntityType.CHEST;
//		}
		);
//		super(properties);
	}
//	private static final TileEntityMerger.ICallback<ChestTileEntity, Optional<IInventory>> field_220109_i = new TileEntityMerger.ICallback<ChestTileEntity, Optional<IInventory>>() {
//		public Optional<IInventory> func_225539_a_(ChestTileEntity p_225539_1_, ChestTileEntity p_225539_2_) {
//			return Optional.of(new DoubleSidedInventory(p_225539_1_, p_225539_2_));
//		}
//
//		public Optional<IInventory> func_225538_a_(ChestTileEntity p_225538_1_) {
//			return Optional.of(p_225538_1_);
//		}
//
//		public Optional<IInventory> func_225537_b_() {
//			return Optional.empty();
//		}
//	};

//		@Override
//		public Optional<IInventory> func_225538_a_(ChestTileEntity p_225538_1_) {
//			return Optional.empty();
//		}
//
//		@Override
//		public Optional<IInventory> func_225537_b_() {
//			return Optional.empty();
//		}

		@Nullable
//	public static IInventory getChestInventory(ChestBlock chest, BlockState state, World world, BlockPos pos, boolean override) {
//		return chest.combine(state, world, pos, override).<Optional<IInventory>>apply(INVENTORY_MERGER).orElse((IInventory)null);
//	}
//	public static IInventory getChestInventory(ChestBlock p_226916_0_, BlockState p_226916_1_, World p_226916_2_, BlockPos p_226916_3_, boolean p_226916_4_) {
//		return p_226916_0_.func_225536_a_(p_226916_1_, p_226916_2_, p_226916_3_, p_226916_4_).<Optional<IInventory>>apply(field_220109_i).orElse((IInventory)null);
//	}
//
//	@Override
//	public boolean hasTileEntity(BlockState state){
//		return true;
//	}
//
////	@Override
////	public TileEntity createNewTileEntity(IBlockReader world) {
////		return ModTileEntityTypes.BANANA_CHEST.get().create();
////	}
//
//	@Override
//	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//		if(!worldIn.isRemote){
//			TileEntity tile = worldIn.getTileEntity(pos);
//			if(tile instanceof  BananaChestTileEntity){//bananachchest was het eerst hieronder ook
//				NetworkHooks.openGui((ServerPlayerEntity) player, (BananaChestTileEntity) tile,pos);
//				return ActionResultType.SUCCESS;
//			}
//		}
//		return ActionResultType.FAIL;
//	}
//
////	@Override
////	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
////		if(state.getBlock() != newState.getBlock()){
////			TileEntity te = worldIn.getTileEntity(pos);
////			if(te instanceof BananaChestTileEntity){
////				InventoryHelper.dropItems(worldIn,pos,((BananaChestTileEntity).te).getItems());
////			}
////		}
////	}
//	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
//		if (!state.isIn(newState.getBlock())) {
//			TileEntity tileentity = worldIn.getTileEntity(pos);
//			if (tileentity instanceof IInventory) {
//				InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
//				worldIn.updateComparatorOutputLevel(pos, this);
//			}
//
//			super.onReplaced(state, worldIn, pos, newState, isMoving);
//		}
//	}
		@Override
		public boolean hasTileEntity(BlockState state) {
			return true;
		}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.BANANA_CHEST.get().create();
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
											 Hand handIn, BlockRayTraceResult result) {
		if (!worldIn.isRemote) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof BananaChestTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (BananaChestTileEntity) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.FAIL;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity te = worldIn.getTileEntity(pos);
			if (te instanceof BananaChestTileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((BananaChestTileEntity) te).getItems());
			}
		}
	}

}
