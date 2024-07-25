package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.MossedEndIslandFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(ForgeRegistries.FEATURES, EndReborn.MODID);
    public static final Feature<NoneFeatureConfiguration> MOSSED_ISLAND = register("mossed_island", new MossedEndIslandFeature(NoneFeatureConfiguration.CODEC));
    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String key, F value) {
        FEATURE.register(key, () -> value);
        return value;
    }
}
