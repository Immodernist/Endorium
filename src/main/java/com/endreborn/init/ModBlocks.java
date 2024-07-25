package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.EndMossBlock;
import com.endreborn.content.IncandescentLampBlock;
import com.endreborn.content.MossPlantBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, EndReborn.MODID);

    public static RegistryObject<Block> SMOOTH_END_STONE = BLOCK.register("end_stone_smooth", () -> new Block(AbstractBlock.Properties.copy(Blocks.END_STONE_BRICKS)));
    public static RegistryObject<Block> CRACKED_END_BRICKS = BLOCK.register("cracked_end_bricks", () -> new Block(AbstractBlock.Properties.copy(Blocks.END_STONE_BRICKS)));
    public static RegistryObject<Block> CHISELED_END_BRICKS = BLOCK.register("chiseled_end_bricks", () -> new Block(AbstractBlock.Properties.copy(Blocks.END_STONE_BRICKS)));
    public static RegistryObject<Block> END_STONE_PILLAR = BLOCK.register("end_stone_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.END_STONE_BRICKS)));
    public static RegistryObject<Block> END_MOSS = BLOCK.register("end_moss", () -> new EndMossBlock(AbstractBlock.Properties.copy(Blocks.END_STONE)));
    public static RegistryObject<Block> OGANA_WEED = BLOCK.register("ogana_weed", () -> new MossPlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static RegistryObject<Block> OGANA_PLANT = BLOCK.register("ogana_plant", () -> new MossPlantBlock(AbstractBlock.Properties.copy(OGANA_WEED.get())));
    public static RegistryObject<Block> POTTED_OGANA = BLOCK.register("potted_ogana", () -> new FlowerPotBlock(OGANA_PLANT.get(), AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static RegistryObject<Block> END_MOSS_BLOCK = BLOCK.register("end_moss_block", () -> new EndMossBlock(AbstractBlock.Properties.of(Material.PLANT).strength(1.4F).sound(SoundType.GRASS)));
    public static RegistryObject<Block> END_MOSS_CARPET = BLOCK.register("end_moss_carpet", () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.of(Material.PLANT).strength(0.1F).sound(SoundType.GRASS)));
    public static RegistryObject<Block> OBSIDIAN_GLASS = BLOCK.register("obsidian_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()));
    public static RegistryObject<Block> OBSIDIAN_GLASS_PANE = BLOCK.register("obsidian_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(20.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()));
    public static RegistryObject<Block> TUNGSTEN_ORE = BLOCK.register("tungsten_ore", () -> new Block(AbstractBlock.Properties.copy(Blocks.END_STONE)));
    public static RegistryObject<Block> ENDORIUM_BLOCK = BLOCK.register("endorium_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(6.0F, 7.0F)));
    public static RegistryObject<Block> INCANDESCENT_LAMP = BLOCK.register("incandescent_lamp", () -> new IncandescentLampBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(3.0F).sound(SoundType.LANTERN).lightLevel(litBlockEmission())));
    public static RegistryObject<Block> TUNGSTEN_BLOCK = BLOCK.register("tungsten_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.5F, 6.0F)));
    public static RegistryObject<Block> RAW_TUNGSTEN_BLOCK = BLOCK.register("raw_tungsten_block", () -> new Block(AbstractBlock.Properties.copy(TUNGSTEN_BLOCK.get())));
    public static RegistryObject<Block> FARSTONE = BLOCK.register("farstone", () -> new Block(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.55F, 9.0F)));
    public static RegistryObject<Block> FARSTONE_DECORATIVE = BLOCK.register("farstone_smooth", () -> new Block(AbstractBlock.Properties.copy(FARSTONE.get())));
    public static RegistryObject<Block> FARSTONE_BRICKS = BLOCK.register("farstone_bricks", () -> new Block(AbstractBlock.Properties.copy(FARSTONE.get())));
    public static RegistryObject<Block> FARSTONE_BRICKS_CHISELED = BLOCK.register("chiseled_farstone", () -> new Block(AbstractBlock.Properties.copy(FARSTONE.get())));
    public static RegistryObject<Block> FARSTONE_PILLAR = BLOCK.register("farstone_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(FARSTONE.get())));
    public static RegistryObject<Block> FARSTONE_WALL = BLOCK.register("farstone_wall", () -> new WallBlock(AbstractBlock.Properties.copy(FARSTONE.get())));
    public static RegistryObject<Block> FARSTONE_BRICKS_STAIRS = BLOCK.register("farstone_brick_stairs", () -> new StairsBlock(FARSTONE_BRICKS.get().defaultBlockState(), AbstractBlock.Properties.copy(FARSTONE.get())));
    public static RegistryObject<Block> FARSTONE_BRICKS_SLAB = BLOCK.register("farstone_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.copy(FARSTONE.get())));

    private static ToIntFunction<BlockState> litBlockEmission() {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? 12 : 0;
        };
    }
}
