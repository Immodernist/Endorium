package com.endreborn;

import com.endreborn.init.*;
import net.fabricmc.api.ModInitializer;

public class Endorium implements ModInitializer {
	public static final String MODID = "endreborn";

	@Override
	public void onInitialize() {
		ModBlocks.setup();
		ModItems.setup();
		ModTab.setup();
		ModFeatures.setup();
		ModPieces.setup();
		ModTypes.setup();
		ModPlaces.setup();

	}
}