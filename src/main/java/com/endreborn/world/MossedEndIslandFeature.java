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
        boolean chance = rand.nextDouble() < 0.35D;

        float f = (float)rand.nextInt(3) + 4.0F;
        for(int i = 0; f > 0.5F; --i) {
            for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
                for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
                        if (i == 0 && chance) {
                            this.setBlockState(worldIn, pos.add(j, i, k), ModBlocks.END_MOSS.getDefaultState());
                        } else {
                            this.setBlockState(worldIn, pos.add(j, i, k), Blocks.END_STONE.getDefaultState());
                        }
                    }
                }
            }
            f -= (float)rand.nextInt(2) + 0.5F;
        }
        if (chance) {
            for (int d = 0; d < 32; ++d) {
                int decorator = rand.nextInt(11);
                BlockPos blockpos = pos.add(rand.nextBetween(-6, 6), 0, rand.nextBetween(-6, 6));
                if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS){
                    if (worldIn.isAir(blockpos.up())) {
                        if (decorator > 4 && decorator < 11){
                            if (decorator > 9){
                                worldIn.setBlockState(blockpos.up(), ModBlocks.OGANA_PLANT.getDefaultState(), 2);
                            } else {
                                worldIn.setBlockState(blockpos.up(), ModBlocks.OGANA_WEED.getDefaultState(), 2);
                            }
                        } else {
                            if (decorator < 5) {
                                worldIn.setBlockState(blockpos, Blocks.END_STONE.getDefaultState(), 2);
                            }
                            if (decorator == 4) {
                                for (int m = 0; m < 6; ++m) {
                                    BlockPos mosspos = blockpos.add(rand.nextInt(3), 0, rand.nextInt(3));
                                    if (!worldIn.isAir(mosspos)) {
                                        worldIn.setBlockState(mosspos.up(), ModBlocks.END_MOSS_CARPET.getDefaultState(), 2);
                                    }
                                }
                            }
                        }

                    }
                    if (worldIn.isAir(blockpos.down())) {
                        for (int m = 0; m < rand.nextInt(6) + 1; ++m) {
                            worldIn.setBlockState(blockpos.down(m), ModBlocks.END_MOSS_BLOCK.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}