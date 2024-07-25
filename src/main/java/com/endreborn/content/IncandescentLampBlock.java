package com.endreborn.content;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class IncandescentLampBlock extends HorizontalFaceBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    protected static final VoxelShape NORTH_AABB = Block.box(5.0D, 5.0D, 8.0D, 11.0D, 11.0D, 15.0D);
    protected static final VoxelShape NORTH_LIT = Block.box(5.0D, 5.0D, 13.0D, 11.0D, 11.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(5.0D, 5.0D, 1.0D, 11.0D, 11.0D, 8.0D);
    protected static final VoxelShape SOUTH_LIT = Block.box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 3.0D);
    protected static final VoxelShape WEST_AABB = Block.box(8.0D, 5.0D, 5.0D, 15.0D, 11.0D, 11.0D);
    protected static final VoxelShape WEST_LIT = Block.box(13.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_AABB = Block.box(1.0D, 5.0D, 5.0D, 8.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_LIT = Block.box(0.0D, 5.0D, 5.0D, 3.0D, 11.0D, 11.0D);
    protected static final VoxelShape UP_AABB = Block.box(5.0D, 1.0D, 5.0D, 11.0D, 8.0D, 11.0D);
    protected static final VoxelShape UP_LIT = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 3.0D, 11.0D);
    protected static final VoxelShape DOWN_AABB = Block.box(5.0D, 8.0D, 5.0D, 11.0D, 15.0D, 11.0D);
    protected static final VoxelShape DOWN_LIT = Block.box(5.0D, 13.0D, 5.0D, 11.0D, 16.0D, 11.0D);

    public IncandescentLampBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACE, AttachFace.FLOOR).setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
    }

    public VoxelShape getShape(BlockState p_54665_, IBlockReader p_54666_, BlockPos p_54667_, ISelectionContext p_54668_) {
        boolean flag = p_54665_.getValue(LIT);
        Direction direction = p_54665_.getValue(FACING);
        switch((AttachFace)p_54665_.getValue(FACE)) {
            case FLOOR:
                return flag ? UP_LIT : UP_AABB;
            case WALL:
                switch(direction) {
                    case EAST:
                        return flag ? EAST_LIT : EAST_AABB;
                    case WEST:
                        return flag ? WEST_LIT : WEST_AABB;
                    case SOUTH:
                        return flag ? SOUTH_LIT : SOUTH_AABB;
                    case NORTH:
                    default:
                        return flag ? NORTH_LIT : NORTH_AABB;
                }

            default:
                return flag ? DOWN_LIT : DOWN_AABB;
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext p_55659_) {
        for(Direction direction : p_55659_.getNearestLookingDirections()) {
            BlockState blockstate;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockstate = this.defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR);
            } else {
                blockstate = this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite());
            }
            if (blockstate.canSurvive(p_55659_.getLevel(), p_55659_.getClickedPos())) {
                return blockstate;
            }
        }
        return null;
    }

    public ActionResultType use(BlockState p_54640_, World p_54641_, BlockPos p_54642_, PlayerEntity p_54643_, Hand p_54644_, BlockRayTraceResult p_54645_) {
        if(p_54641_.hasNeighborSignal(p_54642_)) {
            if (p_54641_.isClientSide) {
                return ActionResultType.SUCCESS;
            } else {
                BlockState blockstate = this.pull(p_54640_, p_54641_, p_54642_);
                float f = blockstate.getValue(LIT) ? 0.6F : 0.5F;
                p_54641_.playSound((PlayerEntity)null, p_54642_, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, f);
                return ActionResultType.CONSUME;
            }
        }
        else {
            return ActionResultType.PASS;
        }
    }

    public BlockState pull(BlockState p_54677_, World p_54678_, BlockPos p_54679_) {
        p_54677_ = p_54677_.cycle(LIT);
        p_54678_.setBlock(p_54679_, p_54677_, 3);
        return p_54677_;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_55673_) {
        p_55673_.add(FACE, FACING, LIT);
    }
}
