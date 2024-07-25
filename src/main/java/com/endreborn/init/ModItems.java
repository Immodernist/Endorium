package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, EndReborn.MODID);

    public static RegistryObject<Item> ENDORIUM_NUGGET = register(() -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)), "endorium_nugget");
    public static RegistryObject<Item> ENDORIUM_INGOT = register(() -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)), "endorium_ingot");
    public static RegistryObject<Item> TUNGSTEN_INGOT = register(() -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)), "tungsten_ingot");
    public static RegistryObject<Item> TUNGSTEN_RAW = register(() -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)), "raw_tungsten");
    public static RegistryObject<Item> IRON_HAMMER = register(() -> new HammerItem(new Item.Properties().tab(EndReborn.ENDGROUP).defaultDurability(32)), "iron_hammer");
    public static RegistryObject<Item> TUNGSTEN_HAMMER = register(() -> new HammerItem(new Item.Properties().tab(EndReborn.ENDGROUP).defaultDurability(48)), "tungsten_hammer");
    public static RegistryObject<Item> ENDORIUM_SWORD = register(() -> new SwordItem(ModTiers.ENDORIUM, 3, -2.4f, new Item.Properties().tab(EndReborn.ENDGROUP)), "endorium_sword");
    public static RegistryObject<Item> ENDORIUM_AXE = register(() -> new AxeItem(ModTiers.ENDORIUM, 5f, -3.0f, new Item.Properties().tab(EndReborn.ENDGROUP)), "endorium_axe");
    public static RegistryObject<Item> ENDORIUM_SHOVEL = register(() -> new ShovelItem(ModTiers.ENDORIUM, 1.5f, -3f, new Item.Properties().tab(EndReborn.ENDGROUP)), "endorium_shovel");
    public static RegistryObject<Item> ENDORIUM_HOE = register(() -> new HoeItem(ModTiers.ENDORIUM, -3, 0f, new Item.Properties().tab(EndReborn.ENDGROUP)), "endorium_hoe");
    public static RegistryObject<Item> ENDORIUM_PICKAXE = register(() -> new PickaxeItem(ModTiers.ENDORIUM, 1, -2.8f, new Item.Properties().tab(EndReborn.ENDGROUP)), "endorium_pickaxe");
    public static RegistryObject<Item> MYSTERIOUS_RELIC = register(() -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)),"mysterious_upgrade_template");
    public static RegistryObject<Item> CURIOUS_RELIC = register(() -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)),"curious_upgrade_template");
    public static RegistryObject<Item> INCANDESCENT_LAMP = register(() -> new BlockItem(ModBlocks.INCANDESCENT_LAMP.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "incandescent_lamp");
    public static RegistryObject<Item> OGANA_FRUIT = register(() -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP).food(Foods.SWEET_BERRIES)), "ogana");
    public static RegistryObject<Item> OGANA_TORTE = register(() -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP).food(Foods.PUMPKIN_PIE)), "ogana_torte");
    public static RegistryObject<Item> ENDER_BOOTS = register(() -> new EnderBootsItem(ModArmor.ENDER, EquipmentSlotType.FEET, (new Item.Properties().tab(EndReborn.ENDGROUP))), "ender_boots");
    public static RegistryObject<Item> TRANSMITTER = register(() -> new TransmitterItem(new Item.Properties().tab(EndReborn.ENDGROUP).defaultDurability(24)), "ender_transmitter");
    public static RegistryObject<Item> OBSIDIAN_GLASS_PANE = register(() -> new BlockItem(ModBlocks.OBSIDIAN_GLASS_PANE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "obsidian_glass_pane");
    public static RegistryObject<Item> OBSIDIAN_GLASS = register(() -> new BlockItem(ModBlocks.OBSIDIAN_GLASS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "obsidian_glass");
    public static RegistryObject<Item> TUNGSTEN_BLOCK = register(() -> new BlockItem(ModBlocks.TUNGSTEN_BLOCK.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "tungsten_block");
    public static RegistryObject<Item> RAW_TUNGSTEN_BLOCK = register(() -> new BlockItem(ModBlocks.RAW_TUNGSTEN_BLOCK.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "raw_tungsten_block");
    public static RegistryObject<Item> ENDORIUM_BLOCK = register(() -> new BlockItem(ModBlocks.ENDORIUM_BLOCK.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "endorium_block");
    public static RegistryObject<Item> SMOOTH_END_STONE = register(() -> new BlockItem(ModBlocks.SMOOTH_END_STONE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "end_stone_smooth");
    public static RegistryObject<Item> FARSTONE_DECORATIVE = register(() -> new BlockItem(ModBlocks.FARSTONE_DECORATIVE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "farstone_smooth");
    public static RegistryObject<Item> CRACKED_END_BRICKS = register(() -> new BlockItem(ModBlocks.CRACKED_END_BRICKS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "cracked_end_bricks");
    public static RegistryObject<Item> FARSTONE_BRICKS = register(() -> new BlockItem(ModBlocks.FARSTONE_BRICKS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "farstone_bricks");
    public static RegistryObject<Item> FARSTONE_WALL = register(() -> new BlockItem(ModBlocks.FARSTONE_WALL.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "farstone_wall");
    public static RegistryObject<Item> FARSTONE_BRICKS_SLAB = register(() -> new BlockItem(ModBlocks.FARSTONE_BRICKS_SLAB.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "farstone_brick_slab");
    public static RegistryObject<Item> FARSTONE_BRICKS_STAIRS = register(() -> new BlockItem(ModBlocks.FARSTONE_BRICKS_STAIRS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "farstone_brick_stairs");
    public static RegistryObject<Item> CHISELED_END_BRICKS = register(() -> new BlockItem(ModBlocks.CHISELED_END_BRICKS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "chiseled_end_bricks");
    public static RegistryObject<Item> FARSTONE_BRICKS_CHISELED = register(() -> new BlockItem(ModBlocks.FARSTONE_BRICKS_CHISELED.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "chiseled_farstone");
    public static RegistryObject<Item> END_STONE_PILLAR = register(() -> new BlockItem(ModBlocks.END_STONE_PILLAR.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "end_stone_pillar");
    public static RegistryObject<Item> FARSTONE_PILLAR = register(() -> new BlockItem(ModBlocks.FARSTONE_PILLAR.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "farstone_pillar");
    public static RegistryObject<Item> TUNGSTEN_ORE = register(() -> new BlockItem(ModBlocks.TUNGSTEN_ORE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "tungsten_ore");
    public static RegistryObject<Item> FARSTONE = register(() -> new BlockItem(ModBlocks.FARSTONE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "farstone");
    public static RegistryObject<Item> OGANA_WEED = register(() -> new BlockItem(ModBlocks.OGANA_WEED.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "ogana_weed");
    public static RegistryObject<Item> OGANA_PLANT = register(() -> new BlockItem(ModBlocks.OGANA_PLANT.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "ogana_plant");
    public static RegistryObject<Item> END_MOSS = register(() -> new BlockItem(ModBlocks.END_MOSS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "end_moss");
    public static RegistryObject<Item> END_MOSS_BLOCK = register(() -> new BlockItem(ModBlocks.END_MOSS_BLOCK.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "end_moss_block");
    public static RegistryObject<Item> END_MOSS_CARPET = register(() -> new BlockItem(ModBlocks.END_MOSS_CARPET.get(), new Item.Properties().tab(EndReborn.ENDGROUP)), "end_moss_carpet");


    public static RegistryObject<Item> CURIOUS_ENDORIUM_SWORD = register(() -> new UpgradableSwordItem(ModTiers.ENDORIUM, 4, -2.4f, new Item.Properties().tab(EndReborn.ENDGROUP), true, false), "curious_endorium_sword");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_AXE = register(() -> new UpgradableAxeItem(ModTiers.ENDORIUM, 6f, -3.0f, new Item.Properties().tab(EndReborn.ENDGROUP), true, false), "curious_endorium_axe");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_SHOVEL = register(() -> new UpgradableShovelItem(ModTiers.ENDORIUM, 2.5f, -3f, new Item.Properties().tab(EndReborn.ENDGROUP), true, false), "curious_endorium_shovel");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_HOE = register(() -> new UpgradableHoeItem(ModTiers.ENDORIUM, -3, 0f, new Item.Properties().tab(EndReborn.ENDGROUP), true, false), "curious_endorium_hoe");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_PICKAXE = register(() -> new UpgradablePickaxeItem(ModTiers.ENDORIUM, 2, -2.8f, new Item.Properties().tab(EndReborn.ENDGROUP), true, false), "curious_endorium_pickaxe");

   public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_SWORD = register(() -> new UpgradableSwordItem(ModTiers.MYSTERIOUS_ENDORIUM, 4, -2.4f, new Item.Properties().tab(EndReborn.ENDGROUP), false, true), "mysterious_endorium_sword");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_AXE = register(() -> new UpgradableAxeItem(ModTiers.MYSTERIOUS_ENDORIUM, 6f, -3.0f, new Item.Properties().tab(EndReborn.ENDGROUP), false, true), "mysterious_endorium_axe");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_SHOVEL = register(() -> new UpgradableShovelItem(ModTiers.MYSTERIOUS_ENDORIUM, 2.5f, -3f, new Item.Properties().tab(EndReborn.ENDGROUP), false, true), "mysterious_endorium_shovel");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_HOE = register(() -> new UpgradableHoeItem(ModTiers.MYSTERIOUS_ENDORIUM, -3, 0f, new Item.Properties().tab(EndReborn.ENDGROUP), false, true), "mysterious_endorium_hoe");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_PICKAXE = register(() -> new UpgradablePickaxeItem(ModTiers.MYSTERIOUS_ENDORIUM, 2, -2.8f, new Item.Properties().tab(EndReborn.ENDGROUP), false, true), "mysterious_endorium_pickaxe");

    public static RegistryObject<Item> register(Supplier<Item> builder, String name) {
        return ITEM.register(name, builder);
    }
}
