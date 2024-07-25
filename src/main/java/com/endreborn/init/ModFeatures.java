package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelStructure;
import com.endreborn.world.MossedEndIslandFeature;
import com.endreborn.world.TungstenOreFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModFeatures {
    public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, EndReborn.MODID);
    public static final RegistryObject<Structure<NoFeatureConfig>> CITADEL = STRUCTURE_FEATURE.register("citadel", () -> new CitadelStructure(NoFeatureConfig.CODEC));
    public static final Supplier<StructureFeature<?, ?>> CONFIGURED_CITADEL = () -> ModStructures.CITADEL.get().configured(IFeatureConfig.NONE);

    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(ForgeRegistries.FEATURES, EndReborn.MODID);
    public static final RegistryObject<MossedEndIslandFeature> MOSSED_ISLAND = FEATURE.register("mossed_island", () -> new MossedEndIslandFeature(NoFeatureConfig.CODEC));
    public static final RegistryObject<TungstenOreFeature> TUNGSTEN_ORE = FEATURE.register("tungsten_ore", () -> new TungstenOreFeature(NoFeatureConfig.CODEC));


    public static void registerConfiguredFeatures() {
        final Registry<StructureFeature<?, ?>> structureRegistry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(structureRegistry, new ResourceLocation(EndReborn.MODID, "citadel"), CONFIGURED_CITADEL.get());
    }
}
