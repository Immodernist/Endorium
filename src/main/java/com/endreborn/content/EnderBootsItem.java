package com.endreborn.content;


import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnderBootsItem extends ArmorItem {
    public EnderBootsItem(ArmorMaterial p_40386_, Type p_266831_, Item.Settings p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.effect").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.ender_boots").formatted(Formatting.DARK_GRAY));
    }
}
