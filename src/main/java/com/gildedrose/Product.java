package com.gildedrose;

abstract class Product {
    static final int NORMAL_QUALITY_CHANGE_RATE = 1;

    static final int MINIMUM_QUALITY = 0;
    static final int MAXIMUM_QUALITY = 50;
    static final int MINIMUM_SELL_IN_DAYS = 0;

    private final Item item;

    public Product(Item item) {
        this.item = item;
    }

    public abstract void update();

    void increaseQualityBy(int by) {
        if (canIncreaseQuality()) {
            item.quality = item.quality + by;
        }
    }

    private boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    boolean canIncreaseQualityIfItemExpiresIn(int minimumSellInDays) {
        return item.sellIn <= minimumSellInDays;
    }

    protected boolean canSetQualityToMinimumQuality(int minimumQuality) {
        return item.quality < minimumQuality;
    }

    void setQualityToZero() {
        item.quality = MINIMUM_QUALITY;
    }

    void decreaseQualityBy(int by) {
        if (canDecreaseQuality()) {
            item.quality = item.quality - by;
        }
    }

    private boolean canDecreaseQuality() {
        return item.quality > MINIMUM_QUALITY;
    }

    void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    boolean isExpired() {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }
}