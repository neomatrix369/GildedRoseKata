package com.gildedrose;

abstract class Product {
    static final int MAXIMUM_QUALITY = 50;
    static final int MINIMUM_SELL_IN_DAYS = 0;

    public abstract void update();

    void increaseQuality(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
    void increaseQualityIfExpired(Item item) {
        if (isExpired(item)) {
            increaseQuality(item);
        }
    }

    void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    boolean isExpired(Item item) {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }
}
