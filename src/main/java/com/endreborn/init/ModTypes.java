package com.endreborn.init;

import com.endreborn.Endorium;
import com.endreborn.world.EndShipwreckStructure;
import com.mojang.serialization.Codec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

public class ModTypes {
    public static final StructureType<EndShipwreckStructure> END_SHIPWRECK = () -> stuff(EndShipwreckStructure.CODEC).codec();
    public static void setup() {
        Registry.register(Registries.STRUCTURE_TYPE, new Identifier(Endorium.MODID, "end_shipwreck"), END_SHIPWRECK);
    }
    private static <T extends Structure> StructureType<T> stuff(Codec<T> codec) {
        return () -> codec;
    }
}
