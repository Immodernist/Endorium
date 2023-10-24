package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MossPlantBlock extends PlantBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 15.0D, 10.0D, 15.0D);

    public MossPlantBlock(AbstractBlock.Settings p_51021_) {
        super(p_51021_);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean canPlantOnTop(BlockState state, BlockView world, BlockPos pos) {
        Block block = state.getBlock();
        return block == ModBlocks.END_MOSS || block == ModBlocks.END_MOSS_BLOCK;

    }
}

