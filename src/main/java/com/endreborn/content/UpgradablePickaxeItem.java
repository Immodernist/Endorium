package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

import java.util.List;
public class UpgradablePickaxeItem extends PickaxeItem {
    private final boolean curious;
    private final boolean mysterious;

    public UpgradablePickaxeItem(Tier p_42961_, Properties p_42964_, boolean curious, boolean mysterious) {
        super(p_42961_, p_42964_);
        this.curious = curious;
        this.mysterious = mysterious;
    }

    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_pickaxe");
    }
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Item.TooltipContext text, List<Component> tooltip, TooltipFlag flag) {
        if (this.curious) {
            tooltip.add(Component.translatable("tooltip.pickaxe_curious").withStyle(ChatFormatting.GRAY));
        }
        if (this.mysterious){
            tooltip.add(Component.translatable("tooltip.uni_mysterious").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("tooltip.uni_mysterious_n").withStyle(ChatFormatting.GRAY));
        }
    }
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (curious) {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(Tags.Blocks.GRAVEL) || state.is(Tags.Blocks.SAND) ? 8.0F : 1.0F;
        }
        else {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) ? 9.6F : 1.0F;
        }
    }
    @Override
    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(this.mysterious ? 1 : 0, p_40996_, EquipmentSlot.MAINHAND);
        return true;
    }
}
