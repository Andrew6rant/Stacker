package io.github.Andrew6rant.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.item.Item;

@Mixin (Item.class)
public interface ItemAccess {
    @Mutable
    @Accessor
    void setMaxCount(int count);
}