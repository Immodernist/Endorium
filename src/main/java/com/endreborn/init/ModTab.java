package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTab extends CreativeModeTab {

    public ModTab() {
        super("endgroup");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModBlocks.FARSTONE_BRICKS_CHISELED.get());
    }
}
