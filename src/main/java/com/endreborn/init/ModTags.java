package com.endreborn.init;

import com.endreborn.Endorium;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.structure.Structure;

public interface ModTags {

    TagKey<Biome> IS_OUTER_END = createBiome("is_outer_end");

    private static TagKey<Biome> createBiome(String id) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(Endorium.MODID, id));
    }
}
