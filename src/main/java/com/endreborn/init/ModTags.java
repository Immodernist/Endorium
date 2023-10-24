package com.endreborn.init;

import com.endreborn.Endorium;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.structure.Structure;

public interface ModTags {

    TagKey<Structure> END_CITY_LOCATED = createStructure("purpur_eye_located");
    TagKey<Feature<?>> TUNGSTEN_ORE = createFeature("tungsten_ore");
    TagKey<Biome> IS_OUTER_END = createBiome("is_outer_end");
    TagKey<Biome> IS_INNER_END = createBiome("is_inner_end");

    private static TagKey<Structure> createStructure(String id) {
        return TagKey.of(RegistryKeys.STRUCTURE, new Identifier(Endorium.MODID, id));
    }
    private static TagKey<Feature<?>> createFeature(String id) {
        return TagKey.of(RegistryKeys.FEATURE, new Identifier(Endorium.MODID, id));
    }
    private static TagKey<Biome> createBiome(String id) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(Endorium.MODID, id));
    }
}
