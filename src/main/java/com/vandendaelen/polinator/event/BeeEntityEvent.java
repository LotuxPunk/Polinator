package com.vandendaelen.polinator.event;

import net.minecraft.entity.passive.BeeEntity;
import net.minecraftforge.eventbus.api.Event;

public class BeeEntityEvent extends Event {
    BeeEntity beeEntity;

    public BeeEntityEvent(BeeEntity beeEntity) {
        this.beeEntity = beeEntity;
    }

    public static class HoneyDelivered extends BeeEntityEvent {
        public HoneyDelivered(BeeEntity beeEntity) {
            super(beeEntity);
        }
    }
}
