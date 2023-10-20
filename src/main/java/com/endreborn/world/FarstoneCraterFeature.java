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

public class FarstoneCraterFeature extends Feature<NoneFeatureConfiguration> {
    public FarstoneCraterFeature(Codec<NoneFeatureConfiguration> p_65248_) {
        super(p_65248_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> feature) {
        WorldGenLevel worldIn = feature.level();
        BlockPos pos = feature.origin();
        BlockPos blockoops = pos.offset(0, -5, 0);
        RandomSource rand = feature.random();
        int o = 3 + rand.nextInt(1);
        int j = o + 4;
        float f = (float) (o + o + o) * 0.333F + 0.5F;
        for (int d = 0; d < 48; ++d) {
            BlockPos blockpos = pos.offset(rand.nextInt(-8, 8), 0, rand.nextInt(-8, 8));
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE){
                if (worldIn.isEmptyBlock(blockpos.above())) {
                    worldIn.setBlock(blockpos, ModBlocks.FARSTONE.get().defaultBlockState(), 2);
                }
            }
        }
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-j, -j, -j), pos.offset(j, j, j))) {
            if (blockpos.distSqr(pos) <= (double)(f * f) && (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE || worldIn.getBlockState(blockpos).getBlock() == ModBlocks.FARSTONE.get())) {
                worldIn.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 2);
            }
        }
        for(BlockPos blockpos : BlockPos.betweenClosed(blockoops.offset(-o, -o, -o), blockoops.offset(o, o, o))) {
            if (blockpos.distSqr(blockoops) <= (double)(f * f)) {
                worldIn.setBlock(blockpos, ModBlocks.FARSTONE.get().defaultBlockState(), 2);
            }
        }
        return true;
    }
}
