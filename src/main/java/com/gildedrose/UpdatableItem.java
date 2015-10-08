package com.gildedrose;

public abstract class UpdatableItem {

    protected static final int MINIMUM_QUALITY = 0;
    protected static final int MINIMUM_SELL_IN_DAYS = 0;
    protected static final int MAXIMUM_QUALITY = 50;

    private final Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }

    protected abstract void update();

    private boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    protected void increaseQuality() {
        if (canIncreaseQuality()) {
            item.quality++;
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

    protected boolean isExpired() {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }

    protected boolean itemIsDueToExpireIn(int daysToExpiration) {
        return item.sellIn <= daysToExpiration;
    }

    protected void decreaseSellIn() {
        item.sellIn--;
    }

}
