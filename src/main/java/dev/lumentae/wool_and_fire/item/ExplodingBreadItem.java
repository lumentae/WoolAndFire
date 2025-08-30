package dev.lumentae.wool_and_fire.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ExplodingBreadItem extends Item {
    public ExplodingBreadItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        level.explode(livingEntity, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 2f, Level.ExplosionInteraction.TNT);
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
