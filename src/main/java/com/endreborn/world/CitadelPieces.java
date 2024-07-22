package com.endreborn.world;

import com.endreborn.Endorium;
import com.endreborn.init.ModBlocks;
import com.endreborn.init.ModPieces;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.inventory.LootableInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class CitadelPieces  {
    private static final Identifier MID = Identifier.of(Endorium.MODID, "citadel_middle");
    private static final Identifier UP = Identifier.of(Endorium.MODID, "citadel_up");
    private static final Identifier ROOM = Identifier.of(Endorium.MODID, "citadel_room");
    private static final Identifier PEAK = Identifier.of(Endorium.MODID, "citadel_peak");
    private static final Identifier HALL = Identifier.of(Endorium.MODID, "citadel_hall");

    public static void addParts(StructureTemplateManager manager, BlockPos pos, BlockRotation rotation, StructurePiecesHolder pieceList, Random random) {
        pieceList.addPiece(new CitadelPieces.Piece(manager, MID, pos, rotation));
        int up = ThreadLocalRandom.current().nextInt(3);
        int down = ThreadLocalRandom.current().nextInt(2, 5);
        for (int u = up; u >= 0; --u) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, UP, pos.up(7 + u * 8), rotation));
        }
        if (ThreadLocalRandom.current().nextDouble() < 0.15D) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, MID, pos.up(15 + up * 8), rotation));
            pieceList.addPiece(new CitadelPieces.Piece(manager, PEAK, pos.add(-3, 22 + up * 8, -3), rotation));
        } else {
            pieceList.addPiece(new CitadelPieces.Piece(manager, PEAK, pos.add(-3, 20 + up * 8, -3), rotation));
            pieceList.addPiece(new CitadelPieces.Piece(manager, ROOM, pos.add(-2, 14 + up * 8, -2), rotation));
        }
        for (int u = down; u >= 0; --u) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, UP, pos.add(0, -(u * 8), 0), rotation));
        }
        pieceList.addPiece(new CitadelPieces.Piece(manager, HALL, pos.add(-4, -(7 + down * 8), -4), rotation));
        pieceList.addPiece(new CitadelPieces.Piece(manager, ROOM, pos.add(-2, -(12 + down * 8), -2), rotation));
    }

    public static class Piece extends SimpleStructurePiece {
        public Piece(StructureTemplateManager manager, Identifier identifier, BlockPos pos, BlockRotation rotation) {
            super(ModPieces.CITADEL_PIECE, 0, manager, identifier, identifier.toString(), createPlacementData(manager, identifier, rotation), pos);
        }
        public Piece(StructureContext manager, NbtCompound nbt) {
            super(ModPieces.CITADEL_PIECE, nbt, manager.structureTemplateManager(), (id) -> {
                return createPlacementData(manager.structureTemplateManager(), id, BlockRotation.valueOf(nbt.getString("Rot")));
            });
        }
        public void writeNbt(StructureContext context, NbtCompound nbt) {
            super.writeNbt(context, nbt);
            nbt.putString("Rot", this.placementData.getRotation().name());
        }
        private static StructurePlacementData createPlacementData(StructureTemplateManager manager, Identifier resourceLocation, BlockRotation rotation) {
            StructureTemplate template = manager.getTemplateOrBlank(resourceLocation);

            BlockPos pivot = new BlockPos(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2);
            return (new StructurePlacementData()).setRotation(rotation).setMirror(BlockMirror.NONE).setPosition(pivot).addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
        }
        public void generate(StructureWorldAccess worldIn, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random rand, BlockBox chunkBox, ChunkPos chunkPos, BlockPos pos) {
            super.generate(worldIn, structureAccessor, chunkGenerator, rand, chunkBox, chunkPos, pos);
            for (int u = 2; u > 0; --u) {
                boolean chance = rand.nextDouble() < 0.5D;
                BlockPos randpos = pos.add(rand.nextBetween(-9, 7), rand.nextBetween(-2, 2)-3, rand.nextBetween(-9, 7));
                int o = 2 + rand.nextInt(4);
                float f = (float) (o + o + o) * 0.333F + 0.5F;
                for (BlockPos blockpos : BlockPos.iterate(randpos.add(-o, -o + rand.nextInt(3), -o), randpos.add(o, o, o))) {
                    if (blockpos.getSquaredDistance(randpos) <= (double) (f * f) && worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR) {
                        if (chance) {
                            worldIn.setBlockState(blockpos, ModBlocks.FARSTONE.getDefaultState(), 2);
                        } else {
                            worldIn.setBlockState(blockpos, Blocks.END_STONE.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        protected void handleMetadata(String function, BlockPos pos, ServerWorldAccess world, Random random, BlockBox sbb) {
            if (function.startsWith("Random")) {
                if (ThreadLocalRandom.current().nextInt(10) == 1) {
                    world.setBlockState(pos, Blocks.CHEST.getDefaultState(), 2);
                    if (sbb.contains(pos)) {
                        LootableInventory.setLootTable(world, random, pos, CitadelLootTables.CITADEL_LOOT);
                    }
                } else {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                }
            }
            if (function.startsWith("Chest")) {
                world.setBlockState(pos, Blocks.CHEST.getDefaultState(), 2);
                if (sbb.contains(pos)) {
                    LootableInventory.setLootTable(world, random, pos, CitadelLootTables.CITADEL_LOOT);
                }
            }
            if (function.startsWith("Shulker")) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                ShulkerEntity shulker = (ShulkerEntity) EntityType.SHULKER.create(world.toServerWorld());
                if (shulker != null) {
                    shulker.setPos(pos.getX(), pos.getY(), pos.getZ());
                    world.spawnEntity(shulker);
                }
            }
        }
    }
}
