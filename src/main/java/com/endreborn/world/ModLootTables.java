package com.endreborn.world;

import com.endreborn.EndReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ModLootTables {
    private static final Set<ResourceKey<LootTable>> LOCATIONS = new HashSet<>();
    private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);
    public static final ResourceKey<LootTable> CITADEL_LOOT = register("chests/citadel");
    private static ResourceKey<LootTable> register(String p_78768_) {
        return register(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(EndReborn.MODID, p_78768_)));
    }
    private static ResourceKey<LootTable> register(ResourceKey<LootTable> p_330139_) {
        if (LOCATIONS.add(p_330139_)) {
            return p_330139_;
        } else {
            throw new IllegalArgumentException(p_330139_.location() + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceKey<LootTable>> all() {
        return IMMUTABLE_LOCATIONS;
    }
}
