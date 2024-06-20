package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class EnderBootsItem extends ArmorItem {
    public EnderBootsItem(Holder<ArmorMaterial> p_40386_, Type p_266831_, Properties p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Item.TooltipContext text, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.ender_boots").withStyle(ChatFormatting.GRAY));
    }
}
