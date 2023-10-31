package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.FarstoneFeature;
import com.endreborn.world.MossedEndIslandFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModFeatures {
    public static final Feature<NoneFeatureConfiguration> MOSSED_ISLAND = registerFeature("mossed_island", new MossedEndIslandFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature<NoneFeatureConfiguration> FARSTONE_CRATER = registerFeature("farstone", new FarstoneFeature(NoneFeatureConfiguration.CODEC));
    public static void setup() {}
    private static <C extends FeatureConfiguration, F extends Feature<C>> F registerFeature(String key, F value) {
        EndReborn.FEATURE_REGISTER.register(key, () -> value);
        return value;
    }
}
