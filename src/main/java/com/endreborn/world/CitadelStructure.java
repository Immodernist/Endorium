package com.endreborn.world;

import com.endreborn.EndReborn;
import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ThreadLocalRandom;

public class CitadelStructure extends Structure<NoFeatureConfig> {
    public CitadelStructure(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    public String getName() {
        return EndReborn.MODID + ":citadel";
    }
    @Nonnull
    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return CitadelStructure.Start::new;
    }

    @Nonnull
    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        @Override
        @ParametersAreNonnullByDefault
        public void generatePieces(DynamicRegistries p_230364_1_, ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig p_230364_6_) {
            int surfaceY = generator.getBaseHeight(chunkX * 16, chunkZ * 16, Heightmap.Type.WORLD_SURFACE_WG);
            if (surfaceY >= 56) {
                BlockPos blockpos = new BlockPos(chunkX * 16, surfaceY, chunkZ * 16);
                Rotation rotation = Rotation.values()[ThreadLocalRandom.current().nextInt(Rotation.values().length)];
                CitadelPieces.addPieces(templateManagerIn, blockpos, rotation, this.pieces);
            }
            this.calculateBoundingBox();
        }
    }
}
