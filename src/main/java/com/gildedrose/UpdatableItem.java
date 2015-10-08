package com.gildedrose;

public abstract class UpdatableItem {

    protected static final int MINIMUM_QUALITY = 0;
    protected static final int MINIMUM_SELL_IN_DAYS = 0;
    protected static final int MAXIMUM_QUALITY = 50;

    private final Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }

    public abstract void update();


    protected boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    public void increaseQuality() {
        item.quality++;
    }

    protected boolean canDecreaseQuality() {
        return item.quality > MINIMUM_QUALITY;
    }

    public void decreaseQualityBy(int by) {
        item.quality -= by;
    }

    public void resetQuality() {
        item.quality = MINIMUM_QUALITY;
    }

    protected boolean isExpired() {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }

    protected boolean itemIsDueToExpireIn(int daysToExpiration) {
        return item.sellIn <= daysToExpiration;
    }

    public void decreaseSellIn() { item.sellIn--; }


    protected void changeSellIn() {
        if (canDecreaseQuality()) {
            decreaseSellIn();
        }
    }
}
