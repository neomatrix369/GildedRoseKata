package com.gildedrose;

public enum ItemName {
    AGED_BRIE("Aged Brie", new AgedBrieQualityUpdater()),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesQualityUpdater()),
    SULFURAS("Sulfuras, Hand of Ragnaros", new SulfurasQualityUpdater()),
    ANY_ITEM("Any item", new AnyItemQualityUpdater());

    private final String itemName;
    private final ItemQualityUpdater itemQualityUpdater;

    ItemName(String itemName, ItemQualityUpdater itemQualityUpdater) {
        this.itemName = itemName;
        this.itemQualityUpdater = itemQualityUpdater;
    }

    public boolean sameAs(Item item) {
        return item.name.equals(itemName);
    }

    @Override
    public String toString() {
        return itemName;
    }

    public ItemQualityUpdater getQualityUpdater() {
        return this.itemQualityUpdater;
    }
}