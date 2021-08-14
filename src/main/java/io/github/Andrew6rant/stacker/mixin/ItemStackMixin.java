package io.github.Andrew6rant.stacker.mixin;

import io.github.Andrew6rant.stacker.Stacker;
import io.github.Andrew6rant.stacker.StackerClient;
import io.github.Andrew6rant.stacker.StackerConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Item.Settings.class)
public class ItemStackMixin {
	@Shadow int maxCount = StackerClient.CONFIG.maxStacker;

	@ModifyVariable(method = "maxCount", at = @At("HEAD"), argsOnly = true)
	private int forceCount(int original) {
		return StackerClient.CONFIG.maxStacker;
	}
}