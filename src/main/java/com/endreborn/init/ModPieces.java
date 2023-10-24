package com.endreborn.init;

import com.endreborn.Endorium;
import com.endreborn.world.EndShipwreckPieces;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;

public class ModPieces {
    public static StructurePieceType END_SHIPWRECK = EndShipwreckPieces.Piece::new;

    public static void setup() {
        Registry.register(Registries.STRUCTURE_PIECE, new Identifier(Endorium.MODID, "end_shipwreck"), END_SHIPWRECK);
    }
}
