package com.endreborn.world;

import com.endreborn.EndReborn;
import com.endreborn.init.ModBlocks;
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

public class CitadelPieces {
    private static final ResourceLocation MID = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_middle");
    private static final ResourceLocation UP = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_up");
    private static final ResourceLocation RUIN = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_ruin");
    private static final ResourceLocation PEAK = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_peak");
    private static final ResourceLocation END = ResourceLocation.fromNamespaceAndPath(EndReborn.MODID,"citadel_bottom");

    public static void addPieces(StructureTemplateManager manager, BlockPos pos, Rotation rotation, StructurePieceAccessor pieceList, Structure.GenerationContext generationContext, RandomSource random) {
        pieceList.addPiece(new CitadelPieces.Piece(manager, MID, pos, rotation));
        int up = random.nextInt( 3);
        int down = random.nextInt(2, 5);
        boolean chance = random.nextDouble() < 0.15D;
        for (int u = up; u >= 0; --u) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, UP, pos.above(7 + u*8), rotation));
        } if (chance) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, RUIN, pos.above(11+up*8), rotation));
            pieceList.addPiece(new CitadelPieces.Piece(manager, UP, pos.above(18+up*8), rotation));
            pieceList.addPiece(new CitadelPieces.Piece(manager, PEAK, pos.offset(-2, 26+up*8,-2), rotation));
        } else {
            pieceList.addPiece(new CitadelPieces.Piece(manager, MID, pos.above(15+up*8), rotation));
            pieceList.addPiece(new CitadelPieces.Piece(manager, PEAK, pos.offset(-2, 22+up*8, -2), rotation));
        } for (int u = down; u >= 0; --u) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, UP, pos.offset(0,-(u*8), 0), rotation));
        } if (chance) {
            pieceList.addPiece(new CitadelPieces.Piece(manager, MID, pos.offset(0, -(7+down*8), 0), rotation));
        } else {
            pieceList.addPiece(new CitadelPieces.Piece(manager, RUIN, pos.offset(0, -(7+down*8), 0), rotation));
        }
        pieceList.addPiece(new CitadelPieces.Piece(manager, END, pos.offset(-1,-(11+down*8), -1), rotation));
    }
    public static class Piece extends TemplateStructurePiece {
        public Piece(StructureTemplateManager manager, ResourceLocation resourceLocation, BlockPos position, Rotation rotation) {
            super(ModPieces.CITADEL_PIECE, 0, manager, resourceLocation, resourceLocation.toString(), loadTemplate(manager, resourceLocation, rotation), position.offset(0, -4, 0));
        }
        public Piece(StructurePieceSerializationContext serializationContext, CompoundTag compoundNBT) {
            super(ModPieces.CITADEL_PIECE, compoundNBT, serializationContext.structureTemplateManager(), (placementSettings) -> {
                ResourceLocation templateLocation = ResourceLocation.parse(compoundNBT.getString("Template"));
                Rotation rotation = Rotation.valueOf(compoundNBT.getString("Rot"));
                return loadTemplate(serializationContext.structureTemplateManager(), templateLocation, rotation);
            });
        }
        public void postProcess(WorldGenLevel worldIn, StructureManager p_229138_, ChunkGenerator p_229139_, RandomSource rand, BoundingBox p_229141_, ChunkPos p_229142_, BlockPos pos) {
            super.postProcess(worldIn, p_229138_, p_229139_, rand, p_229141_, p_229142_, pos);
            for (int u = 2; u > 0; --u) {
                boolean chance = rand.nextDouble() < 0.5D;
                BlockPos randpos = pos.offset(rand.nextInt(-9, 9), rand.nextInt(-2, 2), rand.nextInt(-9, 9));
                int o = 2 + rand.nextInt(4);
                float f = (float) (o + o + o) * 0.333F + 0.5F;
                for (BlockPos blockpos : BlockPos.betweenClosed(randpos.offset(-o, -o+rand.nextInt(3), -o), randpos.offset(o, o, o))) {
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
                BlockPos blockpos = pos.below();
                if (sbb.isInside(blockpos)) {
                    RandomizableContainer.setBlockEntityLootTable(worldIn, rand, blockpos, ModLootTables.CITADEL_LOOT);
                }
            }
            if (function.startsWith("Shulker")) {
                Shulker shulker = EntityType.SHULKER.create(worldIn.getLevel());
                if (shulker != null) {
                    shulker.setPos(pos.getX(), pos.getY()-1, pos.getZ());
                    worldIn.addFreshEntity(shulker);
                }
            }
        }
    }
}