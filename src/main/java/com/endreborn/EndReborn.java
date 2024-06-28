package com.endreborn;

import com.endreborn.init.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod("endreborn")
public class EndReborn {
    public static final String MODID = "endreborn";
    public static final DeferredRegister.Blocks BLOCK = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEM = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(Registries.FEATURE, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public EndReborn(IEventBus bus) {
        CREATIVE_TAB.register(bus);
        BLOCK.register(bus);
        ITEM.register(bus);
        FEATURE.register(bus);
        ModTypes.REGISTRY.register(bus);
        ModPieces.REGISTRY.register(bus);

        ModTab.setup();
        ModBlocks.setup();
        ModItems.setup();
        ModFeatures.setup();
    }
}
