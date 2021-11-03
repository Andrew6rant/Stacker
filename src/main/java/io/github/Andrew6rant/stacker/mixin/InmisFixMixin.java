package io.github.Andrew6rant.stacker.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "draylar.inmis.item.BackpackItem")
public class InmisFixMixin {
    /*
    @Inject(method = "use", at = @At("RETURN"), cancellable = true)
    public void useOverride(CallbackInfoReturnable<TypedActionResult<net.minecraft.item.ItemStack>> cir, World world, PlayerEntity user, Hand hand) {
        if (user.getStackInHand(hand).getCount() > 1) {
            cir.setReturnValue(TypedActionResult.fail(user.getStackInHand(hand)));
        }
        cir.setReturnValue(cir.getReturnValue());
        //cir.setReturnValue(TypedActionResult.success(user.getStackInHand(hand)));
    }
    */
    @Inject(method = "openScreen", at = @At("RETURN"), cancellable = true)
    private static void openScreenOverride(CallbackInfoReturnable cir){
        cir.setReturnValue(null);
    }
}
