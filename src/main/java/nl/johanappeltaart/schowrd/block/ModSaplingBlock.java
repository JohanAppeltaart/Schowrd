//package blocks;
//
//import java.util.function.Supplier;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BushBlock;
//import net.minecraft.block.IGrowable;
//import net.minecraft.block.SoundType;
//import net.minecraft.block.material.Material;
//import net.minecraft.block.trees.Tree;
//import net.minecraft.state.IntegerProperty;
//import net.minecraft.state.properties.BlockStateProperties;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.shapes.ISelectionContext;
//import net.minecraft.util.math.shapes.VoxelShape;
//import net.minecraft.world.IBlockReader;
//import net.minecraftforge.common.ToolType;
//
//public class ModSaplingBlock extends BushBlock implements IGrowable {
//	
//	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
//	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D,2.0D,14.0D ,12.0D,14.0D);
//	private final Supplier<Tree> tree;
//	
//	
//	public ModSaplingBlock(Supplier<Tree> treeIn, Properties properties) {
//		super(properties);
//		this.tree = treeIn;
//	}
//	
//	@Override
//	public VoxelShape getShape(BlockState state, IBlockReader worldIn,BlockPos pos, ISelectionContext context) {
//		return SHAPE;
//	}
//	
//}
