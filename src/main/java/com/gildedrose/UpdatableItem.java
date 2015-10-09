package com.gildedrose;

abstract class UpdatableItem {

    private static final int MINIMUM_QUALITY = 0;
    private static final int MINIMUM_SELL_IN_DAYS = 0;
    private static final int MAXIMUM_QUALITY = 50;

    static final int NORMAL_QUALITY_CHANGE_RATE = 1;
    static final int NORMAL_SELL_IN_CHANGE_RATE = 1;

    private final Item item;

    UpdatableItem(Item item) {
        this.item = item;
    }

    void update() {
        changeQuality();
        decreaseSellIn();
        changeQualityIfExpired();
    }

    protected abstract void changeQuality();

    protected abstract void changeQualityIfExpired();

    private boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    void increaseQualityBy(int by) {
        if (canIncreaseQuality()) {
            item.quality += by;
        }
    }

    private boolean canDecreaseQuality() {
        return item.quality > MINIMUM_QUALITY;
    }

    void decreaseQualityBy(int by) {
        if (canDecreaseQuality()) {
            item.quality -= by;
        }
    }

    void resetQuality() {
        item.quality = MINIMUM_QUALITY;
    }

    abstract void decreaseSellIn();

    boolean isExpired() {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }

    boolean itemIsDueToExpireIn(int daysToExpiration) {
        return item.sellIn <= daysToExpiration;
    }

    void decreaseSellInBy(int by) {
        item.sellIn -= by;
    }
}