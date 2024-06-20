package com.endreborn.content;

import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TransmitterItem extends Item {
    private static final Component CONTAINER_TITLE = Component.translatable("container.ender_transmitter");

    public TransmitterItem(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        PlayerEnderChestContainer enderchestinventory = playerIn.getEnderChestInventory();
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (worldIn.isClientSide) {
            return InteractionResultHolder.success(itemstack);
        } else {
            playerIn.openMenu(new SimpleMenuProvider((p_53124_, p_53125_, p_53126_) -> {
                return ChestMenu.threeRows(p_53124_, p_53125_, enderchestinventory);
            }, CONTAINER_TITLE));
            playerIn.awardStat(Stats.OPEN_ENDERCHEST);
            itemstack.hurtAndBreak(1, playerIn, EquipmentSlot.MAINHAND);
            return InteractionResultHolder.success(itemstack);
        }
    }
}
