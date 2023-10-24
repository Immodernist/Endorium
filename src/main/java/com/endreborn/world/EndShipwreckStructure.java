package com.endreborn.world;

import com.endreborn.init.ModTypes;
import com.mojang.serialization.Codec;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

import java.util.Optional;

public class EndShipwreckStructure extends Structure {
    public static final Codec<EndShipwreckStructure> CODEC = createCodec(EndShipwreckStructure::new);

    public EndShipwreckStructure(Config config) {
        super(config);
    }
    public Optional<Structure.StructurePosition> getStructurePosition(Structure.Context context) {
        return getStructurePosition(context, Heightmap.Type.WORLD_SURFACE_WG, (collector) -> {
            this.addPieces(collector, context);
        });
    }

    private void addPieces(StructurePiecesCollector collector, Structure.Context context) {
        BlockPos chunkPos = new BlockPos(context.chunkPos().getStartX(), 90, context.chunkPos().getStartZ());
        int landHeight = context.chunkGenerator().getHeightOnGround(chunkPos.getX(), chunkPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world(), context.noiseConfig());
        if (landHeight >= 57) {
            BlockPos position = new BlockPos(chunkPos.getX(), landHeight, chunkPos.getZ());
            BlockRotation rotation = BlockRotation.random(context.random());
            EndShipwreckPieces.addParts(context.structureTemplateManager(), position, rotation, collector, context.random());
        }
    }
    public StructureType<?> getType() {
        return ModTypes.END_SHIPWRECK;
    }
}
