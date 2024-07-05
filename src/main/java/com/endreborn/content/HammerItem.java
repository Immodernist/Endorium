package com.endreborn.content;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class HammerItem extends Item {
    public HammerItem(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public boolean hasCraftingRemainingItem(@Nonnull ItemStack stack) {
        return true;
    }

    @Nonnull
    @Override
    public ItemStack getCraftingRemainingItem(@Nonnull ItemStack stack) {
        ItemStack container = stack.copy();
        int i = stack.getDamageValue() + 1;
        if(i >= stack.getMaxDamage()) {
            return ItemStack.EMPTY;
        } else {
            container.setDamageValue(stack.getDamageValue() + 1);
            return container;
        }
    }
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(2, attacker, null);
        return true;
    }
    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack) {
        return false;
    }
}
