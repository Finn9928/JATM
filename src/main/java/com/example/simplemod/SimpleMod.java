package com.example.simplemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SimpleMod implements ModInitializer {
    public static final String MOD_ID = "simplemod";
    public static final Item CUSTOM_ITEM = new Item(new Item.Settings());

    public static final ItemGroup CUSTOM_TAB = FabricItemGroup.builder(
            new Identifier(MOD_ID, "custom_tab"))
            .icon(() -> new ItemStack(CUSTOM_ITEM))
            .entries((context, entries) -> {
                entries.add(CUSTOM_ITEM);
                entries.add(Items.DIAMOND); // Just to populate the tab
            })
            .build();

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "custom_item"), CUSTOM_ITEM);
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "custom_tab"), CUSTOM_TAB);
        System.out.println("SimpleMod has been initialized!");
    }
}
