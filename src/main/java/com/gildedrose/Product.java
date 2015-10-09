package com.gildedrose;

abstract class Product {
    static final int MINIMUM_QUALITY = 0;
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

    void setQualityToZeroIfExpired(Item item) {
        if (isExpired(item)) {
            item.quality = MINIMUM_QUALITY;
        }
    }

    void decreaseQuality(Item item, int by) {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - by;
        }
    }

    int by(int value) {
        return value;
    }

    void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    boolean isExpired(Item item) {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }
}