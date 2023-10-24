package com.endreborn.world;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.EndIslandFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class CrackedBlocksFeature extends Feature<DefaultFeatureConfig> {
    public CrackedBlocksFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<DefaultFeatureConfig> feature) {
        StructureWorldAccess worldIn = feature.getWorld();
        BlockPos pos = feature.getOrigin();
        Random rand = feature.getRandom();
        BlockState brickstate = ModBlocks.CRACKED_END_BRICKS.getDefaultState();
        BlockState blockstate = ModBlocks.CRACKED_PURPUR.getDefaultState();
        for (int j = 0; j < 4; ++j) {
            BlockPos blockpos = pos.add(rand.nextInt(2), rand.nextInt(2), rand.nextInt(2));
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.PURPUR_BLOCK) {
                worldIn.setBlockState(blockpos, blockstate, 2);
            } else if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE_BRICKS) {
                worldIn.setBlockState(blockpos, brickstate, 2);
            }
        }
        return true;
    }
}
