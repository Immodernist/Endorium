package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UpgradablePickaxeItem extends PickaxeItem {
    private final int sharpness;
    private final int flexibility;
    public UpgradablePickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings, int sharpness, int flexibility) {
        super(material, attackDamage, attackSpeed, settings);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_pickaxe");
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(2 + this.flexibility, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.relic").formatted(Formatting.GRAY));
        if (this.sharpness > 0) {
            tooltip.add(Text.translatable("tooltip.pickaxe_sharpness").formatted(Formatting.DARK_GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Text.translatable("tooltip.uni_flexibility").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.translatable("tooltip.uni_flexibility_n").formatted(Formatting.DARK_GRAY));
        }
    }
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (sharpness > 0) {
            return state.isIn(BlockTags.PICKAXE_MINEABLE) || state.isOf(Blocks.GRAVEL) || state.isOf(Blocks.SAND) ? this.miningSpeed : 1.0F;
        } else {
            return state.isIn(BlockTags.PICKAXE_MINEABLE) ? this.miningSpeed : 1.0F;
        }
    }
}
