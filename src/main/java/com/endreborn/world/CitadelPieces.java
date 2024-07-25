package com.endreborn.world;

import com.endreborn.EndReborn;
import com.endreborn.init.ModBlocks;
import com.endreborn.init.ModPieces;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CitadelPieces {
    private static final ResourceLocation MID = new ResourceLocation(EndReborn.MODID, "citadel_middle");
    private static final ResourceLocation UP = new ResourceLocation(EndReborn.MODID, "citadel_up");
    private static final ResourceLocation ROOM = new ResourceLocation(EndReborn.MODID, "citadel_room");
    private static final ResourceLocation PEAK = new ResourceLocation(EndReborn.MODID, "citadel_peak");
    private static final ResourceLocation HALL = new ResourceLocation(EndReborn.MODID, "citadel_hall");
    public static final ResourceLocation CITADEL_LOOT = new ResourceLocation(EndReborn.MODID, "chests/citadel");

    public static void addPieces(TemplateManager manager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList) {
        pieceList.add(new CitadelPieces.Piece(manager, MID, pos, rotation));
        int up = ThreadLocalRandom.current().nextInt(3);
        int down = ThreadLocalRandom.current().nextInt(2, 5);
        for (int u = up; u >= 0; --u) {
            pieceList.add(new CitadelPieces.Piece(manager, UP, pos.above(7 + u * 8), rotation));
        }
        if (ThreadLocalRandom.current().nextDouble() < 0.15D) {
            pieceList.add(new CitadelPieces.Piece(manager, MID, pos.above(15 + up * 8), rotation));
            pieceList.add(new CitadelPieces.Piece(manager, PEAK, pos.offset(-3, 22 + up * 8, -3), rotation));
        } else {
            pieceList.add(new CitadelPieces.Piece(manager, PEAK, pos.offset(-3, 20 + up * 8, -3), rotation));
            pieceList.add(new CitadelPieces.Piece(manager, ROOM, pos.offset(-2, 14 + up * 8, -2), rotation));
        }
        for (int u = down; u >= 0; --u) {
            pieceList.add(new CitadelPieces.Piece(manager, UP, pos.offset(0, -(u * 8), 0), rotation));
        }
        pieceList.add(new CitadelPieces.Piece(manager, HALL, pos.offset(-4, -(7 + down * 8), -4), rotation));
        pieceList.add(new CitadelPieces.Piece(manager, ROOM, pos.offset(-2, -(12 + down * 8), -2), rotation));
    }
    public static class Piece extends TemplateStructurePiece {
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn) {
            super(ModPieces.CITADEL_PIECE, 0);
            this.resourceLocation = resourceLocationIn;
            this.templatePosition = pos.offset(0, -4, 0);
            this.rotation = rotationIn;
            this.loadTemplate(templateManagerIn);
        }

        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(ModPieces.CITADEL_PIECE, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.loadTemplate(templateManagerIn);
        }

        private void loadTemplate(TemplateManager templateManager) {
            Template template = templateManager.get(this.resourceLocation);
            BlockPos pivot = new BlockPos(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).setRotationPivot(pivot).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }

        protected void addAdditionalSaveData(CompoundNBT tagCompound) {
            super.addAdditionalSaveData(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        @Override
        public boolean postProcess(ISeedReader worldIn, StructureManager p_230383_2_, ChunkGenerator chunk, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos, BlockPos pos) {
            BlockPos blockPos = this.template.getSize();
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.templatePosition.offset(Template.calculateRelativePosition(placementsettings, new BlockPos(-blockPos.getX(), 0, -blockPos.getZ())));
            for (int u = 2; u > 0; --u) {
                boolean chance = ThreadLocalRandom.current().nextDouble() < 0.5D;
                BlockPos randpos = pos.offset(ThreadLocalRandom.current().nextInt(-9, 7), ThreadLocalRandom.current().nextInt(-2, 2), ThreadLocalRandom.current().nextInt(-9, 7));
                int o = 2 + ThreadLocalRandom.current().nextInt(4);
                float f = (float) (o + o + o) * 0.333F + 0.5F;
                for (BlockPos blockpos : BlockPos.betweenClosed(randpos.offset(-o, -o + ThreadLocalRandom.current().nextInt(3), -o), randpos.offset(o, o, o))) {
                    if (blockpos.distSqr(randpos) <= (double) (f * f) && worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR) {
                        if (chance) {
                            worldIn.setBlock(blockpos, ModBlocks.FARSTONE.get().defaultBlockState(), 2);
                        } else {
                            worldIn.setBlock(blockpos, Blocks.END_STONE.defaultBlockState(), 2);
                        }
                    }
                }
            }
            boolean flag = super.postProcess(worldIn, p_230383_2_, chunk, randomIn, structureBoundingBoxIn, chunkPos, blockPos);
            return flag;
        }
        protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {
            if (function.startsWith("Chest")) {
                worldIn.setBlock(pos, Blocks.CHEST.defaultBlockState(), 2);
                if (sbb.isInside(pos)) {
                    LockableLootTileEntity.setLootTable(worldIn, rand, pos, CitadelPieces.CITADEL_LOOT);
                }
            }
            if (function.startsWith("Random")) {
                if (ThreadLocalRandom.current().nextInt(10) == 1) {
                    worldIn.setBlock(pos, Blocks.CHEST.defaultBlockState(), 2);
                    if (sbb.isInside(pos)) {
                        LockableLootTileEntity.setLootTable(worldIn, rand, pos, CitadelPieces.CITADEL_LOOT);
                    }
                } else {
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                }
            }
            if (function.startsWith("Shulker")) {
                worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                ShulkerEntity shulker = EntityType.SHULKER.create(worldIn.getLevel());
                if (shulker != null) {
                    shulker.setPos(pos.getX(), pos.getY(), pos.getZ());
                    worldIn.addFreshEntity(shulker);
                }
            }
        }
    }
}
