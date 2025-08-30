package dev.lumentae.wool_and_fire.registry;

import dev.lumentae.wool_and_fire.Constants;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_MOD_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "item_group")
    );

    public static final CreativeModeTab CUSTOM_CREATIVE_MOD_TAB = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup.wool_and_fire"))
            .icon(() -> new ItemStack(ModItems.EXPLOSIVE_BREAD))
            .displayItems((parameters, output) -> {
                // Add items to the creative tab
                output.accept(ModItems.EXPLOSIVE_BREAD);
                output.accept(ModItems.MOLOTOV_COCKTAIL);
            })
            .build();

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_MOD_TAB_KEY, CUSTOM_CREATIVE_MOD_TAB);
    }
}
