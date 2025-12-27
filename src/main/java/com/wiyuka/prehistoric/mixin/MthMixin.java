package com.wiyuka.prehistoric.mixin;

import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mth.class)
public class MthMixin {
    @Inject(
        method = "lerp(FFF)F",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void preLerpFloat(float pDelta, float pStart, float pEnd, CallbackInfoReturnable<Float> cir) {
            cir.setReturnValue(Math.fma(pDelta, pEnd - pStart, pStart));
        }

    @Inject(
        method = "lerp(DDD)D",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void preLerpDouble(double pDelta, double pStart, double pEnd, CallbackInfoReturnable<Double> cir) {
            cir.setReturnValue(Math.fma(pDelta, pEnd - pStart, pStart));
        }

    @Inject(
        method = "lengthSquared(DD)D",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void preLengthSquared2D(double pXDistance, double pYDistance, CallbackInfoReturnable<Double> cir) {
            cir.setReturnValue(Math.fma(pXDistance, pXDistance, pYDistance * pYDistance));
        }

    @Inject(
        method = "lengthSquared(DDD)D",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void preLengthSquared3D(double pXDistance, double pYDistance, double pZDistance, CallbackInfoReturnable<Double> cir) {
            cir.setReturnValue(Math.fma(pXDistance, pXDistance,
                Math.fma(pYDistance, pYDistance, pZDistance * pZDistance)));
        }

    @Inject(
        method = "nextFloat(Lnet/minecraft/util/RandomSource;FF)F",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void preNextFloat(net.minecraft.util.RandomSource pRandom, float pMinimum, float pMaximum, CallbackInfoReturnable<Float> cir) {
            if (pMinimum >= pMaximum) {
                cir.setReturnValue(pMinimum);
            } else {
                cir.setReturnValue(Math.fma(pRandom.nextFloat(), pMaximum - pMinimum, pMinimum));
            }
    }

    @Inject(
        method = "nextDouble(Lnet/minecraft/util/RandomSource;DD)D",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void preNextDouble(net.minecraft.util.RandomSource pRandom, double pMinimum, double pMaximum, CallbackInfoReturnable<Double> cir) {
            if (pMinimum >= pMaximum) {
                cir.setReturnValue(pMinimum);
            } else {
                cir.setReturnValue(Math.fma(pRandom.nextDouble(), pMaximum - pMinimum, pMinimum));
            }
    }

    @Inject(
        method = "normal(Lnet/minecraft/util/RandomSource;FF)F",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void preNormal(net.minecraft.util.RandomSource pRandom, float pMean, float pDeviation, CallbackInfoReturnable<Float> cir) {
            cir.setReturnValue(Math.fma((float) pRandom.nextGaussian(), pDeviation, pMean));
        }
}