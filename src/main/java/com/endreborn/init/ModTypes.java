package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelStructure;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTypes {
    public static final DeferredRegister<StructureType<?>> TYPE = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, EndReborn.MODID);
    public static final RegistryObject<StructureType<CitadelStructure>> CITADEL_TYPE = TYPE.register("citadel", () -> stuff(CitadelStructure.CODEC));
    private static <T extends Structure> StructureType<T> stuff(Codec<T> codec) {
        return () -> codec;
    }
}
