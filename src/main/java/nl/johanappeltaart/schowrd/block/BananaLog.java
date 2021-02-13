package nl.johanappeltaart.schowrd.block;

import nl.johanappeltaart.schowrd.init.ModBlocks;
//import com.sun.istack.internal.NotNull;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.Property;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicReference;

public class BananaLog extends RotatedPillarBlock {
    public BananaLog() {
        super(RotatedPillarBlock.Properties.create(
                Material.WOOD,MaterialColor.GOLD)
                .hardnessAndResistance(2.0F)
                .slipperiness(1.2F)
                .sound(SoundType.WOOD));
    }

    public @NotNull
    ActionResultType onBlockActivated(@NotNull BlockState state, @NotNull World worldIn, @NotNull BlockPos pos, @NotNull PlayerEntity player, @NotNull Hand handIn, @NotNull BlockRayTraceResult hit) {
//        if (blocks.containsKey("stripped_" + sa[0])) {
            if (player.getHeldItem(handIn).getToolTypes().contains(ToolType.AXE)) {
                AtomicReference<BlockState> state1 = new AtomicReference<>(ModBlocks.STRIPPED_BANANA_LOG.get().getDefaultState());
                state.getProperties().forEach(property -> {
                    state1.set(applyProperty(state, state1.get(), property));
                });
                worldIn.setBlockState(pos, state1.get());
                worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1, 1, false);
                if (!player.isCreative())
                    player.getHeldItem(handIn).damageItem(1, player, (p_220040_1_) -> p_220040_1_.sendBreakAnimation(handIn));
                player.swingArm(handIn);
                return ActionResultType.PASS;
            }
//        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
    public <A extends Comparable<A>> BlockState applyProperty(@NotNull BlockState sourceState, @NotNull BlockState newState, Property<A> property) {
        return newState.with(property, sourceState.get(property));
    }
}
