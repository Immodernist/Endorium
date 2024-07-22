package com.endreborn.init;

import com.endreborn.Endorium;
import com.endreborn.content.EndMossBlock;
import com.endreborn.content.IncandescentLampBlock;
import com.endreborn.content.MossPlantBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final Block SMOOTH_END_STONE = new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS));
    public static final Block CRACKED_END_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS));
    public static final Block CHISELED_END_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS));
    public static final Block END_STONE_PILLAR = new PillarBlock(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS));

    public static final Block END_MOSS = new EndMossBlock(AbstractBlock.Settings.copy(Blocks.END_STONE));
    public static final Block OGANA_PLANT = new MossPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).noCollision().breakInstantly().sounds(BlockSoundGroup.STEM).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block OGANA_WEED = new MossPlantBlock(AbstractBlock.Settings.copy(OGANA_PLANT).replaceable());
    public static final Block END_MOSS_BLOCK = new EndMossBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(1.4F).sounds(BlockSoundGroup.MOSS_BLOCK));
    public static final Block END_MOSS_CARPET = new CarpetBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1F).sounds(BlockSoundGroup.MOSS_CARPET).pistonBehavior(PistonBehavior.DESTROY));

    public static final Block OBSIDIAN_GLASS = new TransparentBlock(AbstractBlock.Settings.copy(Blocks.GLASS).instrument(NoteBlockInstrument.PLING).mapColor(MapColor.BLACK).requiresTool().strength(40.0f, 1200.0f));
    public static final Block OBSIDIAN_GLASS_PANE = new PaneBlock(AbstractBlock.Settings.copy(OBSIDIAN_GLASS));

    public static final Block TUNGSTEN_ORE = new Block(AbstractBlock.Settings.copy(Blocks.END_STONE));
    public static final Block ENDORIUM_BLOCK = new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.IRON_GRAY).requiresTool().strength(6.0F, 7.0F));
    public static final Block TUNGSTEN_BLOCK = new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.IRON_GRAY).requiresTool().strength(5.5F, 6.0F));
    public static final Block RAW_TUNGSTEN_BLOCK = new Block(AbstractBlock.Settings.copy(TUNGSTEN_BLOCK));
    public static final Block INCANDESCENT_LAMP = new IncandescentLampBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).solid().strength(3.0F).sounds(BlockSoundGroup.LANTERN).luminance(litBlockEmission(12)));
    public static final Block FARSTONE = new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.STONE_GRAY).requiresTool().strength(2.55F, 9.0F));
    public static final Block FARSTONE_DECORATIVE = new Block(AbstractBlock.Settings.copy(FARSTONE));
    public static final Block FARSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(FARSTONE));
    public static final Block FARSTONE_BRICKS_CHISELED = new Block(AbstractBlock.Settings.copy(FARSTONE));
    public static final Block FARSTONE_BRICKS_STAIRS = new StairsBlock(FARSTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(FARSTONE));
    public static final Block FARSTONE_BRICKS_SLAB = new SlabBlock(AbstractBlock.Settings.copy(FARSTONE));
    public static final Block FARSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(FARSTONE));
    public static final Block FARSTONE_PILLAR = new PillarBlock(AbstractBlock.Settings.copy(FARSTONE));

    public static void setup() {
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "end_stone_smooth"), SMOOTH_END_STONE);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "end_stone_smooth"), new BlockItem(SMOOTH_END_STONE, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "cracked_end_bricks"), CRACKED_END_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "cracked_end_bricks"), new BlockItem(CRACKED_END_BRICKS, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "chiseled_end_bricks"), CHISELED_END_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "chiseled_end_bricks"), new BlockItem(CHISELED_END_BRICKS, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "end_stone_pillar"), END_STONE_PILLAR);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "end_stone_pillar"), new BlockItem(END_STONE_PILLAR, new Item.Settings()));

        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "end_moss"), END_MOSS);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "end_moss"), new BlockItem(END_MOSS, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "ogana_weed"), OGANA_WEED);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "ogana_weed"), new BlockItem(OGANA_WEED, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "ogana_plant"), OGANA_PLANT);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "ogana_plant"), new BlockItem(OGANA_PLANT, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "end_moss_block"), END_MOSS_BLOCK);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "end_moss_block"), new BlockItem(END_MOSS_BLOCK, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "end_moss_carpet"), END_MOSS_CARPET);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "end_moss_carpet"), new BlockItem(END_MOSS_CARPET, new Item.Settings()));

        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "obsidian_glass"), OBSIDIAN_GLASS);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "obsidian_glass"), new BlockItem(OBSIDIAN_GLASS, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "obsidian_glass_pane"), OBSIDIAN_GLASS_PANE);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "obsidian_glass_pane"), new BlockItem(OBSIDIAN_GLASS_PANE, new Item.Settings()));

        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "tungsten_ore"), TUNGSTEN_ORE);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "tungsten_ore"), new BlockItem(TUNGSTEN_ORE, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "endorium_block"), ENDORIUM_BLOCK);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "endorium_block"), new BlockItem(ENDORIUM_BLOCK, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "tungsten_block"), TUNGSTEN_BLOCK);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "tungsten_block"), new BlockItem(TUNGSTEN_BLOCK, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "raw_tungsten_block"), RAW_TUNGSTEN_BLOCK);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "raw_tungsten_block"), new BlockItem(RAW_TUNGSTEN_BLOCK, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "incandescent_lamp"), INCANDESCENT_LAMP);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "incandescent_lamp"), new BlockItem(INCANDESCENT_LAMP, new Item.Settings()));

        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "farstone"), FARSTONE);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "farstone"), new BlockItem(FARSTONE, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "farstone_smooth"), FARSTONE_DECORATIVE);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "farstone_smooth"), new BlockItem(FARSTONE_DECORATIVE, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "farstone_bricks"), FARSTONE_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "farstone_bricks"), new BlockItem(FARSTONE_BRICKS, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "chiseled_farstone"), FARSTONE_BRICKS_CHISELED);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "chiseled_farstone"), new BlockItem(FARSTONE_BRICKS_CHISELED, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "farstone_brick_stairs"), FARSTONE_BRICKS_STAIRS);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "farstone_brick_stairs"), new BlockItem(FARSTONE_BRICKS_STAIRS, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "farstone_brick_slab"), FARSTONE_BRICKS_SLAB);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "farstone_brick_slab"), new BlockItem(FARSTONE_BRICKS_SLAB, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "farstone_wall"), FARSTONE_WALL);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "farstone_wall"), new BlockItem(FARSTONE_WALL, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(Endorium.MODID, "farstone_pillar"), FARSTONE_PILLAR);
        Registry.register(Registries.ITEM, Identifier.of(Endorium.MODID, "farstone_pillar"), new BlockItem(FARSTONE_PILLAR, new Item.Settings()));
     }
    public static ToIntFunction<BlockState> litBlockEmission(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
        };
    }
}
