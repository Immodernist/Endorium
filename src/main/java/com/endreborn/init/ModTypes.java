package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModTypes {
    public static final DeferredRegister<StructureType<?>> REGISTRY = DeferredRegister.create(Registries.STRUCTURE_TYPE, EndReborn.MODID);
    public static final Supplier<StructureType<CitadelStructure>> CITADEL_TYPE = REGISTRY.register("citadel", () -> () -> CitadelStructure.CODEC);
}
