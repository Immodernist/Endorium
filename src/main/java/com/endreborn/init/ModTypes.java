package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelStructure;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTypes {
    public static final DeferredRegister<StructureType<?>> REGISTRY = DeferredRegister.create(Registries.STRUCTURE_TYPE, EndReborn.MODID);
    public static final RegistryObject<StructureType<CitadelStructure>> CITADEL_TYPE = REGISTRY.register("citadel", () -> stuff(CitadelStructure.CODEC));

    private static <T extends Structure> StructureType<T> stuff(MapCodec<T> codec) {
        return () -> codec;
    }
}
