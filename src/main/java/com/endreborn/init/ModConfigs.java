package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfigs {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;
    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = specPair.getLeft();
        COMMON_SPEC = specPair.getRight();
    }
    public static class CommonConfig {
        public final Balance balance;
        public CommonConfig(final ForgeConfigSpec.Builder builder) {
            balance = new Balance(builder);
        }
        public static class Balance {
            public static String name = "general";

            public static ConfigValue<Integer> freq_tungsten_end;
            public static ConfigValue<Boolean> citadel;
            public static ConfigValue<Boolean> tungsten_end;

            public Balance(ForgeConfigSpec.Builder builder) {
                builder.push(name);

                citadel = builder
                        .comment("Citadel generation switch.")
                        .define("citadel", true);

                tungsten_end = builder
                        .comment("Tungsten Ore generation switch.")
                        .define("tungsten_end", true);

                freq_tungsten_end = builder
                        .comment("Tungsten Ore frequency. Lower is less.")
                        .defineInRange("freq_tungsten_end", 2, 0, 16);

                builder.pop();
            }
        }
    }
}