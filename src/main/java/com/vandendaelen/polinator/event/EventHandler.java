package com.vandendaelen.polinator.event;

import com.vandendaelen.polinator.Polinator;
import com.vandendaelen.polinator.helper.BlockPosHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Polinator.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void onHoneyDelivered(final BeeEntityEvent.HoneyDelivered event){
        if (event.beeEntity.hasHive()){
            final BlockPos hivePos = event.beeEntity.getHivePos();
            ArrayList<BlockPos> flowerableSpots = BlockPosHelper.getFreeBlockInRadius(event.beeEntity.world, 10, hivePos);

            if (!flowerableSpots.isEmpty()){
                final Random rand = new Random();
                final BlockPos pos = flowerableSpots.get(rand.nextInt(flowerableSpots.size()));

                event.beeEntity.world.setBlockState(pos, event.beeEntity.world.getBlockState(event.beeEntity.getFlowerPos()));
            }

        }
    }
}
