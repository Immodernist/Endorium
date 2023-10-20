package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.Structure;

public interface ModTags {
    TagKey<Structure> END_CITY_LOCATED = createStructure("purpur_eye_located");
    TagKey<Feature<?>> TUNGSTEN_ORE = createFeature("tungsten_ore");
    TagKey<Biome> IS_END_HIGH = createBiome("is_end_high");

    private static TagKey<Structure> createStructure(String p_215896_) {
        return TagKey.create(Registries.STRUCTURE, new ResourceLocation(EndReborn.MODID, p_215896_));
    }
    private static TagKey<Feature<?>> createFeature(String p_215896_) {
        return TagKey.create(Registries.FEATURE, new ResourceLocation(EndReborn.MODID, p_215896_));
    }
    private static TagKey<Biome> createBiome(String p_207631_) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(EndReborn.MODID, p_207631_));
    }
}
