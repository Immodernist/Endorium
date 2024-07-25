package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.List;

public class UpgradablePickaxeItem extends PickaxeItem {

    private final boolean curious;
    private final boolean mysterious;

    public UpgradablePickaxeItem(IItemTier p_42961_, int p_42962_, float p_42963_, Properties p_42964_, boolean curious, boolean mysterious) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
        this.curious = curious;
        this.mysterious = mysterious;
    }


    public TranslationTextComponent getName(ItemStack p_41458_) {
        return new TranslationTextComponent("item.endreborn.endorium_pickaxe");
    }

    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(this.mysterious ? 3 : 2, p_40996_, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(p_40996_.getUsedItemHand());
        });
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        if (this.curious) {
            tooltip.add(new TranslationTextComponent("tooltip.pickaxe_curious").withStyle(TextFormatting.GRAY));
        }
        if (this.mysterious) {
            tooltip.add(new TranslationTextComponent("tooltip.uni_mysterious").withStyle(TextFormatting.GRAY));
            tooltip.add(new TranslationTextComponent("tooltip.uni_mysterious_n").withStyle(TextFormatting.GRAY));
        }
    }
    public float getDestroySpeed(ItemStack item, BlockState state) {
        Material material = state.getMaterial();
        if (curious){
            return !(state.is(Tags.Blocks.GRAVEL) || state.is(Tags.Blocks.SAND)) && material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(item, state) : this.speed;
        } else {
            return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(item, state) : this.speed;
        }
    }
}
