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
                .icon(() -> new ItemStack(ModItems.CURIOUS_TEMPLATE))
                .entries((displayContext, output) -> {
                    output.add(ModItems.ENDORIUM_NUGGET);
                    output.add(ModItems.ENDORIUM_INGOT);
                    output.add(ModItems.TUNGSTEN_INGOT);
                    output.add(ModItems.TUNGSTEN_RAW);
                    output.add(ModItems.IRON_HAMMER);
                    output.add(ModItems.TUNGSTEN_HAMMER);
                    output.add(ModItems.ENDORIUM_SWORD);
                    output.add(ModItems.ENDORIUM_AXE);
                    output.add(ModItems.ENDORIUM_PICKAXE);
                    output.add(ModItems.ENDORIUM_SHOVEL);
                    output.add(ModItems.ENDORIUM_HOE);
                    output.add(ModItems.MYSTERIOUS_TEMPLATE);
                    output.add(ModItems.CURIOUS_TEMPLATE);
                    output.add(ModBlocks.INCANDESCENT_LAMP);
                    output.add(ModItems.OGANA_FRUIT);
                    output.add(ModItems.OGANA_TORTE);
                    output.add(ModItems.ENDER_BOOTS);
                    output.add(ModItems.TRANSMITTER);
                    output.add(ModBlocks.OBSIDIAN_GLASS_PANE);
                    output.add(ModBlocks.OBSIDIAN_GLASS);
                    output.add(ModBlocks.TUNGSTEN_BLOCK);
                    output.add(ModBlocks.RAW_TUNGSTEN_BLOCK);
                    output.add(ModBlocks.ENDORIUM_BLOCK);
                    output.add(ModBlocks.SMOOTH_END_STONE);
                    output.add(ModBlocks.FARSTONE_DECORATIVE);
                    output.add(ModBlocks.CRACKED_END_BRICKS);
                    output.add(ModBlocks.FARSTONE_BRICKS);
                    output.add(ModBlocks.FARSTONE_BRICKS_WALL);
                    output.add(ModBlocks.FARSTONE_BRICKS_SLAB);
                    output.add(ModBlocks.FARSTONE_BRICKS_STAIRS);
                    output.add(ModBlocks.CHISELED_END_BRICKS);
                    output.add(ModBlocks.FARSTONE_BRICKS_CHISELED);
                    output.add(ModBlocks.END_STONE_PILLAR);
                    output.add(ModBlocks.FARSTONE_PILLAR);
                    output.add(ModBlocks.TUNGSTEN_ORE);
                    output.add(ModBlocks.FARSTONE);
                    output.add(ModBlocks.OGANA_WEED);
                    output.add(ModBlocks.OGANA_PLANT);
                    output.add(ModBlocks.END_MOSS);
                    output.add(ModBlocks.END_MOSS_BLOCK);
                    output.add(ModBlocks.END_MOSS_CARPET);
                }).build());
    }
}
