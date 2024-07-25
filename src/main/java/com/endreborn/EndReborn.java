package com.endreborn;

import com.endreborn.init.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("endreborn")
public class EndReborn {
    public static final String MODID = "endreborn";
    public static final CreativeModeTab ENDGROUP = new ModTab();

    public EndReborn() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCK.register(bus);
        ModItems.ITEM.register(bus);

        ModFeatures.FEATURE.register(bus);
        ModTypes.TYPE.register(bus);
        ModPieces.PIECE.register(bus);
    }
}
