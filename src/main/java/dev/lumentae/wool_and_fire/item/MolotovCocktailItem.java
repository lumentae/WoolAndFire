package dev.lumentae.wool_and_fire.item;

import dev.lumentae.wool_and_fire.entity.ThrownMolotovCocktail;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MolotovCocktailItem extends Item {
    public static float PROJECTILE_SHOOT_POWER = 1.5f;

    public MolotovCocktailItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.TNT_PRIMED, SoundSource.NEUTRAL, 0.5f, 0.4f / (level.getRandom().nextFloat() * 0.4f + 0.8f));
        if (level instanceof ServerLevel serverLevel) {
            Projectile.spawnProjectileFromRotation(ThrownMolotovCocktail::new, serverLevel, itemStack, player, 0.0f, PROJECTILE_SHOOT_POWER, 1.0f);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        itemStack.consume(1, player);
        return InteractionResult.SUCCESS;
    }
}
