package com.endreborn.content;

import com.endreborn.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OganaPlantBlock extends BushBlock implements net.minecraftforge.common.IForgeShearable{

    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 15.0D, 10.0D, 15.0D);

    public OganaPlantBlock(BlockBehaviour.Properties p_51021_) {
        super(p_51021_);
    }

    public VoxelShape getShape(BlockState p_52419_, BlockGetter p_52420_, BlockPos p_52421_, CollisionContext p_52422_) {
        return SHAPE;
    }
    public boolean canSurvive(BlockState p_154709_, LevelReader p_154710_, BlockPos p_154711_) {
        return Block.canSupportCenter(p_154710_, p_154711_.above(), Direction.DOWN) && p_154710_.getBlockState(p_154711_.above()).getBlock() == ModBlocks.END_MOSS_BLOCK.get() && !p_154710_.isWaterAt(p_154711_);
    }
}
