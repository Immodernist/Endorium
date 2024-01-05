package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MossPlantBlock extends BushBlock{
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 15.0D, 10.0D, 15.0D);
    public static final MapCodec<MossPlantBlock> f_302232_ = m_306223_(MossPlantBlock::new);
    public MapCodec<MossPlantBlock> m_304657_() {
        return f_302232_;
    }
    public MossPlantBlock(Properties p_51021_) {
        super(p_51021_);
    }

    public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
        Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(ModBlocks.END_MOSS.get()) || state.is(ModBlocks.END_MOSS_BLOCK.get()) || super.mayPlaceOn(state, worldIn, pos);
    }
}

