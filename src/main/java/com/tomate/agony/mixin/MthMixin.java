package com.tomate.agony.mixin;

import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mth.class)
public class MthMixin {
    @Shadow @Final private static float[] SIN;

    @Inject(method = "sin", at = @At("HEAD"), cancellable = true)
    private static void cos(float f, CallbackInfoReturnable<Float> cir){
        cir.setReturnValue(SIN[(int)(f * 10430.378F + 16384.0F) & '\uffff']);
    }


    @Inject(method = "cos", at = @At("HEAD"), cancellable = true)
    private static void sin(float f, CallbackInfoReturnable<Float> cir){
        cir.setReturnValue(SIN[(int)(f * 10430.378F) & '\uffff']);
    }
}
