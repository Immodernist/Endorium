package com.endreborn.world;

import com.endreborn.Endorium;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

public class CitadelLootTables  {
    private static final Set<RegistryKey<LootTable>> LOOT_TABLES = new HashSet();
    public static final RegistryKey<LootTable> CITADEL_LOOT = register("chests/citadel");

    private static RegistryKey<LootTable> register(String id) {
        return registerLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(Endorium.MODID, id)));
    }

    private static RegistryKey<LootTable> registerLootTable(RegistryKey<LootTable> key) {
        if (LOOT_TABLES.add(key)) {
            return key;
        } else {
            throw new IllegalArgumentException(String.valueOf(key.getValue()) + " is already a registered built-in loot table");
        }
    }
}

