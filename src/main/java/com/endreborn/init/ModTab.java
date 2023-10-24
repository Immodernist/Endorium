package com.endreborn.init;

import com.endreborn.Endorium;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModTab {
    private static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Endorium.MODID, "item_group"));

    public static void setup() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.endgroup"))
                .icon(() -> new ItemStack(ModBlocks.ENDORIUM_BLOCK))
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.ENDORIUM_NUGGET);
                    entries.add(ModItems.ENDORIUM_INGOT);
                    entries.add(ModItems.ENDORIUM_SWORD);
                    entries.add(ModItems.ENDORIUM_AXE);
                    entries.add(ModItems.ENDORIUM_PICKAXE);
                    entries.add(ModItems.ENDORIUM_SHOVEL);
                    entries.add(ModItems.ENDORIUM_HOE);
                    entries.add(ModBlocks.ENDORIUM_BLOCK);

                    entries.add(ModItems.TUNGSTEN_NUGGET);
                    entries.add(ModItems.TUNGSTEN_INGOT);
                    entries.add(ModItems.TUNGSTEN_HAMMER);
                    entries.add(ModItems.TUNGSTEN_SWORD);
                    entries.add(ModItems.TUNGSTEN_AXE);
                    entries.add(ModItems.TUNGSTEN_PICKAXE);
                    entries.add(ModItems.TUNGSTEN_SHOVEL);
                    entries.add(ModItems.TUNGSTEN_HOE);
                    entries.add(ModItems.MYSTERIOUS_RELIC);
                    entries.add(ModItems.CURIOUS_RELIC);
                    entries.add(ModItems.TUNGSTEN_DUST);
                    entries.add(ModItems.TUNGSTEN_HELMET);
                    entries.add(ModItems.TUNGSTEN_CHESTPLATE);
                    entries.add(ModItems.TUNGSTEN_LEGGINGS);
                    entries.add(ModItems.TUNGSTEN_BOOTS);
                    entries.add(ModItems.TUNGSTEN_RAW);
                    entries.add(ModBlocks.TUNGSTEN_BLOCK);
                    entries.add(ModBlocks.RAW_TUNGSTEN_BLOCK);

                    entries.add(ModBlocks.END_CORAL);
                    entries.add(ModBlocks.SMOOTH_END_STONE);
                    entries.add(ModBlocks.CRACKED_END_BRICKS);
                    entries.add(ModBlocks.CHISELED_END_BRICKS);
                    entries.add(ModBlocks.END_STONE_PILLAR);
                    entries.add(ModBlocks.TUNGSTEN_ORE);

                    entries.add(ModItems.PURPUR_EYE);
                    entries.add(ModBlocks.PURPUR_LANTERN);
                    entries.add(ModBlocks.PURPUR_CHAIN);
                    entries.add(ModBlocks.PURPUR_WALL);
                    entries.add(ModBlocks.CRACKED_PURPUR);

                    entries.add(ModItems.OGANA_FRUIT);
                    entries.add(ModBlocks.OGANA_WEED);
                    entries.add(ModBlocks.END_MOSS);
                    entries.add(ModBlocks.END_MOSS_BLOCK);

                    entries.add(ModItems.ENDER_BOOTS);
                    entries.add(ModItems.OBSIDIAN_SHARD);
                    entries.add(ModItems.TRANSMITTER);
                    entries.add(ModBlocks.OBSIDIAN_GLASS);
                    entries.add(ModBlocks.OBSIDIAN_GLASS_PANE);

                    entries.add(ModBlocks.FARSTONE);
                    entries.add(ModBlocks.FARSTONE_DECORATIVE);
                    entries.add(ModBlocks.FARSTONE_PILLAR);
                    entries.add(ModBlocks.FARSTONE_BRICKS);
                    entries.add(ModBlocks.FARSTONE_BRICKS_STAIRS);
                    entries.add(ModBlocks.FARSTONE_BRICKS_SLAB);
                    entries.add(ModBlocks.FARSTONE_BRICKS_WALL);

                    entries.add(ModItems.IRON_HAMMER);
                })
                .build());
    }
}
