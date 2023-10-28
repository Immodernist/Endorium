package com.endreborn.content;

import net.minecraft.block.*;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IncandescentLampBlock extends WallMountedBlock {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    protected static final VoxelShape NORTH_AABB = Block.createCuboidShape(5.0D, 5.0D, 8.0D, 11.0D, 11.0D, 15.0D);
    protected static final VoxelShape SOUTH_AABB = Block.createCuboidShape(5.0D, 5.0D, 1.0D, 11.0D, 11.0D, 8.0D);
    protected static final VoxelShape WEST_AABB = Block.createCuboidShape(8.0D, 5.0D, 5.0D, 15.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_AABB = Block.createCuboidShape(1.0D, 5.0D, 5.0D, 8.0D, 11.0D, 11.0D);
    protected static final VoxelShape UP_AABB_X = Block.createCuboidShape(5.0D, 1.0D, 5.0D, 11.0D, 8.0D, 11.0D);
    protected static final VoxelShape DOWN_AABB_X = Block.createCuboidShape(5.0D, 8.0D, 5.0D, 11.0D, 15.0D, 11.0D);

    public IncandescentLampBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACE, WallMountLocation.FLOOR)).with(FACING, Direction.NORTH)).with(LIT, false));
    }
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext p_55659_) {
        for(Direction direction : p_55659_.getPlacementDirections()) {
            BlockState blockstate;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockstate = this.getDefaultState().with(FACE, direction == Direction.UP ? WallMountLocation.CEILING : WallMountLocation.FLOOR).with(FACING, p_55659_.getHorizontalPlayerFacing()).with(LIT, Boolean.valueOf(p_55659_.getWorld().isReceivingRedstonePower(p_55659_.getBlockPos())));
            } else {
                blockstate = this.getDefaultState().with(FACE, WallMountLocation.WALL).with(FACING, direction.getOpposite()).with(LIT, Boolean.valueOf(p_55659_.getWorld().isReceivingRedstonePower(p_55659_.getBlockPos())));
            }

            if (blockstate.canPlaceAt(p_55659_.getWorld(), p_55659_.getBlockPos())) {
                return blockstate;
            }
        }
        return null;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((WallMountLocation)state.get(FACE)) {
            case FLOOR:
                return UP_AABB_X;
            case WALL:
                return switch ((Direction) state.get(FACING)) {
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
    public void neighborUpdate(BlockState p_55666_, World p_55667_, BlockPos p_55668_, Block p_55669_, BlockPos p_55670_, boolean p_55671_) {
        if (!p_55667_.isClient) {
            boolean flag = (Boolean)p_55666_.get(LIT);
            if (flag != p_55667_.isReceivingRedstonePower(p_55668_)) {
                if (flag) {
                    p_55667_.scheduleBlockTick(p_55668_, this, 24000);
                } else {
                    p_55667_.setBlockState(p_55668_, p_55666_.cycle(LIT), 2);
                }
            }
        }
    }
    public void scheduledTick(BlockState p_221937_, ServerWorld p_221938_, BlockPos p_221939_, Random p_221940_) {
        if ((Boolean)p_221937_.get(LIT) && !p_221938_.isReceivingRedstonePower(p_221939_)) {
            p_221938_.setBlockState(p_221939_, p_221937_.cycle(LIT), 2);
        }
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT, FACE, FACING});
    }
}
