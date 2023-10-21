package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.EndPlantBlock;
import com.endreborn.content.MossPlantBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static RegistryObject<Block> CHISELED_END_BRICKS;
    public static RegistryObject<Block> CRACKED_END_BRICKS;
    public static RegistryObject<Block> SMOOTH_END_STONE;
    public static RegistryObject<Block> END_STONE_PILLAR;
    public static RegistryObject<Block> END_CORAL;
    public static RegistryObject<Block> ENDSTONE_BUTTON;
    public static RegistryObject<Block> PURPUR_LANTERN;
    public static RegistryObject<Block> CRACKED_PURPUR;
    public static RegistryObject<Block> PURPUR_CHAIN;
    public static RegistryObject<Block> PURPUR_WALL;
    public static RegistryObject<Block> END_MOSS;
    public static RegistryObject<Block> OGANA_WEED;
    public static RegistryObject<Block> END_MOSS_BLOCK;
    public static RegistryObject<Block> OBSIDIAN_GLASS;
    public static RegistryObject<Block> OBSIDIAN_GLASS_PANE;
    public static RegistryObject<Block> FRAMED_OBSIDIAN_GLASS_PANE;
    public static RegistryObject<Block> FRAMED_OBSIDIAN_GLASS;
    public static RegistryObject<Block> TUNGSTEN_ORE;
    public static RegistryObject<Block> RAW_TUNGSTEN_BLOCK;
    public static RegistryObject<Block> ENDORIUM_BLOCK;
    public static RegistryObject<Block> TUNGSTEN_BLOCK;
    public static RegistryObject<Block> FARSTONE;
    public static RegistryObject<Block> FARSTONE_DECORATIVE;
    public static RegistryObject<Block> FARSTONE_BRICKS;
    public static RegistryObject<Block> FARSTONE_BRICKS_STAIRS;
    public static RegistryObject<Block> FARSTONE_BRICKS_SLAB;
    public static RegistryObject<Block> FARSTONE_BRICKS_WALL;
    public static RegistryObject<Block> FARSTONE_PILLAR;

    public static void setup() {
        SMOOTH_END_STONE = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS)), "end_stone_smooth");
        CRACKED_END_BRICKS = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS)), "cracked_end_bricks");
        CHISELED_END_BRICKS = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS)), "chiseled_end_bricks");
        END_STONE_PILLAR = registerBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS)), "end_stone_pillar");
        END_CORAL = registerBlock(() -> new EndPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).replaceable()), "end_coral");
        ENDSTONE_BUTTON = registerBlock(() -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.STONE, 20, false), "end_stone_button");

        PURPUR_LANTERN = registerBlock(() -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel((p_152677_) -> {return 12;})), "purpur_lantern");
        CRACKED_PURPUR = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK)), "cracked_purpur");
        PURPUR_CHAIN = registerBlock(() -> new ChainBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)), "purpur_chain");
        PURPUR_WALL = registerBlock(() -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK).forceSolidOn()), "purpur_wall");

        END_MOSS = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)), "end_moss");
        OGANA_WEED = registerBlock(() -> new MossPlantBlock(BlockBehaviour.Properties.copy(END_CORAL.get())), "ogana_weed");
        END_MOSS_BLOCK = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)), "end_moss_block");

        OBSIDIAN_GLASS = registerBlock(() -> new GlassBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PLING).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()), "obsidian_glass");
        OBSIDIAN_GLASS_PANE = registerBlock(() -> new IronBarsBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PLING).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()), "obsidian_glass_pane");
        FRAMED_OBSIDIAN_GLASS_PANE = registerBlock(() -> new IronBarsBlock(BlockBehaviour.Properties.copy(OBSIDIAN_GLASS_PANE.get())), "framed_obsidian_glass_pane");
        FRAMED_OBSIDIAN_GLASS = registerBlock(() -> new GlassBlock(BlockBehaviour.Properties.copy(OBSIDIAN_GLASS.get())), "framed_obsidian_glass");

        TUNGSTEN_ORE = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)), "tungsten_ore");
        ENDORIUM_BLOCK = registerBlock(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(6.0F, 7.0F)), "endorium_block");
        TUNGSTEN_BLOCK = registerBlock(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.5F, 6.0F)), "tungsten_block");
        RAW_TUNGSTEN_BLOCK = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(TUNGSTEN_BLOCK.get())), "raw_tungsten_block");

        FARSTONE = registerBlock(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.55F, 9.0F)), "farstone");
        FARSTONE_DECORATIVE = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(FARSTONE.get())), "farstone_smooth");
        FARSTONE_BRICKS = registerBlock(() -> new Block(BlockBehaviour.Properties.copy(FARSTONE.get())), "farstone_bricks");
        FARSTONE_BRICKS_STAIRS = registerBlock(() -> new StairBlock(FARSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(FARSTONE.get())), "farstone_brick_stairs");
        FARSTONE_BRICKS_SLAB = registerBlock(() -> new SlabBlock(BlockBehaviour.Properties.copy(FARSTONE.get())), "farstone_brick_slab");
        FARSTONE_BRICKS_WALL = registerBlock(() -> new WallBlock(BlockBehaviour.Properties.copy(FARSTONE.get()).forceSolidOn()), "farstone_brick_wall");
        FARSTONE_PILLAR = registerBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(FARSTONE.get())), "farstone_pillar");
    }

    public static RegistryObject<Block> registerBlock(Supplier<Block> blockSupplier, String name) {
        RegistryObject<Block> blockRegistryObject = EndReborn.BLOCK_REGISTER.register(name, blockSupplier);
        EndReborn.ITEM_REGISTER.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties()));
        return blockRegistryObject;
    }
}
