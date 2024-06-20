package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmor {
    public static final Holder<ArmorMaterial> ENDER = register(
            "ender",
            Util.make(new EnumMap<>(ArmorItem.Type.class), p_327101_ -> {
                p_327101_.put(ArmorItem.Type.BOOTS, 3);
                p_327101_.put(ArmorItem.Type.LEGGINGS, 1);
                p_327101_.put(ArmorItem.Type.CHESTPLATE, 1);
                p_327101_.put(ArmorItem.Type.HELMET, 1);
                p_327101_.put(ArmorItem.Type.BODY, 1);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            2.0F,
            0.0F,
            () -> Ingredient.of(ModItems.ENDORIUM_INGOT.get()));

    public static Holder<ArmorMaterial> bootstrap(Registry<ArmorMaterial> p_332591_) {
        return ENDER;
    }

    private static Holder<ArmorMaterial> register(
            String p_334359_,
            EnumMap<ArmorItem.Type, Integer> p_329993_,
            int p_332696_,
            Holder<SoundEvent> p_333975_,
            float p_329381_,
            float p_334853_,
            Supplier<Ingredient> p_333678_
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(EndReborn.MODID, p_334359_)));
        return register(p_334359_, p_329993_, p_332696_, p_333975_, p_329381_, p_334853_, p_333678_, list);
    }

    private static Holder<ArmorMaterial> register(
            String p_332406_,
            EnumMap<ArmorItem.Type, Integer> p_331524_,
            int p_331490_,
            Holder<SoundEvent> p_331648_,
            float p_327988_,
            float p_328616_,
            Supplier<Ingredient> p_334412_,
            List<ArmorMaterial.Layer> p_330855_
    ) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
            enummap.put(armoritem$type, p_331524_.get(armoritem$type));
        }

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                ResourceLocation.fromNamespaceAndPath(EndReborn.MODID, p_332406_),
                new ArmorMaterial(enummap, p_331490_, p_331648_, p_334412_, p_330855_, p_327988_, p_328616_)
        );
    }
}