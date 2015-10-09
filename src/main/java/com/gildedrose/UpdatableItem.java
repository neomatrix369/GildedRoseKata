package com.gildedrose;

public abstract class UpdatableItem {

    protected static final int MINIMUM_QUALITY = 0;
    protected static final int MINIMUM_SELL_IN_DAYS = 0;
    protected static final int MAXIMUM_QUALITY = 50;

    protected static final int NORMAL_QUALITY_CHANGE_RATE = 1;
    protected static final int NORMAL_SELL_IN_CHANGE_RATE = 1;

    private final Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }

    protected void update() {
        changeSellIn();
        changeQuality();
    }

    protected abstract void changeQuality();

    private boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    protected void increaseQualityBy(int by) {
        if (canIncreaseQuality()) {
            item.quality += by;
        }
    }

    private boolean canDecreaseQuality() {
        return item.quality > MINIMUM_QUALITY;
    }

    protected void decreaseQualityBy(int by) {
        if (canDecreaseQuality()) {
            item.quality -= by;
        }
    }

    protected void resetQuality() {
        item.quality = MINIMUM_QUALITY;
    }

    protected abstract void changeSellIn();

    protected boolean isExpired() {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }

    protected boolean itemIsDueToExpireIn(int daysToExpiration) {
        return item.sellIn <= daysToExpiration;
    }

    protected void decreaseSellInBy(int by) {
        item.sellIn -= by;
    }
}