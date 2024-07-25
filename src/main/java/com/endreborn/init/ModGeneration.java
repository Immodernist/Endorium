package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModGeneration {
    @SubscribeEvent
    public static void register(RegistryEvent.Register<Feature<?>> event) {
        if (!event.getName().equals(ForgeRegistries.FEATURES.getRegistryName()))
            return;
        register(ModFeatures.MOSSED_ISLAND.get(), "minecraft", "end_island");
        register(ModFeatures.TUNGSTEN_ORE.get(), EndReborn.MODID, "tungsten_ore");
    }

    public static Feature<?> register(Feature<?> feature, String path, String name) {
        feature.setRegistryName(new ResourceLocation(path, name));
        ForgeRegistries.FEATURES.register(feature);
        return feature;
    }
    public static void addStructures(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.THEEND && ModConfigs.CommonConfig.Balance.citadel.get()) {
            event.getGeneration().getStructures().add(ModFeatures.CONFIGURED_CITADEL);
        }
    }

    public static ConfiguredFeature<?, ?> TUNGSTEN_END_FEATURE = ModFeatures.TUNGSTEN_ORE.get().configured(IFeatureConfig.NONE)
            .decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(ModConfigs.CommonConfig.Balance.freq_tungsten_end.get());
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getCategory() == Biome.Category.THEEND && ModConfigs.CommonConfig.Balance.tungsten_end.get()) {
            generation.addFeature(GenerationStage.Decoration.RAW_GENERATION, TUNGSTEN_END_FEATURE);
        }
    }
}
