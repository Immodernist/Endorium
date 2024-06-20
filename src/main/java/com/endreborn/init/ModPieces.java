package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.EndShipwreckPieces;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class ModPieces {
    public static StructurePieceType END_SHIPWRECK = EndShipwreckPieces.Piece::new;

    public static void setup() {
        Registry.register(BuiltInRegistries.STRUCTURE_PIECE, ResourceLocation.fromNamespaceAndPath(EndReborn.MODID, "end_shipwreck"), END_SHIPWRECK);
    }
}
