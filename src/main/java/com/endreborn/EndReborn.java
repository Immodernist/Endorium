package com.endreborn;

import com.endreborn.init.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("endreborn")
public class EndReborn {
    public static final String MODID = "endreborn";

    public EndReborn() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEM.register(bus);
        ModBlocks.BLOCK.register(bus);
        ModTypes.TYPE.register(bus);
        ModPieces.PIECE.register(bus);
        ModFeatures.FEATURE.register(bus);
        ModTab.CREATIVE_TAB.register(bus);
    }
}
