package com.endreborn.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
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

    private final boolean curious;
    private final boolean mysterious;

    public UpgradableSwordItem(ToolMaterial material, Item.Settings settings, boolean curious, boolean mysterious) {
        super(material, settings.component(DataComponentTypes.TOOL, new ToolComponent(List.of(ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), curious ? 20.0F : 15.0F), ToolComponent.Rule.of(BlockTags.SWORD_EFFICIENT, curious ? 2F : 1.5F)), 1.0F, 2)));
        this.curious = curious;
        this.mysterious = mysterious;
    }
    public Text getName(ItemStack p_41458_) {
        return Text.translatable("item.endreborn.endorium_sword");
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (this.curious) {
            tooltip.add(Text.translatable("tooltip.sword_curious").formatted(Formatting.GRAY));
        }
        if (this.mysterious){
            tooltip.add(Text.translatable("tooltip.sword_mysterious").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.sword_mysterious_n").formatted(Formatting.GRAY));
        }
    }
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(this.mysterious ? 1 : 0, attacker, EquipmentSlot.MAINHAND);
        return true;
    }
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0F) {
            stack.damage(this.mysterious ? 1 : 2, miner, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}
