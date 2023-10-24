package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UpgradableHoeItem extends HoeItem {

    private final int sharpness;
    private final int flexibility;

    public UpgradableHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings, int sharpness, int flexibility) {
        super(material, attackDamage, attackSpeed, settings);
        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_hoe");
    }

    public float getSharpness() {
        return this.sharpness;
    }
    public float getFlexibility() {
        return this.flexibility;
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return state.isIn(BlockTags.HOE_MINEABLE) ? this.miningSpeed : 1.0F + this.sharpness;
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.relic").formatted(Formatting.GRAY));
        if (this.sharpness > 0) {
            tooltip.add(Text.translatable("tooltip.hoe_sharpness").formatted(Formatting.DARK_GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(Text.translatable("tooltip.uni_flexibility").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.translatable("tooltip.uni_flexibility_n").formatted(Formatting.DARK_GRAY));
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(2 + this.flexibility, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }
}
