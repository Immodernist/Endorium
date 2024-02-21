package com.endreborn.content;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TransmitterItem extends Item {
    private static final Text CONTAINER_TITLE = Text.translatable("container.ender_transmitter");

    public TransmitterItem(Item.Settings p_41383_) {
        super(p_41383_);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        EnderChestInventory enderChestInventory = player.getEnderChestInventory();
        ItemStack stack = player.getStackInHand(hand);
        if (world.isClient) {
            return TypedActionResult.success(stack);
        } else {
            player.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inventory, playerx) -> {
                return GenericContainerScreenHandler.createGeneric9x3(syncId, inventory, enderChestInventory);
            }, CONTAINER_TITLE));
            player.incrementStat(Stats.OPEN_ENDERCHEST);
            stack.damage(1, player, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
            return TypedActionResult.success(stack);
        }
    }
}
