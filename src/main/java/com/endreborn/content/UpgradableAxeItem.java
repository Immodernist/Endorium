package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
public class UpgradableAxeItem extends AxeItem {
    private final int sharpness;
    private final int flexibility;

    public UpgradableAxeItem(Tier p_40521_, Properties p_40524_, int sharpness, int flexibility) {
        super(p_40521_, p_40524_);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }

    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_axe");
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        if (playerHasShieldUseIntent(pContext)) {
            return InteractionResult.PASS;
        } else {
            Optional<BlockState> optional = this.evaluateNewBlockState(level, blockpos, player, level.getBlockState(blockpos), pContext);
            if (optional.isEmpty()) {
                return InteractionResult.PASS;
            } else {
                ItemStack itemstack = pContext.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }

                level.setBlock(blockpos, (BlockState)optional.get(), 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, (BlockState)optional.get()));
                if (player != null) {
                    itemstack.hurtAndBreak(1 - this.sharpness, player, LivingEntity.getSlotForHand(pContext.getHand()));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
    }
    private Optional<BlockState> evaluateNewBlockState(Level pLevel, BlockPos pPos, @Nullable Player pPlayer, BlockState pState, UseOnContext p_40529_) {
        Optional<BlockState> optional = Optional.ofNullable(pState.getToolModifiedState(p_40529_, ItemAbilities.AXE_STRIP, false));
        if (optional.isPresent()) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional1 = Optional.ofNullable(pState.getToolModifiedState(p_40529_, ItemAbilities.AXE_SCRAPE, false));
            if (optional1.isPresent()) {
                pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                pLevel.levelEvent(pPlayer, 3005, pPos, 0);
                return optional1;
            } else {
                Optional<BlockState> optional2 = Optional.ofNullable(pState.getToolModifiedState(p_40529_, ItemAbilities.AXE_WAX_OFF, false));
                if (optional2.isPresent()) {
                    pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                    pLevel.levelEvent(pPlayer, 3004, pPos, 0);
                    return optional2;
                } else {
                    return Optional.empty();
                }
            }
        }
    }
    private static boolean playerHasShieldUseIntent(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        return pContext.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext text, List<Component> tooltip, TooltipFlag flag) {
        if (this.sharpness > 0) {
            tooltip.add(Component.translatable("tooltip.axe_sharpness").withStyle(ChatFormatting.GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Component.translatable("tooltip.uni_flexibility").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("tooltip.uni_flexibility_n").withStyle(ChatFormatting.GRAY));
        }
    }
    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(2 + this.flexibility, p_40996_, EquipmentSlot.MAINHAND);
        return true;
    }
}
