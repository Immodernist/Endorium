package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;
import java.util.List;
public class UpgradablePickaxeItem extends PickaxeItem {
    private final int sharpness;
    private final int flexibility;
    public UpgradablePickaxeItem(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_, int sharpness, int flexibility) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }
    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_pickaxe");
    }

    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(2 + this.flexibility, p_40996_, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.relic").withStyle(ChatFormatting.GRAY));
        if (this.sharpness > 0) {
            tooltip.add(Component.translatable("tooltip.pickaxe_sharpness").withStyle(ChatFormatting.DARK_GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Component.translatable("tooltip.uni_flexibility").withStyle(ChatFormatting.DARK_GRAY));
            tooltip.add(Component.translatable("tooltip.uni_flexibility_n").withStyle(ChatFormatting.DARK_GRAY));
        }
    }
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (sharpness > 0) {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(Tags.Blocks.GRAVEL) || state.is(Tags.Blocks.SAND) ? this.speed : 1.0F;
        }
        else {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) ? this.speed : 1.0F;
        }
    }
}
