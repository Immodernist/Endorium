package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelPieces;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class ModPieces {
    public static StructurePieceType CITADEL_PIECE = CitadelPieces.Piece::new;

    public static void setup() {
        Registry.register(BuiltInRegistries.STRUCTURE_PIECE, ResourceLocation.fromNamespaceAndPath(EndReborn.MODID, "citadel"), CITADEL_PIECE);
    }
}
