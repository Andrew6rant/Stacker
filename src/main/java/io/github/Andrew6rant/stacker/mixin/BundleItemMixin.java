package io.github.Andrew6rant.stacker.mixin;

import io.github.Andrew6rant.stacker.Stacker;
import net.minecraft.item.BundleItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * Modifies BundleItem's magic numbers to use Stacker's configured 'maxStacker' value
 */
@Mixin(BundleItem.class)
public abstract class BundleItemMixin {

    @ModifyConstant(method = "getAmountFilled", constant = @Constant(floatValue = 64.0f))
    private static float replaceAmountFilled(float constant) {
        return (float) Stacker.getStacker().getStackerConfig().maxStacker;
    }

    @ModifyConstant(method = "onStackClicked", constant = @Constant(intValue = 64))
    private static int replaceOnStackClicked(int constant) {
        return Stacker.getStacker().getStackerConfig().maxStacker;
    }

    @ModifyConstant(method = "getItemBarStep", constant = @Constant(intValue = 64))
    private static int replaceGetItemBarStep(int constant) {
        return Stacker.getStacker().getStackerConfig().maxStacker;
    }

    @ModifyConstant(method = "addToBundle", constant = @Constant(intValue = 64))
    private static int replaceAddToBundle(int constant) {
        return Stacker.getStacker().getStackerConfig().maxStacker;
    }

    @ModifyConstant(method = "getItemOccupancy", constant = @Constant(intValue = 64))
    private static int replaceGetItemOccupancy(int constant) {
        return Stacker.getStacker().getStackerConfig().maxStacker;
    }

    @ModifyConstant(method = "appendTooltip", constant = @Constant(intValue = 64))
    private static int replaceAppendTooltip(int constant) {
        return Stacker.getStacker().getStackerConfig().maxStacker;
    }
}
