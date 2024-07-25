package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

public class MossPlantBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    public MossPlantBlock(Properties p_51021_) {
        super(p_51021_);
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        Vector3d vec3 = p_220053_1_.getOffset(p_220053_2_, p_220053_3_);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.is(ModBlocks.END_MOSS.get()) || state.is(ModBlocks.END_MOSS_BLOCK.get()) || super.mayPlaceOn(state, worldIn, pos);
    }
    public AbstractBlock.OffsetType getOffsetType() {
        return OffsetType.XZ;
    }
}

