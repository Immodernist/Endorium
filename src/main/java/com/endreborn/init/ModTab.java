package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EndReborn.MODID);
    public static RegistryObject<CreativeModeTab> TAB = CREATIVE_TAB.register("endgroup", () -> CreativeModeTab.builder()
            .icon(() -> ModBlocks.FARSTONE_BRICKS_CHISELED.get().asItem().getDefaultInstance())
            .title(Component.translatable("itemGroup.endgroup"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.ENDORIUM_NUGGET.get());
                output.accept(ModItems.ENDORIUM_INGOT.get());
                output.accept(ModItems.TUNGSTEN_INGOT.get());
                output.accept(ModItems.TUNGSTEN_RAW.get());
                output.accept(ModItems.IRON_HAMMER.get());
                output.accept(ModItems.TUNGSTEN_HAMMER.get());
                output.accept(ModItems.ENDORIUM_SWORD.get());
                output.accept(ModItems.ENDORIUM_AXE.get());
                output.accept(ModItems.ENDORIUM_PICKAXE.get());
                output.accept(ModItems.ENDORIUM_SHOVEL.get());
                output.accept(ModItems.ENDORIUM_HOE.get());
                output.accept(ModItems.MYSTERIOUS_TEMPLATE.get());
                output.accept(ModItems.CURIOUS_TEMPLATE.get());
                output.accept(ModBlocks.INCANDESCENT_LAMP.get());
                output.accept(ModItems.WICKED_FRUIT.get());
                output.accept(ModItems.WICKED_TORTE.get());
                output.accept(ModItems.ENDER_BOOTS.get());
                output.accept(ModItems.TRANSMITTER.get());
                output.accept(ModBlocks.OBSIDIAN_GLASS_PANE.get());
                output.accept(ModBlocks.OBSIDIAN_GLASS.get());
                output.accept(ModBlocks.TUNGSTEN_BLOCK.get());
                output.accept(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
                output.accept(ModBlocks.ENDORIUM_BLOCK.get());
                output.accept(ModBlocks.SMOOTH_END_STONE.get());
                output.accept(ModBlocks.FARSTONE_DECORATIVE.get());
                output.accept(ModBlocks.CRACKED_END_BRICKS.get());
                output.accept(ModBlocks.FARSTONE_BRICKS.get());
                output.accept(ModBlocks.FARSTONE_WALL.get());
                output.accept(ModBlocks.FARSTONE_BRICKS_SLAB.get());
                output.accept(ModBlocks.FARSTONE_BRICKS_STAIRS.get());
                output.accept(ModBlocks.CHISELED_END_BRICKS.get());
                output.accept(ModBlocks.FARSTONE_BRICKS_CHISELED.get());
                output.accept(ModBlocks.END_STONE_PILLAR.get());
                output.accept(ModBlocks.FARSTONE_PILLAR.get());
                output.accept(ModBlocks.TUNGSTEN_ORE.get());
                output.accept(ModBlocks.FARSTONE.get());
                output.accept(ModBlocks.OGANA_WEED.get());
                output.accept(ModBlocks.OGANA_PLANT.get());
                output.accept(ModBlocks.END_MOSS.get());
                output.accept(ModBlocks.END_MOSS_BLOCK.get());
                output.accept(ModBlocks.END_MOSS_CARPET.get());
            }).build());
}
