package io.github.Andrew6rant.stacker.mixin;

import io.github.Andrew6rant.stacker.Stacker;
import io.github.Andrew6rant.stacker.StackerClient;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Item.Settings.class)
public class ItemStackMixin {
	@Unique
	boolean initialized = false;

	@Shadow
	int maxCount = Stacker.CONFIG.maxStacker;

	void onMaxCountAccess() {
		if (!initialized) {
			int maxCount = Stacker.CONFIG.maxStacker;
		}
	}


	@ModifyVariable(method = "maxCount", at = @At("HEAD"), argsOnly = true)
	private int forceCount(int original) {
		return Stacker.CONFIG.maxStacker;
	}
}