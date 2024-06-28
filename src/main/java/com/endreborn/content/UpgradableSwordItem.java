package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class UpgradableSwordItem extends SwordItem {

    private final int sharpness;
    private final int flexibility;

    public UpgradableSwordItem(ToolMaterial material, Item.Settings settings, int sharpness, int flexibility) {
        super(material, settings);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_sword");
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (this.sharpness > 0) {
            tooltip.add(Text.translatable("tooltip.sword_sharpness").formatted(Formatting.GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Text.translatable("tooltip.sword_flexibility").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.sword_flexibility_n").formatted(Formatting.GRAY));
        }
    }
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1 + this.flexibility, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 15 + this.sharpness*5;
        } else {
            return state.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5F + (float) this.sharpness /2: 1.0F;
        }
    }
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0F) {
            stack.damage(2 - this.flexibility, miner, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}
