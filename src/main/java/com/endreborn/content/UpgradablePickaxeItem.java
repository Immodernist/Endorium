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
    private final int sharpness;
    private final int flexibility;
    public UpgradablePickaxeItem(ToolMaterial material, Item.Settings settings, int sharpness, int flexibility) {
        super(material, settings);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_pickaxe");
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(2 + this.flexibility, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (this.sharpness > 0) {
            tooltip.add(Text.translatable("tooltip.pickaxe_sharpness").formatted(Formatting.GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Text.translatable("tooltip.uni_flexibility").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.uni_flexibility_n").formatted(Formatting.GRAY));
        }
    }
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        if (sharpness > 0) {
            return state.isIn(BlockTags.PICKAXE_MINEABLE) || state.isOf(Blocks.GRAVEL) || state.isOf(Blocks.SAND) ? 8.0F : 1.0F;
        } else {
            return state.isIn(BlockTags.PICKAXE_MINEABLE) ? 8.0F : 1.0F;
        }
    }
}
