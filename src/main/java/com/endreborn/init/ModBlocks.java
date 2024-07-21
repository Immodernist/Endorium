package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.content.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(Registries.BLOCK, EndReborn.MODID);

    public static RegistryObject<Block> SMOOTH_END_STONE = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)), "end_stone_smooth");
    public static RegistryObject<Block> CRACKED_END_BRICKS = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)), "cracked_end_bricks");
    public static RegistryObject<Block> CHISELED_END_BRICKS = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)), "chiseled_end_bricks");
    public static RegistryObject<Block> END_STONE_PILLAR = register(() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)), "end_stone_pillar");
    public static RegistryObject<Block> END_MOSS = register(() -> new EndMossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)), "end_moss");
    public static RegistryObject<Block> OGANA_WEED = register(() -> new MossPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).replaceable()), "ogana_weed");
    public static RegistryObject<Block> OGANA_PLANT = register(() -> new MossPlantBlock(BlockBehaviour.Properties.ofFullCopy(OGANA_WEED.get())), "ogana_plant");
    public static RegistryObject<Block> POTTED_OGANA = registerPot(() -> new FlowerPotBlock(OGANA_PLANT.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)), "potted_ogana");
    public static RegistryObject<Block> END_MOSS_BLOCK = register(() -> new EndMossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(1.4F).sound(SoundType.MOSS)), "end_moss_block");
    public static RegistryObject<Block> END_MOSS_CARPET = register(() -> new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.1F).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)), "end_moss_carpet");

    public static RegistryObject<Block> OBSIDIAN_GLASS = register(() -> new TransparentBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PLING).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()), "obsidian_glass");
    public static RegistryObject<Block> OBSIDIAN_GLASS_PANE = register(() -> new IronBarsBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PLING).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0f, 1200.0f).sound(SoundType.GLASS).noOcclusion()), "obsidian_glass_pane");
    public static RegistryObject<Block> TUNGSTEN_ORE = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)), "tungsten_ore");
    public static RegistryObject<Block> ENDORIUM_BLOCK = register(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(6.0F, 7.0F)), "endorium_block");
    public static RegistryObject<Block> TUNGSTEN_BLOCK = register(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.5F, 6.0F)), "tungsten_block");
    public static RegistryObject<Block> RAW_TUNGSTEN_BLOCK = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(TUNGSTEN_BLOCK.get())), "raw_tungsten_block");
    public static RegistryObject<Block> FARSTONE = register(() -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.55F, 9.0F)), "farstone");
    public static RegistryObject<Block> FARSTONE_DECORATIVE = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_smooth");
    public static RegistryObject<Block> FARSTONE_BRICKS = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_bricks");
    public static RegistryObject<Block> FARSTONE_BRICKS_CHISELED = register(() -> new Block(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "chiseled_farstone");
    public static RegistryObject<Block> FARSTONE_BRICKS_STAIRS = register(() -> new StairBlock(FARSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_brick_stairs");
    public static RegistryObject<Block> FARSTONE_BRICKS_SLAB = register(() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_brick_slab");
    public static RegistryObject<Block> FARSTONE_WALL = register(() -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get()).forceSolidOn()), "farstone_wall");
    public static RegistryObject<Block> FARSTONE_PILLAR = register(() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(FARSTONE.get())), "farstone_pillar");
    public static RegistryObject<Block> INCANDESCENT_LAMP = register(() -> new IncandescentLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).forceSolidOn().strength(3.0F).sound(SoundType.LANTERN).lightLevel(litBlockEmission())), "incandescent_lamp");

    public static RegistryObject<Block> register(Supplier<Block> blockSupplier, String name) {
        RegistryObject<Block> blockRegistryObject = BLOCK.register(name, blockSupplier);
        ModItems.ITEM.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties()));
        return blockRegistryObject;
    }
    public static RegistryObject<Block> registerPot(Supplier<Block> blockSupplier, String name) {
        return BLOCK.register(name, blockSupplier);
    }
    private static ToIntFunction<BlockState> litBlockEmission() {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? 12 : 0;
        };
    }
}
