package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public interface ModTags {
    TagKey<Structure> END_CITY_LOCATED = createStructure("purpur_eye_located");

    private static TagKey<Structure> createStructure(String p_215896_) {
        return TagKey.create(Registries.STRUCTURE, new ResourceLocation(EndReborn.MODID, p_215896_));
    }
}
