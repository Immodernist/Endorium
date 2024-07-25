package com.endreborn.content;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class EnderBootsItem extends ArmorItem {
    public EnderBootsItem(ArmorMaterial p_40386_, EquipmentSlot p_266831_, Properties p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, Level world, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.ender_boots").withStyle(ChatFormatting.GRAY));
    }
}
