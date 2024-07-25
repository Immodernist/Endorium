package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.ThreadLocalRandom;

@Mod.EventBusSubscriber(modid = EndReborn.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        ItemStack feet = entity.getItemBySlot(EquipmentSlotType.FEET);
        if(feet.getItem() == ModItems.ENDER_BOOTS.get()) {
            if (event.getSource().getDirectEntity() != null) {
                if (!entity.level.isClientSide) {
                    for(int i = 0; i < 16; ++i) {
                        double d3 = entity.getX() + (ThreadLocalRandom.current().nextDouble() - 0.5D) * 16.0D;
                        double d4 = MathHelper.clamp(entity.getY() + (double)(ThreadLocalRandom.current().nextInt(12) - 6), (double)entity.level.getHeight(), (double)(entity.level.getHeight() + ((ServerWorld)entity.level).getHeight() - 1));
                        double d5 = entity.getZ() + (ThreadLocalRandom.current().nextDouble() - 0.5D) * 16.0D;
                        if (entity.isPassenger()) {
                            entity.stopRiding();
                        }
                        if (entity.randomTeleport(d3, d4, d5, true)) {
                            break;
                        }
                    }
                    entity.lookAt(EntityAnchorArgument.Type.FEET, event.getSource().getDirectEntity().position());
                }
            }
        }
    }
}
