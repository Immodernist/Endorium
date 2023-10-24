package com.endreborn.mixin;

import com.endreborn.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class EnderBootsMixin extends LivingEntity {
	@Shadow
	public abstract Iterable<ItemStack> getArmorItems();
	protected EnderBootsMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("TAIL"), method = "tick")
	private void hasEnderBoots(CallbackInfo cir) {
		if (this.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.ENDER_BOOTS) {
			if (this.hurtTime == 5) {
				if (!this.getWorld().isClient) {
					for (int i = 0; i < 12; ++i) {
						double g = this.getX() + (this.getRandom().nextDouble() - 0.5) * 16.0;
						double h = MathHelper.clamp(this.getY() + (double) (this.getRandom().nextInt(16) - 8), (double) this.getWorld().getBottomY(), (double) (this.getWorld().getBottomY() + ((ServerWorld) this.getWorld()).getLogicalHeight() - 1));
						double j = this.getZ() + (this.getRandom().nextDouble() - 0.5) * 16.0;
						if (this.hasVehicle()) {
							this.stopRiding();
						}

						Vec3d vec3d = this.getPos();
						if (this.teleport(g, h, j, true)) {
							this.getWorld().emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(this));
							break;
						}
					}
				}
			}
		}
	}
}