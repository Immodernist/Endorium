package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class UpgradableHoeItem extends HoeItem {
    private final boolean curious;
    private final boolean mysterious;

    public UpgradableHoeItem(Tier p_41336_, int p_41337_, float p_41338_, Properties p_41339_, boolean curious, boolean mysterious) {
        super(p_41336_, p_41337_, p_41338_, p_41339_);
        this.curious = curious;
        this.mysterious = mysterious;
    }

    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_hoe");
    }

    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (curious){
            return (state.is(BlockTags.MINEABLE_WITH_HOE) || state.is(BlockTags.ICE)) ? this.speed: 1.0F;
        }
        else {
            return (state.is(BlockTags.MINEABLE_WITH_HOE)) ? this.speed : 1.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (this.curious) {
            tooltip.add(Component.translatable("tooltip.hoe_curious").withStyle(ChatFormatting.GRAY));
        }
        if (this.mysterious){
            tooltip.add(Component.translatable("tooltip.uni_mysterious").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("tooltip.uni_mysterious_n").withStyle(ChatFormatting.GRAY));
        }
    }

    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(this.mysterious ? 3 : 2, p_40996_, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }
}
