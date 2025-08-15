package com.github.tacowasa059.displaydistancemod.mixin;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Display.class)
public class DisplayMixin {
    @Final
    @Shadow
    private static EntityDataAccessor<Float> DATA_VIEW_RANGE_ID;

    // NBT viewRangeの値
    @Inject(method = "setViewRange",at=@At("HEAD"), cancellable = true)
    private void setViewRange(float p_270907_, CallbackInfo ci) {
        ((Display)(Object)this).getEntityData().set(DATA_VIEW_RANGE_ID, 512f * 8);
        ci.cancel();
    }

    @Inject(method = "<init>", at=@At("TAIL"))
    private void onInit(EntityType<Display> p_270360_, Level p_270280_, CallbackInfo ci){
        ((Display)(Object)this).getEntityData().set(DATA_VIEW_RANGE_ID, 512f * 8);
    }
}
