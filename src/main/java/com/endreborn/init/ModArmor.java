package com.endreborn.init;

import com.endreborn.Endorium;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmor {
    public static final RegistryEntry<ArmorMaterial> ENDER = register(
            "ender",
            Util.make(new EnumMap<>(ArmorItem.Type.class), p_327101_ -> {
                p_327101_.put(ArmorItem.Type.BOOTS, 3);
                p_327101_.put(ArmorItem.Type.LEGGINGS, 1);
                p_327101_.put(ArmorItem.Type.CHESTPLATE, 1);
                p_327101_.put(ArmorItem.Type.HELMET, 1);
                p_327101_.put(ArmorItem.Type.BODY, 1);
            }),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
            3.0F,
            0.0F,
            () -> Ingredient.ofItems(ModItems.ENDORIUM_INGOT));

    public ModArmor() {
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(Endorium.MODID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = ArmorItem.Type.values();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            ArmorItem.Type type = var9[var11];
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Endorium.MODID, id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }
}