package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
public class UpgradablePickaxeItem extends PickaxeItem {
    private final int sharpness;
    private final int flexibility;

    public UpgradablePickaxeItem(Tier p_42961_, Properties p_42964_, int sharpness, int flexibility) {
        super(p_42961_, p_42964_);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }

    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_pickaxe");
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext text, List<Component> tooltip, TooltipFlag flag) {
        if (this.sharpness > 0) {
            tooltip.add(Component.translatable("tooltip.pickaxe_sharpness").withStyle(ChatFormatting.GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Component.translatable("tooltip.uni_flexibility").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("tooltip.uni_flexibility_n").withStyle(ChatFormatting.GRAY));
        }
    }
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Tool tool = stack.get(DataComponents.TOOL);
        if (sharpness > 0) {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(Blocks.GRAVEL) || state.is(Blocks.SAND) ? 8.0F : 1.0F;
        }
        else {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) ? 8.0F : 1.0F;
        }
    }
    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(2 + this.flexibility, p_40996_, EquipmentSlot.MAINHAND);
        return true;
    }
}
