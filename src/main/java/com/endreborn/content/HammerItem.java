package com.endreborn.content;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

public class HammerItem extends Item {
    public HammerItem(Item.Settings p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack container = stack.copy();
        if(container.damage(1, Random.create(), null))
            return ItemStack.EMPTY;
        else
            return container;
    }
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
}
