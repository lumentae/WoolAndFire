package dev.lumentae.wool_and_fire.mixin;

import dev.lumentae.wool_and_fire.entity.PrimedSheep;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public class SheepMixin {
    @Inject(method= "mobInteract", at=@At("HEAD"), cancellable = true)
    public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.is(Items.FLINT_AND_STEEL)) {
            Level level = player.level();
            Sheep sheep = (Sheep)(Object)this;

            PrimedSheep primedTnt = new PrimedSheep(level, sheep.getX() + 0.5, sheep.getY(), sheep.getZ() + 0.5, sheep);

            level.addFreshEntity(primedTnt);
            level.playSound(null, primedTnt.getX(), primedTnt.getY(), primedTnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.gameEvent(player, GameEvent.PRIME_FUSE, new Vec3(sheep.getX(), sheep.getY(), sheep.getZ()));

            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }
}
