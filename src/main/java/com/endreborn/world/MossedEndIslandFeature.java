package com.endreborn.world;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class MossedEndIslandFeature extends Feature<NoneFeatureConfiguration> {
    public MossedEndIslandFeature(Codec<NoneFeatureConfiguration> p_65701_) {
        super(p_65701_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> feature) {
        WorldGenLevel worldIn = feature.level();
        RandomSource rand = feature.random();
        BlockPos pos = feature.origin();
        boolean chance = rand.nextDouble() < 0.35D;

        float f = (float)rand.nextInt(3) + 4.0F;
        for(int i = 0; f > 0.5F; --i) {
            for(int j = Mth.floor(-f); j <= Mth.ceil(f); ++j) {
                for(int k = Mth.floor(-f); k <= Mth.ceil(f); ++k) {
                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
                        if (i == 0 && chance) {
                            this.setBlock(worldIn, pos.offset(j, i, k), ModBlocks.END_MOSS.get().defaultBlockState());
                        } else {
                            this.setBlock(worldIn, pos.offset(j, i, k), Blocks.END_STONE.defaultBlockState());
                        }
                    }
                }
            }
            f -= (float)rand.nextInt(2) + 0.5F;
        }
        if (chance) {
            for (int d = 0; d < 32; ++d) {
                int decorator = rand.nextInt(11);
                BlockPos blockpos = pos.offset(rand.nextInt(-6, 6), 0, rand.nextInt(-6, 6));
                if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS.get()){
                    if (worldIn.isEmptyBlock(blockpos.above())) {
                        if (decorator > 4 && decorator < 11){
                            if (decorator > 9){
                                worldIn.setBlock(blockpos.above(), ModBlocks.OGANA_PLANT.get().defaultBlockState(), 2);
                            } else {
                                worldIn.setBlock(blockpos.above(), ModBlocks.OGANA_WEED.get().defaultBlockState(), 2);
                            }
                        } else {
                            if (decorator < 5) {
                                worldIn.setBlock(blockpos, Blocks.END_STONE.defaultBlockState(), 2);
                            }
                            if (decorator == 4) {
                                for (int m = 0; m < 6; ++m) {
                                    BlockPos mosspos = blockpos.offset(rand.nextInt(3), 0, rand.nextInt(3));
                                    if (!worldIn.isEmptyBlock(mosspos)) {
                                        worldIn.setBlock(mosspos.above(), ModBlocks.END_MOSS_CARPET.get().defaultBlockState(), 2);
                                    }
                                }
                            }
                        }

                    }
                    if (worldIn.isEmptyBlock(blockpos.below())) {
                        for (int m = 0; m < rand.nextInt(6) + 1; ++m) {
                            worldIn.setBlock(blockpos.below(m), ModBlocks.END_MOSS_BLOCK.get().defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}