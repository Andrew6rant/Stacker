package io.github.Andrew6rant.stacker.util;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class ItemsHelper {

    public static void insertNewItem(PlayerEntity player, ItemStack stack2) {
        if (!player.getInventory().insertStack(stack2)) {
            player.dropItem(stack2, false);
        }
    }
}
