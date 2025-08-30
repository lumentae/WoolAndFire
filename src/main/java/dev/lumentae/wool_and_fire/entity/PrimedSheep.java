package dev.lumentae.wool_and_fire.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class PrimedSheep extends PrimedTnt {
    public PrimedSheep(Level level, double x, double y, double z, @Nullable LivingEntity owner) {
        super(level, x, y, z, owner);
        setBlockState(Blocks.AIR.defaultBlockState());
    }

    @Override
    public void tick() {
        super.tick();
        if (getOwner() != null)
            setPos(getOwner().position());
    }
}
