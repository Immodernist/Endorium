package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
public class UpgradableSwordItem extends SwordItem {
    private final int sharpness;
    private final int flexibility;

    public UpgradableSwordItem(Tier p_43269_, Properties p_43272_, int sharpness, int flexibility) {
        super(p_43269_, p_43272_);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }

    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_sword");
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext text, List<Component> tooltip, TooltipFlag flag) {
        if (this.sharpness > 0) {
            tooltip.add(Component.translatable("tooltip.sword_sharpness").withStyle(ChatFormatting.GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Component.translatable("tooltip.sword_flexibility").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("tooltip.sword_flexibility_n").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15 + this.sharpness*5;
        } else {
            return state.is(BlockTags.SWORD_EFFICIENT) ? 1.5F + (float) this.sharpness /2: 1.0F;
        }
    }

    @Override
    public boolean mineBlock(ItemStack p_43282_, Level p_43283_, BlockState p_43284_, BlockPos p_43285_, LivingEntity p_43286_) {
        if (p_43284_.getDestroySpeed(p_43283_, p_43285_) != 0.0F) {
            p_43282_.hurtAndBreak(2 - this.flexibility, p_43286_, EquipmentSlot.MAINHAND);
        }
        return true;
    }

    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(1 + this.flexibility, p_40996_, EquipmentSlot.MAINHAND);
        return true;
    }
}
