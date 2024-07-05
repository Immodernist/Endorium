package com.endreborn.init;

import com.endreborn.EndReborn;
import com.endreborn.world.CitadelPieces;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPieces {
    public static final DeferredRegister<StructurePieceType> PIECE = DeferredRegister.create(Registries.STRUCTURE_PIECE, EndReborn.MODID);

    public static final RegistryObject<StructurePieceType> CITADEL_PIECE = PIECE.register("citadel", ()-> CitadelPieces.Piece::new);

}
