package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.concurrent.ThreadLocalRandom;

public class EndMossBlock extends Block implements BonemealableBlock {
    public EndMossBlock(BlockBehaviour.Properties p_153790_) {
        super(p_153790_);
    }

    public boolean isValidBonemealTarget(BlockGetter p_50897_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
        return p_50897_.getBlockState(p_50898_.above()).isAir();
    }
    public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_, BlockState p_220881_) {
        return true;
    }

    public void performBonemeal(ServerLevel worldIn, RandomSource rand, BlockPos pos, BlockState p_221536_) {
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