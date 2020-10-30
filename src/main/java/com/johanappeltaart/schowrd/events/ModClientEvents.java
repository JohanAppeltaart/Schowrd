package com.johanappeltaart.schowrd.events;

import com.johanappeltaart.schowrd.Schowrd;
import com.johanappeltaart.schowrd.init.ModBlocks;
import com.johanappeltaart.schowrd.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Schowrd.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onSpeedToomuch(LivingEvent.LivingJumpEvent event){
        LivingEntity player = event.getEntityLiving();
        if(player.getHeldItemMainhand().getItem() == ModItems.DDD_BANANA_ITEM.get()){
            Schowrd.LOGGER.info("STICK DINGSE");
            World world = player.getEntityWorld();
            world.setBlockState(player.getPosition().add(0,-1,0), ModBlocks.BANANA_DOOR.get().getDefaultState());
        };

    }
}
