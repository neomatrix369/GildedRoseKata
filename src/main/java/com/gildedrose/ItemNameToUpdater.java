package com.gildedrose;

public enum ItemNameToUpdater {
    AGED_BRIE("Aged Brie", new AgedBrieQualityUpdater()),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesQualityUpdater()),
    SULFURAS("Sulfuras, Hand of Ragnaros", new SulfurasQualityUpdater()),
    CONJURED_ITEM("Conjured", new ConjuredQualityUpdater()),
    ANY_ITEM("Any item", new StandardQualityUpdater());

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