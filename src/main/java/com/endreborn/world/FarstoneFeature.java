package com.endreborn.world;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FarstoneFeature extends Feature<NoneFeatureConfiguration> {
    public FarstoneFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> feature) {
        RandomSource rand = feature.random();
        BlockPos pos = feature.origin();
        int o = 2 + rand.nextInt(4);
        float f = (float) (o + o + o) * 0.333F + 0.5F;
        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-o, -o - rand.nextInt(4), -o), pos.offset(o, o, o))) {
            if (blockpos.distSqr(pos) <= (double) (f * f) && feature.level().getBlockState(blockpos).getBlock() == Blocks.END_STONE) {
                feature.level().setBlock(blockpos, ModBlocks.FARSTONE.get().defaultBlockState(), 2);
            }
        }

        return true;
    }
}
