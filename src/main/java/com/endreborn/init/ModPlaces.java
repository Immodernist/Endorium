package com.endreborn.init;

import com.endreborn.Endorium;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModPlaces {
    public static final RegistryKey<PlacedFeature> TUNGSTEN_ORE = register("tungsten_ore");
    public static final RegistryKey<PlacedFeature> MOSS_ISLAND = register("mossed_island");
    public static void setup() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.END_CITY_HAS_STRUCTURE), GenerationStep.Feature.UNDERGROUND_ORES, TUNGSTEN_ORE);
    }

    private static RegistryKey<PlacedFeature> register(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Endorium.MODID, name));
    }
}
