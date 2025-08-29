package dev.lumentae.wool_and_fire.registry;

import dev.lumentae.wool_and_fire.Constants;
import dev.lumentae.wool_and_fire.item.ExplosiveBreadItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item EXPLOSIVE_BREAD = register(
            "explosive_bread",
            ExplosiveBreadItem::new,
            new Item.Properties().food(Foods.BREAD)
    );

    public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
    }
}
