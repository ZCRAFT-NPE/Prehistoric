package com.wiyuka.prehistoric.mixin;

import com.wiyuka.prehistoric.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Mixin(ServerLevel.class)
public abstract class BlockBreakMixin {

    @Shadow
    public abstract List<ServerPlayer> players();

    @Unique
    private static final ConcurrentHashMap<Integer, CallbackInfo> prehistoric$callbacks = new ConcurrentHashMap<>();

    @Inject(
        method = "tickBlock",
        at = @At("RETURN")
    )
    private void tickBlock(CallbackInfo ci) {
        try {
            Util.info("Block Ticked!");
            prehistoric$callbacks.put(ci.hashCode(), ci);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}