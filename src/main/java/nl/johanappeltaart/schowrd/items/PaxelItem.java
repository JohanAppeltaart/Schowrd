package nl.johanappeltaart.schowrd.items;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import nl.johanappeltaart.schowrd.util.helpers.KeyboardHelper;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PaxelItem extends ToolItem {
    private static final Set<Material> EFFECTIVE_ON_MATERIALS = Sets.newHashSet(Material.WOOD, Material.NETHER_WOOD, Material.PLANTS, Material.TALL_PLANTS, Material.BAMBOO, Material.GOURD);
    private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.HAY_BLOCK, Blocks.DRIED_KELP_BLOCK, Blocks.TARGET, Blocks.SHROOMLIGHT, Blocks.SPONGE, Blocks.WET_SPONGE, Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES,Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.POWERED_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_STONE, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.PISTON, Blocks.STICKY_PISTON, Blocks.PISTON_HEAD,Blocks.LADDER, Blocks.SCAFFOLDING, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.ACACIA_BUTTON, Blocks.CRIMSON_BUTTON, Blocks.WARPED_BUTTON,Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER, Blocks.SOUL_SOIL);

    protected static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND.getDefaultState(), Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState(), Blocks.DIRT, Blocks.FARMLAND.getDefaultState(), Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState()));
    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).build();



    public PaxelItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
        super((float)attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(ToolType.HOE, tier.getHarvestLevel()).addToolType(ToolType.PICKAXE, tier.getHarvestLevel()).addToolType(ToolType.AXE, tier.getHarvestLevel()).addToolType(ToolType.SHOVEL, tier.getHarvestLevel()));
    }

    public boolean canHarvestBlock(BlockState blockIn) {
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
            return i >= blockIn.getHarvestLevel();
        }
        Material material = blockIn.getMaterial();
        return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return this.efficiency;
    }

    /**
     * Called when this item is used when targetting a Block
     */
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        PlayerEntity playerentity = context.getPlayer();
        //axe
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState block = blockstate.getToolModifiedState(world, blockpos, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.AXE);
        if (block != null) {
//            PlayerEntity playerentity = context.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote) {
                world.setBlockState(blockpos, block, 11);
                if (playerentity != null) {
                    context.getItem().damageItem(1, playerentity, (p_220040_1_) -> {
                        p_220040_1_.sendBreakAnimation(context.getHand());
                    });
                }
            }

            return ActionResultType.func_233537_a_(world.isRemote);
        }
        //holding shift
        if(KeyboardHelper.isHoldingShift()){
            //shovel
            BlockState blockstate1 = blockstate.getToolModifiedState(world, blockpos, playerentity, context.getItem(), net.minecraftforge.common.ToolType.SHOVEL);
            BlockState blockstate2 = null;
            if (blockstate1 != null && world.isAirBlock(blockpos.up())) {
                world.playSound(playerentity, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                blockstate2 = blockstate1;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT)) {
                if (!world.isRemote()) {
                    world.playEvent((PlayerEntity)null, 1009, blockpos, 0);
                }

                CampfireBlock.extinguish(world, blockpos, blockstate);
                blockstate2 = blockstate.with(CampfireBlock.LIT, Boolean.valueOf(false));
            }

            if (blockstate2 != null) {
                if (!world.isRemote) {
                    world.setBlockState(blockpos, blockstate2, 11);
                    if (playerentity != null) {
                        context.getItem().damageItem(1, playerentity, (player) -> {
                            player.sendBreakAnimation(context.getHand());
                        });
                    }
                }

                return ActionResultType.func_233537_a_(world.isRemote);
            }
        }else {
            //hoe
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
            if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
            if (context.getFace() != Direction.DOWN && world.isAirBlock(blockpos.up())) {
                BlockState blockState = world.getBlockState(blockpos).getToolModifiedState(world, blockpos, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
                if (blockState != null) {
//                PlayerEntity playerentity = context.getPlayer();
                    world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (!world.isRemote) {
                        world.setBlockState(blockpos, blockState, 11);
                        if (playerentity != null) {
                            context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {
                                p_220043_1_.sendBreakAnimation(context.getHand());
                            });
                        }
                    }

                    return ActionResultType.func_233537_a_(world.isRemote);
                }
            }
        }


        return ActionResultType.PASS;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Hold SHIFT for Paths."));//"\u00A70"+
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


    //    @javax.annotation.Nullable
//    public static BlockState getHoeTillingState(BlockState originalState) {
//        return HOE_LOOKUP.get(originalState.getBlock());
//    }
//    public static BlockState getAxeStrippingState(BlockState originalState) {
//        Block block = BLOCK_STRIPPING_MAP.get(originalState.getBlock());
//        return block != null ? block.getDefaultState().with(RotatedPillarBlock.AXIS, originalState.get(RotatedPillarBlock.AXIS)) : null;
//    }
}
