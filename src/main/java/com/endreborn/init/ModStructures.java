package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelStructure;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class ModStructures {
    public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, EndReborn.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> CITADEL = STRUCTURE_FEATURES.register("citadel", () -> new CitadelStructure(NoFeatureConfig.CODEC));

    public static void setupStructures() {
        setupStructure(CITADEL.get(), new StructureSeparationSettings(35, 19, 70987131));
    }

    public static <F extends Structure<?>> void setupStructure(F structure, StructureSeparationSettings structureSeparationSettings) {
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
        DimensionStructuresSettings.DEFAULTS = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                .putAll(DimensionStructuresSettings.DEFAULTS)
                .put(structure, structureSeparationSettings)
                .build();
    }

    public static void addDimensionSpacing(WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();
            if (!(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator) && serverWorld.dimension().equals(World.END)) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
                tempMap.put(CITADEL.get(), DimensionStructuresSettings.DEFAULTS.get(CITADEL.get()));
                serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
            }
        }
    }

}