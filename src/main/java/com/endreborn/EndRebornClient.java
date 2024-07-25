package com.endreborn;

import com.endreborn.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndRebornClient {
    private static void renderCutout(Block block) {
        RenderTypeLookup.setRenderLayer(block, RenderType.cutout());
    }
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        renderCutout(ModBlocks.OGANA_WEED.get());
        renderCutout(ModBlocks.POTTED_OGANA.get());
        renderCutout(ModBlocks.OGANA_PLANT.get());
        renderCutout(ModBlocks.OBSIDIAN_GLASS.get());
        renderCutout(ModBlocks.OBSIDIAN_GLASS_PANE.get());
    }
}
