package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.EndShipwreckStructure;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTypes {
    public static final DeferredRegister<StructureType<?>> REGISTRY = DeferredRegister.create(Registries.STRUCTURE_TYPE, EndReborn.MODID);
    public static final RegistryObject<StructureType<EndShipwreckStructure>> END_SHIPWRECK = REGISTRY.register("end_shipwreck", () -> stuff(EndShipwreckStructure.CODEC));

    private static <T extends Structure> StructureType<T> stuff(Codec<T> codec) {
        return () -> codec;
    }
}
