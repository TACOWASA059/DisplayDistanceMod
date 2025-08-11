package com.github.tacowasa059.displaydistancemod.mixin;

import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerPlayerConnection;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(targets = "net/minecraft/server/level/ChunkMap$TrackedEntity")
public abstract class TrackedEntityMixin {
    @Final
    @Shadow
    ServerEntity serverEntity;
    @Final
    @Shadow Entity entity;
    @Final
    @Shadow
    private Set<ServerPlayerConnection> seenBy;
    @Shadow
    protected abstract int getEffectiveRange();

    // サーバーの描画距離設定を無視
    @Inject(method = "updatePlayer", at = @At("HEAD"), cancellable = true)
    public void updatePlayer(ServerPlayer p_140498_, CallbackInfo ci) {
        if(this.entity instanceof Display){
            if (p_140498_ != this.entity) {
                Vec3 vec3 = p_140498_.position().subtract(this.entity.position());
                double d0 = this.getEffectiveRange();
                double d1 = vec3.x * vec3.x + vec3.z * vec3.z;
                double d2 = d0 * d0;
                boolean flag = d1 <= d2 && this.entity.broadcastToPlayer(p_140498_);
                if (flag) {
                    if (this.seenBy.add(p_140498_.connection)) {
                        this.serverEntity.addPairing(p_140498_);
                    }
                } else if (this.seenBy.remove(p_140498_.connection)) {
                    this.serverEntity.removePairing(p_140498_);
                }
            }
            ci.cancel();
        }
    }
}
