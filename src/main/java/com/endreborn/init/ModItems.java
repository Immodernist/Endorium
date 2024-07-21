package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.*;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEM = DeferredRegister.createItems(EndReborn.MODID);

    public static DeferredItem<Item> ENDORIUM_NUGGET = register(() -> new Item(new Item.Properties()), "endorium_nugget");
    public static DeferredItem<Item> ENDORIUM_INGOT = register(() -> new Item(new Item.Properties()), "endorium_ingot");
    public static DeferredItem<Item> ENDORIUM_SWORD = register(() -> new SwordItem(ModTiers.ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.ENDORIUM, 3, -2.4f))), "endorium_sword");
    public static DeferredItem<Item> ENDORIUM_AXE = register(() -> new AxeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.ENDORIUM,5f, -3.0f))), "endorium_axe");
    public static DeferredItem<Item> ENDORIUM_SHOVEL = register(() -> new ShovelItem(ModTiers.ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.ENDORIUM,1.5f, -3f))), "endorium_shovel");
    public static DeferredItem<Item> ENDORIUM_HOE = register(() -> new HoeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.ENDORIUM,-3.0F, 0.0F))), "endorium_hoe");
    public static DeferredItem<Item> ENDORIUM_PICKAXE = register(() -> new PickaxeItem(ModTiers.ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.ENDORIUM,1, -2.8f))), "endorium_pickaxe");

    public static DeferredItem<Item> CURIOUS_TEMPLATE = register(UpgradeTemplateItem::createEndoriumUpgrade, "curious_upgrade_template");
    public static DeferredItem<Item> CURIOUS_ENDORIUM_SWORD = register(() -> new UpgradableSwordItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.UPGRADE_ENDORIUM, 3, -2.4f)), true, false), "curious_endorium_sword");
    public static DeferredItem<Item> CURIOUS_ENDORIUM_AXE = register(() -> new UpgradableAxeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,5f, -3.0f)), true, false), "curious_endorium_axe");
    public static DeferredItem<Item> CURIOUS_ENDORIUM_SHOVEL = register(() -> new UpgradableShovelItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,1.5f, -3f)), true, false), "curious_endorium_shovel");
    public static DeferredItem<Item> CURIOUS_ENDORIUM_HOE = register(() -> new UpgradableHoeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,-4, 0.0f)), true, false), "curious_endorium_hoe");
    public static DeferredItem<Item> CURIOUS_ENDORIUM_PICKAXE = register(() -> new UpgradablePickaxeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,1, -2.8f)), true, false), "curious_endorium_pickaxe");

    public static DeferredItem<Item> MYSTERIOUS_TEMPLATE = register(UpgradeTemplateItem::createEndoriumUpgrade, "mysterious_upgrade_template");
    public static DeferredItem<Item> MYSTERIOUS_ENDORIUM_SWORD = register(() -> new UpgradableSwordItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.UPGRADE_ENDORIUM, 3, -2.4f)), false, true), "mysterious_endorium_sword");
    public static DeferredItem<Item> MYSTERIOUS_ENDORIUM_AXE = register(() -> new UpgradableAxeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,5f, -3.0f)), false, true), "mysterious_endorium_axe");
    public static DeferredItem<Item> MYSTERIOUS_ENDORIUM_SHOVEL = register(() -> new UpgradableShovelItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,1.5f, -3f)), false, true), "mysterious_endorium_shovel");
    public static DeferredItem<Item> MYSTERIOUS_ENDORIUM_HOE = register(() -> new UpgradableHoeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,-4, 0.0f)), false, true), "mysterious_endorium_hoe");
    public static DeferredItem<Item> MYSTERIOUS_ENDORIUM_PICKAXE = register(() -> new UpgradablePickaxeItem(ModTiers.UPGRADE_ENDORIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.UPGRADE_ENDORIUM,1, -2.8f)), false, true), "mysterious_endorium_pickaxe");

    public static DeferredItem<Item> TUNGSTEN_INGOT = register(() -> new Item(new Item.Properties()), "tungsten_ingot");
    public static DeferredItem<Item> TUNGSTEN_RAW = register(() -> new Item(new Item.Properties()), "raw_tungsten");
    public static DeferredItem<Item> TUNGSTEN_HAMMER = register(() -> new HammerItem(new Item.Properties().durability(48)), "tungsten_hammer");

    public static DeferredItem<Item> ENDER_BOOTS = register(() -> new EnderBootsItem(ModArmor.ENDER, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35))), "ender_boots");
    public static DeferredItem<Item> TRANSMITTER = register(() -> new TransmitterItem(new Item.Properties().durability(24)), "ender_transmitter");
    public static DeferredItem<Item> WICKED_FRUIT = register(() -> new Item(new Item.Properties().food(Foods.SWEET_BERRIES)), "ogana");
    public static DeferredItem<Item> WICKED_TORTE = register(() -> new Item(new Item.Properties().food(Foods.PUMPKIN_PIE)), "ogana_torte");
    public static DeferredItem<Item> IRON_HAMMER = register(() -> new HammerItem(new Item.Properties().durability(32)), "iron_hammer");
    public static DeferredItem<Item> register(Supplier<Item> itemSupplier, String name) {
        return ITEM.register(name, itemSupplier);
    }

}
