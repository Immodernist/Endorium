package com.endreborn.content;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class IncandescentLampBlock extends WallMountedBlock {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    protected static final VoxelShape NORTH_AABB = Block.createCuboidShape(5.0D, 5.0D, 9.0D, 11.0D, 11.0D, 15.0D);
    protected static final VoxelShape NORTH_LIT = Block.createCuboidShape(5.0D, 5.0D, 15.0D, 11.0D, 11.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.createCuboidShape(5.0D, 5.0D, 1.0D, 11.0D, 11.0D, 7.0D);
    protected static final VoxelShape SOUTH_LIT = Block.createCuboidShape(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 1.0D);
    protected static final VoxelShape WEST_AABB = Block.createCuboidShape(9.0D, 5.0D, 5.0D, 15.0D, 11.0D, 11.0D);
    protected static final VoxelShape WEST_LIT = Block.createCuboidShape(15.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_AABB = Block.createCuboidShape(1.0D, 5.0D, 5.0D, 7.0D, 11.0D, 11.0D);
    protected static final VoxelShape EAST_LIT = Block.createCuboidShape(0.0D, 5.0D, 5.0D, 1.0D, 11.0D, 11.0D);
    protected static final VoxelShape UP_AABB = Block.createCuboidShape(5.0D, 1.0D, 5.0D, 11.0D, 7.0D, 11.0D);
    protected static final VoxelShape UP_LIT = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 1.0D, 11.0D);
    protected static final VoxelShape DOWN_AABB = Block.createCuboidShape(5.0D, 9.0D, 5.0D, 11.0D, 15.0D, 11.0D);
    protected static final VoxelShape DOWN_LIT = Block.createCuboidShape(5.0D, 15.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    public IncandescentLampBlock(Settings p_49795_) {
        super(p_49795_);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACE, BlockFace.FLOOR).with(FACING, Direction.NORTH).with(LIT, Boolean.valueOf(false)));
    }

    public static final MapCodec<IncandescentLampBlock> f_302232_ = createCodec(IncandescentLampBlock::new);
    public MapCodec<IncandescentLampBlock> getCodec() {
        return f_302232_;
    }
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext p_55659_) {
        for(Direction direction : p_55659_.getPlacementDirections()) {
            BlockState blockstate;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockstate = this.getDefaultState().with(FACE, direction == Direction.UP ? BlockFace.CEILING : BlockFace.FLOOR);
            } else {
                blockstate = this.getDefaultState().with(FACE, BlockFace.WALL).with(FACING, direction.getOpposite());
            }
            if (blockstate.canPlaceAt(p_55659_.getWorld(), p_55659_.getBlockPos())) {
                return blockstate;
            }
        }
        return null;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        boolean lit = state.get(LIT);
        return switch ((BlockFace) state.get(FACE)) {
            case FLOOR -> lit ? UP_LIT : UP_AABB;
            case WALL -> switch ((Direction) state.get(FACING)) {
                case EAST -> lit ? EAST_LIT : EAST_AABB;
                case WEST -> lit ? WEST_LIT : WEST_AABB;
                case SOUTH -> lit ? SOUTH_LIT : SOUTH_AABB;
                default -> lit ? NORTH_LIT : NORTH_AABB;
            };
            default -> lit ? DOWN_LIT : DOWN_AABB;
        };
    }
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isReceivingRedstonePower(pos)) {
            if (world.isClient) {
                return ActionResult.SUCCESS;
            } else {
                BlockState blockState = this.togglePower(state, world, pos);
                float f = (Boolean) blockState.get(LIT) ? 0.6F : 0.5F;
                world.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, f);
                world.emitGameEvent(player, (Boolean) blockState.get(LIT) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
                return ActionResult.CONSUME;
            }
        }
        else {
            return ActionResult.PASS;
        }
    }

    public BlockState togglePower(BlockState state, World world, BlockPos pos) {
        state = (BlockState)state.cycle(LIT);
        world.setBlockState(pos, state, 3);
        return state;
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT, FACE, FACING});
    }
}
