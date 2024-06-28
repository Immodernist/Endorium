package com.endreborn.content;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class HammerItem extends Item {
    public HammerItem(Item.Settings p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

    @NotNull
    @Override
    public ItemStack getRecipeRemainder(@NotNull ItemStack stack) {
        ItemStack container = stack.copy();
        int i = stack.getDamage() + 1;
        if(i >= stack.getMaxDamage()) {
            return ItemStack.EMPTY;
        } else {
            container.setDamage(stack.getDamage() + 1);
            return container;
        }
    }
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
}
