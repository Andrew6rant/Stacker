package io.github.Andrew6rant.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;

@Mixin(BundleItem.class)
public class BundleItemMixin {
    // The following mixin was backported from Stacc API 1.3.3. Thanks to Devan-Kerman for the code.
    @Inject(at = @At("RETURN"), method = "getItemOccupancy", cancellable = true)
    private static void getItemOccupancyFix(ItemStack stack, CallbackInfoReturnable<Integer> c) {
        if (c.getReturnValue() <= 0) {
            c.setReturnValue(1);
        }
    }
}
