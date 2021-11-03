package io.github.Andrew6rant.stacker.mixin;

import io.github.Andrew6rant.stacker.util.HorseScreenInterface;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(targets = "net/minecraft/screen/HorseScreenHandler$1")
public class HorseScreenHandlerMixin extends Slot implements HorseScreenInterface {
    // Credit to ZoeyTheEgoist for this mixin
    public HorseScreenHandlerMixin(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }
    @Override
    public int getMaxItemCount() {
        return 1;
    }
}
