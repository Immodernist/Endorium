package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
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
public class UpgradableAxeItem extends AxeItem {
    private final boolean curious;
    private final boolean mysterious;

    public UpgradableAxeItem(IItemTier p_40521_, float p_40522_, float p_40523_, Properties p_40524_, boolean curious, boolean mysterious) {
        super(p_40521_, p_40522_, p_40523_, p_40524_);
        this.curious = curious;
        this.mysterious = mysterious;
    }

    public TranslationTextComponent getName(ItemStack p_41458_) {
        return new TranslationTextComponent("item.endreborn.endorium_axe");
    }

    @Override
    public ActionResultType useOn(ItemUseContext p_195939_1_) {
        World world = p_195939_1_.getLevel();
        BlockPos blockpos = p_195939_1_.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState block = blockstate.getToolModifiedState(world, blockpos, p_195939_1_.getPlayer(), p_195939_1_.getItemInHand(), net.minecraftforge.common.ToolType.AXE);
        if (block != null) {
            PlayerEntity playerentity = p_195939_1_.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isClientSide) {
                world.setBlock(blockpos, block, 11);
                if (playerentity != null) {
                    p_195939_1_.getItemInHand().hurtAndBreak(this.curious ? 0 : 1, playerentity, (p_220040_1_) -> {
                        p_220040_1_.broadcastBreakEvent(p_195939_1_.getHand());
                    });
                }
            }

            return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
            return ActionResultType.PASS;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        if (this.curious) {
            tooltip.add(new TranslationTextComponent("tooltip.axe_curious").withStyle(TextFormatting.GRAY));
        }
        if (this.mysterious){
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
}
