package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.EndMossBlock;
import com.endreborn.content.IncandescentLampBlock;
import com.endreborn.content.MossPlantBlock;
import com.endreborn.content.PublicGlassBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static DeferredBlock<Block> CHISELED_END_BRICKS;
    public static DeferredBlock<Block> CRACKED_END_BRICKS;
    public static DeferredBlock<Block> SMOOTH_END_STONE;
    public static DeferredBlock<Block> END_STONE_PILLAR;
    public static DeferredBlock<Block> END_MOSS;
    public static DeferredBlock<Block> OGANA_WEED;
    public static DeferredBlock<Block> OGANA_PLANT;
    public static DeferredBlock<Block> POTTED_OGANA;
    public static DeferredBlock<Block> END_MOSS_BLOCK;
    public static DeferredBlock<Block> END_MOSS_CARPET;
    public static DeferredBlock<Block> OBSIDIAN_GLASS;
    public static DeferredBlock<Block> OBSIDIAN_GLASS_PANE;
    public static DeferredBlock<Block> TUNGSTEN_ORE;
    public static DeferredBlock<Block> RAW_TUNGSTEN_BLOCK;
    public static DeferredBlock<Block> ENDORIUM_BLOCK;
    public static DeferredBlock<Block> TUNGSTEN_BLOCK;
    public static DeferredBlock<Block> FARSTONE;
    public static DeferredBlock<Block> FARSTONE_DECORATIVE;
    public static DeferredBlock<Block> FARSTONE_BRICKS;
    public static DeferredBlock<Block> FARSTONE_BRICKS_CHISELED;
    public static DeferredBlock<Block> FARSTONE_BRICKS_STAIRS;
    public static DeferredBlock<Block> FARSTONE_BRICKS_SLAB;
    public static DeferredBlock<Block> FARSTONE_BRICKS_WALL;
    public static DeferredBlock<Block> FARSTONE_PILLAR;
    public static DeferredBlock<Block> INCANDESCENT_LAMP;

    public static void setup() {
        SMOOTH_END_STONE = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)), "end_stone_smooth");
        CRACKED_END_BRICKS = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)), "cracked_end_bricks");
        CHISELED_END_BRICKS = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)), "chiseled_end_bricks");
        END_STONE_PILLAR = register(() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)), "end_stone_pillar");
        END_MOSS = register(() -> new EndMossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)), "end_moss");
        OGANA_WEED = register(() -> new MossPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).replaceable()), "ogana_weed");
        OGANA_PLANT = register(() -> new MossPlantBlock(BlockBehaviour.Properties.ofFullCopy(OGANA_WEED.get())), "ogana_plant");
        POTTED_OGANA = registerPot(() -> new FlowerPotBlock(OGANA_PLANT.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)), "potted_ogana");
        END_MOSS_BLOCK = register(() -> new EndMossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(1.4F).sound(SoundType.MOSS)), "end_moss_block");
        END_MOSS_CARPET = register(() -> new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.1F).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)), "end_moss_carpet");

        OBSIDIAN_GLASS = register(() -> new PublicGlassBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PLING).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()), "obsidian_glass");
        OBSIDIAN_GLASS_PANE = register(() -> new IronBarsBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PLING).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()), "obsidian_glass_pane");
        TUNGSTEN_ORE = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)), "tungsten_ore");
        ENDORIUM_BLOCK = register(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(6.0F, 7.0F)), "endorium_block");
        TUNGSTEN_BLOCK = register(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.5F, 6.0F)), "tungsten_block");
        RAW_TUNGSTEN_BLOCK = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(TUNGSTEN_BLOCK.get())), "raw_tungsten_block");
        FARSTONE = register(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.55F, 9.0F)), "farstone");
        FARSTONE_DECORATIVE = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_smooth");
        FARSTONE_BRICKS = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_bricks");
        FARSTONE_BRICKS_CHISELED = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "chiseled_farstone");
        FARSTONE_BRICKS_STAIRS = register(() -> new StairBlock(FARSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_brick_stairs");
        FARSTONE_BRICKS_SLAB = register(() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_brick_slab");
        FARSTONE_BRICKS_WALL = register(() -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get()).forceSolidOn()), "farstone_brick_wall");
        FARSTONE_PILLAR = register(() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_pillar");
        INCANDESCENT_LAMP = register(() -> new IncandescentLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).forceSolidOn().strength(3.0F).sound(SoundType.LANTERN).lightLevel(litBlockEmission())), "incandescent_lamp");
    }
    public static DeferredBlock<Block> register(Supplier<Block> blockSupplier, String name) {
        DeferredBlock<Block> blockRegistryObject = EndReborn.BLOCK.register(name, blockSupplier);
        EndReborn.ITEM.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties()));
        return blockRegistryObject;
    }
    public static DeferredBlock<Block> registerPot(Supplier<Block> blockSupplier, String name) {
        return EndReborn.BLOCK.register(name, blockSupplier);
    }
    private static ToIntFunction<BlockState> litBlockEmission() {
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.LIT) ? 12 : 0;
    }
}
