package com.endreborn.init;

import com.endreborn.EndReborn;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTab extends ItemGroup {

    public ModTab() {
        super("endgroup");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModBlocks.FARSTONE_BRICKS_CHISELED.get());
    }
}
