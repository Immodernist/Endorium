package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndReborn.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        ItemStack feet = entity.getItemBySlot(EquipmentSlot.FEET);
        if(feet.getItem() == ModItems.ENDER_BOOTS.get()) {
            if (event.getSource().getDirectEntity() != null) {
                float amount = event.getAmount();
                if (!entity.level().isClientSide) {
                    for(int i = 0; i < 16; ++i) {
                        double d3 = entity.getX() + (entity.getRandom().nextDouble() - 0.5D) * 16.0D;
                        double d4 = Mth.clamp(entity.getY() + (double)(entity.getRandom().nextInt(16) - 8), (double)entity.level().getMinBuildHeight(), (double)(entity.level().getMinBuildHeight() + ((ServerLevel)entity.level()).getLogicalHeight() - 1));
                        double d5 = entity.getZ() + (entity.getRandom().nextDouble() - 0.5D) * 16.0D;
                        if (entity.isPassenger()) {
                            entity.stopRiding();
                        }
                        if (entity.randomTeleport(d3, d4, d5, true)) {
                            amount = amount / 2;
                            event.setAmount(amount);
                            break;
                        }
                    }
                }
            }
        }
    }
}
