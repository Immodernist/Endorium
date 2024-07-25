package com.endreborn.world;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TungstenOreFeature extends Feature<NoFeatureConfig> {
    public TungstenOreFeature(Codec<NoFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        BlockState blockstate = ModBlocks.TUNGSTEN_ORE.get().defaultBlockState();
        if (pos.getY() <= 70 && worldIn.getBlockState(pos.below()).getBlock() == Blocks.END_STONE) {
            for (int j = 0; j < ThreadLocalRandom.current().nextInt(5); ++j) {
                BlockPos blockpos = pos.offset(ThreadLocalRandom.current().nextInt(3), -ThreadLocalRandom.current().nextInt(2), ThreadLocalRandom.current().nextInt(3));
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE) {
                    worldIn.setBlock(blockpos, blockstate, 2);
                }
            }
        }
        return true;
    }
}