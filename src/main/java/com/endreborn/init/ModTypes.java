package com.endreborn.init;

import com.endreborn.Endorium;
import com.endreborn.world.CitadelStructure;
import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

public class ModTypes {
    public static final StructureType<CitadelStructure> CITADEL_TYPE = () -> stuff(CitadelStructure.CODEC).codec();
    public static void setup() {
        Registry.register(Registries.STRUCTURE_TYPE, Identifier.of(Endorium.MODID, "citadel"), CITADEL_TYPE);
    }
    private static <T extends Structure> StructureType<T> stuff(MapCodec<T> codec) {
        return () -> codec;
    }
}
