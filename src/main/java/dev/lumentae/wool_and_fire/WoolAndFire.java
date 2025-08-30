package dev.lumentae.wool_and_fire;

import dev.lumentae.wool_and_fire.registry.ModCreativeTab;
import dev.lumentae.wool_and_fire.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class WoolAndFire implements ModInitializer {

    @Override
    public void onInitialize() {
        ModCreativeTab.initialize();
        ModItems.initialize();
    }
}
