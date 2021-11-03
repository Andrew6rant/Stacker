package io.github.Andrew6rant.stacker.mixin;

import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(JukeboxBlock.class)
public class JukeboxBlockMixin {
    // Credit to ZoeyTheEgoist for this mixin
    @Redirect(method = "setRecord", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/JukeboxBlockEntity;setRecord(Lnet/minecraft/item/ItemStack;)V"))
    public void setCountToOne(JukeboxBlockEntity jukeboxBlockEntity, ItemStack stack) {
        ItemStack newStack = stack.copy();
        newStack.setCount(1);
        jukeboxBlockEntity.setRecord(newStack);
    }
}