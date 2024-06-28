package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelPieces;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModPieces {
    public static final DeferredRegister<StructurePieceType> REGISTRY = DeferredRegister.create(Registries.STRUCTURE_PIECE, EndReborn.MODID);
    public static final Supplier<StructurePieceType> CITADEL_PIECE = REGISTRY.register("buried_shipwreck", () -> CitadelPieces.Piece::new);
}
