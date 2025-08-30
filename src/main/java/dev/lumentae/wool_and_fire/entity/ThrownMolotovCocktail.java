package dev.lumentae.wool_and_fire.entity;

import dev.lumentae.wool_and_fire.registry.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class ThrownMolotovCocktail extends ThrowableItemProjectile {
    public ThrownMolotovCocktail(Level level, LivingEntity owner, ItemStack item) {
        super(EntityType.ENDER_PEARL, owner, level, item);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return ModItems.MOLOTOV_COCKTAIL;
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);

        Level level = level();
        if (!level.isClientSide) {
            level.explode(this, getX(), getY(), getZ(), 2.0f, true, Level.ExplosionInteraction.BLOCK);
            discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide) {
            level().addParticle(ParticleTypes.FLAME, getX(), getY(), getZ(), 0, 0, 0);
        }
    }
}
