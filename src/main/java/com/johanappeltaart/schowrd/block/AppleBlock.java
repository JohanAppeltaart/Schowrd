package com.johanappeltaart.schowrd.block;

import com.johanappeltaart.schowrd.Schowrd;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;

public class AppleBlock extends Block {
    public AppleBlock() {
        super(Block.Properties.create(Material.CLAY)
                .hardnessAndResistance(1.0f)
                .jumpFactor(3.0f)
//                .slipperiness(2.0f)
                .sound(SoundType.CROP)
                .harvestLevel(0)
                .harvestTool(ToolType.HOE)
        );
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<String> touchedBlock = new ArrayList();
    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if (entityIn.isSuppressingBounce()) {
//            super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
            entityIn.onLivingFall(fallDistance, 0.0F);
        } else {
            entityIn.onLivingFall(fallDistance, 0.0F);
        }

    }

    /**
     * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
     * on its own
     */
    public void onLanded(IBlockReader worldIn, Entity entityIn) {
        if (entityIn.isSuppressingBounce()) {
            super.onLanded(worldIn, entityIn);
        } else {
            this.bounceEntity(entityIn);
        }

    }

    private void bounceEntity(Entity entity) {
        Vector3d vector3d = entity.getMotion();
        if (vector3d.y < -0.52D) {
            double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setMotion(vector3d.x, -vector3d.y * d0, vector3d.z);
//            entity.onLivingFall(100f, 0.0F);
        }else{
            entity.setMotion(vector3d.x, 0, vector3d.z);
        }

    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        String name = entityIn.getName().toString();
        if(!touchedBlock.contains(name))
        touchedBlock.add(name);
        super.onEntityWalk(worldIn, pos, entityIn);
    }

    /**
     * Called when the given entity walks on this Block
     */
//    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
//        double d0 = Math.abs(entityIn.getMotion().y);
//        if (d0 < 0.1D && !entityIn.isSteppingCarefully()) {
//            double d1 = 0.4D + d0 * 0.2D;
//            entityIn.setMotion(entityIn.getMotion().mul(d1, 1.0D, d1));
//        }
//
//        super.onEntityWalk(worldIn, pos, entityIn);
//    }
}
