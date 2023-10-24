package com.endreborn.world;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FarstoneFeature extends Feature<NoneFeatureConfiguration> {
    public FarstoneFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> feature) {
        WorldGenLevel worldIn = feature.level();
        RandomSource rand = feature.random();
        BlockPos pos = feature.origin();
        int o = 3 + rand.nextInt(4);
        float f = (float) (o + o + o) * 0.333F + 0.5F;
        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-o, -o - rand.nextInt(8), -o), pos.offset(o, o, rand.nextIntBetweenInclusive(2, o + 1)))) {
            if (blockpos.distSqr(pos) <= (double) (f * f) && worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && worldIn.getBlockState(blockpos.above()).getBlock() != ModBlocks.END_CORAL.get()) {
                worldIn.setBlock(blockpos, ModBlocks.FARSTONE.get().defaultBlockState(), 2);
            }
        }
        return true;
    }
}
