package io.github.Andrew6rant.stacker.mixin;

import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Item.Settings.class)
public class ItemStackMixin {
	@Shadow int maxCount = 99;

	@ModifyVariable(method = "maxCount", at = @At("HEAD"), argsOnly = true)
	private int forceCount(int original) {
		return 99;
	}
}