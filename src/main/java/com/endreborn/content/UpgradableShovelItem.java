package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class UpgradableShovelItem extends ShovelItem {
    private final boolean curious;
    private final boolean mysterious;

    public UpgradableShovelItem(IItemTier p_43114_, float p_43115_, float p_43116_, Properties p_43117_, boolean curious, boolean mysterious) {
        super(p_43114_, p_43115_, p_43116_, p_43117_);
        this.curious = curious;
        this.mysterious = mysterious;
    }

    public TranslationTextComponent getName(ItemStack p_41458_) {
        return new TranslationTextComponent("item.endreborn.endorium_shovel");
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        if (this.curious) {
            tooltip.add(new TranslationTextComponent("tooltip.shovel_curious").withStyle(TextFormatting.GRAY));
        }
        if (this.mysterious) {
            tooltip.add(new TranslationTextComponent("tooltip.uni_mysterious").withStyle(TextFormatting.GRAY));
            tooltip.add(new TranslationTextComponent("tooltip.uni_mysterious_n").withStyle(TextFormatting.GRAY));
        }
    }

    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(this.mysterious ? 3 : 2, p_40996_, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(p_40996_.getUsedItemHand());
        });
        return true;
    }

    @Override
    public ActionResultType useOn(ItemUseContext p_195939_1_) {
        World world = p_195939_1_.getLevel();
        BlockPos blockpos = p_195939_1_.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (p_195939_1_.getClickedFace() == Direction.DOWN) {
            return ActionResultType.PASS;
        } else {
            PlayerEntity playerentity = p_195939_1_.getPlayer();
            BlockState blockstate1 = blockstate.getToolModifiedState(world, blockpos, playerentity, p_195939_1_.getItemInHand(), net.minecraftforge.common.ToolType.SHOVEL);
            BlockState blockstate2 = null;
            if (blockstate1 != null && world.isEmptyBlock(blockpos.above())) {
                world.playSound(playerentity, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                blockstate2 = blockstate1;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                if (!world.isClientSide()) {
                    world.levelEvent((PlayerEntity)null, 1009, blockpos, 0);
                }

                CampfireBlock.dowse(world, blockpos, blockstate);
                blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
            }

            if (blockstate2 != null) {
                if (!world.isClientSide) {
                    world.setBlock(blockpos, blockstate2, 11);
                    if (playerentity != null) {
                        p_195939_1_.getItemInHand().hurtAndBreak(this.curious ? 0 : 1, playerentity, (p_220041_1_) -> {
                            p_220041_1_.broadcastBreakEvent(p_195939_1_.getHand());
                        });
                    }
                }

                return ActionResultType.sidedSuccess(world.isClientSide);
            } else {
                return ActionResultType.PASS;
            }
        }
    }
}
