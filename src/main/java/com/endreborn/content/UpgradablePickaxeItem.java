package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class UpgradablePickaxeItem extends PickaxeItem {
    private final boolean curious;
    private final boolean mysterious;
    public UpgradablePickaxeItem(ToolMaterial material, Item.Settings settings, boolean curious, boolean mysterious) {
        super(material, settings);
        this.curious = curious;
        this.mysterious = mysterious;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_pickaxe");
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(this.mysterious ? 1 : 0, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (this.curious) {
            tooltip.add(Text.translatable("tooltip.pickaxe_curious").formatted(Formatting.GRAY));
        }
        if (this.mysterious){
            tooltip.add(Text.translatable("tooltip.uni_mysterious").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.uni_mysterious_n").formatted(Formatting.GRAY));
        }
    }
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        if (curious) {
            return state.isIn(BlockTags.PICKAXE_MINEABLE) || state.isOf(Blocks.GRAVEL) || state.isOf(Blocks.SAND) ? this.getMaterial().getMiningSpeedMultiplier() : 1.0F;
        } else {
            return state.isIn(BlockTags.PICKAXE_MINEABLE) ? this.getMaterial().getMiningSpeedMultiplier() : 1.0F;
        }
    }
}
