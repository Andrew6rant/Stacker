package io.github.Andrew6rant.stacker.mixin;

import io.github.Andrew6rant.stacker.StackerConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import org.apache.commons.lang3.Validate;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//@Environment(EnvType.CLIENT)
@Pseudo
@Mixin(targets = "net.devtech.stacc.ItemCountRenderHandler")
public class ItemRenderScaleMixin {
    /*private static ItemRenderScaleMixin instance = new ItemRenderScaleMixin();
    public static ItemRenderScaleMixin getInstance() {
        return instance;
    }*/
    //@Unique
    //boolean initialized = false;

    //@Shadow
    //float scale = StackerConfig.CONFIG.itemCountScaleInt;

    /*void onScaleAccess() {
        if (!initialized) {
            int scale = StackerConfig.CONFIG.itemCountScaleInt;
        }
    }*/

    @Inject(method = "scale", at = @At("RETURN"), cancellable = true)
    private void forceScale(CallbackInfoReturnable<Float> cir) {
        float intToFloat = (float) (StackerConfig.CONFIG.itemCountScaleInt+50)/100;
        if (StackerConfig.CONFIG.variableOverride) {
            cir.setReturnValue(cir.getReturnValue());
        } else {
            cir.setReturnValue(intToFloat);
        }



        /*switch (StackerConfig.CONFIG.itemCountScaleInt) {
            case 0 -> { cir.setReturnValue(cir.getReturnValue()); }
            case 1 -> { cir.setReturnValue(.5f); }
            case 2 -> { cir.setReturnValue(.75f); }
            case 3 -> { cir.setReturnValue(1f); }
        };*/
    }
    /*@ModifyVariable(method = "scale", at = @At("HEAD"), remap = false)
    public float forceScale(String string) {
        switch (StackerConfig.CONFIG.itemCountScaleInt) {
            case 0 -> {
                if (string.length() > 3) {
                    return .5f;
                } else if (string.length() == 3) {
                    return .75f;
                }
                return 1f;
            }
            case 1 -> { return .5f; }
            case 2 -> { return .75f; }
            case 3 -> { return 1f; }
        };
        return 1f;
    }*/
}
