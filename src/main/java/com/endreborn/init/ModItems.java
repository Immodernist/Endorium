package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.*;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModItems {
    public static RegistryObject<Item> ENDORIUM_NUGGET;
    public static RegistryObject<Item> ENDORIUM_INGOT;
    public static RegistryObject<Item> ENDORIUM_SWORD;
    public static RegistryObject<Item> ENDORIUM_AXE;
    public static RegistryObject<Item> ENDORIUM_SHOVEL;
    public static RegistryObject<Item> ENDORIUM_HOE;
    public static RegistryObject<Item> ENDORIUM_PICKAXE;
    public static RegistryObject<Item> TUNGSTEN_INGOT;
    public static RegistryObject<Item> TUNGSTEN_HAMMER;
    public static RegistryObject<Item> TUNGSTEN_RAW;
    public static RegistryObject<Item> CURIOUS_TEMPLATE;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_AXE;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_HOE;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_PICKAXE;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_SHOVEL;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_SWORD;
    public static RegistryObject<Item> MYSTERIOUS_TEMPLATE;
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_AXE;
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_HOE;
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_PICKAXE;
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_SHOVEL;
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_SWORD;
    public static RegistryObject<Item> ENDER_BOOTS;
    public static RegistryObject<Item> TRANSMITTER;
    public static RegistryObject<Item> OGANA_FRUIT;
    public static RegistryObject<Item> OGANA_TORTE;
    public static RegistryObject<Item> IRON_HAMMER;

    public static void setup() {
        ENDORIUM_NUGGET = registerItem(() -> new Item(new Item.Properties()), "endorium_nugget");
        ENDORIUM_INGOT = registerItem(() -> new Item(new Item.Properties()), "endorium_ingot");
        ENDORIUM_SWORD = registerItem(() -> new SwordItem(ModTiers.ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.ENDORIUM, 3, -2.4f))), "endorium_sword");
        ENDORIUM_AXE = registerItem(() -> new AxeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.ENDORIUM,5f, -3.0f))), "endorium_axe");
        ENDORIUM_SHOVEL = registerItem(() -> new ShovelItem(ModTiers.ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.ENDORIUM,1.5f, -3f))), "endorium_shovel");
        ENDORIUM_HOE = registerItem(() -> new HoeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.ENDORIUM,-3.0F, 0.0F))), "endorium_hoe");
        ENDORIUM_PICKAXE = registerItem(() -> new PickaxeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.ENDORIUM,1, -2.8f))), "endorium_pickaxe");
        
        CURIOUS_TEMPLATE = registerItem(() -> new SmithingTemplateItem(APPLIES_TO, INGREDIENTS, UPGRADE, BASE_SLOT_DESCRIPTION, ADDITIONS_SLOT_DESCRIPTION, createUpgradeIconList(), createUpgradeMaterialList()), "curious_upgrade_template");
        CURIOUS_ENDORIUM_SWORD = registerItem(() -> new UpgradableSwordItem(ModTiers.CURIOUS_ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.CURIOUS_ENDORIUM, 3, -2.4f)), 1, 0), "curious_endorium_sword");
        CURIOUS_ENDORIUM_AXE = registerItem(() -> new UpgradableAxeItem(ModTiers.CURIOUS_ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.CURIOUS_ENDORIUM,5f, -3.0f)), 1, 0), "curious_endorium_axe");
        CURIOUS_ENDORIUM_SHOVEL = registerItem(() -> new UpgradableShovelItem(ModTiers.CURIOUS_ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.CURIOUS_ENDORIUM,1.5f, -3f)), 1, 0), "curious_endorium_shovel");
        CURIOUS_ENDORIUM_HOE = registerItem(() -> new UpgradableHoeItem(ModTiers.CURIOUS_ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.CURIOUS_ENDORIUM,-4, 0.0f)), 1, 0), "curious_endorium_hoe");
        CURIOUS_ENDORIUM_PICKAXE = registerItem(() -> new UpgradablePickaxeItem(ModTiers.CURIOUS_ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.CURIOUS_ENDORIUM,1, -2.8f)), 1, 0), "curious_endorium_pickaxe");

        MYSTERIOUS_TEMPLATE = registerItem(() -> new SmithingTemplateItem(APPLIES_TO, INGREDIENTS, UPGRADE, BASE_SLOT_DESCRIPTION, ADDITIONS_SLOT_DESCRIPTION, createUpgradeIconList(), createUpgradeMaterialList()), "mysterious_upgrade_template");
        MYSTERIOUS_ENDORIUM_SWORD = registerItem(() -> new UpgradableSwordItem(ModTiers.MYSTERIOUS_ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.MYSTERIOUS_ENDORIUM, 3, -2.4f)), 0, 1), "mysterious_endorium_sword");
        MYSTERIOUS_ENDORIUM_AXE = registerItem(() -> new UpgradableAxeItem(ModTiers.MYSTERIOUS_ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.MYSTERIOUS_ENDORIUM,5f, -3.0f)), 0, 1), "mysterious_endorium_axe");
        MYSTERIOUS_ENDORIUM_SHOVEL = registerItem(() -> new UpgradableShovelItem(ModTiers.MYSTERIOUS_ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.MYSTERIOUS_ENDORIUM,1.5f, -3f)), 0, 1), "mysterious_endorium_shovel");
        MYSTERIOUS_ENDORIUM_HOE = registerItem(() -> new UpgradableHoeItem(ModTiers.MYSTERIOUS_ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.MYSTERIOUS_ENDORIUM,-4, 0.0f)), 0, 1), "mysterious_endorium_hoe");
        MYSTERIOUS_ENDORIUM_PICKAXE = registerItem(() -> new UpgradablePickaxeItem(ModTiers.MYSTERIOUS_ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.MYSTERIOUS_ENDORIUM,1, -2.8f)), 0, 1), "mysterious_endorium_pickaxe");

        TUNGSTEN_INGOT = registerItem(() -> new Item(new Item.Properties()), "tungsten_ingot");
        TUNGSTEN_RAW = registerItem(() -> new Item(new Item.Properties()), "raw_tungsten");
        TUNGSTEN_HAMMER = registerItem(() -> new HammerItem(new Item.Properties().durability(48)), "tungsten_hammer");

        ENDER_BOOTS = registerItem(() -> new EnderBootsItem(ModArmor.ENDER, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35))), "ender_boots");
        TRANSMITTER = registerItem(() -> new TransmitterItem(new Item.Properties().durability(32)), "ender_transmitter");
        OGANA_FRUIT = registerItem(() -> new Item(new Item.Properties().food(Foods.SWEET_BERRIES)), "ogana");
        OGANA_TORTE = registerItem(() -> new Item(new Item.Properties().food(Foods.PUMPKIN_PIE)), "ogana_torte");
        IRON_HAMMER = registerItem(() -> new HammerItem(new Item.Properties().durability(32)), "iron_hammer");
    }
    public static RegistryObject<Item> registerItem(Supplier<Item> itemSupplier, String name) {
        return EndReborn.ITEM.register(name, itemSupplier);
    }
    private static final Component APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(EndReborn.MODID, "smithing_template.endorium_upgrade.applies_to"))
            ).withStyle(ChatFormatting.BLUE);
    private static final Component INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(EndReborn.MODID, "endorium_ingot"))
            ).withStyle(ChatFormatting.BLUE);
    private static final Component UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(EndReborn.MODID, "endorium_upgrade")))
            .withStyle(ChatFormatting.GRAY);
    private static final Component BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.netherite_upgrade.base_slot_description"))
    );
    private static final Component ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.netherite_upgrade.additions_slot_description"))
    );
    private static List<ResourceLocation> createUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }
    private static List<ResourceLocation> createUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");
}
