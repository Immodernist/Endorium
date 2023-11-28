package com.endreborn.world;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class MossedEndIslandFeature extends Feature<DefaultFeatureConfig> {
    public MossedEndIslandFeature(Codec<DefaultFeatureConfig> p_65701_) {
        super(p_65701_);
    }

    public boolean generate(FeatureContext<DefaultFeatureConfig> feature) {
        StructureWorldAccess worldIn = feature.getWorld();
        BlockPos pos = feature.getOrigin();
        Random rand = feature.getRandom();
        double chance = rand.nextDouble();

        float f = (float)rand.nextInt(3) + 4.0F;
        for(int i = 0; f > 0.5F; --i) {
            for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
                for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
                        if (i == 0 && chance < 0.4D) {
                            this.setBlockState(worldIn, pos.add(j, i, k), ModBlocks.END_MOSS.getDefaultState());
                        } else {
                            this.setBlockState(worldIn, pos.add(j, i, k), Blocks.END_STONE.getDefaultState());
                        }
                    }
                }
            }
            f -= (float)rand.nextInt(2) + 0.5F;
        }
        for (int d = 0; d < 32; ++d) {
            double decorator = rand.nextDouble();
            BlockPos blockpos = pos.add(rand.nextBetween(-8, 8), 0, rand.nextBetween(-8, 8));
            if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS){
                if (worldIn.isAir(blockpos.up())) {
                    if (decorator < 0.4D) {
                        worldIn.setBlockState(blockpos, Blocks.END_STONE.getDefaultState(), 2);
                    } else if (decorator < 0.85D){
                        worldIn.setBlockState(blockpos.up(), ModBlocks.OGANA_WEED.getDefaultState(), 2);
                    } else {
                        worldIn.setBlockState(blockpos.up(), ModBlocks.OGANA_PLANT.getDefaultState(), 2);
                    }
                }
                if (worldIn.isAir(blockpos.down())) {
                    for (int m = 0; m < rand.nextInt(6) + 1; ++m) {
                        worldIn.setBlockState(blockpos.down(m), ModBlocks.END_MOSS_BLOCK.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}