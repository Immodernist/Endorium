package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.*;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

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
    public static RegistryObject<Item> TUNGSTEN_DUST;
    public static RegistryObject<Item> TUNGSTEN_HAMMER;
    public static RegistryObject<Item> TUNGSTEN_RAW;
    public static RegistryObject<Item> CURIOUS_RELIC;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_AXE;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_HOE;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_PICKAXE;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_SHOVEL;
    public static RegistryObject<Item> CURIOUS_ENDORIUM_SWORD;
    public static RegistryObject<Item> MYSTERIOUS_RELIC;
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
        ENDORIUM_SWORD = registerItem(() -> new SwordItem(ModTiers.ENDORIUM, 3, -2.4f, new Item.Properties()), "endorium_sword");
        ENDORIUM_AXE = registerItem(() -> new AxeItem(ModTiers.ENDORIUM, 5f, -3.1f, new Item.Properties()), "endorium_axe");
        ENDORIUM_SHOVEL = registerItem(() -> new ShovelItem(ModTiers.ENDORIUM, 1.5f, -3f, new Item.Properties()), "endorium_shovel");
        ENDORIUM_HOE = registerItem(() -> new HoeItem(ModTiers.ENDORIUM, -4, -1f, new Item.Properties()), "endorium_hoe");
        ENDORIUM_PICKAXE = registerItem(() -> new PickaxeItem(ModTiers.ENDORIUM, 1, -2.8f, new Item.Properties()), "endorium_pickaxe");
        
        CURIOUS_RELIC = registerItem(() -> new Item(new Item.Properties()), "curious_relic");
        CURIOUS_ENDORIUM_SWORD = registerItem(() -> new UpgradableSwordItem(ModTiers.ENDORIUM, 3, -2.4f, new Item.Properties(), 1, 0), "curious_endorium_sword");
        CURIOUS_ENDORIUM_AXE = registerItem(() -> new UpgradableAxeItem(ModTiers.ENDORIUM, 5f, -3.1f, new Item.Properties(), 1, 0), "curious_endorium_axe");
        CURIOUS_ENDORIUM_SHOVEL = registerItem(() -> new UpgradableShovelItem(ModTiers.ENDORIUM, 1.5f, -3f, new Item.Properties(), 1, 0), "curious_endorium_shovel");
        CURIOUS_ENDORIUM_HOE = registerItem(() -> new UpgradableHoeItem(ModTiers.ENDORIUM, -4, -1f, new Item.Properties(), 1, 0), "curious_endorium_hoe");
        CURIOUS_ENDORIUM_PICKAXE = registerItem(() -> new UpgradablePickaxeItem(ModTiers.ENDORIUM, 1, -2.8f, new Item.Properties(), 1, 0), "curious_endorium_pickaxe");

        MYSTERIOUS_RELIC = registerItem(() -> new Item(new Item.Properties()), "mysterious_relic");
        MYSTERIOUS_ENDORIUM_SWORD = registerItem(() -> new UpgradableSwordItem(ModTiers.ENDORIUM_FLEXIBILITY, 3, -2.4f, new Item.Properties(), 0, 1), "mysterious_endorium_sword");
        MYSTERIOUS_ENDORIUM_AXE = registerItem(() -> new UpgradableAxeItem(ModTiers.ENDORIUM_FLEXIBILITY, 5f, -3.1f, new Item.Properties(), 0, 1), "mysterious_endorium_axe");
        MYSTERIOUS_ENDORIUM_SHOVEL = registerItem(() -> new UpgradableShovelItem(ModTiers.ENDORIUM_FLEXIBILITY, 1.5f, -3f, new Item.Properties(), 0, 1), "mysterious_endorium_shovel");
        MYSTERIOUS_ENDORIUM_HOE = registerItem(() -> new UpgradableHoeItem(ModTiers.ENDORIUM_FLEXIBILITY, -4, -1f, new Item.Properties(), 0, 1), "mysterious_endorium_hoe");
        MYSTERIOUS_ENDORIUM_PICKAXE = registerItem(() -> new UpgradablePickaxeItem(ModTiers.ENDORIUM_FLEXIBILITY, 1, -2.8f, new Item.Properties(), 0, 1), "mysterious_endorium_pickaxe");

        TUNGSTEN_INGOT = registerItem(() -> new Item(new Item.Properties()), "tungsten_ingot");
        TUNGSTEN_DUST = registerItem(() -> new Item(new Item.Properties()), "tungsten_dust");
        TUNGSTEN_RAW = registerItem(() -> new Item(new Item.Properties()), "raw_tungsten");
        TUNGSTEN_HAMMER = registerItem(() -> new HammerItem(new Item.Properties().defaultDurability(48)), "tungsten_hammer");

        ENDER_BOOTS = registerItem(() -> new EnderBootsItem(ModArmor.ENDER, ArmorItem.Type.BOOTS, (new Item.Properties())), "ender_boots");
        TRANSMITTER = registerItem(() -> new TransmitterItem(new Item.Properties().defaultDurability(32)), "ender_transmitter");
        OGANA_FRUIT = registerItem(() -> new Item(new Item.Properties().food(Foods.SWEET_BERRIES)), "ogana");
        OGANA_TORTE = registerItem(() -> new Item(new Item.Properties().food(Foods.PUMPKIN_PIE)), "ogana_torte");
        IRON_HAMMER = registerItem(() -> new HammerItem(new Item.Properties().defaultDurability(32)), "iron_hammer");
    }
    public static RegistryObject<Item> registerItem(Supplier<Item> itemSupplier, String name) {
        return EndReborn.ITEM.register(name, itemSupplier);
    }
}
