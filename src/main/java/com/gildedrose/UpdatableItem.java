package com.gildedrose;

public abstract class UpdatableItem {

    protected static final int MINIMUM_QUALITY = 0;
    protected static final int MINIMUM_SELL_IN_DAYS = 0;
    protected static final int MAXIMUM_QUALITY = 50;

    protected final Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }

    public abstract void update();

    public void decreaseSellIn() { item.sellIn--; }

    public void increaseQuality() {
        item.quality++;
    }

    public void setQualityToZero() {
        item.quality = MINIMUM_QUALITY;
    }

    public void decreaseQualityBy(int by) {
        item.quality -= by;
    }

    protected boolean canIncreaseQualityOf(Item item) {
        return item.quality < MAXIMUM_QUALITY;
    }

    protected boolean isExpired(Item item) {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }

    protected boolean itemIsDueToExpireIn(int daysToExpiration) {
        return item.sellIn <= daysToExpiration;
    }
}
