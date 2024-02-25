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
    private final int sharpness;
    private final int flexibility;

    public UpgradableHoeItem(Tier p_41336_, int p_41337_, float p_41338_, Properties p_41339_, int sharpness, int flexibility) {
        super(p_41336_, p_41337_, p_41338_, p_41339_);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }
    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_hoe");
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_HOE) ? this.speed + this.sharpness * 2.4F: 1.0F;
    }
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.relic").withStyle(ChatFormatting.GRAY));
        if (this.sharpness > 0) {
            tooltip.add(Component.translatable("tooltip.hoe_sharpness").withStyle(ChatFormatting.DARK_GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Component.translatable("tooltip.uni_flexibility").withStyle(ChatFormatting.DARK_GRAY));
            tooltip.add(Component.translatable("tooltip.uni_flexibility_n").withStyle(ChatFormatting.DARK_GRAY));
        }
    }
    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(2 + this.flexibility, p_40996_, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }
}
