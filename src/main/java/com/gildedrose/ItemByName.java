package com.gildedrose;

public enum ItemByName {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    ANY_OTHER_ITEM("Any item");

    private final String itemName;

    ItemByName(String itemName) {
        this.itemName = itemName;
    }

    public boolean sameAs(Item item) {
        return item.name.equals(itemName);
    }

    @Override
    public String toString() {
        return itemName;
    }
}
