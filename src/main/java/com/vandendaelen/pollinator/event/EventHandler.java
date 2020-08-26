package com.vandendaelen.pollinator.event;

import com.vandendaelen.pollinator.Pollinator;
import com.vandendaelen.pollinator.config.PollinatorConfig;
import com.vandendaelen.pollinator.helper.BlockPosHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Pollinator.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void onHoneyDelivered(final BeeEntityEvent.HoneyDelivered event){
        final Random rand = new Random();
        final boolean doesFlowerAppear = rand.nextInt(100) <= PollinatorConfig.CHANCE.get() * 100;
        if (event.beeEntity.hasHive() && doesFlowerAppear){
            final BlockPos hivePos = event.beeEntity.getHivePos();
            ArrayList<BlockPos> flowerableSpots = BlockPosHelper.getFreeBlockInRadius(event.beeEntity.world, PollinatorConfig.RADIUS.get(), hivePos);

            if (!flowerableSpots.isEmpty()){

                final BlockPos pos = flowerableSpots.get(rand.nextInt(flowerableSpots.size()));
                event.beeEntity.world.setBlockState(pos, event.beeEntity.world.getBlockState(event.beeEntity.getFlowerPos()));
                Pollinator.LOGGER.debug(pos.toString());
            }

        }
    }
}
