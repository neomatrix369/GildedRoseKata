package com.gildedrose;

public abstract class QualityUpdater {
    protected final Item item;

    protected static final int MINIMUM_QUALITY = 0;
    protected static final int MAXIMUM_QUALITY = 50;
    protected static final int MINIMUM_SELL_IN = 0;

    protected static final int NORMAL_RATE_OF_CHANGE_OF_QUALITY = 1;

    public QualityUpdater(Item item) {
        this.item = item;
    }

    abstract void update();

    boolean isExpired() {
        return expiresIn(MINIMUM_SELL_IN);
    }

    void increaseQualityBy(int by) {
        if (canIncreaseQuality()) {
            item.quality += by;
        }
    }

    void decreaseQualityBy(int by) {
        if (canDecreaseQuality()) {
            item.quality -= by;
        }
    }

    private boolean canDecreaseQuality() {
        return item.quality > MINIMUM_QUALITY;
    }

    boolean canSetQualityToMinimum() {
        return item.quality < MINIMUM_QUALITY;
    }

    void setQualityToMinimum() {
        item.quality = MINIMUM_QUALITY;
    }

    protected boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    protected boolean expiresIn(int daysToExpiration) {
        return item.sellIn < daysToExpiration;
    }

    protected boolean qualityIsMoreThanMaximum() {
        return item.quality > MAXIMUM_QUALITY;
    }
}