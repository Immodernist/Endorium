package com.endreborn.content;

import com.google.common.collect.BiMap;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.Optional;

public class UpgradableAxeItem extends AxeItem {
    private final boolean curious;
    private final boolean mysterious;

    public UpgradableAxeItem(ToolMaterial material, Item.Settings settings, boolean curious, boolean mysterious) {
        super(material, settings);

        this.curious = curious;
        this.mysterious = mysterious;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_axe");
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);
        Optional<BlockState> optional = this.getStrippedState(blockState);
        Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(blockState);
        Optional<BlockState> optional3 = Optional.ofNullable((Block)((BiMap) HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(blockState.getBlock())).map((block) -> {
            return block.getStateWithProperties(blockState);
        });
        ItemStack itemStack = context.getStack();
        Optional<BlockState> optional4 = Optional.empty();
        if (optional.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            optional4 = optional;
        } else if (optional2.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3005, blockPos, 0);
            optional4 = optional2;
        } else if (optional3.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3004, blockPos, 0);
            optional4 = optional3;
        }

        if (optional4.isPresent()) {
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
            }

            world.setBlockState(blockPos, (BlockState)optional4.get(), 11);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, (BlockState)optional4.get()));
            if (playerEntity != null) {
                itemStack.damage(this.curious ? 0 : 1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
            }

            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (this.curious) {
            tooltip.add(Text.translatable("tooltip.axe_curious").formatted(Formatting.GRAY));
        }
        if (this.mysterious){
            tooltip.add(Text.translatable("tooltip.uni_mysterious").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.uni_mysterious_n").formatted(Formatting.GRAY));
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(this.mysterious ? 1 : 0, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable((Block)STRIPPED_BLOCKS.get(state.getBlock())).map((block) -> {
            return (BlockState)block.getDefaultState().with(PillarBlock.AXIS, (Direction.Axis)state.get(PillarBlock.AXIS));
        });
    }
}
