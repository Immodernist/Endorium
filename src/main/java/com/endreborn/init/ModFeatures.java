package com.endreborn.init;

import com.endreborn.Endorium;
import com.endreborn.world.MossedEndIslandFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {
    public static final Feature<DefaultFeatureConfig> MOSS_ISLAND = new MossedEndIslandFeature(DefaultFeatureConfig.CODEC);

    public static void setup() {
        register("mossed_island", MOSS_ISLAND);
    }
    private static void register(String name, Feature<?> feature) {
        Registry.register(Registries.FEATURE, Identifier.of(Endorium.MODID, name), feature);
    }
}
