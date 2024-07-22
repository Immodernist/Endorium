package com.endreborn.content;


import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
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

public class UpgradableShovelItem extends ShovelItem {
    private final boolean curious;
    private final boolean mysterious;

    public UpgradableShovelItem(ToolMaterial material, Item.Settings settings, boolean curious, boolean mysterious) {
        super(material, settings);
        this.curious = curious;
        this.mysterious = mysterious;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_shovel");
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (this.curious) {
            tooltip.add(Text.translatable("tooltip.shovel_curious").formatted(Formatting.GRAY));
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
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (context.getSide() == Direction.DOWN) {
            return ActionResult.PASS;
        } else {
            PlayerEntity playerEntity = context.getPlayer();
            BlockState blockState2 = (BlockState)PATH_STATES.get(blockState.getBlock());
            BlockState blockState3 = null;
            if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                blockState3 = blockState2;
            } else if (blockState.getBlock() instanceof CampfireBlock && (Boolean)blockState.get(CampfireBlock.LIT)) {
                if (!world.isClient()) {
                    world.syncWorldEvent((PlayerEntity)null, 1009, blockPos, 0);
                }

                CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                blockState3 = (BlockState)blockState.with(CampfireBlock.LIT, false);
            }

            if (blockState3 != null) {
                if (!world.isClient) {
                    world.setBlockState(blockPos, blockState3, 11);
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState3));
                    if (playerEntity != null) {
                        context.getStack().damage(this.curious ? 0 : 1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }

                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.PASS;
            }
        }
    }
}
