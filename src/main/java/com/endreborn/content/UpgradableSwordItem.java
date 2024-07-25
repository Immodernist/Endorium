package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;
public class UpgradableSwordItem extends SwordItem {
    private final boolean curious;
    private final boolean mysterious;

    public UpgradableSwordItem(IItemTier p_43269_, int p_43270_, float p_43271_, Properties p_43272_, boolean curious, boolean mysterious) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
        this.curious = curious;
        this.mysterious = mysterious;
    }

    public TranslationTextComponent getName(ItemStack p_41458_) {
        return new TranslationTextComponent("item.endreborn.endorium_sword");
    }
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        if (this.curious) {
            tooltip.add(new TranslationTextComponent("tooltip.sword_curious").withStyle(TextFormatting.GRAY));
        }
        if (this.mysterious) {
            tooltip.add(new TranslationTextComponent("tooltip.sword_mysterious").withStyle(TextFormatting.GRAY));
            tooltip.add(new TranslationTextComponent("tooltip.sword_mysterious_n").withStyle(TextFormatting.GRAY));
        }
    }
    public boolean hurtEnemy(ItemStack p_40994_, LivingEntity p_40995_, LivingEntity p_40996_) {
        p_40994_.hurtAndBreak(this.mysterious ? 2 : 1, p_40996_, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(p_40996_.getUsedItemHand());
        });
        return true;
    }
    @Override
    public float getDestroySpeed(ItemStack p_150893_1_, BlockState p_150893_2_) {
        if (p_150893_2_.is(Blocks.COBWEB)) {
            return this.curious ? 20 : 15;
        } else {
            Material material = p_150893_2_.getMaterial();
            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && material != Material.CORAL && !p_150893_2_.is(BlockTags.LEAVES) && material != Material.VEGETABLE ? 1.0F : this.curious ? 2F : 1.5F;
        }
    }
    public boolean mineBlock(ItemStack p_179218_1_, World p_179218_2_, BlockState p_179218_3_, BlockPos p_179218_4_, LivingEntity p_179218_5_) {
        if (p_179218_3_.getDestroySpeed(p_179218_2_, p_179218_4_) != 0.0F) {
            p_179218_1_.hurtAndBreak(this.mysterious ? 1 : 2, p_179218_5_, (p_220044_0_) -> {
                p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }
}
