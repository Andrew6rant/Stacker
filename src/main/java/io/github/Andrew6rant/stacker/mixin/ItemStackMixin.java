package io.github.Andrew6rant.stacker.mixin;

import io.github.Andrew6rant.stacker.Stacker;
import io.github.Andrew6rant.stacker.StackerConfig;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Item.Settings.class)
public class ItemStackMixin {
    @ModifyVariable(method = "maxCount", at = @At("HEAD"), argsOnly = true)
    private int forceCount(int original) {
        return Integer.MAX_VALUE;
    }
}
