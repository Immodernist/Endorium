package com.endreborn.world;

import com.endreborn.Endorium;
import com.endreborn.init.ModBlocks;
import com.endreborn.init.ModPieces;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class EndShipwreckPieces {
    private static final Identifier[] STRUCTURES = new Identifier[]{new Identifier(Endorium.MODID + ":end_shipwreck"), new Identifier(Endorium.MODID + ":end_beacon"), new Identifier(Endorium.MODID + ":end_shipruin")};
    public static final Identifier END_SHIPWRECK_LOOT = new Identifier(Endorium.MODID, "chests/end_shipwreck");

    public EndShipwreckPieces() {
    }
    public static void addParts(StructureTemplateManager structureTemplateManager, BlockPos pos, BlockRotation rotation, StructurePiecesHolder holder, Random random) {
        holder.addPiece(new EndShipwreckPieces.Piece(structureTemplateManager, (Identifier) Util.getRandom(STRUCTURES, random), pos, rotation));
    }
    public static class Piece extends SimpleStructurePiece {
        public Piece(StructureTemplateManager manager, Identifier identifier, BlockPos pos, BlockRotation rotation) {
            super(ModPieces.END_SHIPWRECK, 0, manager, identifier, identifier.toString(), createPlacementData(rotation, identifier), pos.add(0, -4, 0));
        }
        public Piece(StructureContext manager, NbtCompound nbt) {
            super(ModPieces.END_SHIPWRECK, nbt, manager.structureTemplateManager(), (id) -> {
                return createPlacementData(BlockRotation.valueOf(nbt.getString("Rot")), id);
            });
        }
        public void writeNbt(StructureContext context, NbtCompound nbt) {
            super.writeNbt(context, nbt);
            nbt.putString("Rot", this.placementData.getRotation().name());
        }
        private static StructurePlacementData createPlacementData(BlockRotation rotation, Identifier identifier) {
            return (new StructurePlacementData()).setRotation(rotation).setMirror(BlockMirror.NONE).setPosition(BlockPos.ORIGIN).addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
        }
        public void generate(StructureWorldAccess worldIn, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random rand, BlockBox chunkBox, ChunkPos chunkPos, BlockPos pivot) {
            super.generate(worldIn, structureAccessor, chunkGenerator, rand, chunkBox, chunkPos, pivot);
            for (int j = 0; j < 8; ++j) {
                BlockPos blockpos = pos.add(rand.nextInt(4), rand.nextInt(6), rand.nextInt(4));
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.PURPUR_BLOCK) {
                    worldIn.setBlockState(blockpos, ModBlocks.CRACKED_PURPUR.getDefaultState(), 2);
                } else if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE_BRICKS) {
                    worldIn.setBlockState(blockpos, ModBlocks.CRACKED_END_BRICKS.getDefaultState(), 2);
                }
            }
        }
            protected void handleMetadata(String function, BlockPos pos, ServerWorldAccess world, Random random, BlockBox sbb) {
            if (function.startsWith("Chest")) {
                BlockPos blockpos = pos.down();
                if (sbb.contains(blockpos)) {
                    LootableContainerBlockEntity.setLootTable(world, random, blockpos, END_SHIPWRECK_LOOT);
                }
            }
        }
    }
}
