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

public class CitadelPieces  {
    private static final Identifier MID = Identifier.of(Endorium.MODID, "citadel_middle");
    private static final Identifier UP = Identifier.of(Endorium.MODID, "citadel_up");
    private static final Identifier RUIN = Identifier.of(Endorium.MODID, "citadel_ruin");
    private static final Identifier PEAK = Identifier.of(Endorium.MODID, "citadel_peak");
    private static final Identifier END = Identifier.of(Endorium.MODID, "citadel_bottom");

    public static void addParts(StructureTemplateManager manager, BlockPos pos, BlockRotation rotation, StructurePiecesHolder pieceList, Random random) {
        pieceList.addPiece(new CitadelPieces.Piece(manager, MID, pos, rotation));
        int up = random.nextInt(3);
        int down = random.nextBetween(2, 5);
        boolean chance = random.nextDouble() < 0.15D;
        for (int u = up; u >= 0; --u) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, UP, pos.up(7 + u * 8), rotation));
        }
        if (chance) {
            pieceList.addPiece(new Piece(manager, RUIN, pos.up(11 + up * 8), rotation));
            pieceList.addPiece(new Piece(manager, UP, pos.up(18 + up * 8), rotation));
            pieceList.addPiece(new Piece(manager, PEAK, pos.add(-2, 26 + up * 8, -2), rotation));
        } else {
            pieceList.addPiece(new Piece(manager, MID, pos.up(15 + up * 8), rotation));
            pieceList.addPiece(new Piece(manager, PEAK, pos.add(-2, 22 + up * 8, -2), rotation));
        }
        for (int u = down; u >= 0; --u) {
            pieceList.addPiece(new Piece(manager, UP, pos.add(0, -(u * 8), 0), rotation));
        }
        if (chance) {
            pieceList.addPiece(new Piece(manager, MID, pos.add(0, -(7 + down * 8), 0), rotation));
        } else {
            pieceList.addPiece(new Piece(manager, RUIN, pos.add(0, -(7 + down * 8), 0), rotation));
        }
        pieceList.addPiece(new Piece(manager, END, pos.add(-1, -(11 + down * 8), -1), rotation));
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
            if (function.startsWith("Chest")) {
                BlockPos blockpos = pos.down();
                if (sbb.contains(blockpos)) {
                    LootableInventory.setLootTable(world, random, blockpos, CitadelLootTables.CITADEL_LOOT);
                }
            }
            if (function.startsWith("Shulker")) {
                ShulkerEntity shulker = (ShulkerEntity) EntityType.SHULKER.create(world.toServerWorld());
                if (shulker != null) {
                    shulker.setPos(pos.getX(), pos.getY() - 1, pos.getZ());
                    world.spawnEntity(shulker);
                }
            }
        }
    }
}
