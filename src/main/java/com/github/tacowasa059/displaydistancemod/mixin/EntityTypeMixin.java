package com.github.tacowasa059.displaydistancemod.mixin;

import com.github.tacowasa059.displaydistancemod.config.DDConfig;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityType.class)
public abstract class EntityTypeMixin {

    // entity typeごとの送信チャンク範囲
    @Inject(method = "clientTrackingRange", at = @At("HEAD"), cancellable = true)
    private void yourmod$boostDisplayTrackingRange(CallbackInfoReturnable<Integer> cir) {
        EntityType<?> self = (EntityType<?>)(Object)this;

        if (self == EntityType.TEXT_DISPLAY || self == EntityType.ITEM_DISPLAY || self == EntityType.BLOCK_DISPLAY) {
            cir.setReturnValue(DDConfig.displayRangeChunks());
        }
    }
}