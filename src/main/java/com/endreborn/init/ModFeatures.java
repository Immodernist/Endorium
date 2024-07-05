package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.MossedEndIslandFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(Registries.FEATURE, EndReborn.MODID);
    public static final Feature<NoneFeatureConfiguration> MOSSED_ISLAND = registerFeature("mossed_island", new MossedEndIslandFeature(NoneFeatureConfiguration.CODEC));
    private static <C extends FeatureConfiguration, F extends Feature<C>> F registerFeature(String key, F value) {
        FEATURE.register(key, () -> value);
        return value;
    }
}
