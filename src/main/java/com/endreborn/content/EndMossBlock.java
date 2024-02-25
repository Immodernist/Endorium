package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class EndMossBlock extends Block implements Fertilizable {
    public static final MapCodec<MossBlock> CODEC = createCodec(MossBlock::new);

    public MapCodec<MossBlock> getCodec() {
        return CODEC;
    }

    public EndMossBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.up()).isAir();
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        for (int j = 0; j < 8; ++j) {
            int decorator = rand.nextInt(5);
            BlockPos blockpos = pos.add(rand.nextInt(4), 0, rand.nextInt(4));
            if (worldIn.getBlockState(blockpos).getBlock() == this && worldIn.isAir(blockpos.up())) {
                if (decorator < 2) {
                    worldIn.setBlockState(blockpos.up(), ModBlocks.OGANA_PLANT.getDefaultState(), 2);
                }
                else {
                    worldIn.setBlockState(blockpos.up(), ModBlocks.OGANA_WEED.getDefaultState(), 2);
                }
            }
        }
    }
}

