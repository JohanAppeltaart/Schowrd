package nl.johanappeltaart.schowrd.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class DDD_Banana extends Block {
    public static final VoxelShape SHAPE = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(7, 9.600000000000001, 15, 9, 11.600000000000001, 16), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(6, 0, 5.649999999999999, 10, 3, 10.650000000000006), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(6, 4.399999999999993, 15.350000000000005, 10, 8.8, 18.350000000000016), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(6, -4.499999999999998, 2.449999999999999, 10, -1.5000000000000004, 6.450000000000005), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(6, 1.3000000000000003, 10.249999999999996, 10, 4.299999999999999, 15.250000000000004), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(6, -1.8000000000000003, 4.649999999999999, 10, 1.1999999999999997, 8.650000000000006), Block.makeCuboidShape(6, 5.899999999999993, 14.050000000000008, 10, 9.9, 17.04999999999999), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR);
    public DDD_Banana() {
        super(Block.Properties.create(Material.CACTUS)
                .hardnessAndResistance(1.0f)
                .slipperiness(2.0f)
                .sound(SoundType.CROP)
                .harvestLevel(0)
                .harvestTool(ToolType.HOE)
        );
    }

    @Override
    public VoxelShape getRenderShape(BlockState p_196247_1_, IBlockReader p_196247_2_, BlockPos p_196247_3_) {
//        return super.getRenderShape(p_196247_1_, p_196247_2_, p_196247_3_);
        return SHAPE;
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState p_220080_1_, IBlockReader p_220080_2_, BlockPos p_220080_3_) {
        return 0.7f;
    }
}
