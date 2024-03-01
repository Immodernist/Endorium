package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class EndMossBlock extends Block implements BonemealableBlock {
    public EndMossBlock(BlockBehaviour.Properties p_153790_) {
        super(p_153790_);
    }

    public boolean isValidBonemealTarget(LevelReader p_256559_, BlockPos p_50898_, BlockState p_50899_) {
        return p_256559_.getBlockState(p_50898_.above()).isAir();
    }

    public boolean isBonemealSuccess(Level p_221538_, RandomSource p_221539_, BlockPos p_221540_, BlockState p_221541_) {
        return true;
    }

    public void performBonemeal(ServerLevel worldIn, RandomSource rand, BlockPos pos, BlockState p_221536_) {
        for (int j = 0; j < 8; ++j) {
            int decorator = rand.nextInt(5);
            BlockPos blockpos = pos.offset(rand.nextInt(-2,2), 0, rand.nextInt(-2,2));
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