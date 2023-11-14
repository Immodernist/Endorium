package com.endreborn;

import com.endreborn.init.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

@Mod("endreborn")
public class EndReborn {
    public static final String MODID = "endreborn";
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(Registries.BLOCK, MODID);
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(Registries.ITEM, MODID);
    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(Registries.FEATURE, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public EndReborn() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CREATIVE_TAB.register(bus);
        BLOCK.register(bus);
        ITEM.register(bus);
        FEATURE.register(bus);
        //ModEntities.ENTITIES.register(bus);
        ModTypes.REGISTRY.register(bus);
        bus.addListener(this::setup);

        ModTab.setup();
        ModBlocks.setup();
        ModItems.setup();
        ModFeatures.setup();
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModPieces.setup();
    }
}
