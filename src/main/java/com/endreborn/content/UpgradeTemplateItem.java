package com.endreborn.content;

import com.endreborn.Endorium;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class UpgradeTemplateItem extends SmithingTemplateItem {
    private static Text APPLIES_TO;
    private static Text INGREDIENTS;
    private static Text UPGRADE;
    private static Text BASE_SLOT_DESCRIPTION;
    private static Text ADDITIONS_SLOT_DESCRIPTION;
    private static final Identifier EMPTY_SLOT_HOE;
    private static final Identifier EMPTY_SLOT_AXE;
    private static final Identifier EMPTY_SLOT_SWORD;
    private static final Identifier EMPTY_SLOT_SHOVEL;
    private static final Identifier EMPTY_SLOT_PICKAXE;
    private static final Identifier EMPTY_SLOT_INGOT;
    public UpgradeTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }
    public static SmithingTemplateItem createEndoriumUpgrade() {
        return new SmithingTemplateItem(APPLIES_TO, INGREDIENTS, UPGRADE, BASE_SLOT_DESCRIPTION, ADDITIONS_SLOT_DESCRIPTION, createUpgradeIconList(), createUpgradeMaterialList());
    }
    private static List<Identifier> createUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
    private static List<Identifier> createUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }
    static {
        APPLIES_TO = Text.translatable(Util.createTranslationKey("item", Identifier.of(Endorium.MODID, "smithing_template.endorium_upgrade.applies_to"))).formatted(Formatting.BLUE);
        INGREDIENTS = Text.translatable(Util.createTranslationKey("item", Identifier.of(Endorium.MODID, "endorium_ingot"))).formatted(Formatting.BLUE);
        UPGRADE = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(Endorium.MODID, "endorium_upgrade"))).formatted(Formatting.GRAY);
        BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.netherite_upgrade.base_slot_description")));
        ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.netherite_upgrade.additions_slot_description")));

        EMPTY_SLOT_HOE = Identifier.ofVanilla("item/empty_slot_hoe");
        EMPTY_SLOT_AXE = Identifier.ofVanilla("item/empty_slot_axe");
        EMPTY_SLOT_SWORD = Identifier.ofVanilla("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL = Identifier.ofVanilla("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE = Identifier.ofVanilla("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT = Identifier.ofVanilla("item/empty_slot_ingot");
    }
}
