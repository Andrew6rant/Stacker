package io.github.Andrew6rant.stacker.mixin;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.slot.FurnaceFuelSlot;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;

import net.fabricmc.loader.api.FabricLoader;

@Mixin(FurnaceFuelSlot.class)
public abstract class LimitFurnaceStackMixin extends Slot {

    public LimitFurnaceStackMixin(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    public boolean canInsert(ItemStack stack) { // I know this is a kinda gross override,
        return true;                            // but if removed it crashes the game
    }

    @Override
    public int getMaxItemCount(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getMaxItemCount(stack);
    }
    public boolean isBucket(ItemStack stack) {
        return stack.isOf(Items.BUCKET) || stack.isOf(Items.LAVA_BUCKET);
    }
}