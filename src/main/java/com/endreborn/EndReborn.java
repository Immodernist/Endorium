package com.endreborn;

import com.endreborn.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("endreborn")
public class EndReborn {
    public static final String MODID = "endreborn";
    public static final ItemGroup ENDGROUP = new ModTab();

    public EndReborn() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.COMMON_SPEC);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        bus.addListener(this::setup);
        ModBlocks.BLOCK.register(bus);
        ModItems.ITEM.register(bus);

        ModStructures.STRUCTURE_FEATURES.register(bus);
        ModFeatures.FEATURE.register(bus);
        ModPieces.init();

        forgeBus.addListener(ModGeneration::onBiomeLoad);
        forgeBus.addListener(ModGeneration::addStructures);
        forgeBus.addListener(ModStructures::addDimensionSpacing);
    }
    private void setup(final FMLCommonSetupEvent event) {
        new ModGeneration();
        event.enqueueWork(() -> {
            ModStructures.setupStructures();
            ModFeatures.registerConfiguredFeatures();
        });
    }
}
