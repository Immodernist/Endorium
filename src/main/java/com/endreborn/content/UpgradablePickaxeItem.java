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
    private final boolean curious;
    private final boolean mysterious;

    public UpgradablePickaxeItem(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_, boolean curious, boolean mysterious) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
        this.curious = curious;
        this.mysterious = mysterious;
    }

    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_pickaxe");
    }

    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(this.mysterious ? 3 : 2, p_40996_, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
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
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(Tags.Blocks.GRAVEL) || state.is(Tags.Blocks.SAND) ? this.speed : 1.0F;
        } else {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) ? this.speed : 1.0F;
        }
    }
}
