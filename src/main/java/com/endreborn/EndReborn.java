package com.endreborn;

import com.endreborn.init.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("endreborn")
public class EndReborn {
    public static final String MODID = "endreborn";

    public EndReborn(IEventBus bus) {
        ModTab.CREATIVE_TAB.register(bus);
        ModBlocks.BLOCK.register(bus);
        ModItems.ITEM.register(bus);
        ModFeatures.FEATURE.register(bus);
        ModTypes.TYPE.register(bus);
        ModPieces.PIECE.register(bus);
    }
}
