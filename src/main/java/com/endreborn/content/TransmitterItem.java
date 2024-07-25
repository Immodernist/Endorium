package com.endreborn.content;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class TransmitterItem extends Item {
    private static final ITextComponent CONTAINER_TITLE =  new TranslationTextComponent("container.ender_transmitter");

    public TransmitterItem(Properties p_41383_) {
        super(p_41383_);
    }

    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        EnderChestInventory enderchestinventory = playerIn.getEnderChestInventory();
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (!worldIn.isClientSide) {
            playerIn.openMenu(new SimpleNamedContainerProvider((p_53124_, p_53125_, p_53126_) -> {
                return ChestContainer.threeRows(p_53124_, p_53125_, enderchestinventory);
            }, CONTAINER_TITLE));
            playerIn.awardStat(Stats.OPEN_ENDERCHEST);
            itemstack.hurtAndBreak(1, playerIn, (p_41007_) -> {
                p_41007_.broadcastBreakEvent(handIn);
            });
        }
        return ActionResult.success(itemstack);
    }
}
