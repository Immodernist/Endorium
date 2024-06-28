package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class UpgradableHoeItem extends HoeItem {
    private final int sharpness;
    private final int flexibility;
    public UpgradableHoeItem(ToolMaterial material, Item.Settings settings, int sharpness, int flexibility) {
        super(material, settings);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_hoe");
    }

    public float getMiningSpeed(ItemStack stack, BlockState state) {
        if (sharpness == 1){
            return (state.isIn(BlockTags.HOE_MINEABLE) || state.isIn(BlockTags.ICE)) ? 8.0F : 1.0F;
        }
        else {
            return (state.isIn(BlockTags.HOE_MINEABLE)) ? 8.0F : 1.0F;
        }
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (this.sharpness > 0) {
            tooltip.add(Text.translatable("tooltip.hoe_sharpness").formatted(Formatting.GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Text.translatable("tooltip.uni_flexibility").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.uni_flexibility_n").formatted(Formatting.GRAY));
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(2 + this.flexibility, attacker, EquipmentSlot.MAINHAND);
        return true;
    }
}
