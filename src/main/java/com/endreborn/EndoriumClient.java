package com.endreborn;

import com.endreborn.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EndoriumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.OGANA_WEED, ModBlocks.OGANA_PLANT, ModBlocks.OBSIDIAN_GLASS, ModBlocks.OBSIDIAN_GLASS_PANE);
    }
}
