package com.endreborn.world;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CrackedBlocksFeature extends Feature<NoneFeatureConfiguration> {
    public CrackedBlocksFeature(Codec<NoneFeatureConfiguration> p_65786_) {
        super(p_65786_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> feature) {
        WorldGenLevel worldIn = feature.level();
        BlockPos pos = feature.origin();
        RandomSource rand = feature.random();
        BlockState brickstate = ModBlocks.CRACKED_END_BRICKS.get().defaultBlockState();
        BlockState blockstate = ModBlocks.CRACKED_PURPUR.get().defaultBlockState();
        for (int j = 0; j < 4; ++j) {
            BlockPos blockpos = pos.offset(rand.nextInt(2), rand.nextInt(2), rand.nextInt(2));
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.PURPUR_BLOCK) {
                worldIn.setBlock(blockpos, blockstate, 2);
            } else if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE_BRICKS) {
                worldIn.setBlock(blockpos, brickstate, 2);
            }
        }
        return true;
    }
}
