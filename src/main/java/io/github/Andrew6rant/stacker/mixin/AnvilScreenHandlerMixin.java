package io.github.Andrew6rant.stacker.mixin;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = AnvilScreenHandler.class, priority = 999) // default priority is 1000, so this applies a bit after other mod's AnvilScreenHandler mixins
public class AnvilScreenHandlerMixin {
    // Credit to ZoeyTheEgoist for the original code behind this mixin
    @Redirect(method = "onTakeOutput", at = @At(value = "INVOKE", target = "Lnet/minecraft/inventory/Inventory;setStack(ILnet/minecraft/item/ItemStack;)V", ordinal = 3))
    private void setDecrementSlot1StackCount(Inventory inventory, int slot, ItemStack stack) {
        ItemStack newStack = inventory.getStack(1);
        newStack.decrement(1);
        inventory.setStack(1, newStack);
    }
}
