package com.vandendaelen.polinator.mixin;

import com.vandendaelen.polinator.event.BeeEntityEvent;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.entity.passive.BeeEntity.class)
public class BeeEntity {

    @Inject(at = @At("HEAD"),  method = "Lnet/minecraft/entity/passive/BeeEntity;onHoneyDelivered()V", cancellable = false, remap = false)
    public void onHoneyDelivered(CallbackInfo ci){
        this.setHasNectar(false);
        this.resetCropCounter();
        MinecraftForge.EVENT_BUS.post(new BeeEntityEvent.HoneyDelivered((net.minecraft.entity.passive.BeeEntity)(Object) this));
    }

    @Shadow
    private void resetCropCounter() {
        throw new IllegalStateException("Mixin failed to shadow resetCropCounter()");
    }

    @Shadow
    private void setHasNectar(boolean value) {
        throw new IllegalStateException("Mixin failed to shadow setHasNectar()");
    }
}
