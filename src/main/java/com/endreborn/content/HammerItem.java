package com.endreborn.content;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Random;

public class HammerItem extends Item {
    public HammerItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
    @Nonnull
    @Override
    public ItemStack getContainerItem(@Nonnull ItemStack stack)
    {
        ItemStack container = stack.copy();
        if(container.hurt(1, new Random(), null))
            return ItemStack.EMPTY;
        else
            return container;
    }
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, null);
        return true;
    }

    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack) {
        return false;
    }
}
