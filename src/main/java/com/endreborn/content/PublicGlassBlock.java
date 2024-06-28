package com.endreborn.content;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.TransparentBlock;

public class PublicGlassBlock extends TransparentBlock {
    public static final MapCodec<PublicGlassBlock> CODEC = simpleCodec(PublicGlassBlock::new);

    public MapCodec<PublicGlassBlock> codec() {
        return CODEC;
    }
    public PublicGlassBlock(Properties p_309186_) {
        super(p_309186_);
    }
}
