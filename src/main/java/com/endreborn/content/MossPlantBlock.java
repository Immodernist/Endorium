package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MossPlantBlock extends BushBlock implements net.minecraftforge.common.IForgeShearable{

    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 15.0D, 10.0D, 15.0D);

    public MossPlantBlock(Properties p_51021_) {
        super(p_51021_);
    }

    public VoxelShape getShape(BlockState p_52419_, BlockGetter p_52420_, BlockPos p_52421_, CollisionContext p_52422_) {
        return SHAPE;
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == ModBlocks.END_MOSS.get() || block == ModBlocks.END_MOSS_BLOCK.get();

    }
}

