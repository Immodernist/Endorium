package com.endreborn.content;

import com.endreborn.init.ModArmor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class EnderBootsItem extends ArmorItem {
    public EnderBootsItem(ModArmor p_40386_, EquipmentSlotType p_266831_, Properties p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("tooltip.ender_boots").withStyle(TextFormatting.GRAY));
    }
}
