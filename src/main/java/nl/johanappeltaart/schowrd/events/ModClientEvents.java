package nl.johanappeltaart.schowrd.events;

import nl.johanappeltaart.schowrd.Schowrd;
import nl.johanappeltaart.schowrd.block.AppleBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Schowrd.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void appleBlockBounceNoDamage(LivingDamageEvent event){
        if(AppleBlock.touchedBlock.contains(event.getEntity().getName().toString())){
            event.setAmount(0f);
            AppleBlock.touchedBlock.remove(event.getEntity().getName().toString());
        }
    }

//    @SubscribeEvent
//    public static void noSlipperyWithBananaBoots(LivingEntity entity,World world){
//        BlockPos underneath = entity.getPosition().add(0,-0.5000001D,0);
//        BlockState oldstate = world.getBlockState(underneath);
//        Schowrd.LOGGER.info("runnig");
//        world.setBlockState(underneath,oldstate);
//
//    }
//    public BlockPos getPositionUnderneath() {
//        return new BlockPos(this.positionVec.x, this.getBoundingBox().minY - 0.5000001D, this.positionVec.z);
//    }

//    @SubscribeEvent
//    public static void onSpeedToomuch(LivingEvent.LivingJumpEvent event){
//        LivingEntity player = event.getEntityLiving();
//        if(player.getHeldItemMainhand().getItem() == ModItems.DDD_BANANA_ITEM.get()){
//            Schowrd.LOGGER.info("STICK DINGSE");
//            World world = player.getEntityWorld();
//            world.setBlockState(player.getPosition().add(0,-1,0), ModBlocks.BANANA_DOOR.get().getDefaultState());
//        };
//
//    }
}
