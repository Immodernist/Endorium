package com.endreborn.content;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.KnockbackEnchantment;

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
        if(container.hurt(1, RandomSource.createNewThreadLocalInstance(), null))
            return ItemStack.EMPTY;
        else
            return container;
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
