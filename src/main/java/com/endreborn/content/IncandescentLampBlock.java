package com.endreborn.content;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class IncandescentLampBlock extends FaceAttachedHorizontalDirectionalBlock {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    protected static final VoxelShape NORTH_AABB = Block.box(5.0D, 5.0D, 8.0D, 11.0D, 11.0D, 15.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(5.0D, 5.0D, 1.0D, 11.0D, 11.0D, 8.0D);
    protected static final VoxelShape WEST_AABB = Block.box(8.0D, 5.0D, 5.0D, 15.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_AABB = Block.box(1.0D, 5.0D, 5.0D, 8.0D, 11.0D, 11.0D);
    protected static final VoxelShape UP_AABB_X = Block.box(5.0D, 1.0D, 5.0D, 11.0D, 8.0D, 11.0D);
    protected static final VoxelShape DOWN_AABB_X = Block.box(5.0D, 8.0D, 5.0D, 11.0D, 15.0D, 11.0D);

    public IncandescentLampBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACE, AttachFace.FLOOR).setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
    }

    public VoxelShape getShape(BlockState p_54665_, BlockGetter p_54666_, BlockPos p_54667_, CollisionContext p_54668_) {
        switch ((AttachFace)p_54665_.getValue(FACE)) {
            case FLOOR:
                return UP_AABB_X;
            case WALL:
                return switch ((Direction) p_54665_.getValue(FACING)) {
                    case EAST -> EAST_AABB;
                    case WEST -> WEST_AABB;
                    case SOUTH -> SOUTH_AABB;
                    default -> NORTH_AABB;
                };
            case CEILING:
            default:
                return DOWN_AABB_X;
        }
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_55659_) {
        for(Direction direction : p_55659_.getNearestLookingDirections()) {
            BlockState blockstate;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockstate = this.defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, p_55659_.getHorizontalDirection()).setValue(LIT, Boolean.valueOf(p_55659_.getLevel().hasNeighborSignal(p_55659_.getClickedPos())));
            } else {
                blockstate = this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite()).setValue(LIT, Boolean.valueOf(p_55659_.getLevel().hasNeighborSignal(p_55659_.getClickedPos())));
            }

            if (blockstate.canSurvive(p_55659_.getLevel(), p_55659_.getClickedPos())) {
                return blockstate;
            }
        }
        return null;
    }

    public void neighborChanged(BlockState p_55666_, Level p_55667_, BlockPos p_55668_, Block p_55669_, BlockPos p_55670_, boolean p_55671_) {
        if (!p_55667_.isClientSide) {
            boolean flag = p_55666_.getValue(LIT);
            if (flag != p_55667_.hasNeighborSignal(p_55668_)) {
                if (flag) {
                    p_55667_.scheduleTick(p_55668_, this, 24000);
                } else {
                    p_55667_.setBlock(p_55668_, p_55666_.cycle(LIT), 2);
                }
            }
        }
    }

    public void tick(BlockState p_221937_, ServerLevel p_221938_, BlockPos p_221939_, RandomSource p_221940_) {
        if (p_221937_.getValue(LIT) && !p_221938_.hasNeighborSignal(p_221939_)) {
            p_221938_.setBlock(p_221939_, p_221937_.cycle(LIT), 2);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55673_) {
        p_55673_.add(FACE, FACING, LIT);
    }
}
