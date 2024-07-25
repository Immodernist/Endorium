package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EndMossBlock extends Block implements IGrowable {
    public EndMossBlock(AbstractBlock.Properties p_153790_) {
        super(p_153790_);
    }

    public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return p_176473_1_.getBlockState(p_176473_2_.above()).isAir();
    }


    public boolean isBonemealSuccess(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, BlockState p_180670_4_) {
        return true;
    }

    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState p_221536_) {
        for (int j = 0; j < 8; ++j) {
            int decorator = ThreadLocalRandom.current().nextInt(5);
            BlockPos blockpos = pos.offset(ThreadLocalRandom.current().nextInt(-2,2), 0, ThreadLocalRandom.current().nextInt(-2,2));
            if (worldIn.getBlockState(blockpos).getBlock() == this && worldIn.isEmptyBlock(blockpos.above())) {
                if (decorator == 1) {
                    worldIn.setBlock(blockpos.above(), ModBlocks.OGANA_PLANT.get().defaultBlockState(), 2);
                } else {
                    worldIn.setBlock(blockpos.above(), ModBlocks.OGANA_WEED.get().defaultBlockState(), 2);
                }
            }
        }
    }
}