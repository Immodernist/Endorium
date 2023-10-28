package com.endreborn.init;

import com.endreborn.Endorium;
import com.endreborn.content.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ENDORIUM_NUGGET = new Item(new FabricItemSettings());
    public static final Item ENDORIUM_INGOT = new Item(new FabricItemSettings());
    public static final Item ENDORIUM_SWORD = new SwordItem(ModTiers.ENDORIUM, 3, -2.4f, new FabricItemSettings());
    public static final Item ENDORIUM_AXE = new AxeItem(ModTiers.ENDORIUM, 4f, -3f, new FabricItemSettings());
    public static final Item ENDORIUM_SHOVEL = new ShovelItem(ModTiers.ENDORIUM, 1.5f, -3f, new FabricItemSettings());
    public static final Item ENDORIUM_HOE = new HoeItem(ModTiers.ENDORIUM, -4, 0f, new FabricItemSettings());
    public static final Item ENDORIUM_PICKAXE = new PickaxeItem(ModTiers.ENDORIUM, 1, -2.8f, new FabricItemSettings());

    public static final Item CURIOUS_RELIC = new Item(new FabricItemSettings());
    public static final Item CURIOUS_ENDORIUM_SWORD = new UpgradableSwordItem(ModTiers.ENDORIUM, 3, -2.4f, new FabricItemSettings(), 1, 0);
    public static final Item CURIOUS_ENDORIUM_AXE = new UpgradableAxeItem(ModTiers.ENDORIUM, 4f, -3f,  new FabricItemSettings(), 1, 0);
    public static final Item CURIOUS_ENDORIUM_SHOVEL = new UpgradableShovelItem(ModTiers.ENDORIUM, 1.5f, -3f, new FabricItemSettings(), 1, 0);
    public static final Item CURIOUS_ENDORIUM_HOE = new UpgradableHoeItem(ModTiers.ENDORIUM, -4, 0f, new FabricItemSettings(), 1, 0);
    public static final Item CURIOUS_ENDORIUM_PICKAXE = new UpgradablePickaxeItem(ModTiers.ENDORIUM, 1, -2.8f, new FabricItemSettings(), 1, 0);

    public static final Item MYSTERIOUS_RELIC = new Item(new FabricItemSettings());
    public static final Item MYSTERIOUS_ENDORIUM_SWORD = new UpgradableSwordItem(ModTiers.ENDORIUM_FLEXIBILITY, 3, -2.4f, new FabricItemSettings(), 0, 1);
    public static final Item MYSTERIOUS_ENDORIUM_AXE = new UpgradableAxeItem(ModTiers.ENDORIUM_FLEXIBILITY, 4f, -3f, new FabricItemSettings(), 0, 1);
    public static final Item MYSTERIOUS_ENDORIUM_SHOVEL = new UpgradableShovelItem(ModTiers.ENDORIUM_FLEXIBILITY, 1.5f, -3f, new FabricItemSettings(), 0, 1);
    public static final Item MYSTERIOUS_ENDORIUM_HOE = new UpgradableHoeItem(ModTiers.ENDORIUM_FLEXIBILITY, -4, 0f, new FabricItemSettings(), 0, 1);
    public static final Item MYSTERIOUS_ENDORIUM_PICKAXE = new UpgradablePickaxeItem(ModTiers.ENDORIUM_FLEXIBILITY, 1, -2.8f, new FabricItemSettings(), 0, 1);

    public static final Item TUNGSTEN_NUGGET = new Item(new FabricItemSettings());
    public static final Item TUNGSTEN_INGOT = new Item(new FabricItemSettings());
    public static final Item TUNGSTEN_DUST = new Item(new FabricItemSettings());
    public static final Item TUNGSTEN_RAW = new Item(new FabricItemSettings());
    public static final Item TUNGSTEN_SWORD = new SwordItem(ModTiers.TUNGSTEN, 3, -2.4f, new FabricItemSettings());
    public static final Item TUNGSTEN_AXE = new AxeItem(ModTiers.TUNGSTEN, 6f, -3.1f, new FabricItemSettings());
    public static final Item TUNGSTEN_SHOVEL = new ShovelItem(ModTiers.TUNGSTEN, 1.5f, -3f, new FabricItemSettings());
    public static final Item TUNGSTEN_HOE = new HoeItem(ModTiers.TUNGSTEN, -3, -1f, new FabricItemSettings());
    public static final Item TUNGSTEN_PICKAXE = new PickaxeItem(ModTiers.TUNGSTEN, 1, -2.8f, new FabricItemSettings());
    public static final Item TUNGSTEN_HAMMER = new HammerItem(new FabricItemSettings().maxDamage(48));
    public static final Item TUNGSTEN_HELMET = new ArmorItem(ModArmor.TUNGSTEN, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item TUNGSTEN_CHESTPLATE = new ArmorItem(ModArmor.TUNGSTEN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item TUNGSTEN_LEGGINGS = new ArmorItem(ModArmor.TUNGSTEN, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item TUNGSTEN_BOOTS = new ArmorItem(ModArmor.TUNGSTEN, ArmorItem.Type.BOOTS, new FabricItemSettings());

    public static final Item ENDER_BOOTS = new EnderBootsItem(ModArmor.ENDER, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static final Item TRANSMITTER = new TransmitterItem(new FabricItemSettings().maxDamage(32));
    public static final Item PURPUR_EYE = new PurpurEyeItem(new FabricItemSettings());
    public static final Item OGANA_FRUIT = new Item(new FabricItemSettings().food(FoodComponents.SWEET_BERRIES));
    public static final Item OGANA_TORTE = new Item(new FabricItemSettings().food(FoodComponents.PUMPKIN_PIE));
    public static final Item IRON_HAMMER = new HammerItem(new FabricItemSettings().maxDamage(32));
    public static void setup() {
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "endorium_nugget"), ENDORIUM_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "endorium_ingot"), ENDORIUM_INGOT);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "endorium_sword"), ENDORIUM_SWORD);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "endorium_axe"), ENDORIUM_AXE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "endorium_shovel"), ENDORIUM_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "endorium_hoe"), ENDORIUM_HOE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "endorium_pickaxe"), ENDORIUM_PICKAXE);

        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "curious_relic"), CURIOUS_RELIC);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "curious_endorium_sword"), CURIOUS_ENDORIUM_SWORD);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "curious_endorium_axe"), CURIOUS_ENDORIUM_AXE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "curious_endorium_shovel"), CURIOUS_ENDORIUM_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "curious_endorium_hoe"), CURIOUS_ENDORIUM_HOE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "curious_endorium_pickaxe"), CURIOUS_ENDORIUM_PICKAXE);

        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "mysterious_relic"), MYSTERIOUS_RELIC);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "mysterious_endorium_sword"), MYSTERIOUS_ENDORIUM_SWORD);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "mysterious_endorium_axe"), MYSTERIOUS_ENDORIUM_AXE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "mysterious_endorium_shovel"), MYSTERIOUS_ENDORIUM_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "mysterious_endorium_hoe"), MYSTERIOUS_ENDORIUM_HOE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "mysterious_endorium_pickaxe"), MYSTERIOUS_ENDORIUM_PICKAXE);

        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_nugget"), TUNGSTEN_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_ingot"), TUNGSTEN_INGOT);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_dust"), TUNGSTEN_DUST);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "raw_tungsten"), TUNGSTEN_RAW);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_sword"), TUNGSTEN_SWORD);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_axe"), TUNGSTEN_AXE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_shovel"), TUNGSTEN_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_hoe"), TUNGSTEN_HOE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_pickaxe"), TUNGSTEN_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_hammer"), TUNGSTEN_HAMMER);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_helmet"), TUNGSTEN_HELMET);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_chestplate"), TUNGSTEN_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_leggings"), TUNGSTEN_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "tungsten_boots"), TUNGSTEN_BOOTS);

        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "ender_boots"), ENDER_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "ender_transmitter"), TRANSMITTER);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "purpur_eye"), PURPUR_EYE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "ogana"), OGANA_FRUIT);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "ogana_torte"), OGANA_TORTE);
        Registry.register(Registries.ITEM, new Identifier(Endorium.MODID, "iron_hammer"), IRON_HAMMER);
    }

}
