package com.gildedrose;

public enum ItemNameToUpdater {
    AGED_BRIE(Constants.AGED_BRIE, new AgedBrieQualityUpdater()),
    BACKSTAGE_PASSES(Constants.BACKSTAGE_PASSES, new BackstagePassesQualityUpdater()),
    SULFURAS(Constants.SULFURAS, new SulfurasQualityUpdater()),
    CONJURED_ITEM(Constants.CONJURED, new ConjuredQualityUpdater()),
    STANDARD_ITEM(Constants.STANDARD_ITEM, new StandardQualityUpdater());

    private final String itemName;
    private final QualityUpdater qualityUpdater;

    ItemNameToUpdater(String itemName, QualityUpdater qualityUpdater) {
        this.itemName = itemName;
        this.qualityUpdater = qualityUpdater;
    }

    public boolean sameAs(Item item) {
        return item.name.equals(itemName);
    }

    @Override
    public String toString() {
        return itemName;
    }

    public QualityUpdater getQualityUpdater() {
        return this.qualityUpdater;
    }
}