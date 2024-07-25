package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelPieces;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
public class ModPieces {
    public static IStructurePieceType CITADEL_PIECE;

    public static void init() {
        CITADEL_PIECE = Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(EndReborn.MODID, "citadel"), CitadelPieces.Piece::new);
    }
}
