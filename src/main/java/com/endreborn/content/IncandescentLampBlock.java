package com.endreborn.content;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class IncandescentLampBlock extends FaceAttachedHorizontalDirectionalBlock {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    protected static final VoxelShape NORTH_AABB = Block.box(5.0D, 5.0D, 9.0D, 11.0D, 11.0D, 15.0D);
    protected static final VoxelShape NORTH_LIT = Block.box(5.0D, 5.0D, 15.0D, 11.0D, 11.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(5.0D, 5.0D, 1.0D, 11.0D, 11.0D, 7.0D);
    protected static final VoxelShape SOUTH_LIT = Block.box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 1.0D);
    protected static final VoxelShape WEST_AABB = Block.box(9.0D, 5.0D, 5.0D, 15.0D, 11.0D, 11.0D);
    protected static final VoxelShape WEST_LIT = Block.box(15.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_AABB = Block.box(1.0D, 5.0D, 5.0D, 7.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_LIT = Block.box(0.0D, 5.0D, 5.0D, 1.0D, 11.0D, 11.0D);
    protected static final VoxelShape UP_AABB = Block.box(5.0D, 1.0D, 5.0D, 11.0D, 7.0D, 11.0D);
    protected static final VoxelShape UP_LIT = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 1.0D, 11.0D);
    protected static final VoxelShape DOWN_AABB = Block.box(5.0D, 9.0D, 5.0D, 11.0D, 15.0D, 11.0D);
    protected static final VoxelShape DOWN_LIT = Block.box(5.0D, 15.0D, 5.0D, 11.0D, 16.0D, 11.0D);

    public IncandescentLampBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACE, AttachFace.FLOOR).setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
    }

    public VoxelShape getShape(BlockState p_54665_, BlockGetter p_54666_, BlockPos p_54667_, CollisionContext p_54668_) {
        boolean lit = p_54665_.getValue(LIT);
        return switch ((AttachFace) p_54665_.getValue(FACE)) {
            case FLOOR -> lit ? UP_LIT : UP_AABB;
            case WALL -> switch ((Direction) p_54665_.getValue(FACING)) {
                case EAST -> lit ? EAST_LIT : EAST_AABB;
                case WEST -> lit ? WEST_LIT : WEST_AABB;
                case SOUTH -> lit ? SOUTH_LIT : SOUTH_AABB;
                default -> lit ? NORTH_LIT : NORTH_AABB;
            };
            default -> lit ? DOWN_LIT : DOWN_AABB;
        };
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_55659_) {
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
    public InteractionResult use(BlockState p_54640_, Level p_54641_, BlockPos p_54642_, Player p_54643_, InteractionHand p_54644_, BlockHitResult p_54645_) {
        if(p_54641_.hasNeighborSignal(p_54642_) || p_54640_.getValue(LIT)) {
            if (p_54641_.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockState blockstate = this.pull(p_54640_, p_54641_, p_54642_);
                float f = blockstate.getValue(LIT) ? 0.6F : 0.5F;
                p_54641_.playSound((Player)null, p_54642_, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3F, f);
                p_54641_.gameEvent(p_54643_, blockstate.getValue(LIT) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, p_54642_);
                return InteractionResult.CONSUME;
            }
        }
        else {
            return InteractionResult.PASS;
        }
    }
    public BlockState pull(BlockState p_54677_, Level p_54678_, BlockPos p_54679_) {
        p_54677_ = p_54677_.cycle(LIT);
        p_54678_.setBlock(p_54679_, p_54677_, 3);
        return p_54677_;
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55673_) {
        p_55673_.add(FACE, FACING, LIT);
    }
}
