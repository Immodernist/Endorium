package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static RegistryObject<Block> CHISELED_END_BRICKS;
    public static RegistryObject<Block> CRACKED_END_BRICKS;
    public static RegistryObject<Block> SMOOTH_END_STONE;
    public static RegistryObject<Block> END_STONE_PILLAR;
    public static RegistryObject<Block> END_MOSS;
    public static RegistryObject<Block> OGANA_WEED;
    public static RegistryObject<Block> OGANA_PLANT;
    public static RegistryObject<Block> POTTED_OGANA;
    public static RegistryObject<Block> END_MOSS_BLOCK;
    public static RegistryObject<Block> END_MOSS_CARPET;
    public static RegistryObject<Block> OBSIDIAN_GLASS;
    public static RegistryObject<Block> OBSIDIAN_GLASS_PANE;
    public static RegistryObject<Block> TUNGSTEN_ORE;
    public static RegistryObject<Block> RAW_TUNGSTEN_BLOCK;
    public static RegistryObject<Block> ENDORIUM_BLOCK;
    public static RegistryObject<Block> TUNGSTEN_BLOCK;
    public static RegistryObject<Block> FARSTONE;
    public static RegistryObject<Block> FARSTONE_DECORATIVE;
    public static RegistryObject<Block> FARSTONE_BRICKS;
    public static RegistryObject<Block> FARSTONE_BRICKS_CHISELED;
    public static RegistryObject<Block> FARSTONE_BRICKS_STAIRS;
    public static RegistryObject<Block> FARSTONE_BRICKS_SLAB;
    public static RegistryObject<Block> FARSTONE_BRICKS_WALL;
    public static RegistryObject<Block> FARSTONE_PILLAR;
    public static RegistryObject<Block> INCANDESCENT_LAMP;

    public static void setup() {
        SMOOTH_END_STONE = registerBlock(() -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.END_STONE_BRICKS)), "end_stone_smooth");
        CRACKED_END_BRICKS = registerBlock(() -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.END_STONE_BRICKS)), "cracked_end_bricks");
        CHISELED_END_BRICKS = registerBlock(() -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.END_STONE_BRICKS)), "chiseled_end_bricks");
        END_STONE_PILLAR = registerBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.m_308003_(Blocks.END_STONE_BRICKS)), "end_stone_pillar");
        END_MOSS = registerBlock(() -> new EndMossBlock(BlockBehaviour.Properties.m_308003_(Blocks.END_STONE)), "end_moss");
        OGANA_WEED = registerBlock(() -> new MossPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).replaceable()), "ogana_weed");
        OGANA_PLANT = registerBlock(() -> new MossPlantBlock(BlockBehaviour.Properties.m_308003_(OGANA_WEED.get())), "ogana_plant");
        POTTED_OGANA = registerPot(() -> new FlowerPotBlock(OGANA_PLANT.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)), "potted_ogana");
        END_MOSS_BLOCK = registerBlock(() -> new EndMossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(1.4F).sound(SoundType.MOSS)), "end_moss_block");
        END_MOSS_CARPET = registerBlock(() -> new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.1F).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)), "end_moss_carpet");

        OBSIDIAN_GLASS = registerBlock(() -> new TransparentBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PLING).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()), "obsidian_glass");
        OBSIDIAN_GLASS_PANE = registerBlock(() -> new IronBarsBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PLING).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()), "obsidian_glass_pane");
        TUNGSTEN_ORE = registerBlock(() -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.END_STONE)), "tungsten_ore");
        ENDORIUM_BLOCK = registerBlock(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(6.0F, 7.0F)), "endorium_block");
        TUNGSTEN_BLOCK = registerBlock(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.5F, 6.0F)), "tungsten_block");
        RAW_TUNGSTEN_BLOCK = registerBlock(() -> new Block(BlockBehaviour.Properties.m_308003_(TUNGSTEN_BLOCK.get())), "raw_tungsten_block");
        FARSTONE = registerBlock(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.55F, 9.0F)), "farstone");
        FARSTONE_DECORATIVE = registerBlock(() -> new Block(BlockBehaviour.Properties.m_308003_(FARSTONE.get())), "farstone_smooth");
        FARSTONE_BRICKS = registerBlock(() -> new Block(BlockBehaviour.Properties.m_308003_(FARSTONE.get())), "farstone_bricks");
        FARSTONE_BRICKS_CHISELED = registerBlock(() -> new Block(BlockBehaviour.Properties.m_308003_(FARSTONE.get())), "chiseled_farstone");
        FARSTONE_BRICKS_STAIRS = registerBlock(() -> new StairBlock(FARSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.m_308003_(FARSTONE.get())), "farstone_brick_stairs");
        FARSTONE_BRICKS_SLAB = registerBlock(() -> new SlabBlock(BlockBehaviour.Properties.m_308003_(FARSTONE.get())), "farstone_brick_slab");
        FARSTONE_BRICKS_WALL = registerBlock(() -> new WallBlock(BlockBehaviour.Properties.m_308003_(FARSTONE.get()).forceSolidOn()), "farstone_brick_wall");
        FARSTONE_PILLAR = registerBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.m_308003_(FARSTONE.get())), "farstone_pillar");
        INCANDESCENT_LAMP = registerBlock(() -> new IncandescentLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).forceSolidOn().strength(3.0F).sound(SoundType.LANTERN).lightLevel(litBlockEmission())), "incandescent_lamp");
    }
    public static RegistryObject<Block> registerBlock(Supplier<Block> blockSupplier, String name) {
        RegistryObject<Block> blockRegistryObject = EndReborn.BLOCK.register(name, blockSupplier);
        EndReborn.ITEM.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties()));
        return blockRegistryObject;
    }
    public static RegistryObject<Block> registerPot(Supplier<Block> blockSupplier, String name) {
        return EndReborn.BLOCK.register(name, blockSupplier);
    }
    private static ToIntFunction<BlockState> litBlockEmission() {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? 12 : 0;
        };
    }
}
