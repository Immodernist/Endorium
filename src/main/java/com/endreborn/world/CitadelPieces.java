package com.endreborn.world;

import com.endreborn.EndReborn;
import com.endreborn.init.ModBlocks;
import com.endreborn.init.ModLootTables;
import com.endreborn.init.ModPieces;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.concurrent.ThreadLocalRandom;

public class CitadelPieces {
    private static final ResourceLocation MID = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_middle");
    private static final ResourceLocation UP = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_up");
    private static final ResourceLocation ROOM = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_room");
    private static final ResourceLocation PEAK = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_peak");
    private static final ResourceLocation HALL = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_hall");

    public static void addPieces(StructureTemplateManager manager, BlockPos pos, Rotation rotation, StructurePieceAccessor pieceList, Structure.GenerationContext generationContext, RandomSource random) {
        pieceList.addPiece(new CitadelPieces.Piece(manager, MID, pos, rotation));
        int up = ThreadLocalRandom.current().nextInt(3);
        int down = ThreadLocalRandom.current().nextInt(2, 5);
        for (int u = up; u >= 0; --u) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, UP, pos.above(7 + u * 8), rotation));
        }
        if (ThreadLocalRandom.current().nextDouble() < 0.15D) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, MID, pos.above(15 + up * 8), rotation));
            pieceList.addPiece(new CitadelPieces.Piece(manager, PEAK, pos.offset(-3, 22 + up * 8, -3), rotation));
        } else {
            pieceList.addPiece(new CitadelPieces.Piece(manager, PEAK, pos.offset(-3, 20 + up * 8, -3), rotation));
            pieceList.addPiece(new CitadelPieces.Piece(manager, ROOM, pos.offset(-2, 14 + up * 8, -2), rotation));
        }
        for (int u = down; u >= 0; --u) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, UP, pos.offset(0, -(u * 8), 0), rotation));
        }
        pieceList.addPiece(new CitadelPieces.Piece(manager, HALL, pos.offset(-4, -(7 + down * 8), -4), rotation));
        pieceList.addPiece(new CitadelPieces.Piece(manager, ROOM, pos.offset(-2, -(12 + down * 8), -2), rotation));
    }
    public static class Piece extends TemplateStructurePiece {
        public Piece(StructureTemplateManager manager, ResourceLocation resourceLocation, BlockPos position, Rotation rotation) {
            super(ModPieces.CITADEL_PIECE.get(), 0, manager, resourceLocation, resourceLocation.toString(), loadTemplate(manager, resourceLocation, rotation), position.offset(0, -4, 0));
        }
        public Piece(StructurePieceSerializationContext serializationContext, CompoundTag compoundNBT) {
            super(ModPieces.CITADEL_PIECE.get(), compoundNBT, serializationContext.structureTemplateManager(), (placementSettings) -> {
                ResourceLocation templateLocation = ResourceLocation.parse(compoundNBT.getString("Template"));
                Rotation rotation = Rotation.valueOf(compoundNBT.getString("Rot"));
                return loadTemplate(serializationContext.structureTemplateManager(), templateLocation, rotation);
            });
        }
        public void postProcess(WorldGenLevel worldIn, StructureManager p_229138_, ChunkGenerator p_229139_, RandomSource rand, BoundingBox p_229141_, ChunkPos p_229142_, BlockPos pos) {
            super.postProcess(worldIn, p_229138_, p_229139_, rand, p_229141_, p_229142_, pos);
            for (int u = 2; u > 0; --u) {
                boolean chance = ThreadLocalRandom.current().nextDouble() < 0.5D;
                BlockPos randpos = pos.offset(ThreadLocalRandom.current().nextInt(-9, 7), ThreadLocalRandom.current().nextInt(-2, 2), ThreadLocalRandom.current().nextInt(-9, 7));
                int o = 2 + ThreadLocalRandom.current().nextInt(4);
                float f = (float) (o + o + o) * 0.333F + 0.5F;
                for (BlockPos blockpos : BlockPos.betweenClosed(randpos.offset(-o, -o+ThreadLocalRandom.current().nextInt(3), -o), randpos.offset(o, o, o))) {
                    if (blockpos.distSqr(randpos) <= (double) (f * f) && worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR) {
                        if (chance) {
                            worldIn.setBlock(blockpos, ModBlocks.FARSTONE.get().defaultBlockState(), 2);
                        } else {
                            worldIn.setBlock(blockpos, Blocks.END_STONE.defaultBlockState(), 2);
                        }
                    }
                }
            }
        }

        private static StructurePlaceSettings loadTemplate(StructureTemplateManager manager, ResourceLocation resourceLocation, Rotation rotation) {
            StructureTemplate template = manager.getOrCreate(resourceLocation);

            BlockPos pivot = new BlockPos(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2);
            return (new StructurePlaceSettings()).setRotation(rotation).setMirror(Mirror.NONE).setRotationPivot(pivot).addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        }
        protected void addAdditionalSaveData(StructurePieceSerializationContext serializationContext, CompoundTag compoundNBT) {
            super.addAdditionalSaveData(serializationContext, compoundNBT);
            compoundNBT.putString("Rot", this.placeSettings.getRotation().name());
        }

        protected void handleDataMarker(String function, BlockPos pos, ServerLevelAccessor worldIn, RandomSource rand, BoundingBox sbb) {
            if (function.startsWith("Chest")) {
                worldIn.setBlock(pos, Blocks.CHEST.defaultBlockState(), 2);
                if (sbb.isInside(pos)) {
                    RandomizableContainer.setBlockEntityLootTable(worldIn, rand, pos, ModLootTables.CITADEL_LOOT);
                }
            }
            if (function.startsWith("Random")) {
                if (ThreadLocalRandom.current().nextInt(10) == 1) {
                    worldIn.setBlock(pos, Blocks.CHEST.defaultBlockState(), 2);
                    if (sbb.isInside(pos)) {
                        RandomizableContainer.setBlockEntityLootTable(worldIn, rand, pos, ModLootTables.CITADEL_LOOT);
                    }
                } else {
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                }
            }
            if (function.startsWith("Shulker")) {
                worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                Shulker shulker = EntityType.SHULKER.create(worldIn.getLevel());
                if (shulker != null) {
                    shulker.setPos(pos.getX(), pos.getY(), pos.getZ());
                    worldIn.addFreshEntity(shulker);
                }
            }
        }
    }
}