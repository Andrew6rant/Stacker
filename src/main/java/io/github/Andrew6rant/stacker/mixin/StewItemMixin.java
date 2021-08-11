package io.github.Andrew6rant.stacker.mixin;

import io.github.Andrew6rant.stacker.util.ItemsHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MushroomStewItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MushroomStewItem.class)
public class StewItemMixin { //This mixin works for soup as well
    @Inject(method = "finishUsing", at=@At(value = "NEW", target = "net/minecraft/item/ItemStack"), cancellable = true)
    private void stackableStew(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir){
        ItemsHelper.insertNewItem((PlayerEntity)user, new ItemStack(Items.BOWL));
        cir.setReturnValue(stack);
    }
}
