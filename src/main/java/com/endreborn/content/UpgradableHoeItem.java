package com.endreborn.content;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Set;

public class UpgradableHoeItem extends HoeItem {
    private final boolean curious;
    private final boolean mysterious;
    private static final Set<Block> DIGGABLES = ImmutableSet.of(Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.HAY_BLOCK, Blocks.DRIED_KELP_BLOCK, Blocks.TARGET, Blocks.SHROOMLIGHT, Blocks.SPONGE, Blocks.WET_SPONGE, Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES);

    public UpgradableHoeItem(IItemTier p_41336_, int p_41337_, float p_41338_, Properties p_41339_, boolean curious, boolean mysterious) {
        super(p_41336_, p_41337_, p_41338_, p_41339_);
        this.curious = curious;
        this.mysterious = mysterious;
    }

    public TranslationTextComponent getName(ItemStack p_41458_) {
        return new TranslationTextComponent("item.endreborn.endorium_hoe");
    }

    public float getDestroySpeed(ItemStack p_150893_1_, BlockState state) {
        if (curious){
            return DIGGABLES.contains(state.getBlock()) || state.is(BlockTags.ICE) ? this.speed : 1.0F;
        } else {
            return DIGGABLES.contains(state.getBlock()) ? this.speed : 1.0F;
        }

    }
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        if (this.curious) {
            tooltip.add(new TranslationTextComponent("tooltip.hoe_curious").withStyle(TextFormatting.GRAY));
        }
        if (this.mysterious) {
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
