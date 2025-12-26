package com.wiyuka.prehistoric.mixin;

import com.mojang.logging.LogUtils;
import com.wiyuka.prehistoric.Util;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

@Mixin(GameRenderer.class)
public class RenderMixin {

    @Inject(method = "render", at = @At("HEAD"))
    private void renderMixin(CallbackInfo ci) {
        try {
            info();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    @Inject(method = "render", at = @At("TAIL"))
    private void renderMixinTail(CallbackInfo ci) {
        try {
            info();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static void info() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        LogUtils.getLogger().info("RenderMixin");
//        Class<?> loggerUtil = Class.forName("com.mojang.logging.LogUtils");
//        Class<?> loggerClass = Class.forName("org.slf4j.Logger");
//        Method getLoggerMethod = loggerUtil.getMethod("getLogger");
//        Object logger = getLoggerMethod.invoke(null);
//        Method infoMethod = loggerClass.getMethod("info", String.class);
//        infoMethod.invoke(logger, "Frame Render Finished!");

        Util.info("Frame Render Finished!");
    }
}