package com.endreborn.content;


import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class EnderBootsItem extends ArmorItem {
    public EnderBootsItem(RegistryEntry<ArmorMaterial> p_40386_, Type p_266831_, Item.Settings p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.ender_boots").formatted(Formatting.GRAY));
    }
}
