package com.endreborn.world;

import com.endreborn.init.ModTypes;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Optional;

public class CitadelStructure extends Structure {
    public static final Codec<CitadelStructure> CODEC = simpleCodec(CitadelStructure::new);
    public CitadelStructure(Structure.StructureSettings structureSettings) {
        super(structureSettings);
    }

    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext generationContext) {
        return onTopOfChunkCenter(generationContext, Heightmap.Types.WORLD_SURFACE_WG, (builder) -> {
            this.generatePieces(builder, generationContext);
        });
    }

    public void generatePieces(StructurePiecesBuilder pieceBuilder, Structure.GenerationContext generatorContext) {
        BlockPos chunkPos = new BlockPos(generatorContext.chunkPos().getMinBlockX(), 90, generatorContext.chunkPos().getMinBlockZ());
        int landHeight = generatorContext.chunkGenerator().getFirstOccupiedHeight(chunkPos.getX(), chunkPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, generatorContext.heightAccessor(), generatorContext.randomState());
        if (landHeight >= 56) {
            BlockPos position = new BlockPos(chunkPos.getX(), landHeight, chunkPos.getZ());
            Rotation rotation = Rotation.getRandom(generatorContext.random());
            CitadelPieces.addPieces(generatorContext.structureTemplateManager(), position, rotation, pieceBuilder, generatorContext, generatorContext.random());
        }
    }

    @Override
    public StructureType<?> type() {
        return ModTypes.CITADEL_TYPE.get();
    }
}
