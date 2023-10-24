package com.endreborn.world;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class FarstoneFeature extends Feature<DefaultFeatureConfig> {
    public FarstoneFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<DefaultFeatureConfig> feature) {
        StructureWorldAccess worldIn = feature.getWorld();
        Random rand = feature.getRandom();
        BlockPos pos = feature.getOrigin();
        int o = 3 + rand.nextInt(4);
        float f = (float) (o + o + o) * 0.333F + 0.5F;
        for (BlockPos blockpos : BlockPos.iterate(pos.add(-o, -o - rand.nextInt(8), -o), pos.add(o, o, rand.nextBetween(2, o + 1)))) {
            if (blockpos.getSquaredDistance(pos) <= (double) (f * f) && worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && worldIn.getBlockState(blockpos.up()).getBlock() != ModBlocks.END_CORAL) {
                worldIn.setBlockState(blockpos, ModBlocks.FARSTONE.getDefaultState(), 2);
            }
        }
        return true;
    }
}
