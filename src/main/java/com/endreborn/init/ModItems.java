package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(Registries.ITEM, EndReborn.MODID);

    public static RegistryObject<Item> ENDORIUM_NUGGET = register(() -> new Item(new Item.Properties()), "endorium_nugget");
    public static RegistryObject<Item> ENDORIUM_INGOT = register(() -> new Item(new Item.Properties()), "endorium_ingot");
    public static RegistryObject<Item> ENDORIUM_SWORD = register(() -> new SwordItem(ModTiers.ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.ENDORIUM, 3, -2.4f))), "endorium_sword");
    public static RegistryObject<Item> ENDORIUM_AXE = register(() -> new AxeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.ENDORIUM,5f, -3.0f))), "endorium_axe");
    public static RegistryObject<Item> ENDORIUM_SHOVEL = register(() -> new ShovelItem(ModTiers.ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.ENDORIUM,1.5f, -3f))), "endorium_shovel");
    public static RegistryObject<Item> ENDORIUM_HOE = register(() -> new HoeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.ENDORIUM,-3.0F, 0.0F))), "endorium_hoe");
    public static RegistryObject<Item> ENDORIUM_PICKAXE = register(() -> new PickaxeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.ENDORIUM,1, -2.8f))), "endorium_pickaxe");

    public static RegistryObject<Item> CURIOUS_TEMPLATE = register(UpgradeTemplateItem::createEndoriumUpgrade, "curious_upgrade_template");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_SWORD = register(() -> new UpgradableSwordItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.UPGRADE_ENDORIUM, 3, -2.4f)), true, false), "curious_endorium_sword");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_AXE = register(() -> new UpgradableAxeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,5f, -3.0f)), true, false), "curious_endorium_axe");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_SHOVEL = register(() -> new UpgradableShovelItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,1.5f, -3f)), true, false), "curious_endorium_shovel");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_HOE = register(() -> new UpgradableHoeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,-4, 0.0f)), true, false), "curious_endorium_hoe");
    public static RegistryObject<Item> CURIOUS_ENDORIUM_PICKAXE = register(() -> new UpgradablePickaxeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,1, -2.8f)), true, false), "curious_endorium_pickaxe");

    public static RegistryObject<Item> MYSTERIOUS_TEMPLATE = register(UpgradeTemplateItem::createEndoriumUpgrade, "mysterious_upgrade_template");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_SWORD = register(() -> new UpgradableSwordItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.UPGRADE_ENDORIUM, 3, -2.4f)), false, true), "mysterious_endorium_sword");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_AXE = register(() -> new UpgradableAxeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,5f, -3.0f)), false, true), "mysterious_endorium_axe");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_SHOVEL = register(() -> new UpgradableShovelItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,1.5f, -3f)), false, true), "mysterious_endorium_shovel");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_HOE = register(() -> new UpgradableHoeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,-4, 0.0f)), false, true), "mysterious_endorium_hoe");
    public static RegistryObject<Item> MYSTERIOUS_ENDORIUM_PICKAXE = register(() -> new UpgradablePickaxeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,1, -2.8f)), false, true), "mysterious_endorium_pickaxe");

    public static RegistryObject<Item> TUNGSTEN_INGOT = register(() -> new Item(new Item.Properties()), "tungsten_ingot");
    public static RegistryObject<Item> TUNGSTEN_RAW = register(() -> new Item(new Item.Properties()), "raw_tungsten");
    public static RegistryObject<Item> TUNGSTEN_HAMMER = register(() -> new HammerItem(new Item.Properties().durability(48)), "tungsten_hammer");

    public static RegistryObject<Item> ENDER_BOOTS = register(() -> new EnderBootsItem(ModArmor.ENDER, ArmorItem.Type.BOOTS, (new Item.Properties())), "ender_boots");
    public static RegistryObject<Item> TRANSMITTER = register(() -> new TransmitterItem(new Item.Properties().durability(24)), "ender_transmitter");
    public static RegistryObject<Item> WICKED_FRUIT = register(() -> new Item(new Item.Properties().food(Foods.SWEET_BERRIES)), "ogana");
    public static RegistryObject<Item> WICKED_TORTE = register(() -> new Item(new Item.Properties().food(Foods.PUMPKIN_PIE)), "ogana_torte");
    public static RegistryObject<Item> IRON_HAMMER = register(() -> new HammerItem(new Item.Properties().durability(32)), "iron_hammer");

    public static RegistryObject<Item> register(Supplier<Item> builder, String name) {
        return ITEM.register(name, builder);
    }
}
