package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
public class UpgradableSwordItem extends SwordItem {
    private final boolean curious;
    private final boolean mysterious;

    public UpgradableSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_, boolean curious, boolean mysterious) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
        this.curious = curious;
        this.mysterious = mysterious;
    }

    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.endreborn.endorium_sword");
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (this.curious) {
            tooltip.add(Component.translatable("tooltip.sword_curious").withStyle(ChatFormatting.GRAY));
        }
        if (this.mysterious){
            tooltip.add(Component.translatable("tooltip.sword_mysterious").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("tooltip.sword_mysterious_n").withStyle(ChatFormatting.GRAY));
        }
    }

    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(this.mysterious ? 2 : 1, p_40996_, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack p_150893_1_, BlockState p_150893_2_) {
        if (p_150893_2_.is(Blocks.COBWEB)) {
            return this.curious ? 20 : 15;
        } else {
            Material material = p_150893_2_.getMaterial();
            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !p_150893_2_.is(BlockTags.LEAVES) && material != Material.VEGETABLE ? 1.0F : this.curious ? 2F : 1.5F;
        }
    }
    @Override
    public boolean mineBlock(ItemStack p_43282_, Level p_43283_, BlockState p_43284_, BlockPos p_43285_, LivingEntity p_43286_) {
        if (p_43284_.getDestroySpeed(p_43283_, p_43285_) != 0.0F) {
            p_43282_.hurtAndBreak(this.mysterious ? 1 : 2, p_43286_, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
        return true;
    }
}
