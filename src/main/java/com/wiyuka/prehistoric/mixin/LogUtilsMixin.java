package com.wiyuka.prehistoric.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.logging.LogUtils;
import com.wiyuka.prehistoric.logging.SecureAsyncLogger;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LogUtils.class)
public class LogUtilsMixin {

    @WrapMethod(method = "getLogger")
    private static Logger prehistoric$getLogger(Operation<Logger> original) {
        return SecureAsyncLogger.getSecureLogger(original.call());
    }

}
